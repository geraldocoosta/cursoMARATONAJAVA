package br.com.ultcode.threads.teste;

class ThreadsExemplo implements Runnable {
	private String nome;

	public ThreadsExemplo(String nome) {
		this.nome = nome;
	}

	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println(nome);
			Thread.yield();
		}
	}
}

// sleep - espera um determindado tempo. não garante que uma thread voltará a executar
// depois que o tempo passar, garante que ela vai retornar ao estado de runnable
// wait - espera um notify ou notifyall de outro Thread.
// yield - eventualmente permite outros Threads a executar. Não é garantido, mas uma das
// funções desse método é dar uma chance de threads com prioridade igual ou superior serem
// executadas, voltando a thread em running para o estado runnable
// join - método não statico utilizado para avisar uma thread, que outra thread que ela chamou
// deve terminar seu run antes de chamar uma thread diferente, ou antes de completar seu proprio
// run
// exemplo -> thread main que manda executar as threads T1 e T2, então temos que falar
// pra thread main executar t2 só quando t1 acabar, [unico garantido!!!]
// Não importa a prioridade, o join vai executar e vai ficar suna suna
// porém, se startar e depois dar o join, provavelmente a jvm vai começar executando na normalidade
// ai quando der o join ela vai dar a prioridade bolada, porém ainda tem possibilidade de aparecer
// outra thread, fique ligeiro


public class MétodosSleepYieldJoin {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new ThreadsExemplo("NORMAL1"), "Thread1");
		Thread t2 = new Thread(new ThreadsExemplo("NORMAL2"), "Thread2");
		Thread t3 = new Thread(new ThreadsExemplo("NORMAL3"), "Thread3");
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
		t1.join(); // o que estamos falando aqui?
		// thread que executa a thread t1, marca suave até ela terminar o serviço dela,
		// depois chama os outros otarios
		
	}
}
