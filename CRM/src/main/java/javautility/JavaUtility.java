package javautility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random random = new Random();
		int ranInt = random.nextInt(2000);
		return ranInt;
	}
	public String getRequiredDate(int days) {
		Date date = new Date();
		SimpleDateFormat sim  = new SimpleDateFormat("dd-mm-yyyy");
		sim.format(date);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String dateRequired = sim.format(cal.getTime());
		
		return dateRequired;
	}
	public String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("dd-mm-yyyy");
		String currentDate = sim.format(date);
		return currentDate;
		
		
	}

}
