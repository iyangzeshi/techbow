package bq_resume.parking_lot_design.parkingRule;

import bq_resume.parking_lot_design.vehicle.Vehicle;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by FLK on 2020-06-27.
 */
public class WeekDayRule implements IParkingRule {
	
	@Override
	public boolean isValid(Vehicle vehicle) {
		GregorianCalendar date = new GregorianCalendar();
		int day = date.get(Calendar.DAY_OF_WEEK);
		return day <= 5;
		// Only valid for Weekdays
		// return false;
	}
	
	public static void main(String[] args) {
		GregorianCalendar date = new GregorianCalendar();
		int day = date.get(Calendar.DAY_OF_WEEK);
		System.out.println(day);
		
		Calendar calendar = Calendar.getInstance();
		System.out.println("Day: " + (calendar.get(Calendar.DATE)));
		System.out.println("Month: " + (calendar.get(Calendar.MONTH) + 1));
		System.out.println("Year: " + (calendar.get(Calendar.YEAR)));
		String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		System.out.println("Current day = " + days[calendar.get(Calendar.DAY_OF_WEEK) - 1]);
	}
	
}
