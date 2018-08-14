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
		
		//    PORÉM, não podemos passar uma lista de uma classe filha como argumento de
		//        um método que tem como parametro uma lista da classe pai.
		//  EXEMPLO NÃO VALIDO, SÓ PRA MOSTRAR O QUE NÃO PODE
		//			List<Cachorro> listaCachorro = new ArrayList<>();
		//    chamadaDeMetodo(listaCachorro);
		//
		//    public static void chamadaDeMetodo(List<Animal> listaAnimal);
		
		// O exemplo acima da um erro de compilação, devemos passar um lista de animais mesmo
		// nas collections, a jvm não sabe de que é aquela lista em tempo de execução
		//  Isso é impedido em tempo de compilação
		//    Para generics, polimorfismo de classe sucks
		
		
		Cachorro[] arrayCachorro = new Cachorro[] { new Cachorro(), new Cachorro() };
		Gato[] arrayGato = { new Gato(), new Gato() };
		//consultarAnimais(arrayCachorro);
		//consultarAnimais(arrayGato);
		
		// Polimorfismo bolado no array
		//  KOé generico, bora aprender meu kriduh
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
		// Adicionando um gato em uma lista de cachorro no migué maximo
		// Mas se tivesse algum método diferente na classe Gato, eu não poderia usar
		// Só posso usar o que está declarado na classe animal
		Animal gatoAnimal = new Gato();
		teste.add(gatoAnimal);
		consultarCachorroList(teste);
		
	}

	public static void consultarAnimais(Animal[] animais) {
		for (Animal a : animais) {
			a.consulta();
		}
		// A jvm sabe o tipo do array em tempo de execução
		// animais[1] = new Gato();
	}

	// Tem polimorfismo não brother, não da pra passar cachorro
	// Mesmo um cachorro sendo um animal brother
	// Quando o <? extends Classe> é usado, você esta especificando que:
	//    Posso passar um lista da Classe ou qualquer subclasse dela
	//    Falando que não vai alterar a Lista (NÃO ALTERA DISGRAÇA)
	//                                              Se tentar colocar da erro de compilação
	public static void consultarAnimaisList(List<? extends Animal> list) {
		for (Animal animal : list) {
			animal.consulta();
		}
		
	}
	
	// Agora o bagulho ficou loco
	//  Posso alterar(!!!), mas só posso passar lista de Cachorro, ou a super classe dessa
	// Se eu alterar, só posso adicionar a elementos do tipo Cachorro na lista
	// Não posso aniaml
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
	
	// Porra Geraldão, quero usar um generico pra um método, tipo, toda lista que for usar tem que 
	//   implementar a interface Comprable<>, e agora?
	//   PORRA JOVEM, usa um extends ai, pq a disgraça do implements não existe nesse contexto
	//   CARALHO VALEU GERALDÃO!!! :)
		public static void testeDeMetodoImplementandoInterface(List<? extends Comparable> lista) {
			Collections.sort(lista);
		}
		
		
	

}
