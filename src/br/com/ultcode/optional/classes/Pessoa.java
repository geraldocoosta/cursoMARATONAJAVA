package br.com.ultcode.optional.classes;

import java.util.Optional;

public class Pessoa {
	private String nome;
	private Carro carro;
	private int idade;

	public Pessoa(String nome, Carro carro, int idade) {
		this.nome = nome;
		this.carro = carro;
		this.idade = idade;
	}

	public Pessoa(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String buscarSeguradora() {
		return this.getCarro().flatMap(Carro::getSeguradora).map(Seguradora::getNome)
				.orElse("Seguradora não encontrada");
	}

	public String buscarSeguradoraMaiorDeIdade(int maiorIdade) {
		return Optional.of(this).filter(p -> p.getIdade() >= maiorIdade).flatMap(Pessoa::getCarro)
				.flatMap(Carro::getSeguradora).map(Seguradora::getNome)
				.orElse(String.format("Seguradora não existe ou idade menor que %s", maiorIdade));
	}
	
	

	
	@Override
	public String toString() {
		return "Pessoa [" + (nome != null ? "nome=" + nome + ", " : "") + (carro != null ? "carro=" + carro + ", " : "")
				+ "idade=" + idade + "]";
	}

}
