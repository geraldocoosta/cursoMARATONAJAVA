package br.com.ultcode.threads.teste;

public class SeguindoApostila implements Runnable
{
	private String acao;
	
	SeguindoApostila(String c){
		acao = c;
	}
	
	SeguindoApostila(String c, int prioridade){
		acao = c;
	}
	
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		Thread t1 = new Thread(new SeguindoApostila("Alta"),"Thread1");
		t1.setPriority(7);
		Thread t2 = new Thread(new SeguindoApostila("baixa"),"Thread2");
		t2.setPriority(2);
		Thread t3 = new Thread(new SeguindoApostila("default1"),"Thread3");
		Thread t4 = new Thread(new SeguindoApostila("default2"),"Thread4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

	@Override
	public void run() {
		//System.out.println(Thread.currentThread().getName());
		for (int i = 0; i < 4; i++) {
			System.out.println(acao + " " + (i+1));	
		//	Thread.yield();
	
		}
		
		
	}
}
