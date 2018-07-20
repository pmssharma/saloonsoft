package com.saloonsoft.app.dto;

import java.util.Arrays;

public class ProcessObject
{
	private String id;
    private String name;
    private String timeSlot;
    private ProcedureStepsDTO[] procedureSteps;
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public ProcedureStepsDTO[] getProcedureSteps()
    {
        return procedureSteps;
    }

    public void setProcedureSteps(ProcedureStepsDTO[] procedureSteps)
    {
        this.procedureSteps = procedureSteps;
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
	public String toString() {
		return "ProcessObject [id=" + id + ", name=" + name + ", procedureSteps=" + Arrays.toString(procedureSteps)
				+ ", timeSlot=" + timeSlot + "]";
	}
    
}