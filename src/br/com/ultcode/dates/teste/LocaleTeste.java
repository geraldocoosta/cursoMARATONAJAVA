/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.dates.teste;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author Geraldo
 */
public class LocaleTeste {
    public static void main(String[] args) {
        // usa o padrão iso 639 para convesão de siglas de idiomas
        // ex: pt = portugues BR = brasil
        // ex2: en - ingles US = estados unidos
        Locale locale = new Locale("pt","BR");
        Locale locale2 = new Locale("it");
        Calendar c = Calendar.getInstance();
        
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,locale);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL,locale2);
        
        System.out.println(df.format(c.getTime()));
        System.out.println(df2.format(c.getTime()));
        
        //metodos uteis da classe locale
        // mostra a ligua escolhida 
        System.out.println(locale.getDisplayLanguage());
        System.out.println(locale2.getDisplayLanguage(locale2));
        
        
        //mostra o pais setado no metodo linguage
        System.out.println(locale.getDisplayCountry());
    }
}
