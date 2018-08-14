package com.ultcode.padroesdeprojetofactory.teste;

import com.ultcode.padroesdeprojetofactory.classes.MoedaFactory;
import com.ultcode.padroesdeprojetofactory.classes.MoedaType;
import com.ultcode.padroesdeprojetofactory.interfaces.Moeda;

public class TestePadraoFactory {
	public static void main(String[] args) {
		Moeda moeda = MoedaFactory.getMoeda(MoedaType.BRASIL);
		System.out.println(moeda.getSimbolo());
		moeda = MoedaFactory.getMoeda(MoedaType.EUA);
		System.out.println(moeda.getSimbolo());
	}
}
