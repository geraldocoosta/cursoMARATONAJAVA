package br.com.ultcode.threads.classes;

import java.util.LinkedList;
import java.util.Queue;

public class ListaMembros {
	private final Queue<String> emails = new LinkedList<>();
	private boolean aberta = true;

	public int getEmailsPendentes() {
		synchronized (emails) {
			return this.emails.size();
		}
	}

	public boolean isAberta() {
		return aberta;
	}

	public String obterEmailMembro() {
		String email = null;
		try {

			synchronized (emails) {
				while (emails.size() == 0) {
					if (!aberta)
						return null;
					System.out.println(
							"Lista vazia, colocando a thread: " + Thread.currentThread().getName() + " em modo wait");
					emails.wait();
				}
				email = emails.poll();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		return email;
	}

	public void adicionarEmailMembro(String email) {
		synchronized (emails) {
			this.emails.add(email);
			System.out.println("Email adicionado na lista!");
			System.out.println("Notificando a threads que estão em esperas!");
			this.emails.notifyAll();
		}
	}

	public void fecharLista() {
		System.out.println("Notificando todas as threads e fechando a lista");
		aberta = false;
		synchronized (emails) {
			this.emails.notifyAll();
		}
	}
}
