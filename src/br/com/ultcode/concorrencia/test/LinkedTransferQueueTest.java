package br.com.ultcode.concorrencia.test;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest {
	public static void main(String[] args) throws InterruptedException {
		// TransferQueue -> SynchronousQueue + LinkedBlockingQueue + ConcurrentLinkedQueue
		TransferQueue<String> tq = new LinkedTransferQueue<String>();
		System.out.println(tq.add("GEGE")); // -> retorna um boolean se for adicionado ou lança exceção
		System.out.println(tq.offer("Algo")); // -> retorna true ou false
		System.out.println(tq.offer("Algo", 10, TimeUnit.MILLISECONDS)); // -> retorna true se for adicionado nessa
																			// janela de tempo, e falso se não
		tq.put("Algo"); // -> bloqueia se a capacidade estiver estourada e lança exceção
		tq.transfer("Opa"); // -> o tranfer bloqueia a thread até que esse elemento seja consumido por outra thread
		System.out.println(tq.tryTransfer("TryTransfer")); // -> retorna true se for consumido por uma thread que esta
															// esperando
		// tem o jeito com o timeout tbm, mas to com preguiça
		System.out.println(tq.remainingCapacity()); // para ver a capacidade de uma queue concurrenty, bem grande

		tq.element(); // -> pega o valor sem remover, lança exceção se tiver vazia
		tq.peek(); // -> pega sem remover ou retorna null
		tq.poll(); // -> remove o primeiro valor ou retorna null
		// tem tbm versão sobrecarregada, retorna nulo se tiver vazio
		tq.remove(); // remove ou lança exceção
		tq.take(); // -> remove o primeiro bloqueia até que exista um valor disponivel

	}
}
