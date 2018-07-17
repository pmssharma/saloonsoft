package com.saloonsoft.app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.saloonsoft.app.entities.WeekTradingHours;


@Repository
public interface AdminRepository extends CrudRepository<WeekTradingHours, String> {

	
	//public String insertPublicHoliday(String publicHoliday);
	
	
	/*@Query("{'processName.procedureSteps.staff':?0}")
	public List<AppointmentCollection> findByStaff(String staff);
	
	@Query("{'processName.procedureSteps.procedure':'?0'}")
	public List<AppointmentCollection> findByProcedure(String staff);*/
	
}
