package br.com.ultcode.padroesdeprojetostrategy.teste;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import br.com.ultcode.padroesdeprojetostrategy.classes.Carro;

public class Teste {
	public static void main(String[] args) {
		List<Carro> carros = asList(new Carro("gol","verde",2001),new Carro("gol","azul",1999),new Carro("corsa","preto",2015));
	
		List<Carro> carrosFiltrados = filtrarCarro(carros, new Predicate<Carro>() {

			@Override
			public boolean test(Carro c) {
				return c.getCor().equals("verde");
			}
		});
		
		for (Carro carro : carrosFiltrados) {
			System.out.println(carro);
		}
	}
	
	public static <T> List<T> filtrarCarro(List<T> lista, Predicate<T> predicate) {
		List<T> list = new ArrayList<>();
		for(T t:lista) {
			if(predicate.test(t)) {
				list.add(t);
			}
		}
		return list;
	}
}
