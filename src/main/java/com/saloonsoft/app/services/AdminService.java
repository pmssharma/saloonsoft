package com.saloonsoft.app.services;


import java.util.List;
import com.saloonsoft.app.dto.DownTimeOnceOffDTO;
import com.saloonsoft.app.dto.DownTimeRecurringDTO;
import com.saloonsoft.app.dto.PublicHolidaysDTO;
import com.saloonsoft.app.dto.ServiceMasterDTO;
import com.saloonsoft.app.dto.WeekTradingHoursDTO;
import com.saloonsoft.app.dto.StaffDTO;
import com.saloonsoft.app.dto.StaffRoleDTO;

public interface AdminService {

	String insertPublicHolidays(PublicHolidaysDTO pulicHolidayDTO);
	 
	String insertWeekTradingHours(WeekTradingHoursDTO weekTradingHoursDTO);
	 
	String insertDownTimeRecurring(DownTimeRecurringDTO downTimeRecurringDTO);
	 
	String insertDownTimeOnceOff(DownTimeOnceOffDTO downTimeOnceOffDTO);

	List<StaffDTO> findAll();

	PublicHolidaysDTO findByPublicHolidayDesc(String publicHolidayDesc);

	String deletePubliHoliday(String publicHolidaysDesc);

	DownTimeRecurringDTO findByDownTimeIdRec(String downTimeId);
	String deleteDownTimeRecurring(String downTimeRecurring);

	DownTimeOnceOffDTO findByDownTimeIdOnce(String downTimeId);
	String deleteDownTimeOnceOff(String downTimeOnceOff);
	
	String insertStaffRole(StaffRoleDTO staffRoleDTO);
	
	List<StaffRoleDTO> getRoles();
	
	String insertService(ServiceMasterDTO serviceMasterDTO);
	
	List<ServiceMasterDTO> getServices();
	 
}