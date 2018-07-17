package com.saloonsoft.app.dto;



public class DownTimeOnceOffDTO {

	private String id;
	private String downTimeId;
	private String downTimeDesc;
	private String staffId;
	private String startDate;
	private String startTime;
	private String endDate;
	private String endTime;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	
	@Override
	public String toString() {
		return "DownTimeOnceOffDTO [id=" + id + ", downTimeId=" + downTimeId + ", downTimeDesc=" + downTimeDesc
				+ ", staffId=" + staffId + ", startDate=" + startDate + ", startTime=" + startTime + ", endDate="
				+ endDate + ", endTime=" + endTime + "]";
	}
	
}
