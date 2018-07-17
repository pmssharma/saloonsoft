package com.saloonsoft.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.saloonsoft.app.dto.DownTimeOnceOffDTO;
import com.saloonsoft.app.entities.DownTimeOnceOff;

@Repository
public interface DownTimeOnceOffRepository extends CrudRepository<DownTimeOnceOff, String> {
	
	//public List<Client> findByClient(String client);
	
	DownTimeOnceOffDTO findByDownTimeId(String downTimeId);
	
}
