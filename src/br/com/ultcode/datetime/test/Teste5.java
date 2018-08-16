package br.com.ultcode.datetime.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Teste5 {
	public static void main(String[] args) {
		// converter e formatando datas
		LocalDate date = LocalDate.now();
		// mts vezes vamos receber a data como string e converter para um local date ou
		// local date time, ou o contrario
		// format formata a data e devolve uma string
		// string para data usa o parse
		// Date time formatter é a classe responsavel por definir como vai ser a formatação
		String a1 = date.format(DateTimeFormatter.BASIC_ISO_DATE); // 20180816
		System.out.println(a1);
		a1 = date.format(DateTimeFormatter.ISO_DATE); // '2011-12-03' or '2011-12-03+01:00'.
		System.out.println(a1);
		a1 = date.format(DateTimeFormatter.ISO_LOCAL_DATE); // '2011-12-03'
		System.out.println(a1);
		a1 = date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
		System.out.println(a1);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println();
		System.out.println("Parse");
		String s1 = "20180816";
		String s2 = "2018-08-16";
		String s3 = "16/08/18";
		LocalDate parse1 = LocalDate.parse(s1, DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println(parse1);
		LocalDate parse2 = LocalDate.parse(s2, DateTimeFormatter.ISO_DATE);
		System.out.println(parse2);
		LocalDate parse3 = LocalDate.parse(s3,
				DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
		System.out.println(parse3);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Usando dataTimeFormatter custom
		// serve tanto para o parse quanto para o format
		System.out.println();
		System.out.println("DateTimeCuston");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy 'horas: 'HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.now();
		String dateTimeString = dateTime.format(formatter);
		System.out.println(dateTimeString);
		LocalDateTime dateTime2 = LocalDateTime.parse(dateTimeString, formatter);
		System.out.println(dateTime2);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Passando um fodendo locale bem nice
		System.out.println();
		System.out.println("DateTimeCuston com Locale");
		DateTimeFormatter formattFR = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", new Locale("pt-BR"));
		System.out.println(LocalDate.now().format(formattFR));
	}
}
