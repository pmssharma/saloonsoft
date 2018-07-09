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
import com.saloonsoft.app.dto.AppointmentObject;
import com.saloonsoft.app.dto.ProcedureStepsDTO;
import com.saloonsoft.app.services.AppointmentService;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

	@Autowired
	AppointmentService appService;

	@RequestMapping(value = "/v1/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String insertAppointment(@RequestBody AppointmentObject requestDto) {
		//System.out.println(requestDto.toString());
		return appService.insertAppointment(requestDto);
	}

	@RequestMapping(value = "/v1/getAppointmentByDate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AppointmentObject> getAppointmentByDate(@Valid @RequestParam String appDate) {
		
		return appService.getAppointmentByDate(appDate);
	}
	
	@RequestMapping(value = "/v1/getAppointmentByClientID", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AppointmentObject> getAppointmentByClientID(@Valid @RequestParam String clientID) {
		
		return appService.getAppointmentByClientID(clientID);
	}
	
	@RequestMapping(value = "/v1/getAppointmentByStaff", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProcedureStepsDTO> getAppointmentByStaff(@Valid @RequestParam String staff) {
		
		return appService.getAppointmentByStaff(staff);
	}

	
}
