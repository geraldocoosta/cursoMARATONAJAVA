package br.com.ultcode.classesaninhadastest;

class Externa{
	private static double valor;
	
	// Uma classe estatica s� tem acesso a atributos estaticos da classe exterior
	// Mesma coisa para m�todos da classe externa
	// Classes estaticas s�o como se fossem membros estaticos
	// apesar de usar o nome classes, n�o s�o classes
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
		
		//verificando se pode do jeito padr�o
		//ClassesEstaticasTest.Interna2 interna3 = new ClassesEstaticasTest().new Interna2();
		// Da erra de compila��o!!
	}
	
	static class Interna2{
		public void Imprime() {
			System.out.println("Dentro do interna 2 ");
		}
	}
}
