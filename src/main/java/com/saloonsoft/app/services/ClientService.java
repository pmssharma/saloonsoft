package com.saloonsoft.app.services;


import java.util.List;

import com.saloonsoft.app.dto.ClientDTO;


public interface ClientService {

	String insertClient(ClientDTO clientDto);
	
	List<ClientDTO> getClientByClientId(String clientId);

	String delete(String clientId); 
}
