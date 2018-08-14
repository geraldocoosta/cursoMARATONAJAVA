package com.ultcode.stream.classes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Pessoa {
	private String nome;
	private int idade;
	private double salario;
	private Genero genero;

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

	public static List<Pessoa> bancoDePessoas() {
		return Arrays.asList(
				new Pessoa("Gege", 21, 7000.0, Genero.MASC), 
				new Pessoa("Tete", 19, 6500.0, Genero.FEM),
				new Pessoa("Roro", 25, 1500.0, Genero.MASC),
				new Pessoa("Dede", 65, 1000.0, Genero.MASC),
				new Pessoa("Heldin", 25, 1000.0, Genero.MASC), 
				new Pessoa("Maluq", 17, 10000.0, Genero.MASC),
				new Pessoa("Kscerato", 20, 2700.0, Genero.MASC),
				new Pessoa("Potato", 14, 3560.0, Genero.MASC),
				new Pessoa("Ana", 22, 6500.0, Genero.FEM),
				new Pessoa("Vitoria", 15, 900.0, Genero.FEM),
				new Pessoa("Jess", 25, 3000.0, Genero.FEM),
				new Pessoa("Mangula", 82, 1200.0, Genero.MASC),
				new Pessoa("Aristolfo", 63, 1700.0, Genero.MASC), 
				new Pessoa("Graça", 45, 3500.0, Genero.FEM));
	}

	public static Stream<Pessoa> getStream() {
		return bancoDePessoas().stream();
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Pessoa [" + (nome != null ? "nome=" + nome + ", " : "") + "idade=" + idade
				+ ", salario=" + salario + "]";
	}

}
