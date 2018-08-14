package br.com.ultcode.padraodeprojeto.classes;

import java.util.HashSet;
import java.util.Set;

public enum AviaoSingletonEnum {
	INSTANCIA;
	private Set<String> assentos;
	
	AviaoSingletonEnum() {
		this.assentos = new HashSet<>();
		assentos.add("A1");
		assentos.add("A2");
	}
	
	public boolean pegarAssento(String s) {
		return assentos.remove(s);
	}
	
	
}
