package br.com.ultcode.optionals.testes;

import java.util.Optional;

import br.com.ultcode.optionals.classes.Carro;
import br.com.ultcode.optionals.classes.Pessoa;
import br.com.ultcode.optionals.classes.Seguradora;

public class OptionalsTesteReal {
	public static void main(String[] args) {
		Seguradora seguradora = new Seguradora("GEGE SEGUROS");
		Carro carro = new Carro("ABCD123", seguradora);
		Pessoa gege = new Pessoa("GEGE", carro);
		System.out.println(obterNomeSeguradoraOptional(gege));

	}

	public static String obterNomeSeguradoraOptional(Pessoa pessoa) {
		return Optional.ofNullable(pessoa).flatMap(Pessoa::getCarro).flatMap(Carro::getSeguradora)
				.map(Seguradora::getNome).orElse("Não tem nada");

	}

}
