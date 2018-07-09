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
import com.saloonsoft.app.dto.ProcedureDTO;
import com.saloonsoft.app.services.ProcedureService;

@RestController
@RequestMapping("/api/procedure")
public class ProcedureController {

	@Autowired
	ProcedureService procedureService;

	@RequestMapping(value = "/v1/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String insertProcessName(@RequestBody ProcedureDTO procedureDto) {
		return procedureService.insertProcessName(procedureDto);
	}

	@RequestMapping(value = "/v1/findByProcessID", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProcedureDTO> findByProcessID(@Valid @RequestParam String processID) {
		return procedureService.findByProcessID(processID);
	}
}
