package br.com.ultcode.stream.testes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import br.com.ultcode.stream.classes.Pessoa;

import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.Comparator;

public class StreamTest2 {
	public static void main(String[] args) {
		// AULA 3
		List<String> listaString = asList("OLA", "GEGE");
		List<String> fizCerto = listaString.stream().map(s -> s.split("")).flatMap(Arrays::stream)
				.collect(Collectors.toList());
		System.out.println(fizCerto);
		System.out.println();

		// AULA 4
		System.out.println(Pessoa.getStream().anyMatch(p -> p.getSalario() > 2500.0D));
		System.out.println(Pessoa.getStream().allMatch(p -> p.getIdade() >= 18));
		System.out.println(Pessoa.getStream().noneMatch(p -> p.getIdade() < 18));
		System.out.println();
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		Pessoa.getStream().filter(p -> p.getSalario() > 5000.0)
				.sorted(Comparator.comparing(Pessoa::getNome).reversed()).findFirst()
				.ifPresent(System.out::println);

		Pessoa.getStream().filter(p -> p.getSalario() > 5000.0)
				.sorted(Comparator.comparing(Pessoa::getNome)).findAny()
				.ifPresent(System.out::println);
		System.out.println();

		// AULA 5
		Optional<Integer> reduceComLambda = getStreamInteger().reduce((x, y) -> x + y); // Veja que retorna um OPTIONAL
		System.out.println("Utilizando o reduce retornando optional: " + reduceComLambda);

		Integer reduceComLambdaRetornoInteger = getStreamInteger().reduce(0, (x, y) -> x + y); // Veja que retorna um INTEGER
		System.out.println(
				"Utilizando o reduce com retorno integer: " + reduceComLambdaRetornoInteger);

		Optional<Integer> usandoMethodReference = getStreamInteger().reduce(Integer::sum);
		Integer usandoMethodReferenceRetornoInteger = getStreamInteger().reduce(0, Integer::sum);
		System.out.println("Method Reference com retorno Optional \t- " + usandoMethodReference
				+ "\nMethod Reference com Retorno Integer \t- "
				+ usandoMethodReferenceRetornoInteger);

		// -> OBS IMPORTANTE: não da pra utilizar uma stream duas vezes, ou seja, usou um método terminal, CABO!!

		Optional<Integer> usandoLambdaParaEncontraOMaior = getStreamInteger()
				.reduce((x, y) -> x > y ? x : y);
		Optional<Integer> usandoMethodReferenceEncontraOMaior = getStreamInteger()
				.reduce(Integer::max); // Mesma coisa para o minimo
		System.out.println(
				"Encontrando o valor maximo com lambda: \t\t " + usandoLambdaParaEncontraOMaior
						+ "\nEncontrando o valor maximo com Method Reference: "
						+ usandoMethodReferenceEncontraOMaior);

		// Utilizando reduce para somar todo os salarios
		Pessoa.getStream().filter(p -> p.getSalario() > 4000.0).map(Pessoa::getSalario)
				.reduce(Double::sum).ifPresent(System.out::println);
		// Mas gege, se não quisermos fazer boxing nessa operação??
		double x = Pessoa.getStream().filter(p -> p.getSalario() > 4000.0)
				.mapToDouble(Pessoa::getSalario).sum(); // Aqui temos o max e o min
		System.out.println(x);
		// Mas gege, como faço pra voltar de um DoubleStream para um Stream<Fouble>
		DoubleStream mapToDoubleEx = Pessoa.getStream().filter(p -> p.getSalario() > 4000.0)
				.mapToDouble(Pessoa::getSalario);
		Stream<Double> doubleToStream = mapToDoubleEx.boxed();
		System.out.println(doubleToStream);

	}

	public static Stream<Integer> getStreamInteger() {
		return asList(1, 2, 3, 4, 5, 6, 7, 8, 9).stream();
	}
}
