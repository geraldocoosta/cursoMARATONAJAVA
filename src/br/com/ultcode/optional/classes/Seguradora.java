package br.com.ultcode.optional.classes;

import java.util.Optional;

public class Seguradora {
	private String nome;

	public Seguradora(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String verificandoNomeSeguradora(String nome) {
		return Optional.of(this).filter(s -> s.getNome().equals(nome)).map(Seguradora::getNome)
				.orElse("Não há seguradora com esse nome");
	}

	public Seguradora retornaSeguradoraComNomes(String nome) {
		return Optional.of(this).filter(s -> s.getNome().equals(nome)).orElse(new Seguradora("SEGURADORA NULA"));
	}

	@Override
	public String toString() {
		return String.format("Seguradora [nome=%s]", nome);
	}

}
