package br.com.ultcode.threads.teste;

// Threads = linhas de comando
// elas possibilitam a execu��o de multiplas tarefas ao mesmo tempo
// no gerenciador de tarefas do windows, mostra quantas threads est�o
// sendo utilizadas no momento
// A JVM que decide a prioridades da threads, decidindo qual come�a ou 
// qual termina
// Temos 2 formas de criar threads, e tamb�m temos 2 tipos de threads
// Daemon -> Se tiver um thread Daemon rodando, a JVM pode ignorar e finalizar
//  sua execu��o igual, sem peso na conciencia 
// User   -> A JVM s� finaliza sua execu��o quando todas as threads User
//  s�o finalizadas
// E para criar as threads gege?
// Ou extendemos da classe java.lang.Thread ou implementamos a interface 
//  Runnable

public class ThreadsTeste {
	// Todas as vezes que executamos o m�todo main, n�s temos uma thread
	// qual o nome da thread? (toda thread tem um nome, voc� nomeando ou n�o)
	public static void main(String[] args) {
		// Thread.currentThread().getName() -> descobre o nome da thread
		System.out.println("thread sendo executada: " + Thread.currentThread().getName());
		// ThreadExemplo t1 = new ThreadExemplo('a');
		// ThreadExemplo t2 = new ThreadExemplo('b');
		// ThreadExemplo t3 = new ThreadExemplo('c');
		// ThreadExemplo t4 = new ThreadExemplo('d');
		// Todos est�o sendo executados na mesma thread, pois estamos chamando
		// explicitamente o m�todo run
		// para iniciar uma thread (ai sim v�o executar em paralelo) chama-se
		// o m�todo .start();

		// t1.run();
		// t2.run();
		// t3.run();
		// t4.run();

		// Perceba que assim n�o d� pra prever qual a ordem de execu��o!!!
		// uma vez dado o start, � responsabilidade da JVM verificar qual das
		// threads vai ser executada e por quanto tempo.
		// schedule = cronograma, n�o temos no��o do schedule que a jvm faz
		// para a execu��o das threads
		// Uma thread pode afetar a execu��o da outra

		// t1.start();
		// t2.start();
		// t3.start();
		// t4.start();

		// Testando threads implementando runnable
		// para executar uma thread que implementa runnable, devemos instanciar
		// um objeto de Thread(java.lang) e passar nossa thread no construtor
		// cria--se thread, passa o runnable pra essa thread, e ai sim da o start

		Thread runnable1 = new Thread(new ThreadExemploRunnable('a'));
		Thread runnable2 = new Thread(new ThreadExemploRunnable('b'));
		Thread runnable3 = new Thread(new ThreadExemploRunnable('c'));
		Thread runnable4 = new Thread(new ThreadExemploRunnable('d'));
		runnable1.start();
		runnable2.start();
		runnable3.start();
		runnable4.start();

	}
}

// outra forma de implementar uma thread � implementando a interface runnable
// que � por padr�o uma boa pr�tica de OO
class ThreadExemploRunnable implements Runnable {
	private char c;

	public ThreadExemploRunnable(char c) {
		this.c = c;
	}

	@Override
	public void run() {
		System.out.println("thread sendo executada: " + Thread.currentThread().getName());
		for (int i = 1; i <= 1000; i++) {
			System.out.print(c);
			if (i % 100 == 0) {
				System.out.println();
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}

		}
	}

}

// Exemplo de thread extendendo da classe Thread
// M� PRATICA EM RELA��O A OO
class ThreadExemplo extends Thread {
	private char c;

	public ThreadExemplo(char c) {
		this.c = c;
	}

	@Override
	public void run() {
		// A m�gica toda acontece aqui
		// se voc� quiser que um c�digo seja executado em paralelo
		// coloque dentro do run
		System.out.println("thread sendo executada: " + Thread.currentThread().getName());
		for (int i = 1; i <= 1000; i++) {
			System.out.print(c);
			if (i % 100 == 0) {
				System.out.println();
			}
		}
	}
}

// A thread, dps de executada, ela morre, e voc� n�o pode ressuscitar!!
// Depois de startarmos uma thread, ela n�o pode ser startada novamente (gera uma exception)
// --------------------------------------------------------------- (IllegalThreadStateException)
// O que podemos garantir falando sobre threads? O m�todo que est� no run
// ser� executado! Quando? Em que ordem? Ai j� estamos querendo saber muito
// O scheduler gerencia threads, decide quando ela inicia, quanto tempo ficar� ativa e quando
// ela deve sair do estado de runnable
// Quais s�o os estados da thread?
//
// ~~~~~~~~~ Waiting/Blocking ~~~~~~~~
// New -> [Runnable <-> Running] -> Dead -> em alguns livros, os estados runnable e running
// ~~~~~~~~~~~~ [Execut�vel] ~~~~~~~~~~~~~~~~ S�o um s�, chamado executavel (ou runnable)

// New -> Uma thread nova � uma thread que ainda n�o foi executada, ou foi rec�m instanciada

// Runnable -> Ela se torna Runnable quando � startada, ai sim ela est� viva
// ~~ Aten��o!! n�o � pq usei o m�todo start que ela est� rodando, apenas est� pronta para tal
// ~~~ O schedule que decide se vai ser executada ou n�o

// Running -> Quando o schedule seleciona uma thread e executa o m�todo run, ai sim ta rodado
// ~~ Aten��o!! Uma thread pode interromper sua execu��o e ir para os estados
// ~~~ Waiting ou Blocking ou Sleeping, sendo que isso pode acontecer por vontade do dev
// ~~~~ Ou por programas de terceiros, e uma vez que sai dos estatos wait/blocking/sleep
// ~~~~~ Ela volta para o status Runnable, status anterior
// ~~~~~~ A thread decide por "vontade pr�pria" entrar nos estados de w/b/s, uma thread n�o
// ~~~~~~~ pode decidir isso por outra thread. Lembrando que est�o vivas se tiverem em w/b/s

// Dead -> significa que o m�todo run foi completado, e n�o pode executar essa thread novamente
