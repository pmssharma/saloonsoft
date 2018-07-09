package com.saloonsoft.app.services;


import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.saloonsoft.app.dto.ProcedureDTO;
import com.saloonsoft.app.entities.Procedure;
import com.saloonsoft.app.repositories.ProcedureRepository;


@Service
public class ProcedureServiceImpl implements ProcedureService{
	
	@Autowired
	ProcedureRepository procedureRepository;

	@Override
	public String insertProcessName(ProcedureDTO procedureDto) {
		
		 Procedure procedure = new Procedure();
		 BeanUtils.copyProperties(procedureDto, procedure);
		 procedureRepository.save(procedure);
		 return procedure.getId();
			
	}
		
	@Override
	public  List<ProcedureDTO> findByProcessID(String processID) {
		MongoClient client = new MongoClient("localhost", 27017);
		MongoDatabase database = client.getDatabase("saloonsoft-db");
		MongoCollection<org.bson.Document> collection = database.getCollection("Staff");
 
		FindIterable<Document> documents = collection.find(); 
	      // Getting the iterator 
	      Iterator it = documents.iterator(); 
	      while (it.hasNext()) {  
	         System.out.println(it.next());  
	      }
		return null;
	}
}
 