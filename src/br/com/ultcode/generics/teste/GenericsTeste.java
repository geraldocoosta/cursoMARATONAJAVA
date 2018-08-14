package br.com.ultcode.generics.teste;

import java.util.ArrayList;
import java.util.List;

public class GenericsTeste {
	public static void main(String[] args) {
		// type erasure
		// Em tempo de execução, o java não sabe que essa lista é de String
		// Em tempo de compilação ele save
		List<String> lista = new ArrayList<String>();
		lista.add("Qualquer coisa");
		add(lista, 1L);

	}
	
	// Com esse método, estou burlanfo o bagulho brother
	//   Extremamente não recomendado
	public static void add(List lista, long l) {
		lista.add(l);
	}
}
