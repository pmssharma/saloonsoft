package com.saloonsoft.app.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.saloonsoft.app.dto.StaffDTO;
import com.saloonsoft.app.entities.AppointmentCollection;
import com.saloonsoft.app.entities.PublicHolidays;
import com.saloonsoft.app.entities.Staff;


@Repository
public interface AdminRepository extends CrudRepository<PublicHolidays, String> {
	

	//public String insertPublicHoliday(String publicHoliday);
	
	
	/*@Query("{'processName.procedureSteps.staff':?0}")
	public List<AppointmentCollection> findByStaff(String staff);
	
	@Query("{'processName.procedureSteps.procedure':'?0'}")
	public List<AppointmentCollection> findByProcedure(String staff);*/
	
}
