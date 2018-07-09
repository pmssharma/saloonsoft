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
import com.saloonsoft.app.dto.StaffDTO;
import com.saloonsoft.app.entities.Staff;
import com.saloonsoft.app.repositories.StaffRepository;


@Service
public class StaffServiceImpl implements StaffService{
	
	@Autowired
	StaffRepository staffRepository;

	@Override
	public String insertStaff(StaffDTO staffDto) {
		
		 Staff staff = new Staff();
		 BeanUtils.copyProperties(staffDto, staff);
		 staffRepository.save(staff);
		 //staffRepository.save(appointment.())
		 return staff.getId();
			
	}
		
	@Override
	public  List<StaffDTO> findByiDNumber(String staffiDNumber) {
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
 