package br.com.ultcode.threads.classes;

public class Conta {
	private int saldo = 1000;
					
	public int getSaldo() {
		return saldo;
	}
	
	public void saque(int valor) {
		saldo -= valor;
	}
}
