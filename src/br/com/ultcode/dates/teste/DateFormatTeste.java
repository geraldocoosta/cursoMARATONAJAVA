/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.dates.teste;

import java.text.DateFormat;
import java.util.Calendar;

/**
 *
 * @author Geraldo
 */
public class DateFormatTeste {

    public static void main(String[] args) {
        //instanciando objeto calendario
        Calendar c = Calendar.getInstance();
        
        //instanciando um array de DateFormat
        // Depois disso, é mostrado as formas de formas de iniciar um objeto DateFormat
        // Já q, DateFormat é uma classe abstrata
        
        DateFormat[] dfa = new DateFormat[6];
        dfa[0] = DateFormat.getInstance();
        dfa[1] = DateFormat.getDateInstance();
        dfa[2] = DateFormat.getDateInstance(DateFormat.SHORT);
        dfa[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);
        dfa[4] = DateFormat.getDateInstance(DateFormat.LONG);
        dfa[5] = DateFormat.getDateInstance(DateFormat.FULL);
        
        
        /*
        Primeiro instanciamos o calendario
        Depois instanciamos o objeto DateFormat, e disemos como queremos mostrar a data
        Com o argumento passado no método getDateInstance
        (Se iniciarmos com getInstance não podemos passar argumento)
        Depois disso é que vinculamos o objeto calendar (ou date) ao objeto DateFormat
        
        */
        int i = 0;
        for(DateFormat tf : dfa){
            // No método format() devemos passar um date, com isso ele irá retornar
            // a data formatada
            System.out.println( i + ": " + tf.format(c.getTime()));
            i++;
            if (i != dfa.length)
            System.out.print("\n");
        }
    }

}
