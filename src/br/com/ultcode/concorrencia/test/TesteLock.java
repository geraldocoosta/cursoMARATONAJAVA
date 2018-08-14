package br.com.ultcode.concorrencia.test;

import java.util.concurrent.locks.ReentrantLock;

public class TesteLock {
	public static void main(String[] args) {
		ReentrantLock re = new ReentrantLock();
		new Thread(new Brincando(re, "A")).start();
		new Thread(new Brincando(re, "B")).start();
		new Thread(new Brincando(re, "C")).start();
		new Thread(new Brincando(re, "D")).start();
		new Thread(new Brincando(re, "E")).start();
		new Thread(new Brincando(re, "F")).start();
		new Thread(new Brincando(re, "G")).start();
	}

	static class Brincando implements Runnable {
		ReentrantLock lock;
		String nome;

		Brincando(ReentrantLock lock, String nome) {
			this.lock = lock;
			this.nome = nome;
		}

		@Override
		public void run() {

			lock.lock();
			try {
				if (lock.isHeldByCurrentThread()) {
					System.out.println("==============================");
					System.out.printf("Thread %s entrou em uma sessão critica%n", nome);
				}

				System.out.printf("Threads esperando na fila: %d%n", lock.getQueueLength());
				System.out.printf("Thread %s vai trabalhar por 2 segundos%n", nome);
				Thread.sleep(2000);
				System.out.printf("Thread %s finalizou o trab%n", nome);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}

	}
}
