package com.saloonsoft.app.dto;

import java.util.Arrays;
import java.util.Date;
import com.saloonsoft.app.util.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class AppointmentObject
{
	private String id;
	private String clientID;
	@JsonSerialize(using = CustomDateSerializerForDate.class)
	private Date appDate;
	private ProcessObject[] processName;
   
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ProcessObject[] getProcessName ()
    {
        return processName;
    }

    public void setProcessName (ProcessObject[] processName)
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

	public Date getAppDate() {
		return appDate;
	}

	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}

	@Override
	public String toString() {
		return "AppointmentObject [id=" + id + ", clientID=" + clientID + ", appDate=" + appDate + ", processName="
				+ Arrays.toString(processName) + "]";
	}
    
}
