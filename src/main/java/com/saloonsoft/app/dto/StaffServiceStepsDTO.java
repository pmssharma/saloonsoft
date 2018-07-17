package com.saloonsoft.app.dto;

public class StaffServiceStepsDTO {
	
	private String id;
	private String stepID;
	private String stepName;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStepID() {
		return stepID;
	}
	public void setStepID(String stepID) {
		this.stepID = stepID;
	}
	public String getStepName() {
		return stepName;
	}
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}
	@Override
	public String toString() {
		return "StaffServiceStepsDTO [id=" + id + ", stepID=" + stepID + ", stepName=" + stepName + "]";
	}
	
}
