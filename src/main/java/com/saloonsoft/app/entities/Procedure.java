package com.saloonsoft.app.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.saloonsoft.app.dto.ProcedureStepsDTO;

@Document(collection = "Procedure")
public class Procedure {
	@Id
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	private String processID; 
	private String processName;
	private String duration;
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
	
	
}
