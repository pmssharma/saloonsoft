package com.saloonsoft.app.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.saloonsoft.app.dto.ProcedureDTO;
import com.saloonsoft.app.entities.Procedure;



@Repository
public interface ProcedureRepository extends CrudRepository<Procedure, String> {
	

//	public String insertProcessName(ProcedureDTO prodecureDTO);
	
	public List<ProcedureDTO> findByProcessID(String processID);
	
}
