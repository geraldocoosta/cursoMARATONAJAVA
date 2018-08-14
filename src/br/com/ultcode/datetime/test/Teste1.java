package br.com.ultcode.datetime.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

public class Teste1 {
	public static void main(String[] args) {
		// só datinhas bem nice
		LocalDate date = LocalDate.of(2015, Month.MAY, 23);
		System.out.println(date.getYear());
		System.out.println(date.getMonth());
		System.out.println(date.getMonthValue());
		System.out.println(date.getYear());
		System.out.println(date.getDayOfMonth());
		System.out.println(date.getDayOfWeek());
		System.out.println(date.lengthOfMonth());
		System.out.println(date.lengthOfYear());
		System.out.println(date.isLeapYear());
		System.out.println(date.get(ChronoField.YEAR));
		System.out.println(LocalDate.now());
		System.out.println(LocalDate.MAX);
		System.out.println(LocalDate.MIN);
		System.out.println("====================================================================");
		// só horinhas bem nice
		LocalTime time = LocalTime.of(23, 11, 15); // VAI DO 0 AO 23:99
		System.out.println(time);
		System.out.println(time.getHour());
		System.out.println(time.getMinute());
		System.out.println(time.getSecond());
		System.out.println(LocalTime.MAX);
		System.out.println(LocalTime.MIN);
		System.out.println("====================================================================");
		// parse de datas e horas
		LocalDate localDate = LocalDate.parse("2018-08-14");
		LocalTime localTime = LocalTime.parse("23:14:14");
		System.out.println(localDate);
		System.out.println(localTime);
		System.out.println("====================================================================");
		// data e hora bem nice
		LocalDateTime dateTime = LocalDateTime.now();
		LocalDateTime dateTime2 = LocalDateTime.of(localDate, localTime);
		LocalDateTime dateTime3 = LocalDateTime.of(2005, Month.APRIL, 12, 9, 15);
		LocalDateTime dateTime4 = localTime.atDate(localDate);
		LocalDateTime dateTime5 = localTime.atDate(LocalDate.of(1997, Month.MAY, 23));
		LocalDateTime dateTime6 = date.atTime(time);
		LocalDateTime dateTime7 = date.atTime(12, 4);
		System.out.println(dateTime);
		System.out.println(dateTime2);
		System.out.println(dateTime3);
		System.out.println(dateTime4);
		System.out.println(dateTime5);
		System.out.println(dateTime6);
		System.out.println(dateTime7);
	}
}
