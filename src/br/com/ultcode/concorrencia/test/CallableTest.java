package br.com.ultcode.concorrencia.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class CallableTest {
	
	public static void main(String[] args) throws Exception {
		
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		Callable<String> callable = new Teste();
		Future<String> submit = singleThreadExecutor.submit(callable);
		String s = submit.get();
		System.out.println(s);
	}

	static class Teste implements Callable<String>{

		 
		@Override
		public String call() throws Exception {
			int i = ThreadLocalRandom.current().nextInt(1, 11);
			for (int j = 0; j < i; j++) {
				System.out.println("Thread trabalhando...");
			}
			return "O numero escolhido foi o " +i;
		}
		
	}

}




