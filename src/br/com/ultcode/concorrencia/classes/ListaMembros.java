package br.com.ultcode.concorrencia.classes;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ListaMembros {
	private final Queue<String> emails = new LinkedList<>();
	private final ReentrantLock rlock = new ReentrantLock();
	// Quando temos uma váriavel final inicializada, todas as threads veem aquela variavel
	private Condition conditionLock1 = rlock.newCondition();
	// Condition -> é como se fosse o wait
	private boolean aberta = true;

	public int getQtdEmailsPendentes() {
		rlock.lock();
		try {
			return emails.size();
		} finally {
			rlock.unlock();
		}
	}

	public boolean isAberta() {
		rlock.lock();
		try {
			return aberta;
		} finally {
			rlock.unlock();
		}
	}

	public String obterEmail() {
		String email = null;
		rlock.lock();
		try {
			while (emails.size() == 0) {
				if (!aberta)
					return null;
				System.out.printf("Lista vazia, colocando a thread %s em modo wait%n", Thread.currentThread().getName());
				conditionLock1.await(); // -> é como se fosse o wait
			}
			email = emails.poll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			rlock.unlock();
		}
		return email;
	}
	
	public void adicionarEmail(String email) {
		rlock.lock();
		try {
			emails.add(email);
			System.out.println("Email adicionado na lista");
			System.out.printf("Notificando a thread em espera: %s%n",Thread.currentThread().getName());
			conditionLock1.signalAll(); // -> mesma coisa do notify
		}finally {
			rlock.unlock();
		}
	}
	
	public void fecharLista() {
		rlock.lock();
		try {
			System.out.println("Notificando todas as threads e fechando a lista");
			aberta = false;
			conditionLock1.signalAll();
		}finally {
			rlock.unlock();
		}
	}
}
