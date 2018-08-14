package com.ultcode.padroesdeprojetofactory.classes;

import com.ultcode.padroesdeprojetofactory.interfaces.Moeda;

public class Real implements Moeda{

	@Override
	public String getSimbolo() {
		return "R$";
	}

}
