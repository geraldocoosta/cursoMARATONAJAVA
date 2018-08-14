package br.com.ultcode.completablefutureavanc.classes;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Loja {
	private String nome;

	public Loja(String nome) {
		this.nome = nome;
	}

	public String getPreco() {
		Desconto.Codigo codigo = Desconto.Codigo.values()[ThreadLocalRandom.current()
				.nextInt(Desconto.Codigo.values().length)];
		Double preco = gerarPreco();
		return String.format("%s:%,.2f:%s", this.nome, preco, codigo);
	}

	private static void delay() {
		int x = ThreadLocalRandom.current().nextInt(500, 2500);
		try {
			TimeUnit.MILLISECONDS.sleep(x);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static double gerarPreco() {
		delay();
		return ThreadLocalRandom.current().nextDouble(0.1, 5000.0);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static List<Loja> getLojas() {
		return Arrays.asList(new Loja("Americanas"), new Loja("Carrefour"),
				new Loja("Extra"), new Loja("Amazon"));
	}

}
