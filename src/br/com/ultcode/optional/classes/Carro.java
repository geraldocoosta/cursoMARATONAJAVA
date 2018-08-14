package com.ultcode.optional.classes;

import java.util.Optional;

public class Carro {
	private String nome;
	private Seguradora seguradora;

	public Carro(String nome, Seguradora seguradora) {
		this.nome = nome;
		this.seguradora = seguradora;
	}

	public Carro(String nome) {
		this.nome = nome; 
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Optional<Seguradora> getSeguradora() {
		return Optional.ofNullable(seguradora);
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

	@Override
	public String toString() {
		return String.format("Carro [nome=%s, seguradora=%s]", nome, seguradora);
	}


}
