package br.com.ultcode.threads.teste;

public class DeadlockTeste {
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();
	
	private static class ThreadExemplo1 extends Thread{
		public void run() {
			synchronized(lock1) {
				System.out.println(currentThread().getName() + " pegou o lock1");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(currentThread().getName() + " esperando o lock2");
				synchronized(lock2) {
					System.out.println(currentThread().getName() + " pegou o lock 1 e 2");
				}
			}
		}
	}
	
	private static class ThreadExemplo2 extends Thread{
		public void run() {
			synchronized(lock2) {
				System.out.println(currentThread().getName() + " pegou o lock2");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(currentThread().getName() + " esperando o lock1");
				synchronized(lock1) {
					System.out.println(currentThread().getName() + " pegou o lock 2 e 1");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new ThreadExemplo1().start();
		new ThreadExemplo2().start();
	}
}
