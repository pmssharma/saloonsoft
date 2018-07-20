package com.saloonsoft.app.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.saloonsoft.app.dto.ProcessObject;
import com.saloonsoft.app.entities.ProcessCollection;


@Document(collection = "AppointmentCollection2")

public class AppointmentCollection2 {

	@Id
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	    String  processName;
	    public String getProcessName() {
			return processName;
		}
		public void setProcessName(String processName) {
			this.processName = processName;
		}
		public String getClientID() {
			return clientID;
		}
		public void setClientID(String clientID) {
			this.clientID = clientID;
		}
		public String getAppDate() {
			return appDate;
		}
		public void setAppDate(String appDate) {
			this.appDate = appDate;
		}
		public String getProcedureName() {
			return procedureName;
		}
		public void setProcedureName(String procedureName) {
			this.procedureName = procedureName;
		}
		public String getStaff() {
			return staff;
		}
		public void setStaff(String staff) {
			this.staff = staff;
		}
		public String getDuration() {
			return duration;
		}
		public void setDuration(String duration) {
			this.duration = duration;
		}

		private String clientID;
	    private String appDate;
	    private String procedureName;
	    private String staff;
	    private String duration;

	   
	   
	   
	}
