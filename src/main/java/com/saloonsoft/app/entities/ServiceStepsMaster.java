package com.saloonsoft.app.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ServiceStepsMaster")
public class ServiceStepsMaster {
	@Id
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	private String serviceStepID;
	private String ServiceStepName;
	private String duration;
	
	public String getServiceStepID() {
		return serviceStepID;
	}
	public void setServiceStepID(String serviceStepID) {
		this.serviceStepID = serviceStepID;
	}
	public String getServiceStepName() {
		return ServiceStepName;
	}
	public void setServiceStepName(String serviceStepName) {
		ServiceStepName = serviceStepName;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		return "ServiceStepsMaster [id=" + id + ", serviceStepID=" + serviceStepID + ", ServiceStepName="
				+ ServiceStepName + ", duration=" + duration + "]";
	}
	
}
