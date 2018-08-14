package br.com.ultcode.streams.classes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Pessoa {
	private String nome;
	private int idade;
	private double salario;
	private Genero genero;

	public static List<Pessoa> getList() {
		return Arrays.asList(
				new Pessoa("Gege", 21, 7000.0,  Genero.MASCULINO),
				new Pessoa("Tete", 19, 8000.0, Genero.FEMININO),
				new Pessoa("Phelipe", 25, 1700.0, Genero.MASCULINO),
				new Pessoa("Maria", 45, 1200.0, Genero.FEMININO),
				new Pessoa("Graça", 36, 4000.0, Genero.FEMININO),
				new Pessoa("Rodolfo", 29, 4500.5, Genero.MASCULINO),
				new Pessoa("Astolfo", 86, 2500.0, Genero.MASCULINO),
				new Pessoa("Roberta", 15, 500.0, Genero.FEMININO));
	}

	public static Stream<Pessoa> getStream() {
		return getList().stream();
	}

	public Pessoa(String nome, int idade, double salario) {
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;
	}

	public Pessoa(String nome, int idade, double salario, Genero genero) {
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;
		this.genero = genero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return String.format("Pessoa [nome=%s, idade=%s, salario=%s]", nome, idade, salario);
	}

}
