package br.com.ultcode.completablefutureavanc.teste;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import br.com.ultcode.completablefutureavanc.classes.Desconto;
import br.com.ultcode.completablefutureavanc.classes.Loja;
import br.com.ultcode.completablefutureavanc.classes.Orcamento;

public class TesteLoja {
	public static void main(String[] args) {
		List<Loja> lojas = Loja.getLojas();

		ExecutorService executor = Executors.newFixedThreadPool(Math.min(lojas.size(), 100),
				r -> {
					Thread t = new Thread(r);
					t.setDaemon(true);
					return t;
				});
		long start = System.currentTimeMillis();
		CompletableFuture<?>[] array = getLojasAssync(lojas, executor)
				.map(future -> future.thenAccept(s -> System.out.println(s)))
				.toArray(CompletableFuture[]::new);

		CompletableFuture.allOf(array).join(); // retorna todos
		// CompletableFuture.anyOf(array).join(); // só retorna o primeiro
		System.out.println("Tempo final " + (System.currentTimeMillis() - start) + " ms");

	}

	public static Stream<CompletableFuture<String>> getLojasAssync(List<Loja> lojas,
			ExecutorService executor) {
		return lojas.stream()
				.map(loja -> CompletableFuture.supplyAsync(loja::getPreco, executor))
				.map(future -> future.thenApply(Orcamento::buildOrcamento))
				.map(future -> future.thenCompose(orcamento -> CompletableFuture
						.supplyAsync(() -> Desconto.gerarDesconto(orcamento), executor)));
	}
}
