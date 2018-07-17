package com.saloonsoft.app.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "WeekTradingHours")
public class WeekTradingHours{
	@Id
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	private String dayName;
	private String startTime;
	private String endTime;
	
	
	public String getDayName() {
		return dayName;
	}
	
	public void setDayName(String dayName) {
		this.dayName = dayName;
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
