package br.com.ultcode.concorrencia.test;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcorrenciaColectionsTest {
	public static void main(String[] args) {
		// Cole��es que n�o tem o mesmo comportamento das CopyOnWrite

		// -> ConcurrentHashMap
		// -> ConcurrentLinkedDeck
		// -> ConcurrentLinkedQueue
		// -> ConcurrentSkipListMap
		// -> ConcurrentSkipListSet
		// Cole��es que s�o thread safe, est�o no pacote concurrent mas n�o s�o CopyOnWrite
		// O interator � pouco consistente
		// ou seja, imagina que no meio de um itera��o pode ser acrescentado 100 elementos por outra thread
		// ou o m�todo size() pode se inconsistente
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
