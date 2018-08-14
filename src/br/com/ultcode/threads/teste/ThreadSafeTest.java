package br.com.ultcode.threads.teste;

import java.util.LinkedList;
import java.util.List;

// Muito cuidado ao utilizar classes thread-safe meu jovem, o jeito de implementar também conta

class ListaNomes {
	private List<String> nomes = new LinkedList<>();

	public synchronized void add(String nome) {
		nomes.add(nome);
	}

	public synchronized void removerPrimeiro() {
		if (nomes.size() > 0) {
			System.out.println(nomes.remove(0));
		}
	}
}

public class ThreadSafeTest {
	public static void main(String[] args) {
		ListaNomes nomes = new ListaNomes();
		nomes.add("Geraldão");

		class RemovedorDeNomes extends Thread {
			public void run() {
				nomes.removerPrimeiro();
			}
		}

		new RemovedorDeNomes().start();
		new RemovedorDeNomes().start();
	}
}
