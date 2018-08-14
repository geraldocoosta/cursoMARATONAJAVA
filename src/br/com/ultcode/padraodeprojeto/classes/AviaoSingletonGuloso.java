package br.com.ultcode.padraodeprojeto.classes;

import java.util.HashSet;
import java.util.Set;

public class AviaoSingletonGuloso {
	private static final AviaoSingletonGuloso INSTANCE = new AviaoSingletonGuloso(); 
	private Set<String> assentos;
	
	//EAGER SINGLETON
	private AviaoSingletonGuloso() {
		assentos = new HashSet<>();
		assentos.add("A1");
		assentos.add("A2");
	}
	
	public static AviaoSingletonGuloso getInstance() {
		return INSTANCE;
	}
	
	public boolean pegarAssento(String assento) {
		return assentos.remove(assento);
	}
}
