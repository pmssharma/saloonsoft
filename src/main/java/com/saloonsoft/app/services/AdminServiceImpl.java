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
import com.saloonsoft.app.dto.DownTimeOnceOffDTO;
import com.saloonsoft.app.dto.DownTimeRecurringDTO;
import com.saloonsoft.app.dto.PublicHolidaysDTO;
import com.saloonsoft.app.dto.StaffDTO;
import com.saloonsoft.app.dto.WeekTradingHoursDTO;
import com.saloonsoft.app.entities.DownTimeOnceOff;
import com.saloonsoft.app.entities.DownTimeRecurring;
import com.saloonsoft.app.entities.PublicHolidays;
import com.saloonsoft.app.entities.Staff;
import com.saloonsoft.app.entities.WeekTradingHours;
import com.saloonsoft.app.repositories.AdminRepository;
import com.saloonsoft.app.repositories.DownTimeOnceOffRepository;
import com.saloonsoft.app.repositories.DownTimeRecurringRepository;
import com.saloonsoft.app.repositories.PublicHolidaysRepository;
import com.saloonsoft.app.repositories.StaffRepository;


@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	StaffRepository staffRepository;
	
	@Autowired
	PublicHolidaysRepository publicHolidaysRepository;
	
	@Autowired
	DownTimeOnceOffRepository downTimeOnceOffRepository;
	
	@Autowired
	DownTimeRecurringRepository downTimeRecurringRepository;

	@Override
	public String insertPublicHolidays(PublicHolidaysDTO publicHolidaysDto) {
		
		 PublicHolidays publicHoliday = new PublicHolidays();
		 BeanUtils.copyProperties(publicHolidaysDto, publicHoliday);
		 publicHolidaysRepository.save(publicHoliday);
		 return publicHoliday.getId();
			
	}
	
	@Override
	public String insertWeekTradingHours(WeekTradingHoursDTO weekTradingHoursDTO) {
		
		 WeekTradingHours weekTradingHours = new WeekTradingHours();
		 BeanUtils.copyProperties(weekTradingHoursDTO, weekTradingHours);
		 adminRepository.save(weekTradingHours);
		 return weekTradingHours.getId();
			
	}
	
	@Override
	public String insertDownTimeOnceOff(DownTimeOnceOffDTO downTimeOnceOffDTO) {
		
		 DownTimeOnceOff downTimeOnceOff = new DownTimeOnceOff();
		 DownTimeRecurring downTimeRecurring = new DownTimeRecurring();
		 BeanUtils.copyProperties(downTimeOnceOffDTO, downTimeOnceOff);
		 downTimeOnceOffRepository.save(downTimeOnceOff);
		 return downTimeOnceOff.getId();
	}
	
	@Override
	public String insertDownTimeRecurring(DownTimeRecurringDTO downTimeRecurringDTO) {
		
		 DownTimeRecurring downTimeRecurring = new DownTimeRecurring();
		 BeanUtils.copyProperties(downTimeRecurringDTO, downTimeRecurring);
		 downTimeRecurringRepository.save(downTimeRecurring);
		 return downTimeRecurring.getId();			
	}
		
	
	@Override
	public List<StaffDTO> findAll(){

		List<StaffDTO> staffDTO = new ArrayList<StaffDTO>();
		List<Staff> staff = staffRepository.findAll();
		System.out.println(staff.toString());
		
		
		StaffDTO staffDTO2 = new StaffDTO();
		for(Staff staff2:staff) {
			BeanUtils.copyProperties(staff2, staffDTO2);
			staffDTO.add(staffDTO2);
		}
		System.out.println(staffDTO.toString());
		return staffDTO;
	}
	
	@Override
	public PublicHolidaysDTO findByPublicHolidayDesc(String publicHolidayDesc) {
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
	public  String  deletePubliHoliday(String publicHolidaysDesc) {
		
		PublicHolidaysDTO publicHolidaysDTO = new PublicHolidaysDTO();
		publicHolidaysDTO = publicHolidaysRepository.findByPublicHolidayDesc(publicHolidaysDesc);
		publicHolidaysRepository.deleteById(publicHolidaysDTO.getId());
		return publicHolidaysDesc;
	}

	@Override
	public DownTimeRecurringDTO findByDownTimeIdRec(String downTimeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteDownTimeRecurring(String downTimeRecurring) {
		DownTimeRecurringDTO downTimeRecurringDTO = new DownTimeRecurringDTO();
		downTimeRecurringDTO = downTimeRecurringRepository.findByDownTimeId(downTimeRecurring);
		downTimeRecurringRepository.deleteById(downTimeRecurringDTO.getId());
		return downTimeRecurring;
	}

	@Override
	public DownTimeOnceOffDTO findByDownTimeIdOnce(String downTimeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteDownTimeOnceOff(String downTimeOnceOff) {
		DownTimeOnceOffDTO downTimeOnceOffDTO = new DownTimeOnceOffDTO();
		downTimeOnceOffDTO = downTimeOnceOffRepository.findByDownTimeId(downTimeOnceOff);
		downTimeOnceOffRepository.deleteById(downTimeOnceOffDTO.getId());
		return downTimeOnceOff;		
	}
	
}
 