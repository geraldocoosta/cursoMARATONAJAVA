package br.com.ultcode.classesaninhadastest;

public class ClassesLocaisTeste {
	private String nome = "OMEGALUL";
	
	public void fazAlgo(String finais) {
		// classes locais são classes dentro de um método
		// A classe local ainda tem acesso as váriaveis da classe externa
		String local = "";
		
		//Classes dentro de métodos só podem usar os modificadores final e abstract
		class InternaLocal{
			public void fazAlgoInterna() {
				// Se a classe for statica, sei lá mano, não da pra acessar as paradas não  (A classe não pode ser statica dentro de métodos)
				// No java 7 uma classe interna não podia utilizar atributos locais (variaveis do método)
				//  que não fossem finais
				// Hoje em dia pode se não modificar, pois elas se tornam efetivamente finais
			
				System.out.println("OI, EU SOU UMA DESGRAÇAAAA!!!");
				System.out.println(nome);
				System.out.println(local); // isso não é possible no java 7
				System.out.println(finais); // isso tbm não era permitido, o atributo deveria ser final
				// Os atributos para serem usados devem ser efetivamentes finais, ou seja,
				//    Não podem ser modificados
				
			}
			//classes locais só podem ser instanciadas dentro do método em que elas são declaradas
			// sério, mas que porra é essa?
		}
		
		InternaLocal il = new InternaLocal();
		il.fazAlgoInterna();
		
	}
	
	
	
	public static void main(String[] args) {

		ClassesLocaisTeste teste = new ClassesLocaisTeste();
		teste.fazAlgo("Opa meu compadre");
	}
}
