/**
 * 
 */
package JavaBasicWk1Cap;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * This class represents Assignment 1 part 2.
 * 
 * @author mattb
 *
 */
public class DateTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 1.) LocalDateTime stores the date down to the nanoseconds and can be printed
		// out in a long format with periods.
		// 2.)
		LocalDate today = LocalDate.now();
		System.out.println("The previous Thursday was: " + today.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY)));
		// 3.) Both track an offset from Greenwich/UTC time,
		// but ZoneOffSet tracks only the absolute offset from Greenwich/UTC.
		// ZoneID uses ZoneRules
		// 4.)
		ZonedDateTime zdt = ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
		Instant inst = ZonedDateTime.now().toInstant();
		System.out.println("Zone Date Time: " + zdt);
		System.out.println("Instant: " + inst);
		// 5.)
		DateTime.monthLength(2007);
		DateTime.monthLength(2025);
		// 6.)
		DateTime.monthMonday(1);
		DateTime.monthMonday(9);
		// 7.)
		DateTime.testFriday("9/19/2021");
		DateTime.testFriday("5/13/2016");
	}

	protected static void monthLength(Integer y) {
		Year year = null;
		try {
			year = Year.of(y);
		} catch (NullPointerException e) {
			throw (e);
		}
		System.out.println("Months for the year: " + year);
		for (Month month : Month.values()) {
			YearMonth val = YearMonth.of(y, month);
			System.out.println("There are " + val.lengthOfMonth() + " days in " + month);
		}
	}

	protected static void monthMonday(Integer m) {
		Month month = null;
		try {
			month = Month.of(m);
		} catch (NullPointerException e) {
			throw (e);
		}
		System.out.println("Mondays for month of: " + month);
		LocalDate date = Year.now().atMonth(month).atDay(1).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
		Month m1 = date.getMonth();
		while (m1 == month) {
			System.out.println(date);
			date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
			m1 = date.getMonth();
		}
	}

	protected static void testFriday(String s) {
		if(s == null)
			throw new NullPointerException();
		String[] splits = s.split("/");
		Integer[] ints = new Integer[3];
		for (int i = 0; i < splits.length; i++)
			ints[i] = Integer.parseInt(splits[i]);
		Month m = Month.of(ints[0]);
		LocalDate date = Year.of(ints[2]).atMonth(m).atDay(ints[1]);

		Boolean friday13 = ((date.get(ChronoField.DAY_OF_MONTH) == 13) && (date.get(ChronoField.DAY_OF_WEEK) == 5));
		if (friday13 == true) {
			System.out.println(s + " is on Friday the 13th");
		} else {
			System.out.println(s + " is not on Friday the 13th");
		}
	}
}
