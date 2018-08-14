package br.com.ultcode.concorrencia.test;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest {
	public static void main(String[] args) throws InterruptedException {
		// TransferQueue -> SynchronousQueue + LinkedBlockingQueue + ConcurrentLinkedQueue
		TransferQueue<String> tq = new LinkedTransferQueue<String>();
		System.out.println(tq.add("GEGE")); // -> retorna um boolean se for adicionado ou lan�a exce��o
		System.out.println(tq.offer("Algo")); // -> retorna true ou false
		System.out.println(tq.offer("Algo", 10, TimeUnit.MILLISECONDS)); // -> retorna true se for adicionado nessa
																			// janela de tempo, e falso se n�o
		tq.put("Algo"); // -> bloqueia se a capacidade estiver estourada e lan�a exce��o
		tq.transfer("Opa"); // -> o tranfer bloqueia a thread at� que esse elemento seja consumido por outra thread
		System.out.println(tq.tryTransfer("TryTransfer")); // -> retorna true se for consumido por uma thread que esta
															// esperando
		// tem o jeito com o timeout tbm, mas to com pregui�a
		System.out.println(tq.remainingCapacity()); // para ver a capacidade de uma queue concurrenty, bem grande

		tq.element(); // -> pega o valor sem remover, lan�a exce��o se tiver vazia
		tq.peek(); // -> pega sem remover ou retorna null
		tq.poll(); // -> remove o primeiro valor ou retorna null
		// tem tbm vers�o sobrecarregada, retorna nulo se tiver vazio
		tq.remove(); // remove ou lan�a exce��o
		tq.take(); // -> remove o primeiro bloqueia at� que exista um valor disponivel

	}
}
