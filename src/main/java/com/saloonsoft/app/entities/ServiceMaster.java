package com.saloonsoft.app.entities;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.saloonsoft.app.dto.ServiceStepsMasterDTO;

@Document(collection = "ServiceMaster")
public class ServiceMaster {
	@Id
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	private String serviceID; 
	private String serviceName;
	private String duration;
	private int serviceStepCount;
	private ServiceStepsMasterDTO[] serviceStepsMaster;
	
	public String getServiceID() {
		return serviceID;
	}
	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getServiceStepCount() {
		return serviceStepCount;
	}
	public void setServiceStepCount(int serviceStepCount) {
		this.serviceStepCount = serviceStepCount;
	}
	public ServiceStepsMasterDTO[] getServiceStepsMaster() {
		return serviceStepsMaster;
	}
	public void setServiceStepsMaster(ServiceStepsMasterDTO[] serviceStepsMaster) {
		this.serviceStepsMaster = serviceStepsMaster;
	}

	@Override
	public String toString() {
		return "ServiceMaster [id=" + id + ", serviceID=" + serviceID + ", serviceName=" + serviceName + ", duration="
				+ duration + ", serviceStepCount=" + serviceStepCount + ", serviceStepsMaster="
				+ Arrays.toString(serviceStepsMaster) + "]";
	}
	
}
