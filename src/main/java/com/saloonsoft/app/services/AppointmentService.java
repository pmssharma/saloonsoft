package com.saloonsoft.app.services;


import java.util.List;
import com.saloonsoft.app.dto.AppointmentObject;
import com.saloonsoft.app.dto.ProcedureStepsDTO;


public interface AppointmentService {

	 String insertAppointment(AppointmentObject employeeDto);
	 
	 List<AppointmentObject> getAppointmentByDate(String appDate);
	 List<AppointmentObject> getAppointmentByClientID(String clientID);
	 
	List<ProcedureStepsDTO> getAppointmentByStaff(String appDate);
	 
	 
} 
