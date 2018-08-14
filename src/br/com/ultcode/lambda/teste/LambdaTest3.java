package br.com.ultcode.lambda.teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import br.com.ultcode.lambda.classes.ComparadorStrings;

public class LambdaTest3 {
	public static void main(String[] args) {
		// Meta reference -> recurso inserido para facilitar ainda mais a leitura dos lambdas
		// Quando existem lambdas simples que só chamam um método, é possivel a chamada o uso
		// de method referencesm são 4 tipos
		// Pode utilizar uma classe com a mesma assinatura funcional ou descrição funcional da interface em um metodo
		// logo faço um exemplo, to mo preguiçoso
		String[] teste = {"Maluco", "Mago", "MALUCO","Geraldo"};
		List<String> listaString = new ArrayList<>();
		listaString.addAll(Arrays.asList(teste));
		forEach(listaString, System.out::println);
		System.out.println("==============================================================");
		// Exemplo, classe com método statico -> nome da classe depois o método ESTATICO
		Collections.sort(listaString, ComparadorStrings::comparandoString);
		System.out.println(listaString);
		System.out.println("==============================================================");
		// Exemplo, classe com método de instancia -> instancia depois o método de uma classe
		ComparadorStrings comparador = new ComparadorStrings();
		Collections.sort(listaString, comparador::comparandoStringIgnorandoCase);
		System.out.println(listaString);
		// Trabalhando com a classe, porém com método não estaticos
		System.out.println("==============================================================");
		listaString.sort((s1,s2) -> s2.compareToIgnoreCase(s1));
		System.out.println(listaString);
		listaString.sort(String::compareTo); // Assim que é meu bom, trabalha na forma padrão vio
		System.out.println(listaString);
		listaString.forEach(s -> System.out.println(s));
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
