package com.ultcode.completablefutureaplicado.classes;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Desconto {
	public enum Codigo {
		NENHUM(0), SILVER(5), GOLD(10), PLATINUM(15), ELITE(20);

		public final int porcentagem;

		private Codigo(int i) {
			this.porcentagem = i;
		}

		public int getPorcentagem() {
			return porcentagem;
		}

	}

	public static String calcularDesconto(Orcamento orcamento) {
		return String.format("%s deu um descoconto de %d%s no preco %,.2f. Total: %,.2f",
				orcamento.getNomeLoja(), orcamento.getCodigo().getPorcentagem(), "%",
				orcamento.getPreco(), calculo(orcamento.getPreco(), orcamento.getCodigo()));
	}

	private static Double calculo(double preco, Codigo codigo) {
		delay();
		return preco * (100 - codigo.porcentagem) / 100;
	}

	private static void delay() {
		try {
			TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(500, 2500));
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
}
