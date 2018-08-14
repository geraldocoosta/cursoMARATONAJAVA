package br.com.ultcode.stream.testes;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.ultcode.stream.classes.Genero;
import br.com.ultcode.stream.classes.MaiorIdade;
import br.com.ultcode.stream.classes.Pessoa;

public class TesteUltimasAulasStream {
	public static void main(String[] args) {
		Map<Genero, List<Pessoa>> collect = Pessoa.getStream()
				.collect(Collectors.groupingBy(Pessoa::getGenero));
		System.out.println(collect);
		System.out.println();

		Map<MaiorIdade, List<Pessoa>> collect2 = Pessoa.getStream()
				.collect(Collectors.groupingBy(p -> {
					if (p.getIdade() >= 18)
						return MaiorIdade.MAIOR;
					else
						return MaiorIdade.MENOR;
				}));

		for (Map.Entry<MaiorIdade, List<Pessoa>> entry : collect2.entrySet()) {
			System.out.println(entry.getKey());
			for (Pessoa p : entry.getValue()) {
				System.out.println(p);
			}
		}
		System.out.println();
		
		Map<Genero, Map<MaiorIdade, List<Pessoa>>> collect3 = Pessoa.getStream()
				.collect(Collectors.groupingBy(Pessoa::getGenero, Collectors.groupingBy(p -> {
					if (p.getIdade() >= 18)
						return MaiorIdade.MAIOR;
					else
						return MaiorIdade.MENOR;
				})));
		System.out.println(collect3);
		System.out.println();

		Map<Genero, DoubleSummaryStatistics> collect4 = Pessoa.getStream().collect(Collectors
				.groupingBy(Pessoa::getGenero, Collectors.summarizingDouble(Pessoa::getSalario)));
		System.out.println(collect4);
		System.out.println();

		Map<Genero, Long> collect5 = Pessoa.getStream()
				.collect(Collectors.groupingBy(Pessoa::getGenero, Collectors.counting()));
		System.out.println(collect5);
		System.out.println();

		Map<Genero, Optional<Pessoa>> collect6 = Pessoa.getStream().collect(Collectors.groupingBy(
				Pessoa::getGenero, Collectors.maxBy(Comparator.comparing(Pessoa::getSalario))));
		System.out.println(collect6);
		System.out.println();

		Map<Genero, Pessoa> collect7 = Pessoa.getStream()
				.collect(Collectors.groupingBy(Pessoa::getGenero,
						Collectors.collectingAndThen(
								Collectors.maxBy(Comparator.comparing(Pessoa::getSalario)),
								Optional::get)));
		System.out.println(collect7);
		System.out.println();

		Map<Genero, HashSet<MaiorIdade>> collect8 = Pessoa.getStream()
				.collect(Collectors.groupingBy(Pessoa::getGenero, Collectors.mapping(p -> {
					if (p.getIdade() >= 18)
						return MaiorIdade.MAIOR;
					else
						return MaiorIdade.MENOR;
				}, Collectors.toCollection(HashSet::new))));
		System.out.println(collect8);
		System.out.println();
		
		Map<Boolean, List<String>> collect9 = Pessoa.getStream().collect(Collectors.partitioningBy(
				p -> p.getIdade() >= 18, Collectors.mapping(Pessoa::getNome, Collectors.toList())));

		Iterator<Map.Entry<Boolean, List<String>>> iterator = collect9.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Boolean, List<String>> a = iterator.next();
			System.out.printf("Pessoas que %s idade maior a 18%n", a.getKey() ? "tem" : "não tem");
			for (String s : a.getValue()) {
				System.out.printf("%15s%n", s);
			}
		}

	}

}
