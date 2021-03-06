package com.saloonsoft.app.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.saloonsoft.app.dto.StaffDTO;
import com.saloonsoft.app.entities.AppointmentCollection;
import com.saloonsoft.app.entities.Staff;


@Repository
public interface StaffRepository2 extends CrudRepository<Staff, String> {
	

	//public String insertStaff(String staff);
	public List<StaffDTO> findByiDNumber(String iDNumber);
	
	
//	public List<AppointmentCollection> findByProcessNameProcedureStepStaff(String staff);
	
	@Query("{'processName.procedureSteps.procedure':'?0'}")
	public List<AppointmentCollection> findByProcedure(String staff);
	
}
