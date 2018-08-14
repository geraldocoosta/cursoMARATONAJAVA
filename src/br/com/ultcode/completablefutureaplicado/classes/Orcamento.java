package com.ultcode.completablefutureaplicado.classes;

import com.ultcode.completablefutureaplicado.classes.Desconto.Codigo;

public class Orcamento {
	private final String nomeLoja;
	private final double preco;
	private final Desconto.Codigo codigo;

	private Orcamento(String nomeLoja, double preco, Codigo codigo) {
		this.nomeLoja = nomeLoja;
		this.preco = preco;
		this.codigo = codigo;
	}

	public static Orcamento build(String preco) {
		String[] s = preco.split(":");
		String nome = s[0];
		String precoEmString = s[1].replaceAll("\\.", "").replaceAll(",", ".");
		double precoProduto = Double.parseDouble(precoEmString);
		Desconto.Codigo codigoDesconto = Desconto.Codigo.valueOf(s[2]);
		return new Orcamento(nome, precoProduto, codigoDesconto);
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

}
