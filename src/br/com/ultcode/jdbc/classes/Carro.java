package br.com.ultcode.jdbc.classes;

public class Carro {
	private Integer id;
	private String nome;
	private String placa;
	private Comprador comprador;

	public Carro(String nome, String placa, Comprador comprador) {
		this.nome = nome;
		this.placa = placa;
		this.comprador = comprador;
	}

	public Carro(int id, String nome, String placa, Comprador comprador) {
		this.id = id;
		this.nome = nome;
		this.placa = placa;
		this.comprador = comprador;
	}

	public Carro() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Comprador getComprador() {
		return comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
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
		Carro other = (Carro) obj;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Carro [id=" + id + ", nome=" + nome + ", placa=" + placa + ", comprador=" + comprador + "]";
	}

}
