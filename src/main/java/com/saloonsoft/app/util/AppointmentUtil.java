package com.saloonsoft.app.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class AppointmentUtil {
	
	public  static Date toDate(String sDate) throws ParseException {

		
		SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy-MM-dd");
		formattedDate.setTimeZone(TimeZone.getTimeZone("UTC"));
		return formattedDate.parse(sDate);
		//String cdate =formattedDate.format(new SimpleDateFormat("dd/MM/yyyy").parse(sDate));
	//	return formattedDate.parse(cdate,new ParsePosition(0));
				
		
		
		
	}

	public static List<Date> prpare7Days(Date date)  {
		 ArrayList<Date> dates=new ArrayList<Date>();
	            
	        try {
                
	        	
		           
	        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            Calendar c = Calendar.getInstance();
	            c.setTime(date); 
		           
		            for(int i=0;i<7;++i) {
		            	 
		            	
		           
		          // Now use today date.
		            dates.add(c.getTime());
		            c.add(Calendar.DATE, 1); // Adding 5 days
		            
		            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return dates;

	}
}
