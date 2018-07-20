package com.saloonsoft.app.dto;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.saloonsoft.app.util.CustomDateSerializer;

public class ProcedureStepsDTO {

	private String id;
	private String staff;
	private String procedureStepID;
	private String procedure;
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date startTime;
	@JsonSerialize(using = CustomDateSerializer.class)
	private Date endTime;
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
	
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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

	@Override
	public String toString() {
		return "ProcedureStepsDTO [id=" + id + ", staff=" + staff + ", procedureStepID=" + procedureStepID
				+ ", procedure=" + procedure + ", startTime=" + startTime + ", endTime=" + endTime + ", duration="
				+ duration + "]";
	}

}
