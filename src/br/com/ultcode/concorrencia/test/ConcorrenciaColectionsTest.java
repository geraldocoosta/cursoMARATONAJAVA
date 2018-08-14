package br.com.ultcode.concorrencia.test;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcorrenciaColectionsTest {
	public static void main(String[] args) {
		// Coleções que não tem o mesmo comportamento das CopyOnWrite

		// -> ConcurrentHashMap
		// -> ConcurrentLinkedDeck
		// -> ConcurrentLinkedQueue
		// -> ConcurrentSkipListMap
		// -> ConcurrentSkipListSet
		// Coleções que são thread safe, estão no pacote concurrent mas não são CopyOnWrite
		// O interator é pouco consistente
		// ou seja, imagina que no meio de um iteração pode ser acrescentado 100 elementos por outra thread
		// ou o método size() pode se inconsistente
		// -> iterator weakly consistent
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
		ConcurrentLinkedDeque<String> s = new ConcurrentLinkedDeque<>();
		map.put("chave", "valor");
		s.add("Argumentos");
		Set<Map.Entry<String,String>> entry = map.entrySet();
		for(Map.Entry<String, String> coisa : entry) {
			System.out.printf("chave: %s valor: %s%n",coisa.getKey(),coisa.getValue());
		}
	}
}
