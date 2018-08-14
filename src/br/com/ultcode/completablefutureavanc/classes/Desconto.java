package br.com.ultcode.completablefutureavanc.classes;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Desconto {
	public enum Codigo {
		NENHUM(0), SILVER(5), GOLD(10), PLATINUM(15), ELITE(20);

		private final int desconto;

		Codigo(int desconto) {
			this.desconto = desconto;
		}

		public int getDesconto() {
			return desconto;
		}
	}

	public static String gerarDesconto(Orcamento orcamento) {
		delay();
		return String.format(
				"Nome da loja: %s. Preco original é %,.2f. Desconto: %d%s. Valor bruto: %,.2f ",
				orcamento.getNomeLoja(), orcamento.getPreco(), orcamento.getCodigo().desconto,
				"%", calcularDesconto(orcamento.getPreco(), orcamento.getCodigo()));
	}

	private static double calcularDesconto(Double preco, Codigo codigo) {
		return preco * (100 - codigo.desconto) / 100;
	}

	private static void delay() {
		int x = ThreadLocalRandom.current().nextInt(500, 2500);
		try {
			TimeUnit.MILLISECONDS.sleep(x);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
