package com.saloonsoft.app.dto;

public class StaffServicesDTO {
	
	private String serviceName;
	private StaffServiceStepsDTO[] staffServiceStepsDTO;
	
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
	
	

}
