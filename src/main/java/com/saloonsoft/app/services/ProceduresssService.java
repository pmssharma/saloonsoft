package com.saloonsoft.app.services;


import java.util.List;

import com.saloonsoft.app.dto.ProcedureDTO;



public interface ProcedureService {

	 String insertProcessName(ProcedureDTO procedureDto);
 
	 List<ProcedureDTO> findByProcessID(String processID);
}
