package com.ultcode.completablefutureaplicado.teste;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import com.ultcode.completablefutureaplicado.classes.Desconto;
import com.ultcode.completablefutureaplicado.classes.Loja;
import com.ultcode.completablefutureaplicado.classes.Orcamento;

public class LojaTeste {
	public static void main(String[] args) {
		List<Loja> lojas = Loja.getLojas();
		pegarPreco(lojas);
		ExecutorService executor = Executors.newFixedThreadPool(Math.min(lojas.size(), 100), r -> {
			Thread t = new Thread(r);
			t.setDaemon(true);
			return t;
		});
		pegarPrecoAssync(lojas, executor);
	}

	public static void pegarPreco(List<Loja> lojas) {
		System.out.println("Stream paralela");
		long start = System.currentTimeMillis();
		List<String> collect = lojas.parallelStream().map(Loja::getPreco).map(Orcamento::build)
				.map(Desconto::calcularDesconto).collect(Collectors.toList());
		System.out.println("Tempo: " + (System.currentTimeMillis() - start) + " ms");
		System.out.println(collect);
		System.out.println();
	}

	public static void pegarPrecoAssync(List<Loja> lojas, ExecutorService executor) {
		System.out.println("Completable Future");
		long start = System.currentTimeMillis();
		List<CompletableFuture<String>> collect = lojas.stream()
				.map(loja -> CompletableFuture.supplyAsync(loja::getPreco, executor)) // Nessa linhas, executamos assyncronamente o getPreco

				// Nessa linha estamos transformando a String em orcamento quando ela retorna do getPreco
				.map(future -> future.thenApply(Orcamento::build)) // como a tarefa aqui não é assincrona, podemos fazer esta tarefa sincronamente

				// Compoe o primeiro future com mais uma chamada assincrona, para pegar os descontos
				// no momento que a primeira chamada assync ficar disponivel
				.map(future -> future.thenComposeAsync(orcamento -> CompletableFuture
						.supplyAsync(() -> Desconto.calcularDesconto(orcamento), executor)))
				.collect(Collectors.toList());

		System.out.println(
				"Tempo de invocação das tarefas " + (System.currentTimeMillis() - start) + " ms");

		List<String> collect2 = collect.stream().map(CompletableFuture::join)
				.collect(Collectors.toList());
		System.out.println(collect2);
		System.out.println(
				"Tempo de eeecução das tarefas " + (System.currentTimeMillis() - start) + " ms");
	}
	/*
	 * Obs sobre o método acima thenApply -> é usado se você tem uma função mapping sincrona
	 * 
	 * Ou seja, você recebe o resultado de uma requisição, e já aplica uma função, elemento por elemento. Já que essa função
	 * (modificação elemento-por-elemento) é feita em server side (sem requisição) tudo fica bem nice
	 * 
	 * thenCompose -> é usado se você tem uma função mapping assincrona isto é, retorna um CompletableFuture
	 * 
	 * Pelo o que eu entedi, este(thenCompose) encadeia uma nova requisição a um future. Imagine um caso, você faz a
	 * requisição sincrona pra um elemento, logo depois faz outra pra esse mesmo elemtno, pra fazer todas as requisições de
	 * N elementos, vai demorar mt. Agora, se você faz a primeira requisição para todos os elementos de uma lista e depois
	 * faz a segunda requisição para todos esse elementos, vai ser bem mais rapido
	 * 
	 */
}
