package com.saloonsoft.app.services;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saloonsoft.app.dto.PublicHolidaysDTO;
import com.saloonsoft.app.entities.PublicHolidays;
import com.saloonsoft.app.repositories.PublicHolidaysRepository;


@Service
public class PublicHolidaysServiceImpl implements PublicHolidaysService{
	
	@Autowired
	PublicHolidaysRepository publicHolidaysRepository;

	@Override
	public String insertPublicHolidays(PublicHolidaysDTO publicHolidaysDto) {
		
		PublicHolidays publicHolidays = new PublicHolidays();
		BeanUtils.copyProperties(publicHolidaysDto, publicHolidays);
		publicHolidaysRepository.save(publicHolidays);
		return publicHolidays.getId();
	}
}
 