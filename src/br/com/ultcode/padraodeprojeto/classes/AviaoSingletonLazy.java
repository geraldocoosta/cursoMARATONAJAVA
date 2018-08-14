package br.com.ultcode.padraodeprojeto.classes;

import java.util.HashSet;
import java.util.Set;

public class AviaoSingletonLazy {
	private static AviaoSingletonLazy instancia;
	Set<String> assentos;
	
	private AviaoSingletonLazy() {
		assentos = new HashSet<>();
		assentos.add("A1");
		assentos.add("A2");
	}
	
	public static AviaoSingletonLazy getInstancia() {
		if (instancia == null) {
			synchronized (AviaoSingletonLazy.class) {
				if (instancia == null) {
					instancia = new AviaoSingletonLazy();
				}
			}
		}
		return instancia;
	}
	
	public boolean pegarAssento(String assento) {
		return assentos.remove(assento);
	}
	
}
