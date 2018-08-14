package br.com.ultcode.padraodeprojeto.teste;

import br.com.ultcode.padraodeprojeto.classes.AviaoSingletonLazy;

public class AviaoSingletonLazyTest {
	public static void main(String[] args) {
		AviaoSingletonLazy aviao = AviaoSingletonLazy.getInstancia();
		AviaoSingletonLazy aviao2 = AviaoSingletonLazy.getInstancia();
		System.out.println(aviao.pegarAssento("A1"));
		System.out.println(aviao.pegarAssento("A1"));
		System.out.println(aviao);
		System.out.println(aviao2);
	}
}
