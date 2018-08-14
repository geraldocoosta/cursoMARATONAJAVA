package br.com.ultcode.completablefuture.classes;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Loja {

	public double getPrecoSinc() {
		return pegarPreco();
	}

	public Future<Double> getPrecoLojaAssinc() {
		CompletableFuture<Double> completableFuture = new CompletableFuture<>();
		new Thread(() -> {
			try {
				completableFuture.complete(pegarPreco());
			} catch (Exception e) {
				completableFuture.completeExceptionally(e);
			}
		}).start();
		return completableFuture;
	}

	private static double pegarPreco() {
		delay();
		System.out.println(1 / 0);
		return ThreadLocalRandom.current().nextDouble(1, 10000.0);
	}

	private static void delay() {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

}
