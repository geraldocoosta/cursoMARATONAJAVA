package br.com.ultcode.classesaninhadastest;

public class ClassesLocaisTeste {
	private String nome = "OMEGALUL";
	
	public void fazAlgo(String finais) {
		// classes locais s�o classes dentro de um m�todo
		// A classe local ainda tem acesso as v�riaveis da classe externa
		String local = "";
		
		//Classes dentro de m�todos s� podem usar os modificadores final e abstract
		class InternaLocal{
			public void fazAlgoInterna() {
				// Se a classe for statica, sei l� mano, n�o da pra acessar as paradas n�o  (A classe n�o pode ser statica dentro de m�todos)
				// No java 7 uma classe interna n�o podia utilizar atributos locais (variaveis do m�todo)
				//  que n�o fossem finais
				// Hoje em dia pode se n�o modificar, pois elas se tornam efetivamente finais
			
				System.out.println("OI, EU SOU UMA DESGRA�AAAA!!!");
				System.out.println(nome);
				System.out.println(local); // isso n�o � possible no java 7
				System.out.println(finais); // isso tbm n�o era permitido, o atributo deveria ser final
				// Os atributos para serem usados devem ser efetivamentes finais, ou seja,
				//    N�o podem ser modificados
				
			}
			//classes locais s� podem ser instanciadas dentro do m�todo em que elas s�o declaradas
			// s�rio, mas que porra � essa?
		}
		
		InternaLocal il = new InternaLocal();
		il.fazAlgoInterna();
		
	}
	
	
	
	public static void main(String[] args) {

		ClassesLocaisTeste teste = new ClassesLocaisTeste();
		teste.fazAlgo("Opa meu compadre");
	}
}
