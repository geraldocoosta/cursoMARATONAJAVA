package br.com.ultcode.streams.teste;

import static java.util.stream.Collectors.groupingBy;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.ultcode.streams.classes.Genero;
import br.com.ultcode.streams.classes.MaiorIdade;
import br.com.ultcode.streams.classes.Pessoa;

//Afrupamento, mapeamento
public class CollectorsTeste2 {
	public static void main(String[] args) {
		// por genero relacionado a pessoa
		Pessoa.getStream().collect(groupingBy(Pessoa::getGenero))
				.forEach((x, y) -> System.out.println(x + " " + y));

		System.out.println();
		// por idade não relacionada
		Pessoa.getStream().collect(groupingBy(p -> {
			if (p.getIdade() > 18)
				return MaiorIdade.MAIOR_IDADE;
			else
				return MaiorIdade.MENOR_IDADE;
		})).forEach((x, y) -> System.out.println(x + "->" + y));

		System.out.println();
		// coisas mais avançadas
		// Imagine fazer um agrupamento por genero e por maioridade
		// Vai ficar um bang loco tipo assim
		// Map<Genero,Map<MaiorIdade,Pessoa>>
		Map<Genero, Map<MaiorIdade, List<Pessoa>>> collect = Pessoa.getStream()
				.collect(groupingBy(Pessoa::getGenero, groupingBy(p -> {
					if (p.getIdade() > 18)
						return MaiorIdade.MAIOR_IDADE;
					else
						return MaiorIdade.MENOR_IDADE;
				})));
		for (Entry<Genero, Map<MaiorIdade, List<Pessoa>>> entry : collect.entrySet()) {
			System.out.println(entry.getKey() + " ->" + entry.getValue());
		}

		// Agrupando por genero e contando a quantidade de cada, repare que passo o counting dentro
		// do groupingBy
		Pessoa.getStream().collect(groupingBy(Pessoa::getGenero, Collectors.counting()))
				.forEach((i, j) -> System.out.println(i + "->" + j));
		System.out.println();
		// Agrupando por genero e maior salario
		Pessoa.getStream()
				.collect(groupingBy(Pessoa::getGenero,
						Collectors.maxBy(Comparator.comparing(Pessoa::getSalario))))
				.forEach((i, j) -> System.out.println(i + "->" + j));
		System.out.println();
		// fazend isso sem optional
		Pessoa.getStream()
				.collect(groupingBy(Pessoa::getGenero,
						Collectors.collectingAndThen(
								Collectors.maxBy(Comparator.comparing(Pessoa::getSalario)),
								Optional::get)))
				.forEach(((i, j) -> System.out.println(i + "->" + j)));
		System.out.println();
		// agrupamento por genero e estatistica
		Map<Genero, DoubleSummaryStatistics> collect2 = Pessoa.getStream()
				.collect(Collectors.groupingBy(Pessoa::getGenero,
						Collectors.summarizingDouble(Pessoa::getSalario)));

		for (Map.Entry<Genero, DoubleSummaryStatistics> entry : collect2.entrySet()) {
			System.out.println(entry.getKey());
			DoubleSummaryStatistics value = entry.getValue();
			System.out.println("\tTotal de salarios : \t" + value.getCount());
			System.out.println("\tSalario maximo: \t" + value.getMax());
			System.out.println("\tSalario minimo: \t" + value.getMin());
			System.out.println("\tSalarios somados: \t" + value.getSum());
			System.out.println("\tMédia dos salarios: \t" + value.getAverage());
		}
		System.out.println();

		// Mapeando por genero e maioridade
		Map<Genero, Set<MaiorIdade>> collect3 = Pessoa.getStream()
				.collect(Collectors.groupingBy(Pessoa::getGenero, Collectors.mapping(p -> {
					if (p.getIdade() > 18)
						return MaiorIdade.MAIOR_IDADE;
					else
						return MaiorIdade.MENOR_IDADE;
				}, Collectors.toSet()))); // podemos usar o to Collection e passar uma coleção dentro
		System.out.println(collect3);
	}
}
