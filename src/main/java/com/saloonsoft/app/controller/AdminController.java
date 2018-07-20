package com.saloonsoft.app.controller;


import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.saloonsoft.app.dto.DownTimeOnceOffDTO;
import com.saloonsoft.app.dto.DownTimeRecurringDTO;
import com.saloonsoft.app.dto.PublicHolidaysDTO;
import com.saloonsoft.app.dto.ServiceMasterDTO;
import com.saloonsoft.app.dto.StaffDTO;
import com.saloonsoft.app.dto.StaffRoleDTO;
import com.saloonsoft.app.dto.WeekTradingHoursDTO;
import com.saloonsoft.app.services.AdminService;


@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "/v1/1", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String insertPublicHolidays(@RequestBody PublicHolidaysDTO holidaysDto) {
		return adminService.insertPublicHolidays(holidaysDto);
	}

	@RequestMapping(value = "/v1/insertWeekTradingHours", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String insertWeekTradingHours(@RequestBody WeekTradingHoursDTO tradingHoursDTO) {
		return adminService.insertWeekTradingHours(tradingHoursDTO);
	}
	
	@RequestMapping(value = "/v1/insertDownTimeRecurring", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String insertDownTimeRecurring(@RequestBody DownTimeRecurringDTO downTimeRecurringDTO) {
		return adminService.insertDownTimeRecurring(downTimeRecurringDTO);
	}
	
	@RequestMapping(value = "/v1/insertDownTimeOnceOff", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String insertDownTimeOnceOff(@RequestBody DownTimeOnceOffDTO downTimeOnceOffDTO) {
		return adminService.insertDownTimeOnceOff(downTimeOnceOffDTO);
	}
	
	@RequestMapping(value = "/v1/findStaffBootstrap", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StaffDTO> findStaffBootstrap( ) {
		return adminService.findAll();
	}
	
	@RequestMapping(value = "/v1/deletePublicHoliday", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deletePublicHoliday(@Valid @RequestParam String publicHolidayDesc) {
		return adminService.deletePubliHoliday(publicHolidayDesc);
	}
	
	@RequestMapping(value = "/v1/deleteDownTimeRecurring", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteDownTimeRecurring(@Valid @RequestParam String downTimeRecurring) {
		return adminService.deleteDownTimeRecurring(downTimeRecurring);
	}
	
	@RequestMapping(value = "/v1/deleteDownTimeOnceOff", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteDownTimeOnceOff(@Valid @RequestParam String downTimeOnceOff) {
		return adminService.deleteDownTimeOnceOff(downTimeOnceOff);
	}
	
	@RequestMapping(value = "/v1/insertStaffRole", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String insertStaffRole(@RequestBody StaffRoleDTO staffRoleDTO) {
		return adminService.insertStaffRole(staffRoleDTO);
	}
	
	@RequestMapping(value = "/v1/getRoles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StaffRoleDTO> getRoles( ) {
		return adminService.getRoles();
	}
	
	@RequestMapping(value = "/v1/insertService", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String insertProcessName(@RequestBody ServiceMasterDTO serviceMasterDTO) {
		return adminService.insertService(serviceMasterDTO);
	}

	@RequestMapping(value = "/v1/getServices", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ServiceMasterDTO> getServices( ) {
		return adminService.getServices();
	}

	
}