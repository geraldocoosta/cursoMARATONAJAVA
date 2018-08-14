package br.com.ultcode.padraodeprojeto.teste;

import br.com.ultcode.padraodeprojeto.classes.PadraoBuilder;

public class PadraoBuilderTest {
	public static void main(String[] args) {
		PadraoBuilder pessoa = new PadraoBuilder.PadraoBuilderBuilder()
				.nome("GEGE")
				.dtNascimento("23/05/1997")
				.idade(21)
				.sobrenome("Costa")
				.build();
		System.out.println(pessoa);
	}
}
