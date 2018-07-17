package com.saloonsoft.app.repositories;




import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.saloonsoft.app.entities.AppointmentCollection;




@Repository
public interface Appointmentepository extends CrudRepository<AppointmentCollection, String> {
	
	public List<AppointmentCollection> findByAppDate(String appDate);
}
