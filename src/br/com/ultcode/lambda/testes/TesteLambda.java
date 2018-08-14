package br.com.ultcode.lambda.testes;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

import br.com.ultcode.lambda.classes.Carro;
import br.com.ultcode.lambda.classes.ComparaCarro;

public class TesteLambda {
	public static void main(String[] args) {
		List<Carro> carros = Arrays.asList(new Carro("azul", 1999), new Carro("preto", 2008), new Carro("verde", 2013));
		carros.sort(ComparaCarro::compararCarro);
		System.out.println(carros);
		System.out.println("========================================================");
		ComparaCarro compara = new ComparaCarro();
		carros.sort(compara::compararCarroPorAno);
		System.out.println(carros);
		System.out.println("========================================================");
		List<String> nomes = Arrays.asList("Geraldo", "Stephane", "Francisco", "João");
		nomes.sort(String::compareTo);
		System.out.println(nomes);
		nomes.sort((String s, String s1) -> s1.compareTo(s));
		System.out.println(nomes);

		Function<String, Integer> stringParaInteiro = Integer::parseInt;
		Function<String, Integer> stringParaInteiro2 = s -> Integer.parseInt(s);
		System.out.println(stringParaInteiro.apply("25"));
		System.out.println(stringParaInteiro2.apply("34"));

		BiPredicate<List<String>, String> contains = (lista, nome) -> lista.contains(nome);
		BiPredicate<List<String>, String> contains2 = List::contains;

		System.out.println(contains.test(nomes, "Geraldo"));
		System.out.println(contains2.test(nomes, "Stephane"));

		System.out.println("=======================================================");
		Supplier<ComparaCarro> car = ComparaCarro::new;
		System.out.println(car.get());

		BiFunction<String, Integer, Carro> construirCarro = Carro::new;
		Carro car2 = construirCarro.apply("Rosa", 2018);
		System.out.println(car2);

	}
}
