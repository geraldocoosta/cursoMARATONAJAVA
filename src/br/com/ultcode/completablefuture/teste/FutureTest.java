package br.com.ultcode.completablefuture.teste;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTest {
	private static ExecutorService executorService = Executors.newFixedThreadPool(2);

	public static void main(String[] args) {
		Future<Double> future = executorService.submit(() -> {
			TimeUnit.SECONDS.sleep(2);
			return 2000.0;
		});
		enrolando();
		Double retorno = 0.0;
		try {
			retorno = future.get(3, TimeUnit.SECONDS);
			System.out.println(retorno);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}

	}

	private static void enrolando() {
		long soma = 0;
		for (int i = 0; i < 1000000; i++) {
			soma += i;
		}
		System.out.println(soma);
	}
}
