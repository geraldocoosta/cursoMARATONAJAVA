package com.ultcode.interfacesdefault.interfaces;

public interface InterfaceavelSuper {
	int number = 2;
	
	Double coisa();
	
	default double testeImplementacaoNaInterface() {
		return 25;
	}
}
