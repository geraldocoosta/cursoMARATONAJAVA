package br.com.ultcode.optional.test;

import java.util.Optional;

public class OptionalTest {
	private String nome;

	public static void main(String[] args) {
		OptionalTest test = new OptionalTest();
		Optional<String> optional1 = Optional.of("GEGE"); // usar quando tiver crtz de algo não ser null
		Optional<String> optional2 = Optional.empty(); // esse quando for vazio
		Optional<String> optional3 = Optional.ofNullable(test.nome); // Sei lá se é nula ou não

		// Imprimindo
		System.out.println(optional1);
		System.out.println(optional2);
		System.out.println(optional3);
		// Buscando VAlores
		System.out.println(optional1.get()); // forma mais direta de pegar um valor
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		if (optional2.isPresent()) // Recomendado usar isso para pegar o valor de um optional
			System.out.println(optional2.get()); // pode dar uma exceção se não tiver valor
													// 'java.util.NoSuchElementException'
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println(" ");
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println(optional1.orElse("olia")); // retorna o que tem lá, se não retorna o que tu passar no
														// argumento
		System.out.println(optional2.orElse("olia")); // retorna o que tem lá, se não retorna o que tu passar no
														// argumento

		// pq existe essa pora?
		// é uma classe que pode ou não conter um valor não nulo. 
		// Vantagem de usar -> quando a pessoa bater o olho em um atributo Optional<String> Nome por exemplo
		// ela vai saber que aquele atributo pode ser nulo
	}
}
