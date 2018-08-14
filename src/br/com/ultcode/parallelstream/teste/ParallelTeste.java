package br.com.ultcode.parallelstream.teste;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelTeste {
	public static void main(String[] args) {
		long num = 10_000_000_00L;
		testeFor(num);
		//testeStream(num);
		//testeStreamParallel(num);
		testeLongStream(num);
		testeLongStreamParallel(num);
	}
	
	public static void testeFor(long num) {
		System.out.println("Dentro do teste For");
		long result = 0L;
		long timeInicio = System.currentTimeMillis();
		for (long i = 1l; i <= num; i++) {
			result += i;
		}
		long timeFinal = System.currentTimeMillis();
		System.out.println(result +" "+ (timeFinal-timeInicio) + " ms");
	}
	
	public static void testeStream(long num) {
		System.out.println("Dentro do teste Stream");
		long result = 0L;
		long timeInicio = System.currentTimeMillis();
		result = Stream.iterate(1L, i -> i + 1).limit(num).reduce(0L,Long::sum);
		long timeFinal = System.currentTimeMillis();
		System.out.println(result +" "+ (timeFinal-timeInicio) + " ms");
	}
	
	public static void testeStreamParallel(long num) {
		System.out.println("Dentro do teste Stream Parallel");
		long result = 0L;
		long timeInicio = System.currentTimeMillis();
		result = Stream.iterate(1L, i -> i + 1).parallel().limit(num).reduce(0L,Long::sum);
		long timeFinal = System.currentTimeMillis();
		System.out.println(result +" "+ (timeFinal-timeInicio) + " ms");
	}

	public static void testeLongStream(long num) {
		System.out.println("Dentro do teste Stream de long");
		long result = 0L;
		long timeInicio = System.currentTimeMillis();
		result = LongStream.rangeClosed(1, num).reduce(0L, Long::sum);
		long timeFinal = System.currentTimeMillis();
		System.out.println(result +" "+ (timeFinal-timeInicio) + " ms");
	}
	
	public static void testeLongStreamParallel(long num) {
		System.out.println("Dentro do teste Stream de long paralelo");
		long result = 0L;
		long timeInicio = System.currentTimeMillis();
		result = LongStream.rangeClosed(1, num).parallel().reduce(0L, Long::sum);
		long timeFinal = System.currentTimeMillis();
		System.out.println(result +" "+ (timeFinal-timeInicio) + " ms");
	}
}
