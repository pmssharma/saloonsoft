package com.saloonsoft.app.dto;

public class ProcedureStepsDTO {

	private String id;
	private String staff;
	private String procedureStepID;
	private String procedure;
	private String duration;
	
	public String getStaff() {
		return staff;
	}
	
	public void setStaff(String staff) {
		this.staff = staff;
	}
	
	public String getProcedureStepID() {
		return procedureStepID;
	}
	
	public void setProcedureStepID(String procedureStepID) {
		this.procedureStepID = procedureStepID;
	}
	
	public String getProcedure() {
		return procedure;
	}
	
	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
