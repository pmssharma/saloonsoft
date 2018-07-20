package com.saloonsoft.app.repositories;


import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.saloonsoft.app.entities.App;



@Repository
public interface AppRep extends CrudRepository<App, String> {
	
	public List<App> findByAppDate(Date appDate);
	public List<App> findByClientID(String clientID);
	
}
