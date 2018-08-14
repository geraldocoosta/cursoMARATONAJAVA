package br.com.ultcode.optionals.testes;

import java.util.Optional;

public class OptionalTest1 {
	private String nome = "gege";

	public static void main(String[] args) {
		OptionalTest1 optionalTest1 = new OptionalTest1();
		String algo = null;
		Optional<String> optional = Optional.of(optionalTest1.nome);
		Optional<String> optional1 = Optional.empty();
		Optional<String> optional2 = Optional.ofNullable(algo);

		System.out.println(optional);
		System.out.println(optional1);
		System.out.println(optional2);

		System.out.println();

		// Buscando valores
		// forma mais simples de pegar o valor, porém pode dar exceção "NoSuchElementException"
		System.out.println(optional.get());
		// O recomendado ao buscar valor com get é usar o is present
		if (optional1.isPresent())
			// Essa não aparece pq não tem nada
			System.out.println(optional1.get());
		
		
		// Pode-se usar o método orElse também, que retorna um valor, ou o que tu passar pelos params
		System.out.println(optional2.orElse("TEM NADA"));

	}
}
