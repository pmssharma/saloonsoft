package com.saloonsoft.app.dto;

import java.util.Arrays;

public class AppointDto {

	//private String id;
	private String appDate;
	private String clientID;
	private String processName;
	private String timeSlot;
	private ProcedureStepsDTO[] procedureStepsDTO;
	
	
	public ProcedureStepsDTO[] getProcedureStepsDTO() {
		return procedureStepsDTO;
	}
	public void setProcedureStepsDTO(ProcedureStepsDTO[] procedureStepsDTO) {
		this.procedureStepsDTO = procedureStepsDTO;
	}
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
		return procedureStepsDTO;
	}
	public void setProcedureSteps(ProcedureStepsDTO[] procedureSteps) {
		this.procedureStepsDTO = procedureSteps;
	}
	
	@Override
	public String toString() {
		return "AppointDto [appDate=" + appDate + ", clientID=" + clientID + ", processName=" + processName
				+ ", timeSlot=" + timeSlot + ", procedureStepsDTO=" + Arrays.toString(procedureStepsDTO) + "]";
	}
	
	
	
}
