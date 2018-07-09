package com.saloonsoft.app.dto;

public class AppointmentObject
{
    private ProcessObject[] processName;
    private String clientID;
    private String appDate;

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
