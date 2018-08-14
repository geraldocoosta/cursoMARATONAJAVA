package com.ultcode.completablefuture.teste;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import com.ultcode.completablefuture.classes.Loja2;

public class CompletableFutureTest3 {
	public static void main(String[] args) {
		List<Loja2> lojas = Arrays.asList(new Loja2("Americanas"), new Loja2("Walmart"),
				new Loja2("Carrefour"), new Loja2("Extra"), new Loja2("Americanas"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Americanas"), new Loja2("Walmart"), new Loja2("Carrefour"),
				new Loja2("Extra"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Americanas"), new Loja2("Walmart"), new Loja2("Carrefour"),
				new Loja2("Extra"), new Loja2("Americanas"), new Loja2("Walmart"),
				new Loja2("Carrefour"), new Loja2("Extra"), new Loja2("Carrefour"),
				new Loja2("Extra"), new Loja2("Americanas"), new Loja2("Walmart"),
				new Loja2("Carrefour"), new Loja2("Extra"), new Loja2("Americanas"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"),
				new Loja2("Walmart"), new Loja2("Carrefour"), new Loja2("Extra"));
		
		// pegarPreco(lojas);
		// pegarPreco2(lojas);
		// pegarPreco3(lojas);
		// pegarPreco4(lojas);
		// numero de Threads = ncpu * UCPU * (1+W/C)
		// ncpu = numero de cores (como descobrir?)
		System.out.println(Runtime.getRuntime().availableProcessors());
		System.out.println(lojas.size());
		// ucpu = utilização da cpu (0-1)
		// (quanto eu quero utilizar a cpu? 1 = total, 0 = quase nada, 0,5 metadinha)
		// W/C -> wait time e compute time -> tempo computando e esperando
		// NThreads = 8*1*(1+99) // basicamente, informando que a cpu fica 99% do tempo parada
		final ExecutorService executor = Executors.newFixedThreadPool(Math.min(lojas.size(), 100),
				r -> {
					Thread t = new Thread(r);
					t.setDaemon(true);
					return t;
				});
		pegarPreco2(lojas);
		pegarPreco4(lojas);
		pegarPreco4(lojas, executor);

	}

	// Fazendo requisições assincronas sem controle da api
	public static void pegarPreco(List<Loja2> lojas) {
		System.out.println("Stream sequencial");
		long start = System.currentTimeMillis();
		List<String> collect = lojas.stream()
				.map(loja -> String.format("%s o preco eh: %,.2f", loja.getNome(), loja.getPreco()))
				.collect(Collectors.toList());
		System.out.println("Tempo: " + (System.currentTimeMillis() - start) + " ms");
		System.out.println(collect);
	}

	public static void pegarPreco2(List<Loja2> lojas) {
		System.out.println("Stream paralela");
		long start = System.currentTimeMillis();
		List<String> collect = lojas.parallelStream()
				.map(loja -> String.format("%s o preco eh: %,.2f", loja.getNome(), loja.getPreco()))
				.collect(Collectors.toList());
		System.out.println("Tempo: " + (System.currentTimeMillis() - start) + " ms");
		System.out.println(collect);
		System.out.println();
	}

	public static void pegarPreco3(List<Loja2> lojas) {
		System.out.println(" CompletableFuture sequencial");
		long start = System.currentTimeMillis();
		List<String> collect = lojas.stream()
				.map(l -> CompletableFuture.supplyAsync(
						() -> String.format("%s o preco eh: %,.2f", l.getNome(), l.getPreco())))
				.map(CompletableFuture::join).collect(Collectors.toList());
		System.out.println("Tempo: " + (System.currentTimeMillis() - start) + " ms");
		System.out.println(collect);
	}

	// paralel é mais rapido nesse pc com muitas lojas, muitas mesmo (lá pras 20),
	// mas o ideal é fazer testes
	// a vantagem de usar o completableFuture é que podemos passar um ExecutorService
	public static void pegarPreco4(List<Loja2> lojas) {
		System.out.println("CompletableFuture");
		long start = System.currentTimeMillis();
		List<CompletableFuture<String>> collect2 = lojas.stream()
				.map(l -> CompletableFuture.supplyAsync(
						() -> String.format("%s o preco eh: %,.2f", l.getNome(), l.getPreco())))
				.collect(Collectors.toList());
		// Essa linha chama o método supplyAsync da classe CompletableFuture

		System.out.println("Tempo de invocação: " + (System.currentTimeMillis() - start) + " ms");

		List<String> collect = collect2.stream().map(CompletableFuture::join)
				.collect(Collectors.toList()); // Essa linha que pega o resultado

		System.out.println("Tempo total: " + (System.currentTimeMillis() - start) + " ms");
		System.out.println(collect);
		System.out.println();
	}

	public static void pegarPreco4(List<Loja2> lojas, Executor executor) {
		System.out.println("CompletableFuture com executor");
		long start = System.currentTimeMillis();
		List<CompletableFuture<String>> collect2 = lojas.stream()
				.map(l -> CompletableFuture.supplyAsync(
						() -> String.format("%s o preco eh: %,.2f", l.getNome(), l.getPreco()),
						executor))
				.collect(Collectors.toList());

		System.out.println("Tempo de invocação: " + (System.currentTimeMillis() - start) + " ms");

		List<String> collect = collect2.stream().map(CompletableFuture::join)
				.collect(Collectors.toList());

		System.out.println("Tempo total: " + (System.currentTimeMillis() - start) + " ms");
		System.out.println(collect);
	}
}
