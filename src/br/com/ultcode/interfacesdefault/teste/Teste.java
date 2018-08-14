package br.com.ultcode.interfacesdefault.teste;

import br.com.ultcode.interfacesdefault.classes.ClasseImplementadora;
import br.com.ultcode.interfacesdefault.interfaces.Interfaceavel;

public class Teste {

	public static void main(String[] args) {
		ClasseImplementadora ca = new ClasseImplementadora();
		System.out.println(ca.testeImplementacaoNaInterface());
		Interfaceavel.ImprimindoETestando();
	}

}
