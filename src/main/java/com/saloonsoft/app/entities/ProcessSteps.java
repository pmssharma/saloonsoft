package com.saloonsoft.app.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProcessSteps")
public class ProcessSteps {
	@Id
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	private String staff;
	private String procedureStepID;
	private String procedure;
	private Date startTime;
	private Date endTime;
	private String duration;
	private String pid;
	private String aid;
	
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
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	
	@Override
	public String toString() {
		return "ProcessSteps [id=" + id + ", staff=" + staff + ", procedureStepID=" + procedureStepID + ", procedure="
				+ procedure + ", startTime=" + startTime + ", endTime=" + endTime + ", duration=" + duration + ", pid="
				+ pid + ", aid=" + aid + "]";
	}

	
	
}
