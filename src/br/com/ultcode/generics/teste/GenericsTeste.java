package br.com.ultcode.generics.teste;

import java.util.ArrayList;
import java.util.List;

public class GenericsTeste {
	public static void main(String[] args) {
		// type erasure
		// Em tempo de execu��o, o java n�o sabe que essa lista � de String
		// Em tempo de compila��o ele save
		List<String> lista = new ArrayList<String>();
		lista.add("Qualquer coisa");
		add(lista, 1L);

	}
	
	// Com esse m�todo, estou burlanfo o bagulho brother
	//   Extremamente n�o recomendado
	public static void add(List lista, long l) {
		lista.add(l);
	}
}
