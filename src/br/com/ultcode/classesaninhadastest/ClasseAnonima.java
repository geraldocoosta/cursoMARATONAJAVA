package br.com.ultcode.classesaninhadastest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

import br.com.ultcode.generics.classes.Carro;

class Animal {
	public void andar() {
		System.out.println("Animal Andando");
	}
}



public class ClasseAnonima {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// para explicar as classes anonimas, primeiro uma historia
		// Imagina que devemos sobrescrever um método, mas sem criar uma classe
		// Então, para fazer isso, se acrescenta o {} depois da instanciação de uma
		// classe
		// Segue o jogo agora meu bro!!
		Animal animal = new Animal() {
			public void andar() {
				System.out.println("Andando anonimamente bem rapidin");
			}
		};
		
		animal.andar();
		System.out.println(animal);
		
		
		// Classes anonimas também podem ser usadas com interfaces
		//  Se liga menor bolado
		List<Carro> listaCarros = new ArrayList<>();
		listaCarros.add(new Carro("Fusca"));
		listaCarros.add(new Carro("Golf"));
		listaCarros.add(new Carro("Polo"));
		//Collections.sort(listaCarros, new ComparadorDeCarro());
		// A maneira que aprendi a fazer foi assim (com uma classe aux), mas da pra fazer com classes anonimas
		// Se liga na maldade, sobrescreve direto da interface maluco, DOIDERA MAXIMA
		// Com isso, a classe ali em baixo se torna inutil, AEHO!!
		Collections.sort(listaCarros, new Comparator<Carro>(){
			public int compare(Carro o1, Carro o2) {
				return o1.getNome().compareTo(o2.getNome());
			}
		});
		
		for (Carro car : listaCarros) {
			System.out.println(car.getNome());
		}
		
	}

}

/*class ComparadorDeCarro implements Comparator<Carro>{

	@Override
	public int compare(Carro o1, Carro o2) {
		return o1.getNome().compareTo(o2.getNome());
	}
	
}*/
