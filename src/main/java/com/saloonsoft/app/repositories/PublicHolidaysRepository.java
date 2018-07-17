package com.saloonsoft.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saloonsoft.app.dto.PublicHolidaysDTO;
import com.saloonsoft.app.entities.PublicHolidays;


@Repository
public interface PublicHolidaysRepository extends CrudRepository<PublicHolidays, String> {
	
	//public List<Client> findByClient(String client);
	
	public PublicHolidaysDTO findByPublicHolidayDesc(String publicHolidayDesc);
	
	
}
