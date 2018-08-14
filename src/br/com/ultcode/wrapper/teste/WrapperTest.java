/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.wrapper.teste;

/**
 *
 * @author Geraldo
 */
public class WrapperTest {
    public static void main(String[] args) {
        byte variavelByta = 1;
        short variavelShort = 1;
        int varivelInt = 1;
        long variavelLong = 10L;
        float variavelFloat = 10.2F;
        double variavelDouble = 10.2;
        char variavelChar = 'A';
        boolean variavelBoolean = true;
        
        Byte byteWrapper = 1;
        Short shortWrapper = null;
        Integer intWrapper = null;
        Long longWrapper;
        Float floatWrapper = 22.2F;
        Double doubleWrapper = 10D;
        Character charWrapper = 'B';
        Boolean booleanWrapper = true;
        
        String numeroString = "10";
        variavelLong = Long.parseLong(numeroString);
        System.out.println("Passei um valor numerico em forma de string"
                + "\npara o tipo primitivo long por Long.parseLong:"
                + "\n" + variavelLong);
        
        
        Integer integer = Integer.valueOf(numeroString);
        System.out.println("\nMetodo estatico que é usado para converter tipos primitivos e string"
                + "\nem objeto, (valueOf) ex:"
                + "\nInteger.valueOf(\"10\")" + integer);
        
        //intValue, doubleValue, etc. retorna o valor primitivo dentro de um objeto
        //método de um objeto wrapper de tipo primitivo
        
        
        
        /*   MÉTODOS COM CHARACTER INTERESSANTES
        isDigit - é numero?
        isLetter - é letra
        isDigitOrLetter - letra ou numero
        isUpperCase
        isLowerCase
        toUpperCase = deixa minuscula em maiuscula
        */
    }
}
