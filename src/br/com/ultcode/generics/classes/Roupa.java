package br.com.ultcode.generics.classes;

public class Roupa {
	private String nome;
	private String marca;
	private String tipo;

	public Roupa(String nome, String marca, String tipo) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Roupa [nome=" + nome + ", marca=" + marca + ", tipo=" + tipo + "]";
	}

}
