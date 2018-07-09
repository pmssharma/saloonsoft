package com.saloonsoft.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.saloonsoft.app.dto.PublicHolidaysDTO;
import com.saloonsoft.app.services.AdminService;


@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@RequestMapping(value = "/v1/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String insertPublicHolidays(@RequestBody PublicHolidaysDTO holidaysDto) {
		return adminService.insertPublicHolidays(holidaysDto);
	}

	
}
