package com.saloonsoft.app.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "ProcessCollection")

public class ProcedureCollection
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
    private ProcedureStepsCollection[] procedureStepsCollection;
    private String timeSlot;

    public String getName ()
    {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public ProcedureStepsCollection[] getProcedureStepsCollection ()
    {
        return procedureStepsCollection;
    }

    public void setProcedureStepsCollection (ProcedureStepsCollection[] procedureStepsCollection)
    {
        this.procedureStepsCollection = procedureStepsCollection;
    }

    public String getTimeSlot ()
    {
        return timeSlot;
    }

    public void setTimeSlot (String timeSlot)
    {
        this.timeSlot = timeSlot;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [name = "+name+", procedureStepsDTO = "+procedureStepsCollection+", timeSlot = "+timeSlot+"]";
    }
}
