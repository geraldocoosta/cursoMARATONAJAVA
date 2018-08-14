/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.strings.teste;

/**
 *
 * @author Geraldo
 */
public class Teste {

    public static void main(String[] args) {
        char[] a = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'k', 'l'};

        String teste = new String(a);

        // Substring é peculiar
        // primeiro parametro ele considera do que a string é um array começo com indice 0
        // segundo parametro ele considera que a string é um array que começa com indice 1
        System.out.println(teste.substring(0, 2));
        
        String s = "Gege";
        s += " costa";

    }

}
