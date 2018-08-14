package br.com.ultcode.completablefuture.classes;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Loja2 {
	private final String nome;

	public Loja2(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return pegarPreco();
	}

	public Future<Double> getPrecoLojaAssinc() {
		return CompletableFuture.supplyAsync(() -> pegarPreco());
	}

	private static double pegarPreco() {
		delay();
		// System.out.println(1/0);
		return ThreadLocalRandom.current().nextDouble(1, 10000.0);
	}

	private static void delay() {
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

}
