package com.saloonsoft.app.dto;

public class ProcedureStepsObject {

	
	    private String duration;
	    private String staff;
	    private String procedure;

	    public String getDuration ()
	    {
	        return duration;
	    }

	    public void setDuration (String duration)
	    {
	        this.duration = duration;
	    }

	    public String getStaff ()
	    {
	        return staff;
	    }

	    public void setStaff (String staff)
	    {
	        this.staff = staff;
	    }

	    public String getProcedure ()
	    {
	        return procedure;
	    }

	    public void setProcedure (String procedure)
	    {
	        this.procedure = procedure;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [duration = "+duration+", staff = "+staff+", procedure = "+procedure+"]";
	    }
	}

