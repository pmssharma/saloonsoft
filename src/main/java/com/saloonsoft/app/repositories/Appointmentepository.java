package com.saloonsoft.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.saloonsoft.app.entities.App;





@Repository
public interface Appointmentepository extends CrudRepository<App, String> {
	
	//public List<AppointmentCollection> findByAppDate(String appDate);
}
