package br.com.ultcode.datetime.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Teste3 {
	public static void main(String[] args) {
		// Manipulando datas
		LocalDate ld = LocalDate.of(2018, Month.AUGUST, 15);
		// OBS IMPORTANTE.: classes do pacote time são imutaveis, que nem String, bagulho é doido
		// with -> troca datas
		System.out.println("With");
		ld = ld.withDayOfMonth(12);
		System.out.println(ld);
		ld = ld.withMonth(Month.MAY.getValue());
		System.out.println(ld);
		ld = ld.withYear(1997);
		System.out.println(ld);
		ld = ld.withDayOfYear(255);
		System.out.println(ld);
		ld = ld.with(ChronoField.DAY_OF_WEEK, 3); // aqui é um chronoField, qtd vem depois
		System.out.println(ld); // 
		System.out.println();
		// plus -> troca datas somando tal valor
		System.out.println("PLUS");
		ld = ld.plusDays(5);
		System.out.println(ld);
		ld = ld.plusMonths(4);
		System.out.println(ld);
		ld = ld.plusWeeks(12);
		System.out.println(ld);
		ld = ld.plusYears(5);
		System.out.println(ld);
		ld = ld.plus(14, ChronoUnit.YEARS); // Repare que no plus é um chronoUnit, e a qtd vem primeiro
		System.out.println(ld);
		System.out.println();
		// minus é pra diminuir, mesmo padrão do plus
		System.out.println("MINUS");
		ld = ld.minus(14, ChronoUnit.YEARS);
		System.out.println(ld);
		
		// Tem isso tudo pra LocalTime, LocalDateTime também
		
		
	}
}
