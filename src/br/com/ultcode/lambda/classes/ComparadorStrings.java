package com.ultcode.lambda.classes;

public class ComparadorStrings {

	public static int comparandoString(String s1, String s2) {
		return s1.compareTo(s2);
	}
	
	public int comparandoStringIgnorandoCase(String s1, String s2) {
		return s1.compareToIgnoreCase(s2);
	}

}
