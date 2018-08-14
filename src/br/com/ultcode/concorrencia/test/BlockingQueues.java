package br.com.ultcode.concorrencia.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueues {
	public static void main(String[] args) throws InterruptedException {
		// BlockingQueues são filas para gerenciar entrada e saida de dados para threads
		// uma thread produz um dado, outra consome
		// geralmente são filas limitadas
		// uma thread produz um dado e coloca na fila, entra de estado de "wait" até
		// outra thread tirar esse dado da fila, não podendo colocar mais valores que o limite
		// da queue
		// BlockingQueues -> ArrayBlockingQueue, LinkedBlockingQueue, PriorityBlockingQueue
		// Todas as classes que implementão blockingQueues
		// ArrayBlockingQueue, DelayQueue, LinkedBlockingDeque,
		// LinkedBlockingQueue, LinkedTransferQueue, PriorityBlockingQueue, SynchronousQueue
		// A SynchronousQueue é um tipo especial de BlockingQueues, com limite 0, ela só deixa
		// incluir dados se já tiver outra thread querendo fazer a remoção, ou vice verças
		// Tem a DelayQueue, que só aceita classe que é um delayd
		
		BlockingQueue<String> test = new ArrayBlockingQueue<>(1);
		test.put("GEGE");
		System.out.println(test.peek());
		System.out.println("Tentando colocar outro na fila");
		new Thread(new Removedor(test), "ThreadBOLADA").start();
		test.put("É o mais pica viado");
		System.out.println("Outro valor colocado: " + test.peek());

	}

	static class Removedor implements Runnable {

		private final BlockingQueue<?> queue;

		public Removedor(BlockingQueue<?> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			try {
				TimeUnit.SECONDS.sleep(2);
				System.out.println(Thread.currentThread().getName() + " esta removendo o valor: " + queue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}

	}
}
