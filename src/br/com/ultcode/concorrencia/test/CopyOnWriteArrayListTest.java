package br.com.ultcode.concorrencia.test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class CopyOnWriteArrayListTest implements Runnable {

	// CopyOnWriteArrayList � uma colection "thread safe" imutavel
	// ou seja, toda vez que voc� adiciona ou remove um item, um novo objeto dessa classe
	// � criado e referenciado (bom para leitura, para adicionar e remover n�o)
	// Lembre-se da peculiaridade no uso do iterator para classe CopyOnWriteArrayList e ArraySet
	// n�o da pra adicionar ou remover com iterator, oq a lista ou map s�o imutaveis
	private List<Integer> list = new CopyOnWriteArrayList<>();

	public List<Integer> getList() {
		return list;
	}

	public CopyOnWriteArrayListTest() {
		for (int i = 0; i < 2000; i++) {
			list.add(i);
		}
	}

	@Override
	public void run() {
		Iterator<Integer> iterador = list.iterator();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		while (iterador.hasNext()) {
			System.out.println(Thread.currentThread().getName() + " leu: " + iterador.next());
		}
	}

	private static class RemoveMembros implements Runnable {
		private List<Integer> list;

		public RemoveMembros(List<Integer> list) {
			this.list = list;
		}

		@Override
		public void run() {
			for (int i = 0; i < 900; i++) {
				System.out.println("A thread" + Thread.currentThread().getName() + " retirou: " + list.remove(i));
			}
		}

	}
	
	public static void main(String[] args) {
		CopyOnWriteArrayListTest cp = new CopyOnWriteArrayListTest();
		Thread th1 = new Thread(cp,"TRAB1"); 
		Thread th2 = new Thread(cp,"TRAB2"); 
		Thread removedor = new Thread(new RemoveMembros(cp.getList()),"TRAB REMOVE");
		th1.start();
		th2.start();
		removedor.start();
	}
}
