package com.ultcode.lambda.teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTest2 {
	public static void main(String[] args) {
		String[] teste = { "Geraldo", "Maluco", "Mago" };
		List<String> listaString = new ArrayList<>();
		listaString.addAll(Arrays.asList(teste));
		forEach(listaString, (String s) -> System.out.println(s));

		List<Integer> resultado = map(listaString, (String s) -> s.length());
		System.out.println(resultado);

		Supplier<?> supplier = () -> new String();
		System.out.println(supplier.get());
		Predicate<String> predicate = (String s) -> listaString.add(s);
		Consumer<String> consumer = (s) -> listaString.add(s); // -> exemplo de lambda sem o tipo
		System.out.println(predicate.test("GERALDÂO"));
		consumer.accept("GERALDÂO do consumer"); // A minha teoria pra isso é simplesmente, usar método dentro de método
		// se você usar um método com retorno em um método void, influencia? pois é, minha lógica é esta
		// explicação willian -> statement expression -> Basicamente, se você colocar um new String("Algo") random dentro do código
		// ele vai rodar, mesmo se for em um lugar nada a ver
		// Lambda é um padrão inteligente, que pode reconhecer os parametros e se tem retorno ou não
		forEach(listaString, (String s) -> System.out.println(s));
	}

	static <T> void forEach(List<T> list, Consumer<T> c) {
		for (T t : list) {
			c.accept(t);
		}
	}

	static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> result = new ArrayList<>();
		for (T t : list) {
			result.add(f.apply(t));
		}
		return result;
	}

}