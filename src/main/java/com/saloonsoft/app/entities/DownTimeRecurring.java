package com.saloonsoft.app.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "DownTimeRecurring")
public class DownTimeRecurring {
	@Id
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	private String downTimeId;
	private String downTimeDesc;
	private String staffId;
	private String startDate;
	private String startTime;
	private String endDate;
	private String endTime;
	
	public String getDownTimeId() {
		return downTimeId;
	}
	public void setDownTimeId(String downTimeId) {
		this.downTimeId = downTimeId;
	}
	public String getDownTimeDesc() {
		return downTimeDesc;
	}
	public void setDownTimeDesc(String downTimeDesc) {
		this.downTimeDesc = downTimeDesc;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}
