package br.com.ultcode.completablefuture.teste;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import br.com.ultcode.completablefuture.classes.Loja;
import br.com.ultcode.completablefuture.classes.Loja2;

public class CompletableFutureTest2 {
	// Métodos para tratamento de exceção com completableFuture 
	// Se usar o get, ele vai continuar em execução infinitamente
	// Se rolar um exceção antes, não rola get
	// duas opções, primeira: colocar o tempo no get
	// Quando não for possivel colocar o timeout
	// existe outra forma
	// *VER NA CLASSE LOJA*
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Loja casasBahia = new Loja();
		Loja americanas = new Loja();
		Loja extra = new Loja();
		Loja carrefour = new Loja();
		Future<Double> precoNasCasasBahia = casasBahia.getPrecoLojaAssinc();
		Future<Double> precoNaAmericanas = americanas.getPrecoLojaAssinc();
		Future<Double> precoNoExtra = extra.getPrecoLojaAssinc();
		Future<Double> precoNoCarrefour = carrefour.getPrecoLojaAssinc();
		System.out.println(
				"Tempo para iniciar as threads: " + (System.currentTimeMillis() - start) + " ms");
		enrolando();
		try {
			System.out.printf("CasasBahia: %,.2f%n", precoNasCasasBahia.get());
			System.out.printf("Americanas: %,.2f%n", precoNaAmericanas.get());
			System.out.printf("Extra: %,.2f%n", precoNoExtra.get());
			System.out.printf("Carrefour: %,.2f%n", precoNoCarrefour.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("Tempo total: " + (System.currentTimeMillis() - start) + " ms");
		System.out.println();
		
		long start2 = System.currentTimeMillis();
		Loja2 walmart = new Loja2("walmart");
		Loja2 atacadao = new Loja2("atacadao");
		Loja2 seiLa = new Loja2("seiLa");
		Loja2 tbmNaoSei = new Loja2("tbmNaoSei");
		Future<Double> precoNoWalmart = walmart.getPrecoLojaAssinc();
		Future<Double> precoNoAtacadao = atacadao.getPrecoLojaAssinc();
		Future<Double> precoNoSeiLa = seiLa.getPrecoLojaAssinc();
		Future<Double> precoNotbmNaoSeir = tbmNaoSei.getPrecoLojaAssinc();
		System.out.println(
				"Tempo para iniciar as threads: " + (System.currentTimeMillis() - start2) + " ms");
		enrolando();
		try {
			System.out.printf("walmart: %,.2f%n", precoNoWalmart.get());
			System.out.printf("atacadao: %,.2f%n", precoNoAtacadao.get());
			System.out.printf("seiLa: %,.2f%n", precoNoSeiLa.get());
			System.out.printf("tbmNaoSei: %,.2f%n", precoNotbmNaoSeir.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("Tempo total: " + (System.currentTimeMillis() - start2) + " ms");
	}

	private static void enrolando() {
		long soma = 0;
		for (int i = 0; i < 1000000; i++) {
			soma += i;
		}
		System.out.println(soma);
	}
}
