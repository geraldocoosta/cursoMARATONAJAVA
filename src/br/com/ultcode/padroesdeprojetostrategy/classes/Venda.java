package com.ultcode.padroesdeprojetostrategy.classes;

public class Venda {
	private final Funcionario funcionario;
	private final double valorVenda;

	
	public double getValorVenda() {
		return valorVenda;
	}

	public Venda(Funcionario funcionario, Double valorVenda) {
		this.funcionario = funcionario;
		this.valorVenda = valorVenda;
	}
	
	public double calcularComissao(){
		double comissao = 0.0;
		
		Cargo cargo = funcionario.getCargo();
		comissao = cargo.calculaComissao(valorVenda);
		return comissao;
	}
}
