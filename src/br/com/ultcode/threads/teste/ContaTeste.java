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

	// Sincronismo de c�digo �: s� deixar uma thread acessar alguma coisa por vez, seja m�todo ou outra coisa
	// N�o � garantido que a thread execute algo todo de uma vez, mas � possivel garantir que nenhuma outra
	// Thread acesse aquele recurso enquanto uma j� est� acessando
	// Lembre da palavra atomicidade!
	// Nenhuma outra thread vai poder trabalhar com um objeto enquanto n�o for liberado o lock
	// Como resolver isso ent�o gege?
	// primeiramente, campos que vai ser acessado deve ser privado
	// Depois temos que sincronizar o c�digo que queremos que seja indivisivel, atomico, que pode ser acessado por uma
	// thread apenas
	// Eliminamos a possibilidade de concorrencia quando sincronizamos um bloco de c�digo
	// Como isso funciona? Gra�as ao Lock, todo objeto no java tem um lock, que parece uma chave
	// Quando trabalhamos com m�todos synchronized esse lock � utilizado
	// � como se quando um thread executace um bloco sincronizado, ele pega-se a chave, e fala-se que ngm sem a chave
	// pode executar tal c�digo. Um objeto s� tem um lock. Podemos utilizar esse sincronismo em m�todos ou em blocos
	// N�o pode-se ser usado em classe ou v�riaveis. Uma classe pode ter m�todos sincronizados e n�o-sincronizados
	// em m�todos sincronizados, quem chegar primeiro pega o lock e executa
	// sincronizmo afeta performace.
	// Uma thread pode adquirir mais de um lock, ou seja, pode executar um m�todo sincronizado de um classe e outro m�-
	// todo sincronizado de outra.
	// � possivel sincronizar m�todos estaticos tamb�m, mas cuidado, pq � como se estivesse pegando o lock de toda a
	// classe Ex.:

	public static synchronized void imprime() {
		// synchronized (ContaTeste.class) { ->. Outra forma de dar um sincronizar m�todos estaticos
		// Quando � utilizado esse Classe.class, � uma forma forma de falar pro compilador e JVM olhar pra uma classe
		System.out.println(Thread.currentThread().getName() + " est� imprimindo algo");
		// }
	}
	// devemos ter um cuidado especial com m�todos estaticos e n�o estaticos(?), na verdade, pelo o que eu entendi
	// deve-se ter uma preocupa��o sempre ao mudar um dado, sendo ele de um objeto ou de uma classe, ent�o tente
	// proteger quase sempre!
	// O sincronismo protege por instancia
	public synchronized void acessaAiQueroVer() {
		synchronized (ContaTeste.class) {
			System.out.println(numeroqualquer++);			
		}
	}
	
	
	
	
	// Um exemplo para demonstrar a eficacia do synchronized, O lock � por objeto, n�o por m�todo!!!!
	private void saque(int valor) {
		synchronized (conta) { // posso sincronizar um bloco de c�digo assim, apesar deu n�o ter entendido
								// Quando utilizar dessa forma, fassa a v�riavel ser final, uma pr�tica melhor
			if (valor <= conta.getSaldo()) {
				System.out.println(Thread.currentThread().getName() + " est� indo sacar");
				try {
					Thread.sleep(0); // Mesmo colocando a thread para dormir por um segundo, outra thread n�o acessa
										// esse
										// bloco de c�digo (Esse m�todo). o M�todo sleep n�o solta o lock
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
