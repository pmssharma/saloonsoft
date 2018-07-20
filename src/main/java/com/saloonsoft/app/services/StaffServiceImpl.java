package com.saloonsoft.app.services;


import java.util.ArrayList;
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
import com.saloonsoft.app.dto.ServiceMasterDTO;
import com.saloonsoft.app.dto.StaffDTO;
import com.saloonsoft.app.entities.ServiceMaster;
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
	
	
	@Override
	public  String  delete(String staffId) {
		
		List<StaffDTO> staffDTOList = new ArrayList<StaffDTO>();
		//staffRepository.find
		
		staffDTOList = staffRepository.findByiDNumber(staffId);
		if(staffDTOList.size()>0) {
			staffRepository.deleteById(staffDTOList.get(0).getId());	
		}
		return staffId;
	}
	
	@Override
	public  String  updateStaff(StaffDTO staffDTO) {
		
		List<StaffDTO> staffDTOList = new ArrayList<StaffDTO>();
		//staffRepository.u		
		return staffDTO.getId();
	}

	@Override
	public List<StaffDTO> getStaffAll() {
		
		List<StaffDTO> staffListDTO =  new ArrayList<StaffDTO>();
		List<Staff> staffEntList = (List<Staff>) staffRepository.findAll();
	    for(Staff staff:staffEntList) {
	    	StaffDTO staffDTO = new StaffDTO();
	    	BeanUtils.copyProperties(staff, staffDTO);
	    	staffListDTO.add(staffDTO);
	    	
	    }
		return staffListDTO;
	}
}
 