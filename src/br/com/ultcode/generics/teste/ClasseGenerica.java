package br.com.ultcode.generics.teste;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.ultcode.generics.classes.Carro;
import br.com.ultcode.generics.classes.Roupa;

public class ClasseGenerica {

	public static void main(String[] args) {
		List<Carro> carrosAlugaveis = new ArrayList<>();
		carrosAlugaveis.add(new Carro("Porsche"));
		carrosAlugaveis.add(new Carro("Gol"));
		carrosAlugaveis.add(new Carro("Mercedes"));
		AlugaObjeto<Carro> aluguelDeCarros = new AlugaObjeto<>(carrosAlugaveis);
		aluguelDeCarros.mostrarObjetos();
		Carro carroAlugado = aluguelDeCarros.alugarObjeto();
		System.out.printf("Dirigindo o carro %s%n", carroAlugado);
		aluguelDeCarros.devolverObjeto(carroAlugado);

		System.out.println("===================================================");

		List<Roupa> roupasAlugaveis = new LinkedList<>();
		roupasAlugaveis.add(new Roupa("Jordan shirts", "Supreme", "Blusa"));
		roupasAlugaveis.add(new Roupa("Balenciaga new fit", "Balenciaga", "Tenis"));
		roupasAlugaveis.add(new Roupa("Cnto", "Off white", "Cinto"));
		AlugaObjeto<Roupa> aluguelDeRoupas = new AlugaObjeto<>(roupasAlugaveis);
		Roupa r = aluguelDeRoupas.alugarObjeto();
		System.out.printf("Usando %s%n", r.getNome());
		aluguelDeRoupas.devolverObjeto(new Roupa("Galacta", "HOcks", "tenis"));
		aluguelDeRoupas.mostrarObjetos();
	}
}

//Classe Generica, se usa esse T ai na declaração da classe
//  Podemos usar como variavel, retorno de método, argumento, é isto!!
class AlugaObjeto<T> {
	private List<T> objetosDisponiveis;

	public AlugaObjeto(List<T> objetosDisponiveis) {
		this.objetosDisponiveis = objetosDisponiveis;
	}

	public T alugarObjeto() {
		System.out.println("Removendo objeto");
		return objetosDisponiveis.remove(0);
	}

	public void devolverObjeto(T t) {
		System.out.println("Devolvendo Objeto");
		objetosDisponiveis.add(t);
	}

	public void mostrarObjetos() {
		System.out.println("Objetos disponiveis: ");
		for (T t : objetosDisponiveis) {
			System.out.println("\t" + t);
		}
	}

}
