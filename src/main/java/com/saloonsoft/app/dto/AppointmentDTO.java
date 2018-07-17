package com.saloonsoft.app.dto;


public class AppointmentDTO {

	
	private String appDate;
	private String appID;
	private String clientID;
	private String stylishName;
	private String processName;
	private String procedureStep;
	private String timeSlot;
	
	public String getAppDate() {
		return appDate;
	}
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}
	public String getAppID() {
		return appID;
	}
	public void setAppID(String appID) {
		this.appID = appID;
	}
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	public String getStylishName() {
		return stylishName;
	}
	public void setStylishName(String stylishName) {
		this.stylishName = stylishName;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public String getProcedureStep() {
		return procedureStep;
	}
	public void setProcedureStep(String procedureStep) {
		this.procedureStep = procedureStep;
	}
	public String getTimeSlot() {
		return timeSlot;
	}
	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

}
