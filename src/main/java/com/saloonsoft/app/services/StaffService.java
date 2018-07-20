package com.saloonsoft.app.services;


import java.util.List;
import com.saloonsoft.app.dto.StaffDTO;


public interface StaffService {

	String insertStaff(StaffDTO staffDTO);
	 
	List<StaffDTO> findByiDNumber(String staffiDNumber);

	String delete(String staffId);
	
	String updateStaff(StaffDTO staffDTO);

	List<StaffDTO> getStaffAll();
	 
}
