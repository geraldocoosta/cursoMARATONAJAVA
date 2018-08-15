package br.com.ultcode.datetime.test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Teste2 {
	public static void main(String[] args) {
		System.out.println("Instant \t===================================================\n");

		// Inicialização
		Instant t = Instant.now();
		System.out.println(t); // -> instant sempre vai corresponder ao zulu time
		System.out.println(Instant.EPOCH); // -> data onde começa a contar os segundos do Instant
		// Iniciando um Instant a partir de Millisegundos
		System.out.println(Instant.ofEpochMilli(System.currentTimeMillis()));
		// Parse bem tilindinho
		System.out.println(Instant.parse("2016-12-16T23:15:30.00Z"));
		// Criando a partir de segundos com ajustes em nanosegundos
		// -> a partir de 1970-1-1
		System.out.println(Instant.ofEpochSecond(99999999900L, 1_000_000_000));
		System.out.println(Instant.ofEpochSecond(99999999L, -1_000_000_000));

		// Método legais
		System.out.println(t.getEpochSecond());
		System.out.println(t.getNano());
		System.out.println(t.toEpochMilli());
		// -> temos o plus -> aumentar horas
		// -> temos o minus -> diminuir horas
		// -> temos o with -> substituir horas
		System.out.println("\nDuration \t===================================================\n");
		// Podemos trabalhar pra pegar intervalos em horas, minutos e segundos -> TEM A VER COM TEMPO- TEEEEEEEEEEEEMPO
		// HORA - MINUTO - SEGUNDO
		LocalDateTime dt1 = LocalDateTime.now();
		LocalDateTime dt2 = LocalDateTime.of(2016, 12, 16, 23, 12, 53);

		LocalTime time1 = LocalTime.now();
		LocalTime time2 = LocalTime.of(0, 30);

		// O método between recebe -> (Temporal startInclusive, Temporal endExclusive)
		Duration d1 = Duration.between(dt1, dt2);
		System.out.println(d1); // -> a formação fica estranha
		Duration d2 = Duration.between(time1, time2);
		System.out.println(d2);
		Duration d3 = Duration.between(Instant.now(), Instant.now().plusSeconds(45600));
		System.out.println(d3);
		Duration d4 = Duration.between(dt1, time2.atDate(dt1.toLocalDate()));
		System.out.println(d4);
		Duration d5 = Duration.ofMinutes(3);
		System.out.println(d5);
		Duration d6 = Duration.of(4, ChronoUnit.MICROS); // não suporta meses, anos, semanas, forever(?), eras, decadas, milenias
		System.out.println(d6);

		// OBS.: não utilize LocalDate e não misture as classes comparadas, vai rolar uma
		// exceção bem concentrada

		System.out.println("\nPeriod \t\t===================================================\n");
		// Nessa aqui trabalhamos com dias, meses, anos
		// PARAMS DO BETWEEN -> (LocalDate startDateInclusive, LocalDate endDateExclusive)
		// repare no LOCALDATE
		// ANO - MES - DIA
		Period p1 = Period.between(dt1.toLocalDate(), dt2.toLocalDate());
		System.out.println(p1);
		Period p2 = Period.ofDays(322);
		System.out.println(p2);
		Period p3 = Period.from(p2);
		System.out.println(p3);
		Period p4 = Period.of(2015, Month.APRIL.getValue(), 23);
		System.out.println(p4);
		// ATENÇÃO ATENÇÃO -> NA CLASSE PERIOD, A DATA É ORGANIZADA EM ANO-MES-DIA, CADA UM NO SEU CAMPO
		// E O Q Q TEM GERALDÃO? SE VOCÊ PEDIR TU PASSAR UMA DATA EM DIA, AI TU ME PEDE MÊS, DEU BIGODE
		// EXEMPLO
		System.out.println(p2.getMonths()); // Passei no ofDays 322 dias, porém aqui retornou 0 meses
		LocalDateTime now = LocalDateTime.now();
		// until -> até
		System.out.println(now.until(now.plusDays(p2.getDays()), ChronoUnit.MONTHS));

		System.out.println("\nChronoUnit \t===================================================\n");
		// Para esse calculo, me parece q o ChronoUnit é o melhor, pelo menos pra saber sobre só um param
		LocalDateTime aniversario = LocalDateTime.of(1997, Month.MAY, 23, 6, 30, 12);
		System.out.println(ChronoUnit.DAYS.between(aniversario, LocalDateTime.now()));
		System.out.println(ChronoUnit.MONTHS.between(aniversario, LocalDateTime.now()));
		System.out.println(ChronoUnit.WEEKS.between(aniversario, LocalDateTime.now()));
		System.out.println(ChronoUnit.YEARS.between(aniversario, LocalDateTime.now()));
		System.out.println(ChronoUnit.SECONDS.between(aniversario, LocalDateTime.now()));

	}
}
