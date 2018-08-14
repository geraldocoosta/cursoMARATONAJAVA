package br.com.ultcode.streams.teste;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.ultcode.streams.classes.Genero;
import br.com.ultcode.streams.classes.MaiorIdade;
import br.com.ultcode.streams.classes.Pessoa;

public class ConhecimentosTeste {
	public static void main(String[] args) {
		// Mapear uma lista de pessoa por genero e MaiorIdade
		Map<Genero, Map<MaiorIdade, List<Pessoa>>> collect = Pessoa.getStream()
				.collect(Collectors.groupingBy(Pessoa::getGenero, Collectors.groupingBy(p -> {
					if (p.getIdade() > 18)
						return MaiorIdade.MAIOR_IDADE;
					else
						return MaiorIdade.MENOR_IDADE;
				})));
		System.out.println(collect);
		System.out.println();
		Map<Genero, Optional<Pessoa>> collect2 = Pessoa.getStream()
				.collect(Collectors.groupingBy(Pessoa::getGenero,
						Collectors.maxBy(Comparator.comparing(Pessoa::getSalario))));

		System.out.println(collect2);
		System.out.println();
		Map<Genero, Pessoa> collect3 = Pessoa.getStream()
				.collect(Collectors.groupingBy(Pessoa::getGenero,
						Collectors.collectingAndThen(
								Collectors.maxBy(Comparator.comparing(Pessoa::getSalario)),
								Optional::get)));
		System.out.println(collect3);
		System.out.println();
		Fibb(15);

	}

	public static void Fibb(int Sequencia) {
		Stream.iterate(new int[] { 0, 1 }, i -> new int[] { i[1], i[0] + i[1] })
				.limit(Sequencia).forEach(i -> System.out.println(i[0]));
	}
}
