package br.com.ultcode.lambda.classes;

public class ComparaCarro {
	
	public static int compararCarro(Carro s1, Carro s2) {
		return s1.getCor().compareToIgnoreCase(s2.getCor());
	}
	
	public int compararCarroPorAno(Carro s1, Carro s2) {
		return ((Integer)s1.getAno()).compareTo(s2.getAno());
	}

	@Override
	public String toString() {
		return String.format("ComparaCarro [TOSTRING]");
	}
	
	
}
