package com.saloonsoft.app.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.saloonsoft.app.dto.ProcedureStepsDTO;

@Document(collection = "PublicHolidays")
public class PublicHolidays {
	@Id
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	private String publicHolidayDesc; 
	private String startTime;
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
	
	
	
}
