package com.saloonsoft.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.saloonsoft.app.dto.DownTimeRecurringDTO;
import com.saloonsoft.app.entities.DownTimeRecurring;



@Repository
public interface DownTimeRecurringRepository extends CrudRepository<DownTimeRecurring, String> {
	
	//public List<Client> findByClient(String client);
	
	DownTimeRecurringDTO findByDownTimeId(String downTimeId);
		
}
