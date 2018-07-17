package com.saloonsoft.app.repositories;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProcessRep extends CrudRepository<com.saloonsoft.app.entities.Process, String> {
	
	public List<com.saloonsoft.app.entities.Process> findByName(String name);
	public List<com.saloonsoft.app.entities.Process> findByTimeSlot(String name);
	public List<com.saloonsoft.app.entities.Process> findByAid(String name);
	
}
