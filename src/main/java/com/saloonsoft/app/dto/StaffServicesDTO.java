package com.saloonsoft.app.dto;

import java.util.Arrays;

public class StaffServicesDTO {
	
	private String id;
	private String serviceName;
	private StaffServiceStepsDTO[] staffServiceStepsDTO;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	public StaffServiceStepsDTO[] getStaffServiceStepsDTO() {
		return staffServiceStepsDTO;
	}
	public void setStaffServiceStepsDTO(StaffServiceStepsDTO[] staffServiceStepsDTO) {
		this.staffServiceStepsDTO = staffServiceStepsDTO;
	}
	
	@Override
	public String toString() {
		return "StaffServicesDTO [id=" + id + ", serviceName=" + serviceName + ", staffServiceStepsDTO="
				+ Arrays.toString(staffServiceStepsDTO) + "]";
	}
	
}
