package com.ultcode.padroesdeprojetofactory.classes;

import com.ultcode.padroesdeprojetofactory.interfaces.Moeda;

public class Dolar implements Moeda {

	@Override
	public String getSimbolo() {
		return "USD";
	}

}
