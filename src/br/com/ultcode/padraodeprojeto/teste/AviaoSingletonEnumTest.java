package br.com.ultcode.padraodeprojeto.teste;

import br.com.ultcode.padraodeprojeto.classes.AviaoSingletonEnum;

public class AviaoSingletonEnumTest {
	public static void main(String[] args) {
		AviaoSingletonEnum a = AviaoSingletonEnum.INSTANCIA;
		AviaoSingletonEnum b = AviaoSingletonEnum.INSTANCIA;
		System.out.println(a.pegarAssento("A1"));
		System.out.println(b.pegarAssento("A1"));
		System.out.println(a == b);
		
	}
}
