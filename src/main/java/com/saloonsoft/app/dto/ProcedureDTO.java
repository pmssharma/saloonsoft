package com.saloonsoft.app.dto;



public class ProcedureDTO {

	private String processID; 
	private String processName;
	private String duration;
	private int stepCount;
	private ProcedureStepsDTO[] procedureSteps;
	
	public String getProcessID() {
		return processID;
	}
	public void setProcessID(String processID) {
		this.processID = processID;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public ProcedureStepsDTO[] getProcedureSteps() {
		return procedureSteps;
	}
	public void setProcedureSteps(ProcedureStepsDTO[] procedureSteps) {
		this.procedureSteps = procedureSteps;
	}
	public int getStepCount() {
		return stepCount;
	}
	public void setStepCount(int stepCount) {
		this.stepCount = stepCount;
	}
		
}
