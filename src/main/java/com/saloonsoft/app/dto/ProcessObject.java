package com.saloonsoft.app.dto;


public class ProcessObject
{
    private String name;
    private ProcedureStepsDTO[] procedureSteps;
    private String timeSlot;
    
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
    public String toString()
    {
        return "ClassPojo [name = "+name+", procedureSteps = "+procedureSteps+", timeSlot = "+timeSlot+"]";
    }
}
