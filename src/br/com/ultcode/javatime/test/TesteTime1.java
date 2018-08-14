package br.com.ultcode.javatime.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

public class TesteTime1 {
	public static void main(String[] args) {
		LocalDate date1 = LocalDate.now();
		LocalDate date2 = LocalDate.of(2018, Month.MAY, 23);
		System.out.println(date2);
		System.out.println(date1);
		System.out.println(date1.getDayOfMonth());
		System.out.println(date1.getDayOfYear());
		System.out.println(date1.getLong(ChronoField.DAY_OF_MONTH));
		System.out.println(date1.getMonthValue());
		System.out.println(date1.getMonth());

		System.out.println(
				"====================================================================");
		LocalTime lt = LocalTime.parse("23:11");
		LocalTime lt2 = LocalTime.now();
		System.out.println(lt);
		System.out.println(lt2);

	}
}
