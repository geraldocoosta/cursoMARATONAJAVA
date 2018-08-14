package br.com.ultcode.completablefutureavanc.classes;

import br.com.ultcode.completablefutureavanc.classes.Desconto.Codigo;

public class Orcamento {

	private final String nomeLoja;
	private final double preco;
	private final Desconto.Codigo codigo;

	private Orcamento(String nomeLoja, double preco, Codigo codigo) {
		this.nomeLoja = nomeLoja;
		this.preco = preco;
		this.codigo = codigo;
	}

	public String getNomeLoja() {
		return nomeLoja;
	}

	public double getPreco() {
		return preco;
	}

	public Desconto.Codigo getCodigo() {
		return codigo;
	}

	public static Orcamento buildOrcamento(String s) {
		String[] split = s.split(":");
		if (split.length != 3) {
			throw new IllegalArgumentException("Não foi encontrado um parametro para o parse");
		}
		String nome = split[0];
		double valor = Double.parseDouble(split[1].replaceAll("\\.", "").replace(",", "."));
		Desconto.Codigo codigo = Desconto.Codigo.valueOf(split[2]);
		return new Orcamento(nome, valor, codigo);
	}
}
