package com.ultcode.completablefutureaplicado.teste2;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ultcode.completablefutureaplicado.classes.Desconto;
import com.ultcode.completablefutureaplicado.classes.Loja;
import com.ultcode.completablefutureaplicado.classes.Orcamento;

public class Teste {
	public static void main(String[] args) {
		List<Loja> lojas = Loja.getLojas();
		ExecutorService executor = Executors.newFixedThreadPool(Math.min(lojas.size(), 100), r -> {
			Thread t = new Thread(r);
			t.setDaemon(true);
			return t;
		});
		long start = System.currentTimeMillis();
		CompletableFuture<?>[] resultadoFuturo = getPrecosAsync(lojas, executor)
				.map(f -> f.thenAccept(s -> System.out
						.println(s + " tempo: " + (System.currentTimeMillis() - start))))
				.toArray(CompletableFuture[]::new);
		CompletableFuture.anyOf(resultadoFuturo).join();

		System.out.println("TESTE");
		long start2 = System.currentTimeMillis();
		List<String> collect = getPrecosAsync2(lojas, executor);
		long end = System.currentTimeMillis();
		System.out.println(collect);
		System.out.println(end - start2 + " ms");
	}

	public static Stream<CompletableFuture<String>> getPrecosAsync(List<Loja> lojas,
			ExecutorService executor) {
		return lojas.stream().map(loja -> CompletableFuture.supplyAsync(loja::getPreco, executor))
				.map(future -> future.thenApply(Orcamento::build))
				.map(future -> future.thenCompose(orcamento -> CompletableFuture
						.supplyAsync(() -> Desconto.calcularDesconto(orcamento), executor)));
	}

	public static List<String> getPrecosAsync2(List<Loja> lojas, ExecutorService executor) {
		List<CompletableFuture<String>> collect = lojas.stream()
				.map(loja -> CompletableFuture.supplyAsync(loja::getPreco, executor))
				.map(future -> future.thenApply(Orcamento::build))
				.map(future -> future.thenCompose(orcamento -> CompletableFuture
						.supplyAsync(() -> Desconto.calcularDesconto(orcamento), executor)))
				.collect(Collectors.toList());

		return collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
	}
}
