/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.dates.teste;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author Geraldo
 */
public class NumberFormatTeste {

    public static void main(String[] args) {
        float numFloat = 12526.45F;
        Locale localeEU = new Locale("en", "US");
//        System.out.println(numFloat);
        NumberFormat[] nfa = new NumberFormat[4];
        
        nfa[0] = NumberFormat.getInstance(); // numeros normais
        nfa[1] = NumberFormat.getInstance(localeEU);
        nfa[2] = NumberFormat.getCurrencyInstance(); //currencyinstance = money
        nfa[3] = NumberFormat.getCurrencyInstance(localeEU);
        
        for (NumberFormat nf  : nfa){
            System.out.println(nf.format(numFloat));
        }
        
      
        NumberFormat nf = NumberFormat.getInstance();
        // setar o numero maximo de digitos fracionarios 
        nf.setMaximumFractionDigits(5);
        System.out.println(nf.format(numFloat));
        
        try{
            //recebe uma string e produz um numero formatado
            System.out.println(nf.parse("125,3256546"));
            //definindo que só vai converter o numero para um inteiro
            nf.setParseIntegerOnly(true);
            System.out.println(nf.parse("125,3256546"));
        }catch(ParseException e){
            e.printStackTrace();
        }
        
       
        
    }
}
