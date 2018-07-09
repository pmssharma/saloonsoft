package com.saloonsoft.app.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saloonsoft.app.dto.PublicHolidaysDTO;
import com.saloonsoft.app.entities.PublicHolidays;
import com.saloonsoft.app.repositories.AdminRepository;


@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminRepository adminRepository;

	@Override
	public String insertPublicHolidays(PublicHolidaysDTO publicHolidaysDto) {
		
		 PublicHolidays publicHoliday = new PublicHolidays();
		 BeanUtils.copyProperties(publicHolidaysDto, publicHoliday);
		 adminRepository.save(publicHoliday);
		 return publicHoliday.getId();
			
	}
		
}
 