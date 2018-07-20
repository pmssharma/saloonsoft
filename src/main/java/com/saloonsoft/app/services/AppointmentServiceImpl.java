package com.saloonsoft.app.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saloonsoft.app.dto.AppointmentByProcedureDTO;
import com.saloonsoft.app.dto.AppointmentObject;
import com.saloonsoft.app.dto.BusySchedule;
import com.saloonsoft.app.dto.ProcedureStepsDTO;
import com.saloonsoft.app.dto.ProcessObject;
import com.saloonsoft.app.entities.App;
import com.saloonsoft.app.entities.ProcessSteps;
import com.saloonsoft.app.repositories.AppRep;
import com.saloonsoft.app.repositories.Appointmentepository;
import com.saloonsoft.app.repositories.ProcessRep;
import com.saloonsoft.app.repositories.ProcessStepsRep;
import com.saloonsoft.app.repositories.StaffRepository;
import com.saloonsoft.app.util.AppointmentUtil;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	Appointmentepository appointmentRepository;
	@Autowired
	StaffRepository staffRepository;
	@Autowired
	AppRep arep;
	@Autowired
	ProcessRep prep;
	@Autowired
	ProcessStepsRep psrep;

	@Override
	public String insertAppointment(AppointmentObject appointmentDto) {

		App appObject = new App();
		appObject.setAppDate(appointmentDto.getAppDate());
		appObject.setClientID(appointmentDto.getClientID());
		arep.save(appObject);

		for(int i=0;i<appointmentDto.getProcessName().length;++i) {
			com.saloonsoft.app.entities.Process p = new  com.saloonsoft.app.entities.Process();
			p.setName(appointmentDto.getProcessName()[i].getName());
			p.setTimeSlot(appointmentDto.getProcessName()[i].getTimeSlot());
			p.setAid(appObject.getId());
			prep.save(p);
			ProcessObject[] pobj= appointmentDto.getProcessName();
			for(int j=0;j<pobj[i].getProcedureSteps().length;++j) {
				ProcessSteps psteps = new ProcessSteps();
				psteps.setDuration(pobj[i].getProcedureSteps()[j].getDuration());
				psteps.setProcedureStepID(pobj[i].getProcedureSteps()[j].getProcedureStepID());
				psteps.setProcedure(pobj[i].getProcedureSteps()[j].getProcedure());
				psteps.setStaff(pobj[i].getProcedureSteps()[j].getStaff());
				psteps.setStartTime(pobj[i].getProcedureSteps()[j].getStartTime());
				psteps.setEndTime(pobj[i].getProcedureSteps()[j].getEndTime());
				psteps.setPid(p.getId());
				psteps.setAid(appObject.getId());
				psrep.save(psteps);
			}
		}

		return "sucess";
	}

	@Override
	public List<AppointmentObject> getAppointmentByClientID(String clientID){

		List<AppointmentObject> appointmentObject = new ArrayList<AppointmentObject>();
		List<App> aObject= (List<App>) arep.findByClientID(clientID);
		int i=0;
		for(App obj : aObject) {
			AppointmentObject dto =new AppointmentObject();
			System.out.println(obj.getAppDate());
			dto.setAppDate(obj.getAppDate());
			dto.setClientID(obj.getClientID());
			System.out.println(obj.getClientID());
			//System.out.println(obj.getId());
			List<com.saloonsoft.app.entities.Process> pObject= (List< com.saloonsoft.app.entities.Process>) prep.findByAid(obj.getId());
			int j=0;
			ProcessObject pArray[] = new ProcessObject[pObject.size()];
			for(com.saloonsoft.app.entities.Process pobj : pObject) {
				ProcessObject p = new ProcessObject();
				p.setName(pobj.getName());
				p.setTimeSlot(pobj.getTimeSlot());
				System.out.println(pobj.getAid());
				System.out.println(pobj.getName());
				System.out.println(pobj.getTimeSlot());
				List<ProcessSteps> psObject= (List<ProcessSteps>) psrep.findByPid(pobj.getId());

				ProcedureStepsDTO[] psArray= new ProcedureStepsDTO[psObject.size()];
				pArray[j]=p;

				int k=0;
				for(ProcessSteps pss : psObject) {
					ProcedureStepsDTO pssss=new ProcedureStepsDTO();
					pssss.setStaff(pss.getStaff());
					System.out.println(pss.getStaff());
					System.out.println(pss.getProcedure());
					pssss.setProcedure(pss.getProcedure());
					pssss.setDuration(pss.getDuration());	
					psArray[k]=pssss;
					k++;
				}

				pArray[j].setProcedureSteps(psArray);
				++j;

			}
			dto.setProcessName(pArray);
			appointmentObject.add(dto);
			++i;
		}
		return appointmentObject;
	}

	@Override
	public  List<AppointmentObject> getAppointmentByDate(Date appDate) {
		List<AppointmentObject> appointmentObject = new ArrayList<AppointmentObject>();
		List<App> aObject= (List<App>) arep.findByAppDate(appDate);
		int i=0;
		for(App obj : aObject) {
			AppointmentObject dto =new AppointmentObject();
			System.out.println(obj.getAppDate());
			dto.setAppDate(obj.getAppDate());
			dto.setClientID(obj.getClientID());
			dto.setId(obj.getId());
			System.out.println(obj.getClientID());
			//System.out.println(obj.getId());
			List<com.saloonsoft.app.entities.Process> pObject= (List< com.saloonsoft.app.entities.Process>) prep.findByAid(obj.getId());
			int j=0;
			ProcessObject pArray[] = new ProcessObject[pObject.size()];
			for(com.saloonsoft.app.entities.Process pobj : pObject) {
				ProcessObject p = new ProcessObject();
				p.setName(pobj.getName());
				p.setTimeSlot(pobj.getTimeSlot());
				p.setId(pobj.getId());
				System.out.println(pobj.getAid());
				System.out.println(pobj.getName());
				System.out.println(pobj.getTimeSlot());
				List<ProcessSteps> psObject= (List<ProcessSteps>) psrep.findByPid(pobj.getId());

				ProcedureStepsDTO[] psArray= new ProcedureStepsDTO[psObject.size()];
				pArray[j]=p;

				int k=0;
				for(ProcessSteps pss : psObject) {
					ProcedureStepsDTO pssss=new ProcedureStepsDTO();
					pssss.setStaff(pss.getStaff());
					System.out.println(pss.getStaff());
					System.out.println(pss.getProcedure());
					pssss.setId(pss.getId());
					pssss.setProcedure(pss.getProcedure());
					pssss.setDuration(pss.getDuration());
					pssss.setProcedureStepID(pss.getProcedureStepID());
					psArray[k]=pssss;
					k++;
				}

				pArray[j].setProcedureSteps(psArray);
				++j;

			}
			dto.setProcessName(pArray);
			appointmentObject.add(dto);
			++i;
		}
		return appointmentObject;
	}

	@Override
	public  List<ProcedureStepsDTO> getAppointmentByStaff(String staff) {

		List<ProcedureStepsDTO> procesStepsRes = new ArrayList<ProcedureStepsDTO>();
		ProcedureStepsDTO obj = new ProcedureStepsDTO();
		List<ProcessSteps> procesSteps = new ArrayList<ProcessSteps>();
		procesSteps= psrep.findByStaff(staff);
		for(ProcessSteps pstep:procesSteps) {
			BeanUtils.copyProperties(pstep,obj);
			procesStepsRes.add(obj);
		}

		return procesStepsRes;
	}

	@Override
	public  List<AppointmentByProcedureDTO> getAppointmentByProcForGivenDate(String procedure, Date date) {


		ArrayList<Date> dates  =(ArrayList<Date>) AppointmentUtil.prpare7Days(date);
		
		List<AppointmentByProcedureDTO> appByProcedure=new ArrayList<AppointmentByProcedureDTO>();
		for(Date d:dates) {


			List<App> aObject= (List<App>) arep.findByAppDate(d);
			if(aObject.size()!=0) {
			//	List<App> aObject1= (List<App>) arep.findByClientID("Patric");
			ArrayList<String> str= new ArrayList<String>();

			for(App obj:aObject) {
				str.add(obj.getId());

			}

			List<ProcessSteps> psteps = new ArrayList<ProcessSteps>();
			List<ProcessSteps> psteps1 = new ArrayList<ProcessSteps>();
			ProcessSteps ps = new ProcessSteps();
			for(String  obj:str) {
				psteps1=( ArrayList<ProcessSteps>) (psrep.findByAid(obj));
				for(ProcessSteps ps2: psteps1)
					psteps.add(ps2);

			}

			List<ProcessSteps> regal = new ArrayList<ProcessSteps>();
			for(ProcessSteps p : psteps) {
				if(p.getStaff().equals("Regal"))
					regal.add(p);

			}
			AppointmentByProcedureDTO dto=new AppointmentByProcedureDTO();
			dto.setAppDate(aObject.get(0).getAppDate());
			dto.setStaffName(regal.get(0).getStaff());
			BusySchedule []bs = new BusySchedule[regal.size()];

			int i=0;
			for(ProcessSteps psp :regal) {
				BusySchedule sch=new BusySchedule();
				sch.setTimeSlot(regal.get(i).getStartTime()+":"+ regal.get(i).getEndTime());
				//sch.setTimeSlot(psp.getStartTime()+ ":" + psp.getEndTime());
				bs[i]=sch;
				//dto.setBusySchedule(bs);
				i++;
			}
			dto.setBusySchedule(bs);
			appByProcedure.add(dto);
			}
			
		}
		return appByProcedure;
	}



	public  List<AppointmentByProcedureDTO> getAppointmentByProcForGivenDate2(String procedure, Date date) {


		List<AppointmentByProcedureDTO> appByProcedure=new ArrayList<AppointmentByProcedureDTO>();
		List<App> aObject= (List<App>) arep.findByAppDate(date);
		if(aObject.size()!=0) {
			//	List<App> aObject1= (List<App>) arep.findByClientID("Patric");
			ArrayList<String> str= new ArrayList<String>();

			for(App obj:aObject) {
				str.add(obj.getId());

			}

			List<ProcessSteps> psteps = new ArrayList<ProcessSteps>();
			List<ProcessSteps> psteps1 = new ArrayList<ProcessSteps>();
			ProcessSteps ps = new ProcessSteps();
			for(String  obj:str) {
				psteps1=( ArrayList<ProcessSteps>) (psrep.findByAid(obj));
				for(ProcessSteps ps2: psteps1)
					psteps.add(ps2);

			}

			List<ProcessSteps> regal = new ArrayList<ProcessSteps>();
			for(ProcessSteps p : psteps) {
				if(p.getStaff().equals("Regal"))
					regal.add(p);

			}
			AppointmentByProcedureDTO dto=new AppointmentByProcedureDTO();

			dto.setAppDate(aObject.get(0).getAppDate());
			dto.setStaffName(regal.get(0).getStaff());
			BusySchedule []bs = new BusySchedule[regal.size()];

			int i=0;
			for(ProcessSteps psp :regal) {
				BusySchedule sch=new BusySchedule();
				sch.setTimeSlot(regal.get(i).getStartTime()+":"+ regal.get(i).getEndTime());
				//sch.setTimeSlot(psp.getStartTime()+ ":" + psp.getEndTime());
				bs[i]=sch;
				//dto.setBusySchedule(bs);
				i++;
			}
			dto.setBusySchedule(bs);
			appByProcedure.add(dto);
		}
		return appByProcedure;
	}




}