package br.com.ultcode.optionals.classes;

import java.util.Optional;

public class Pessoa {

	private String nome;
	private Carro carro;

	public Pessoa(String nome) {
		this.nome = nome;
	}

	public Pessoa(String nome, Carro carro) {
		this.nome = nome;
		this.carro = carro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Optional<Carro> getCarro() {
		return Optional.ofNullable(carro);
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	@Override
	public String toString() {
		return String.format("Pessoa [nome=%s, carro=%s]", nome, carro);
	}

}
