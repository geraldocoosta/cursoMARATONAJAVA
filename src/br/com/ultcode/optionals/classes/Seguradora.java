package br.com.ultcode.optionals.classes;

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

	@Override
	public String toString() {
		return String.format("Seguradora [nome=%s]", nome);
	}

}
