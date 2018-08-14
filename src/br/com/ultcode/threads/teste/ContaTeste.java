package br.com.ultcode.threads.teste;

import br.com.ultcode.threads.classes.Conta;

public class ContaTeste implements Runnable {
	private Conta conta = new Conta();
	private static int numeroqualquer = 15;

	public static void main(String[] args) {
		ContaTeste ct = new ContaTeste();
		Thread t1 = new Thread(ct, "T1");
		Thread t2 = new Thread(ct, "T2");

		t1.start();
		t2.start();
	}

	// Sincronismo de código é: só deixar uma thread acessar alguma coisa por vez, seja método ou outra coisa
	// Não é garantido que a thread execute algo todo de uma vez, mas é possivel garantir que nenhuma outra
	// Thread acesse aquele recurso enquanto uma já está acessando
	// Lembre da palavra atomicidade!
	// Nenhuma outra thread vai poder trabalhar com um objeto enquanto não for liberado o lock
	// Como resolver isso então gege?
	// primeiramente, campos que vai ser acessado deve ser privado
	// Depois temos que sincronizar o código que queremos que seja indivisivel, atomico, que pode ser acessado por uma
	// thread apenas
	// Eliminamos a possibilidade de concorrencia quando sincronizamos um bloco de código
	// Como isso funciona? Graças ao Lock, todo objeto no java tem um lock, que parece uma chave
	// Quando trabalhamos com métodos synchronized esse lock é utilizado
	// É como se quando um thread executace um bloco sincronizado, ele pega-se a chave, e fala-se que ngm sem a chave
	// pode executar tal código. Um objeto só tem um lock. Podemos utilizar esse sincronismo em métodos ou em blocos
	// Não pode-se ser usado em classe ou váriaveis. Uma classe pode ter métodos sincronizados e não-sincronizados
	// em métodos sincronizados, quem chegar primeiro pega o lock e executa
	// sincronizmo afeta performace.
	// Uma thread pode adquirir mais de um lock, ou seja, pode executar um método sincronizado de um classe e outro mé-
	// todo sincronizado de outra.
	// É possivel sincronizar métodos estaticos também, mas cuidado, pq é como se estivesse pegando o lock de toda a
	// classe Ex.:

	public static synchronized void imprime() {
		// synchronized (ContaTeste.class) { ->. Outra forma de dar um sincronizar métodos estaticos
		// Quando é utilizado esse Classe.class, é uma forma forma de falar pro compilador e JVM olhar pra uma classe
		System.out.println(Thread.currentThread().getName() + " está imprimindo algo");
		// }
	}
	// devemos ter um cuidado especial com métodos estaticos e não estaticos(?), na verdade, pelo o que eu entendi
	// deve-se ter uma preocupação sempre ao mudar um dado, sendo ele de um objeto ou de uma classe, então tente
	// proteger quase sempre!
	// O sincronismo protege por instancia
	public synchronized void acessaAiQueroVer() {
		synchronized (ContaTeste.class) {
			System.out.println(numeroqualquer++);			
		}
	}
	
	
	
	
	// Um exemplo para demonstrar a eficacia do synchronized, O lock é por objeto, não por método!!!!
	private void saque(int valor) {
		synchronized (conta) { // posso sincronizar um bloco de código assim, apesar deu não ter entendido
								// Quando utilizar dessa forma, fassa a váriavel ser final, uma prática melhor
			if (valor <= conta.getSaldo()) {
				System.out.println(Thread.currentThread().getName() + " está indo sacar");
				try {
					Thread.sleep(0); // Mesmo colocando a thread para dormir por um segundo, outra thread não acessa
										// esse
										// bloco de código (Esse método). o Método sleep não solta o lock
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				conta.saque(valor);
				System.out.println(Thread.currentThread().getName() + " completou o saque. Saldo: " + conta.getSaldo());
			} else {
				System.out.println("Sem dinheiro para " + Thread.currentThread().getName() + " efetuar o saque, saldo: "
						+ conta.getSaldo());
			}
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			imprime();
		}
		for (int i = 0; i < 15; i++) {
			saque(50);
			// Thread.yield();
			if (conta.getSaldo() < 0) {
				System.out.println("EITA!");
			}
		}
	}
}
