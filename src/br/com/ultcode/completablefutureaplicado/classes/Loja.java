package com.ultcode.completablefutureaplicado.classes;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Loja {
	private String nome;

	public Loja(String nome) {
		this.nome = nome;
	}

	public Loja() {
	}

	public String getPreco() {
		double preco = pegarPreco();
		Desconto.Codigo codigo = Desconto.Codigo.values()[ThreadLocalRandom.current()
				.nextInt(Desconto.Codigo.values().length)];
		return String.format("%s:%,.2f:%s", this.nome,preco,codigo);
	}

	private double pegarPreco() {
		delay();
		return ThreadLocalRandom.current().nextDouble(5000.0);
	}

	private static void delay() {
		try {
			TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(500, 2500));
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static List<Loja> getLojas() {
		return Arrays.asList(new Loja("Americanas"), new Loja("Walmart"), new Loja("Carrefour"),
				new Loja("Extra"));
	}

}
