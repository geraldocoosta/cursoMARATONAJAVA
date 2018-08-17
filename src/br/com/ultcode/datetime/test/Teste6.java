package br.com.ultcode.datetime.test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Map.Entry;

public class Teste6 {
	public static void main(String[] args) {
		// Pacote time para trabalhar com zonas
		// ZoneId
		// verificando as zonas suportadas pelo ZoneId
		for (Entry<String, String> entrySet : ZoneId.SHORT_IDS.entrySet()) {
			System.out.println(entrySet.getKey() + " -> " + entrySet.getValue());
		}
		System.out.println();
		// Como usar uma zona dessas?
		// Pegando a zona default
		System.out.println(ZoneId.systemDefault());
		System.out.println();
		// Pegando um zona de tokyo como ex
		// se passar um que não existe na lista dos suportados, erro de execução
		ZoneId tokyoZone = ZoneId.of("Asia/Tokyo"); // -> passamos a chave aqui
		System.out.println(tokyoZone);
		System.out.println();

		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
		// Adicionando a esse dateTime a zona de tokyo
		System.out.println();
		ZonedDateTime atZone = dateTime.atZone(tokyoZone); // Esse método não mexe no dateTime, lembre-se que dateTime é imutavel
		System.out.println(atZone); // horario da maquina, mais o tempo pra chegar no horario daquela chave
		System.out.println();
		// outra forma de trabalhar com o ZoneId é com o instant
		Instant instant = Instant.now();
		System.out.println(instant); // -> lembre-se do zulu time
		System.out.println();

		ZonedDateTime atZone2 = instant.atZone(tokyoZone); // -> no caso do instant, já vem o horario do lugar daquela chave
		System.out.println(atZone2);
		System.out.println();
		
		////////////////////////// Outra forma de trabalhar, agora pelo UTC +??
		// por exemplo, indo pra manaus, usando a classe ZoneOffSet
		// Essa classe trabalhar diretamente com os valores numericos em horas a partir do zulutime
		System.out.println(ZoneOffset.MAX); // hora maxima que podemos utilizar
		System.out.println(ZoneOffset.MIN); // hora minima que podemos utilizar
		System.out.println();
		
		ZoneOffset zoneManaus = ZoneOffset.of("-04:00"); // -> repare esse parse, formato [+-]hh:MM
		LocalDateTime dateTime2 = LocalDateTime.now();
		OffsetDateTime offsetManaus = dateTime2.atOffset(zoneManaus); // -> horario local + o tempo a acrescentar
		System.out.println(offsetManaus);
		System.out.println();
		// Outra forma de inicializar esse offsetDateTime
		OffsetDateTime offsetManaus2 = OffsetDateTime.of(dateTime2, zoneManaus);
		System.out.println(offsetManaus2); // -> mesma coisa do bloquinho de código acima
		System.out.println();
		
		//Também podems trabahar com instant
		Instant instant2 = Instant.now();
		OffsetDateTime atOffset = instant2.atOffset(zoneManaus); //-> retorna o horario já no local 
		System.out.println(atOffset);
		OffsetDateTime atOffset2 = OffsetDateTime.ofInstant(instant2, zoneManaus);
		System.out.println(atOffset2);
		
		// Podemos usar as datas do japão com JapaneseDate, mas não to afim de estudar isso
		
	}
}
