package br.com.ultcode.generics.teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class Animal {
	public abstract void consulta();
}

class Cachorro extends Animal {

	@Override
	public void consulta() {
		System.out.println("Consultando animal CACHORRO");
	}

}

class Gato extends Animal {
	@Override
	public void consulta() {
		System.out.println("Coonsultando animal GATO");
	}
}

public class WildcardGenerics {
	public static void main(String[] args) {

		
		// Podemos colocar uma classe filha dentro de uma lista da classe pai
		//    ex.: List<Animal> listaAnimal = new ArrayList<>();
		//			listaAnimal.add(new Gato());
		//			listaAnimal.add(new Cachorro());
		
		//    POR�M, n�o podemos passar uma lista de uma classe filha como argumento de
		//        um m�todo que tem como parametro uma lista da classe pai.
		//  EXEMPLO N�O VALIDO, S� PRA MOSTRAR O QUE N�O PODE
		//			List<Cachorro> listaCachorro = new ArrayList<>();
		//    chamadaDeMetodo(listaCachorro);
		//
		//    public static void chamadaDeMetodo(List<Animal> listaAnimal);
		
		// O exemplo acima da um erro de compila��o, devemos passar um lista de animais mesmo
		// nas collections, a jvm n�o sabe de que � aquela lista em tempo de execu��o
		//  Isso � impedido em tempo de compila��o
		//    Para generics, polimorfismo de classe sucks
		
		
		Cachorro[] arrayCachorro = new Cachorro[] { new Cachorro(), new Cachorro() };
		Gato[] arrayGato = { new Gato(), new Gato() };
		//consultarAnimais(arrayCachorro);
		//consultarAnimais(arrayGato);
		
		// Polimorfismo bolado no array
		//  KO� generico, bora aprender meu kriduh
		Animal[] arrayAnimais = new Animal[2];
		arrayAnimais[0] = new Cachorro();
		arrayAnimais[1] = new Gato();
		
		List<Gato> gatoList = new ArrayList<>();
		gatoList.add(new Gato());

		List<Cachorro> cachorroList = new ArrayList<>();
		cachorroList.add(new Cachorro());
		consultarCachorroList(cachorroList);
		
		System.out.println("==================================================================");
		
		List<Animal> teste = new ArrayList<>();
		teste.add(new Cachorro());
		// Adicionando um gato em uma lista de cachorro no migu� maximo
		// Mas se tivesse algum m�todo diferente na classe Gato, eu n�o poderia usar
		// S� posso usar o que est� declarado na classe animal
		Animal gatoAnimal = new Gato();
		teste.add(gatoAnimal);
		consultarCachorroList(teste);
		
	}

	public static void consultarAnimais(Animal[] animais) {
		for (Animal a : animais) {
			a.consulta();
		}
		// A jvm sabe o tipo do array em tempo de execu��o
		// animais[1] = new Gato();
	}

	// Tem polimorfismo n�o brother, n�o da pra passar cachorro
	// Mesmo um cachorro sendo um animal brother
	// Quando o <? extends Classe> � usado, voc� esta especificando que:
	//    Posso passar um lista da Classe ou qualquer subclasse dela
	//    Falando que n�o vai alterar a Lista (N�O ALTERA DISGRA�A)
	//                                              Se tentar colocar da erro de compila��o
	public static void consultarAnimaisList(List<? extends Animal> list) {
		for (Animal animal : list) {
			animal.consulta();
		}
		
	}
	
	// Agora o bagulho ficou loco
	//  Posso alterar(!!!), mas s� posso passar lista de Cachorro, ou a super classe dessa
	// Se eu alterar, s� posso adicionar a elementos do tipo Cachorro na lista
	// N�o posso aniaml
	public static void consultarCachorroList(List<? super Cachorro> list) {
	
		list.add(new Cachorro());
		list.add(new Cachorro());
		for (Object o : list) {
			if (o instanceof Cachorro) {
				((Cachorro) o).consulta();
			}else if (o instanceof Animal) {
				((Animal)o).consulta();
			}else {
				System.out.println(o);
			}
		}
	}
	
	// Porra Gerald�o, quero usar um generico pra um m�todo, tipo, toda lista que for usar tem que 
	//   implementar a interface Comprable<>, e agora?
	//   PORRA JOVEM, usa um extends ai, pq a disgra�a do implements n�o existe nesse contexto
	//   CARALHO VALEU GERALD�O!!! :)
		public static void testeDeMetodoImplementandoInterface(List<? extends Comparable> lista) {
			Collections.sort(lista);
		}
		
		
	

}
