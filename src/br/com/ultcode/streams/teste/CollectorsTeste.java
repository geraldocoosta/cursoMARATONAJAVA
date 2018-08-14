package br.com.ultcode.streams.teste;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.summarizingDouble;
import static java.util.stream.Collectors.summingDouble;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Stream;

import br.com.ultcode.streams.classes.Pessoa;

public class CollectorsTeste {
	// Redução e sumarização
	public static void main(String[] args) {
		DoubleSummaryStatistics collect = Pessoa.getStream()
				.collect(summarizingDouble(Pessoa::getSalario));
		System.out.println(collect);
		System.out.println();

		Double collect2 = Pessoa.getStream().collect(summingDouble(Pessoa::getSalario));
		System.out.println("Somando: " + collect2);
		System.out.println();

		Optional<Pessoa> collect3 = Pessoa.getStream()
				.collect(minBy(comparing(Pessoa::getSalario)));
		System.out.println("minimo: " + collect3);
		System.out.println();

		Optional<Pessoa> max = Pessoa.getStream().max(comparing(Pessoa::getSalario));
		System.out.println("maximo direto: " + max);
		Optional<Pessoa> collect4 = Pessoa.getStream()
				.collect(maxBy(comparing(Pessoa::getSalario)));
		System.out.println("maximo" + collect4);
		System.out.println();

		Long qtdd = Pessoa.getStream().collect(counting());
		System.out.println("quantidade: " + qtdd);
		System.out.println();

		Double collect5 = Pessoa.getStream().collect(averagingDouble(Pessoa::getSalario));
		System.out.println("media: " + collect5);
		System.out.println();

		String collect6 = Pessoa.getStream().map(Pessoa::getNome).collect(joining(", "));
		System.out.println(collect6);

		IntSummaryStatistics summaryStatistics = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
				.mapToInt(Integer::intValue).summaryStatistics();
		System.out.println(summaryStatistics);
	}

}
