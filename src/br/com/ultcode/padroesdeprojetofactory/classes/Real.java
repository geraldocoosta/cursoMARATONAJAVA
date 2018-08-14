package br.com.ultcode.padroesdeprojetofactory.classes;

import br.com.ultcode.padroesdeprojetofactory.interfaces.Moeda;

public class Real implements Moeda{

	@Override
	public String getSimbolo() {
		return "R$";
	}

}
