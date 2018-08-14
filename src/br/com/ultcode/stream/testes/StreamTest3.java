package com.ultcode.stream.testes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest3 {
	public static void main(String[] args) {
		// Formas de criar um Stream
		// Criando um stream de Tipos primitivos, passando um range
		// fechado, inclui os dois numeros
		IntStream.rangeClosed(1, 50).filter(i -> i % 2 == 0)
				.forEach(i -> System.out.print(i + " "));
		System.out.println();
		// inclui o primeiro e exclui o segundo
		IntStream.range(1, 50).filter(i -> i % 2 == 0).forEach(i -> System.out.print(i + " "));

		System.out.println();
		// Iniciando via método statico, já passando strings, ou objetos
		Stream<String> stringStream = Stream.of("GEGE", "É", "MULEQUE BOM"); // Igual o optionals
		stringStream.map(String::toLowerCase).forEach(p -> System.out.print(p + " "));

		System.out.println();
		// Criando uma stream a partir de array
		int[] i = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		IntStream intStream = Arrays.stream(i);
		System.out.println(intStream.filter(valor -> valor % 2 == 0).average());

		// AGORA VEM COISA AVANÇADA MEU BOM
		// STREAM PARA NIO
		try (Stream<String> lines = Files.lines(Paths.get("Teste.txt"))) {
			lines.flatMap(line -> Arrays.stream(line.split("\n")))
					.filter(s -> s.toLowerCase().contains("file")).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Agora, vamos lidar com streams infinitos
		// O q é isso? Imagina um while(true), tipo isso
		// Stream.iterate(1, n -> n+2).forEach(System.out::println); -> exemplo de stream infinito,
		// vai rodar até acabar a memoria, para adicionar um limite, temos o método limit
		Stream.iterate(1, n -> n + 2).limit(10).forEach(System.out::println);
		// Fazendo um fibonacci atravez desse iterate
		Stream.iterate(new int[] { 0, 1 }, a -> new int[] { a[1], a[0] + a[1] }).limit(10)
				.forEach((int[] arrayInt) -> System.out.print(arrayInt[0] + " "));
		System.out.println();
		// Outra maneira
		Stream.iterate(new int[] { 0, 1 }, a -> new int[] { a[1], a[0] + a[1] }).limit(10)
				.map(fib -> fib[0]).forEach(System.out::println);
		
		
		//enquanto no iterate passamos uma seed e um modo de incrementar(function), no generate
		// geramos atraves de um supplier, também é uma stream infinita
		// ou seja, no generate, o método passado deve gerar um valor e retornar
		Stream.generate(() -> Math.round(Math.random()*100)).limit(100).forEach(System.out::println);
		
		ThreadLocalRandom t = ThreadLocalRandom.current();
		Stream.generate(() -> t.nextInt(1, 101)).limit(100).forEach(System.out::println);
		
	}
}
