package com.saloonsoft.app.repositories;




import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saloonsoft.app.entities.App;
import com.saloonsoft.app.entities.Appointment;
import com.saloonsoft.app.entities.AppointmentCollection;
import com.saloonsoft.app.entities.ProcessSteps;


@Repository
public interface ProcessStepsRep extends CrudRepository<ProcessSteps, String> {
	
	public List<ProcessSteps> findByStaff(String staff);
	public List<ProcessSteps> findByProcedure(String procedure);
	public List<ProcessSteps> findByPid(String pid);
}
