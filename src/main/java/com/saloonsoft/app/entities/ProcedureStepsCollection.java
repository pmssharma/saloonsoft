package com.saloonsoft.app.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProcedureStepsCollection")

public class ProcedureStepsCollection{

	@Id
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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

