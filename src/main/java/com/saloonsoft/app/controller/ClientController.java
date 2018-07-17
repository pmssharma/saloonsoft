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
import com.saloonsoft.app.dto.ClientDTO;
import com.saloonsoft.app.services.ClientService;


@RestController
@RequestMapping("/api/client")
public class ClientController {

	@Autowired
	ClientService clientService;

	@RequestMapping(value = "/v1/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String insertClient(@RequestBody ClientDTO clientDto) {
		return clientService.insertClient(clientDto);
	}

	/*@RequestMapping(value = "/v1/findByiDNumber", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StaffDTO> getStaffByCode(@Valid @RequestParam String staffCode) {
		return staffService.findByiDNumber(staffCode);
	}*/

	@RequestMapping(value = "/v1/findByClientId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClientDTO> getClientByCLientId(@Valid @RequestParam String clientId) {
		return clientService.getClientByClientId(clientId);
	}
	
	@RequestMapping(value = "/v1/deleteByCientId", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteByClientId(@Valid @RequestParam String clientId) {
		return clientService.delete(clientId);
	}
}
