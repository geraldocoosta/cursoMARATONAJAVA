package br.com.ultcode.classesaninhadastest;

public class ClasseInternaTeste {
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public static void main(String[] args) {
		// instanciando uma inner class
		//Primeira forma
		//instancia primeiro a externa e depois a interna
		ClasseInternaTeste cit = new ClasseInternaTeste();
		ClasseInternaTeste.Interna interna = cit.new Interna(0);
		
		//Instanciando ela de uma vez
		ClasseInternaTeste.Interna interna2 = new ClasseInternaTeste().new Interna(0);
		
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	// A classe externa não acessa váriavel privada da classe interna (Pelo menos não vi ainda como)
	
	public void mostrarValor() {
	}
	
	// essa classe interna pode ter varios modificadores de acesso como:
	//     	public
	//		private
	//		static
	//		final
	//		abstract
	//		protected
	//		strictfb
	
	 class Interna{
		// Classe interna acessa váriaveis privadas da classe externa
		// Se a classe interna tiver atributos static, ela deve ser static
		// Atributo pode ser final, mas deve ser inicializada pelo construtor ou bloco de inicialização. 
		final double valor;
		
		public Interna(double valor) {
			this.valor = valor;
		}
		
		public void mostrarAcesso() {
			System.out.println(nome + ": Acessando um atributo da classe externa");
		}
		
		public void acessandoOThis() {
			//acessando o this da classe interna
			System.out.println(this);
			//acessando o this da classe externa na classe interna
			System.out.println(ClasseInternaTeste.this);
		}
		
	}
	
	
	
}
