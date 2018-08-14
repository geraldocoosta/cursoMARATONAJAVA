package br.com.ultcode.concorrencia.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
// Temos outras variaveis atomicas
// o que é isso? váriaveis que vao ser lidas e alteradas por uma thread por vez

class Contador {
	private int count;
	private AtomicInteger i = new AtomicInteger();
	private Lock lock = new ReentrantLock(); // usado para obter o lock de um objeto
	// Pode ser usado também para interromper uma pausa de uma thread(colocar ela em execução)
	// Temos a possibilidade de fazer uma thread que ta esperando a mt tempo pelo lock executar
	// o synchronized não garante isso, o lock não garante, mas ele tenta

	public void incrementCount() {
		lock.lock();
		try {
			count++;
		} finally {
			lock.unlock();
		}
	}

	public void incrementVariavelAtomica() {
		i.incrementAndGet();
	}

	public int getCount() {
		return count;
	}

	public int getAtomicInteger() {
		return i.intValue();
	}
}

class IncrementadorThread extends Thread {
	private Contador contador;

	public IncrementadorThread(Contador contador) {
		this.contador = contador;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			contador.incrementCount();
			contador.incrementVariavelAtomica();
		}
	}
}

public class VariavelAtomicaTest {
	public static void main(String[] args) {
		Contador c = new Contador();
		IncrementadorThread t1 = new IncrementadorThread(c);
		IncrementadorThread t2 = new IncrementadorThread(c);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(c.getCount());
		System.out.println(c.getAtomicInteger());
	}

}
