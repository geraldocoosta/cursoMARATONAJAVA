package br.com.ultcode.stream.testes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test2 {
	public static void main(String[] args) {

		Stream<String> testeRandom = Stream.of("Geraldão", "é BRABO");
		List<String> collect = testeRandom.map(s -> s.split("")).flatMap(Arrays::stream)
				.collect(Collectors.toList());
		collect.stream().forEach(System.out::println);
	}
}
