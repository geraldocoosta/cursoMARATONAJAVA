/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.io.teste;

import java.io.Console;

public class Teste {

    public static void main(String[] args) {
        Console c = System.console();
        char[] pw = c.readPassword("%s", "pw: ");
        for (char caractere : pw) {
            System.out.print(caractere);
        }
        c.format("\n");

        String texto;

        while (true) {
            texto = c.readLine("%s", "\nDigite: ");
            c.format("Esse texto %s foi digitado", texto);

        }

    }

    
}
