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
public class StringPerformance {

    public static void main(String[] args) {
//        long inicio = System.currentTimeMillis();
//        concatString(20000);
//        long fim = System.currentTimeMillis();
//        System.out.println("tempo gasto: " + (fim - inicio) + "ms");

        long inicio2;
        long fim2;

        inicio2 = System.currentTimeMillis();
        concatStringBuilder(10000000);
        fim2 = System.currentTimeMillis();
        System.out.println("tempo gasto: " + (fim2 - inicio2) + "ms");
        System.out.println("========================");
        
        inicio2 = System.currentTimeMillis();
        concatStringBuffer(10000000);
        fim2 = System.currentTimeMillis();
        System.out.println("tempo gasto: " + (fim2 - inicio2) + "ms");
    }

    private static void concatString(int tam) {
        String s = "";
        for (int i = 0; i < tam; i++) {
            s += i;
        }
    }

    //Utilizado em ambiente normal
    private static void concatStringBuilder(int tam) {
        StringBuilder s = new StringBuilder(tam);
        for (int i = 0; i < tam; i++) {
            s.append(i);
        }
        
    }

    //Sincronizada, thread Safe
    private static void concatStringBuffer(int tam) {
        StringBuffer s = new StringBuffer(tam);
        for (int i = 0; i < tam; i++) {
            s.append(i);
        }
        
    }
}
