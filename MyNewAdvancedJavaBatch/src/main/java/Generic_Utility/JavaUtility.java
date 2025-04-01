package Generic_Utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class JavaUtility {
	
	public int getRandomNum(int limit)
	{
		Random ran=new Random();
		int ranomNUm=ran.nextInt(limit);
		return ranomNUm;
	}
	public String generateReqDate(int days)
	{
		java.util.Date dateobj=new java.util.Date();
		SimpleDateFormat sim=new SimpleDateFormat("dd-MM-YYYY");
		String todaysdate = sim.format(dateobj);
		
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 10);
		String closedate = sim.format(cal.getTime());
		return closedate;
		
	}

}
