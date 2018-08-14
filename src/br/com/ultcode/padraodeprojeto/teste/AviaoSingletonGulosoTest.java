package br.com.ultcode.padraodeprojeto.teste;

import br.com.ultcode.padraodeprojeto.classes.AviaoSingletonGuloso;

public class AviaoSingletonGulosoTest {

	public static void main(String[] args) {
		AviaoSingletonGuloso aviao = AviaoSingletonGuloso.getInstance();
		AviaoSingletonGuloso aviao2 = AviaoSingletonGuloso.getInstance();
		System.out.println(aviao.pegarAssento("A1"));
		System.out.println(aviao.pegarAssento("A1"));
		System.out.println(aviao);
		System.out.println(aviao2);
		
	}
}

