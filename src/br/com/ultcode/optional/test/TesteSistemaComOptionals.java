package com.ultcode.optional.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.ultcode.optional.classes.Carro;
import com.ultcode.optional.classes.Pessoa;
import com.ultcode.optional.classes.Seguradora;

public class TesteSistemaComOptionals {
	public static void main(String[] args) {
		Seguradora s = new Seguradora("GEGE SEGUROS");
		Carro c = new Carro("Corsa", s);
		Pessoa p = new Pessoa("Geraldo", c, 21);
		System.out.println(p.buscarSeguradora());
		System.out.println(p.buscarSeguradoraMaiorDeIdade(18));
		//
		
		System.out.println(s.verificandoNomeSeguradora("GEGE SEGUROS"));
		
		// Encapsulando os roles
		Map<String, Integer> map = new HashMap<>();
		System.out.println(Optional.ofNullable(map.get("key")));

		stringParaValor("25").ifPresent(System.out::println);
		
		s = s.retornaSeguradoraComNomes("SEGUROS");
		System.out.println(s);
	}

	// Nem sempre a empresa deixa fazer um catch sem um printStackTrace, mas pode-se fazer assim
	/***
	 * Método auxiliar para converter String para int
	 * 
	 * @param numero
	 * @return Optional de Integer ou um Otional.empty se a conversão não for bem sucedida
	 */
	public static Optional<Integer> stringParaValor(String stringNumero) {
		try {
			return Optional.of(Integer.parseInt(stringNumero));
		} catch (NumberFormatException e) {

			return Optional.empty();
		}
	}

}
