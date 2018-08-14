/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.regex.teste;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Geraldo
 */
public class ScannerTeste {

    public static void main(String[] args) {
        Scanner s = new Scanner(" 1 true 100 oi ");
        // para trocar o separador na classe scanner, devemos usar o metodo
        // useDelimiter, que recebe uma String com um regex ou um objeto pattern
//        Pattern p = Pattern.compile(" ");
//        
//        s.useDelimiter(p);

        while (s.hasNext()) {
            System.out.print(s.next() + "  ");
        }
        System.out.println("\n=========================================");

        //Pegando os valores e convertendo para os tipos primitivos
        Locale loc = new Locale("en", "US");
        Pattern p = Pattern.compile(",");
        Scanner s2 = new Scanner("1,true,100.0,oi,koé,vamonessa,macaco da bola azul");
        //setando um local em um objeto scanner
        s2.useLocale(loc);
        //Setando um delimitador (regex) na classe scanner
        s2.useDelimiter(p);
        String[] recebeTudo = new String[3];
        int i = 0;
        while (s2.hasNext()) {
            
            if (i == recebeTudo.length-1) {
                recebeTudo = aumentandoArray(recebeTudo);
            }
            recebeTudo[i] = s2.next();
            i++;
//                if (s2.hasNextInt()) {
//                int i = s2.nextInt();
//                System.out.println(i);
//            } else if (s2.hasNextBoolean()) {
//                boolean b = s2.nextBoolean();
//                System.out.println(b);
//            } else if (s2.hasNextDouble()) {
//                double d = s2.nextDouble();
//                System.out.println(d);
//            } else {
//                System.out.println(s2.next());
//            }
        }
        for(String str : recebeTudo){
            if (str != null){
                System.out.println(str);
            }
        }

    }

    public static String[] aumentandoArray(String[] strArray) {
        if (strArray == null) {
            throw new NullPointerException();
        }
        String[] aux = new String[strArray.length + 15];

        System.arraycopy(strArray, 0, aux, 0, strArray.length);
        
        return aux;
        
    }

}
