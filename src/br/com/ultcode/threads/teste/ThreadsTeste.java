package br.com.ultcode.threads.teste;

// Threads = linhas de comando
// elas possibilitam a execução de multiplas tarefas ao mesmo tempo
// no gerenciador de tarefas do windows, mostra quantas threads estão
// sendo utilizadas no momento
// A JVM que decide a prioridades da threads, decidindo qual começa ou 
// qual termina
// Temos 2 formas de criar threads, e também temos 2 tipos de threads
// Daemon -> Se tiver um thread Daemon rodando, a JVM pode ignorar e finalizar
//  sua execução igual, sem peso na conciencia 
// User   -> A JVM só finaliza sua execução quando todas as threads User
//  são finalizadas
// E para criar as threads gege?
// Ou extendemos da classe java.lang.Thread ou implementamos a interface 
//  Runnable

public class ThreadsTeste {
	// Todas as vezes que executamos o método main, nós temos uma thread
	// qual o nome da thread? (toda thread tem um nome, você nomeando ou não)
	public static void main(String[] args) {
		// Thread.currentThread().getName() -> descobre o nome da thread
		System.out.println("thread sendo executada: " + Thread.currentThread().getName());
		// ThreadExemplo t1 = new ThreadExemplo('a');
		// ThreadExemplo t2 = new ThreadExemplo('b');
		// ThreadExemplo t3 = new ThreadExemplo('c');
		// ThreadExemplo t4 = new ThreadExemplo('d');
		// Todos estão sendo executados na mesma thread, pois estamos chamando
		// explicitamente o método run
		// para iniciar uma thread (ai sim vão executar em paralelo) chama-se
		// o método .start();

		// t1.run();
		// t2.run();
		// t3.run();
		// t4.run();

		// Perceba que assim não dá pra prever qual a ordem de execução!!!
		// uma vez dado o start, é responsabilidade da JVM verificar qual das
		// threads vai ser executada e por quanto tempo.
		// schedule = cronograma, não temos noção do schedule que a jvm faz
		// para a execução das threads
		// Uma thread pode afetar a execução da outra

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

// outra forma de implementar uma thread é implementando a interface runnable
// que é por padrão uma boa prática de OO
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
// MÁ PRATICA EM RELAÇÃO A OO
class ThreadExemplo extends Thread {
	private char c;

	public ThreadExemplo(char c) {
		this.c = c;
	}

	@Override
	public void run() {
		// A mágica toda acontece aqui
		// se você quiser que um código seja executado em paralelo
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

// A thread, dps de executada, ela morre, e você não pode ressuscitar!!
// Depois de startarmos uma thread, ela não pode ser startada novamente (gera uma exception)
// --------------------------------------------------------------- (IllegalThreadStateException)
// O que podemos garantir falando sobre threads? O método que está no run
// será executado! Quando? Em que ordem? Ai já estamos querendo saber muito
// O scheduler gerencia threads, decide quando ela inicia, quanto tempo ficará ativa e quando
// ela deve sair do estado de runnable
// Quais são os estados da thread?
//
// ~~~~~~~~~ Waiting/Blocking ~~~~~~~~
// New -> [Runnable <-> Running] -> Dead -> em alguns livros, os estados runnable e running
// ~~~~~~~~~~~~ [Executável] ~~~~~~~~~~~~~~~~ São um só, chamado executavel (ou runnable)

// New -> Uma thread nova é uma thread que ainda não foi executada, ou foi recém instanciada

// Runnable -> Ela se torna Runnable quando é startada, ai sim ela está viva
// ~~ Atenção!! não é pq usei o método start que ela está rodando, apenas está pronta para tal
// ~~~ O schedule que decide se vai ser executada ou não

// Running -> Quando o schedule seleciona uma thread e executa o método run, ai sim ta rodado
// ~~ Atenção!! Uma thread pode interromper sua execução e ir para os estados
// ~~~ Waiting ou Blocking ou Sleeping, sendo que isso pode acontecer por vontade do dev
// ~~~~ Ou por programas de terceiros, e uma vez que sai dos estatos wait/blocking/sleep
// ~~~~~ Ela volta para o status Runnable, status anterior
// ~~~~~~ A thread decide por "vontade própria" entrar nos estados de w/b/s, uma thread não
// ~~~~~~~ pode decidir isso por outra thread. Lembrando que estão vivas se tiverem em w/b/s

// Dead -> significa que o método run foi completado, e não pode executar essa thread novamente
