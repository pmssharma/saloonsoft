package com.saloonsoft.app.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.bson.Document;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.saloonsoft.app.dto.AppointmentObject;
import com.saloonsoft.app.dto.ProcedureStepsDTO;
import com.saloonsoft.app.dto.ProcedureStepsObject;
import com.saloonsoft.app.dto.ProcessObject;
import com.saloonsoft.app.entities.App;
import com.saloonsoft.app.entities.AppointmentCollection;
import com.saloonsoft.app.entities.AppointmentCollection2;
import com.saloonsoft.app.entities.ProcedureCollection;
import com.saloonsoft.app.entities.ProcedureStepsCollection;
import com.saloonsoft.app.entities.ProcessCollection;
import com.saloonsoft.app.entities.ProcessSteps;
import com.saloonsoft.app.repositories.AppRep;
import com.saloonsoft.app.repositories.Appointmentepository;
import com.saloonsoft.app.repositories.ProcessRep;
import com.saloonsoft.app.repositories.ProcessStepsRep;
import com.saloonsoft.app.repositories.StaffRepository;

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
				psteps.setProcedure(pobj[i].getProcedureSteps()[j].getProcedure());
				psteps.setStaff(pobj[i].getProcedureSteps()[j].getStaff());
				psteps.setPid(p.getId());
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
	public  List<AppointmentObject> getAppointmentByDate(String appDate) {
		List<AppointmentObject> appointmentObject = new ArrayList<AppointmentObject>();
		List<App> aObject= (List<App>) arep.findByAppDate(appDate);
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
}
