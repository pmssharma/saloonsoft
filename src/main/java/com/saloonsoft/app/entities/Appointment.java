package com.saloonsoft.app.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.saloonsoft.app.dto.ProcedureStepsDTO;



@Document(collection = "Appointment")
public class Appointment {

	@Id
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	private String appDate;
	private String clientID;
	private String processName;
	private String timeSlot;
	private ProcedureStepsDTO[] procedureSteps;
	
	
	public String getAppDate() {
		return appDate;
	}
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}
	
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	
	public String getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}
	
	public ProcedureStepsDTO[] getProcedureSteps() {
		return procedureSteps;
	}
	public void setProcedureSteps(ProcedureStepsDTO[] procedureSteps) {
		this.procedureSteps = procedureSteps;
	}
	
}
