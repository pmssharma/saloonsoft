package com.saloonsoft.app.dto;



public class PublicHolidaysDTO {

	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String publicHolidayDesc;
	private int year;
	private String startDate;
	private String startTime;
	private String endDate;
	private String endTime;
	
	public String getPublicHolidayDesc() {
		return publicHolidayDesc;
	}

	public void setPublicHolidayDesc(String publicHolidayDesc) {
		this.publicHolidayDesc = publicHolidayDesc;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "PublicHolidaysDTO [id=" + id + ", publicHolidayDesc=" + publicHolidayDesc + ", year=" + year
				+ ", startDate=" + startDate + ", startTime=" + startTime + ", endDate=" + endDate + ", endTime="
				+ endTime + ", getId()=" + getId() + ", getPublicHolidayDesc()=" + getPublicHolidayDesc()
				+ ", getStartTime()=" + getStartTime() + ", getEndTime()=" + getEndTime() + ", getStartDate()="
				+ getStartDate() + ", getEndDate()=" + getEndDate() + ", getYear()=" + getYear() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
