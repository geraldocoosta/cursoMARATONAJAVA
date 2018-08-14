package br.com.ultcode.optionals.classes;

import java.util.Optional;

public class Carro {
	private String placa;
	private Seguradora seguradora;

	public Carro(String placa, Seguradora seguradora) {
		this.placa = placa;
		this.seguradora = seguradora;
	}

	public Carro(String placa) {
		this.placa = placa;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Optional<Seguradora> getSeguradora() {
		return Optional.ofNullable(seguradora);
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

	@Override
	public String toString() {
		return String.format("Carro [placa=%s, seguradora=%s]", placa, seguradora);
	}

}
