package br.com.ultcode.optionals.testes;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.ultcode.streams.classes.Pessoa;

public class Treino {
	public static void main(String[] args) {
		List<String> palavras = Arrays.asList("OLA", "GEGE");
		Stream<String> caracteres = palavras.stream().map(p -> p.split(""))
				.flatMap((String[] s) -> Arrays.stream(s));
		System.out.println(caracteres.collect(Collectors.toList()));

		List<Pessoa> listaPessoas = Pessoa.getList();
		System.out.println(listaPessoas.stream().filter(p -> p.getSalario() > 4000D)
				.map(Pessoa::getSalario).reduce(0.0, Double::sum));

		OptionalDouble average = listaPessoas.stream().mapToDouble(Pessoa::getSalario)
				.average();
		average.ifPresent(d -> System.out.println(Math.round(d)));

		System.out.println(listaPessoas.stream().count());
		// Gerando Streams
		Stream<String> of = Stream.of("GEGE", "CASA", "CPU");
		System.out.println(of.collect(Collectors.toList()));

		int[] i = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Arrays.stream(i);

		try (Stream<String> lines = Files.lines(Paths.get("Teste.txt"),
				Charset.defaultCharset())) {
			lines.map(s -> s.split("\n")).flatMap(Arrays::stream)
					.filter(s -> s.toLowerCase().contains("file"))
					.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Stream.iterate(new int[] { 0, 1 }, a -> new int[] { a[1], a[0] + a[1] }).limit(10)
				.forEach(fib -> System.out.println(fib[0]));

		Stream.generate(() -> Math.round(Math.random() * 100)).limit(100)
				.forEach(System.out::println);
	}
}
