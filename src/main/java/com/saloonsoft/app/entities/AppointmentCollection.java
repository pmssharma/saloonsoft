package com.saloonsoft.app.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.saloonsoft.app.dto.ProcessObject;
import com.saloonsoft.app.entities.ProcessCollection;


@Document(collection = "AppointmentCollection")

public class AppointmentCollection {

	@Id
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	    
	    private ProcessCollection[] processName;
	    private String clientID;
	    private String appDate;

	    public ProcessCollection[] getProcessName ()
	    {
	        return processName;
	    }

	    public void setProcessName (ProcessCollection[] processName)
	    {
	        this.processName = processName;
	    }

	    public String getClientID ()
	    {
	        return clientID;
	    }

	    public void setClientID (String clientID)
	    {
	        this.clientID = clientID;
	    }

	    public String getAppDate ()
	    {
	        return appDate;
	    }

	    public void setAppDate (String appDate)
	    {
	        this.appDate = appDate;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [processName = "+processName+", clientID = "+clientID+", appDate = "+appDate+"]";
	    }
	}
