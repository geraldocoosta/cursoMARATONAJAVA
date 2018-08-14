package com.ultcode.padroesdeprojetofactory.classes;

import com.ultcode.padroesdeprojetofactory.interfaces.Moeda;

public class MoedaFactory {
	public static Moeda getMoeda(MoedaType moeda) {
		if (moeda.equals(MoedaType.BRASIL)) {
			return new Real();
		}else if(moeda.equals(MoedaType.EUA)) {
			return new Dolar();
		}
		throw new IllegalArgumentException("Não existe o parametro passado");
	}
}


