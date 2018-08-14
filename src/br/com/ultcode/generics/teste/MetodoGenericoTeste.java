package br.com.ultcode.generics.teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.ultcode.generics.classes.Carro;

public class MetodoGenericoTeste {
	public static void main(String[] args) {
		List<Carro> lista = criarArray(new Carro("BMW"));

		pupularLista(lista, 25.0D);

		for (Object object : lista) {
			System.out.println(object);
		}
		
		//Collections.sort();
	}

	// Para criar um m�todo generico, o tipo vem antes do retorno
	// Podemos utilizar o super e o extends aqui para limitar esse metodo
	// nos m�todos, n�o usamos o ? e sim o T
	//  N�o pode usar o wildcard como parametro no m�todo quando estiver com a flag de Generico ali antes do retorno � nooooois!!!!
	public static <T extends Object> List<T> criarArray(T t) {
		List<T> lista = new ArrayList<>();
		lista.add(t);
		for (Object t2 : lista) {
			System.out.println(t2);
		}
		return lista;
		
	}

	
	public static <T> void pupularLista(List lista, T element) {
		lista.add(element);
	}
}
