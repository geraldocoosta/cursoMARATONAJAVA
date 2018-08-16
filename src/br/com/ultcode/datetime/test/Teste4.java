package br.com.ultcode.datetime.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Teste4 {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
		// Hoje é quinta, indo pra outra quinta ou a mesma
		// proximo ou mesmo -> tu já sabe como é o role
		date = date.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY));
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
		// Proximo mesmo, proximo da semaninha q vem bem nice
		date = date.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
		// E se eu quiser voltar?
		date = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.THURSDAY));
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
		// primeiro dia do mês
		date = date.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
		// ultimo dia do mês
		date = date.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
		// primeiro dia do ano q vem
		date = date.with(TemporalAdjusters.firstDayOfNextYear());
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
		// ultimo dia do ano q vem
		date = date.with(TemporalAdjusters.lastDayOfYear());
		System.out.println(date);
		System.out.println(date.getDayOfWeek());

		// se olhar bem a classe TemporalAdjuster, vamos notar que ela é uma interface funcional
		// e ai gege? podemos passar um lambda bem nice com param (Temporal temporal)
		// e com retorno Temporal, e se quiser saber as classes temporais, pesquise animal

		// ou seja
		System.out.println();
		date = date.with(temporal -> {
			temporal = temporal.with(ChronoField.MONTH_OF_YEAR, Month.MAY.getValue());
			temporal = temporal.with(ChronoField.DAY_OF_MONTH, 23);
			return temporal;
		});
		System.out.println(date);
		System.out.println(date.getDayOfWeek());
		System.out.println();

		LocalDate date2 = LocalDate.of(2018, Month.AUGUST, 18);
		TemporalAdjuster adjuster = Teste4::pegarDiasUteis;

		date2 = date2.with(adjuster);
		System.out.println(date2);
		System.out.println(date2.getDayOfWeek());
	}
	
	public static Temporal pegarDiasUteis(Temporal temporal) {
		DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
		int diaDaSemana = 1;
		switch (dayOfWeek) {
		case FRIDAY:
			diaDaSemana = 3;
			break;
		case SATURDAY:
			diaDaSemana = 2;
			break;
		default:
			break;
		}
		return temporal.plus(diaDaSemana, ChronoUnit.DAYS);
	}
	
	
	
}
