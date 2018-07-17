package com.saloonsoft.app.services;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saloonsoft.app.dto.ClientDTO;
import com.saloonsoft.app.entities.Client;
import com.saloonsoft.app.repositories.ClientRepository;


@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	ClientRepository clientRepository;

	@Override
	public String insertClient(ClientDTO clientDto) {
		
		 Client client = new Client();
		 System.out.println("################# In DTO #####################");
		 System.out.println(clientDto.toString());
		 BeanUtils.copyProperties(clientDto, client);
		 System.out.println("################# In Entity #####################");
		 System.out.println(client.toString());
		 clientRepository.save(client);
		 return client.getId();
	}
		
	@Override
	public  List<ClientDTO> getClientByClientId(String clientId) {
        
		List<ClientDTO> clientDTOs = new ArrayList<ClientDTO>();
		ClientDTO clientDTO = new ClientDTO();
		clientDTO = (ClientDTO) clientRepository.findByClientId(clientId);
		clientDTOs.add(clientDTO);

		return clientDTOs;
	}
	
	@Override
	public  String  delete(String clientId) {
		
		List<Client> clientEntList = new ArrayList<Client>();
		clientEntList =clientRepository.findByClientId(clientId);
		Client client = new Client();
		for(Client cleintList:clientEntList ) {
			BeanUtils.copyProperties(cleintList, client);
			clientRepository.delete(client);
		}
		return clientId;
	}
} 