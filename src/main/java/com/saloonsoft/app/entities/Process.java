package com.saloonsoft.app.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Process")

public class Process
{
	@Id
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
    
	private String name;
    private String timeSlot;
    private String aid;

    public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    
    public String getTimeSlot ()
    {
        return timeSlot;
    }

    public void setTimeSlot (String timeSlot)
    {
        this.timeSlot = timeSlot;
    }

   
}
