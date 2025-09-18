package imp.concepts.javBasics;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ExploreDateClass {

	public static void main(String[] args) {
		
		//date class in java
		Date date = new Date();
		
		//Sun Aug 31 12:30:04 IST 2025 day mon date time  IST  year
		System.out.println(date.toString()); 
		
		//simpleDateformatClassInJava
		SimpleDateFormat simp= new SimpleDateFormat("yyyy-MM-dd");
		String actualDate= simp.format(date);
		System.out.println(actualDate);
		
		
		//calendar class 
		Calendar cal = simp.getCalendar();
		//static variables 30 for next 30 days -30 for last 30days
		cal.add(Calendar.DAY_OF_MONTH, -30);
		String dateRequired= simp.format(cal.getTime());
		System.out.println(dateRequired);
		 
	}

}
