package com.saloonsoft.app.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.saloonsoft.app.entities.Client;


@Repository
public interface ClientRepository extends CrudRepository<Client, String> {
	
	public List<Client> findByClientId(String client);
	public List<Client> findAll();
	//public  String  delete(String clientId);
	
	
}
