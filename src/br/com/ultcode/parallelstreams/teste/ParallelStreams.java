package br.com.ultcode.parallelstreams.teste;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreams {
	public static void main(String[] args) {
		long num = 10_000_000_000L;
		somaFor(num);
		somaStream(num);
		parallelStream(num);
		System.out.println(Runtime.getRuntime().availableProcessors());
	}

	private static void somaFor(Long num) {
		System.out.println("Somando com for");
		long result = 0L;
		long tempoComeco = System.currentTimeMillis();
		for (long i = 1L; i <= num; i++) {
			result += i;
		}
		long tempoFinal = System.currentTimeMillis();
		System.out.println(result + " " + (tempoFinal - tempoComeco) + "ms");
	}

	private static void somaStream(Long num) {
		System.out.println("Somando com for");
		long result = 0L;
		long tempoComeco = System.currentTimeMillis();
		result = Stream.iterate(1L, i -> i + 1).limit(num).reduce(0L, (l,m) -> l+m);
		long tempoFinal = System.currentTimeMillis();
		System.out.println(result + " " + (tempoFinal-tempoComeco) + "ms");
	}
	
	
	private static void parallelStream(Long num) {
		System.out.println("Somando com for");
		long result = 0L;
		long tempoComeco = System.currentTimeMillis();
		result = LongStream.rangeClosed(1, num).reduce(0L,Long::sum);
		long tempoFinal = System.currentTimeMillis();
		System.out.println(result + " " + (tempoFinal-tempoComeco) + "ms");
	}
}
