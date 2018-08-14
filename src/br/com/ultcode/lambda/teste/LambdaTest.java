package br.com.ultcode.lambda.teste;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import br.com.ultcode.lambda.classes.TestePredicate;

public class LambdaTest {
	public static void main(String[] args) {
		TestePredicate predicate = new TestePredicate() {
			@Override
			public boolean test(String s) {
				return s.equals("Teste");
			}
		};
		System.out.println(predicate.test("Teste"));

		// agora com lambda
		// lembrando que -> tem que coincidir com a interface
		// ou seja, tem um parametro e um retorno boolean
		// por algum motivo, não precisa do retutn, mas dá, porém não precisa!!!
		// deixando só pra entender direitin
		TestePredicate predicate1 = (String s) -> {
			return s.equals("Teste");
		};
		System.out.println(predicate1.test("Teste"));

		Callable<String> callable = () -> {
			int i = 5, b = 6;
			int j = i + b;
			return String.valueOf(j);
		};
		// Também posso adicionar umas chaves mesmo sem return
//		Runnable r = () -> {
//			System.out.println("Demonstrando um uso topper");
//			System.out.println("Duas");
//		};
		ExecutorService service = Executors.newCachedThreadPool();
//		service.execute(r);
		Future<String> result = service.submit(callable);
		try {
			while(!result.isDone()) {
				System.out.println("Tarefa não processou cara!");
				TimeUnit.SECONDS.sleep(1);
			}
			String s = result.get();
			System.out.println(s);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.shutdown();
	}
}
