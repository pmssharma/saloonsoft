package com.saloonsoft.app.repositories;




import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saloonsoft.app.entities.App;
import com.saloonsoft.app.entities.Appointment;
import com.saloonsoft.app.entities.AppointmentCollection;


@Repository
public interface AppRep extends CrudRepository<App, String> {
	
	public List<App> findByAppDate(String appDate);
	public List<App> findByClientID(String clientID);
}
