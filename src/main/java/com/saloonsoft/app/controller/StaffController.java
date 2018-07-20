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
import com.saloonsoft.app.dto.StaffDTO;
import com.saloonsoft.app.services.StaffService;


@RestController
@RequestMapping("/api/staff")
public class StaffController {

	@Autowired
	StaffService staffService;

	@RequestMapping(value = "/v1/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String insertStaff(@RequestBody StaffDTO staffDto) {
		return staffService.insertStaff(staffDto);
	}

	@RequestMapping(value = "/v1/findByiDNumber", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StaffDTO> getStaffByCode(@Valid @RequestParam String staffCode) {
		return staffService.findByiDNumber(staffCode);
	}
	
	@RequestMapping(value = "/v1/deleteByStaffId", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteByStaffId(@Valid @RequestParam String staffId) {
		return staffService.delete(staffId);
	}

	@RequestMapping(value = "/v1/updateStaff", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateStaff(@Valid @RequestParam StaffDTO staffDTO) {
		return staffService.updateStaff(staffDTO);
	}

	@RequestMapping(value = "/v1/getStaffAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StaffDTO> getStaffAll() {
		return staffService.getStaffAll();
	}
	
}