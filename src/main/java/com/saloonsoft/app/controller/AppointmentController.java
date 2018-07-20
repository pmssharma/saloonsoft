package com.saloonsoft.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saloonsoft.app.dto.AppointmentByProcedureDTO;
import com.saloonsoft.app.dto.AppointmentObject;
import com.saloonsoft.app.dto.ProcedureStepsDTO;
import com.saloonsoft.app.services.AppointmentService;
import com.saloonsoft.app.util.AppointmentUtil;

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
	public List<AppointmentObject> getAppointmentByDate(@Valid @RequestParam String appDate) throws ParseException {
		Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(appDate);
		return appService.getAppointmentByDate(date1);
	}
	
	@RequestMapping(value = "/v1/getAppointmentByClientID", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AppointmentObject> getAppointmentByClientID(@Valid @RequestParam String clientID) {
		
		return appService.getAppointmentByClientID(clientID);
	}
	
	@RequestMapping(value = "/v1/getAppointmentByStaff", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProcedureStepsDTO> getAppointmentByStaff(@Valid @RequestParam String staff) {
		
		return appService.getAppointmentByStaff(staff);
	}
	
	@RequestMapping(value = "/v1/getAppointmentByProcForGivenDate", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AppointmentByProcedureDTO> getAppointmentByProcForGivenDate(@Valid @RequestParam String process, String date) throws ParseException {
		Date cdate=AppointmentUtil.toDate(date);
		return appService.getAppointmentByProcForGivenDate(process, cdate);
	}
}
