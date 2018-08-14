package br.com.ultcode.classesaninhadastest;

class Externa{
	private static double valor;
	
	// Uma classe estatica só tem acesso a atributos estaticos da classe exterior
	// Mesma coisa para métodos da classe externa
	// Classes estaticas são como se fossem membros estaticos
	// apesar de usar o nome classes, não são classes
	 static class Interna{
		public void Imprime() {
			System.out.println("Imprime " + valor);
		}
	 }
}


public class ClassesEstaticasTest {
	public static void main(String[] args) {
		// Para instanciar uma classe statica interna de uma outra classe:
		Externa.Interna interna = new Externa.Interna();
		interna.Imprime();
		
		
		//Instanciando uma classe statica interna da que estamos
		Interna2 interna2 = new Interna2();
		interna2.Imprime();
		
		//verificando se pode do jeito padrão
		//ClassesEstaticasTest.Interna2 interna3 = new ClassesEstaticasTest().new Interna2();
		// Da erra de compilação!!
	}
	
	static class Interna2{
		public void Imprime() {
			System.out.println("Dentro do interna 2 ");
		}
	}
}
