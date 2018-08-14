package br.com.ultcode.exercicioPP;

public class Exercicio {
	public static void main(String[] args) {
		String s = "Bom dia! Boa tarde, Boa Noite-";
		String[] split = s.split("[!,-.]");
		String nonCaracteres = s.replaceAll("[\\w\\s]", "");
		char[] charArray = nonCaracteres.toCharArray();

		for (int j = 0; j < split.length; j++) {
			split[j] = split[j].trim();
			String[] temp = split[j].split(" ");
			for (int i = temp.length - 1; i >= 0; i--) {
				
				System.out.print(" "+temp[i].trim());

			}
			System.out.print(charArray[j]);
		}
	}
}
