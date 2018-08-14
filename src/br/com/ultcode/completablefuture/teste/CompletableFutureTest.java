package br.com.ultcode.completablefuture.teste;

import br.com.ultcode.completablefuture.classes.Loja;

public class CompletableFutureTest {
	public static void main(String[] args) {
		Loja casasBahia = new Loja();
		Loja Americanas = new Loja();
		Loja Extra = new Loja();
		Loja Carrefour = new Loja();
		long start = System.currentTimeMillis();
		System.out.printf("casasBahia: %,.2f%n",casasBahia.getPrecoSinc());
		System.out.printf("Americanas: %,.2f%n",Americanas.getPrecoSinc());
		System.out.printf("Extra: %,.2f%n",Extra.getPrecoSinc());
		System.out.printf("Carrefour: %,.2f%n",Carrefour.getPrecoSinc());
		System.out
				.println("Tarefa terminadada após " + (System.currentTimeMillis() - start) + " ms");
	}
}
