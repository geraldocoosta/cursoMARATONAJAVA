/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.dates.teste;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Geraldo
 */
public class ManipulacaoDatasTeste {

    public static void main(String[] args) {
        //depreciado
        //Cria um objeto date com a data atual
        Date date = new Date();
        
        //Se eu fizer assim
        //Date date = new Date(10000000000L) por exemplo
        // eu estou colocando uma data em date, em milisigundos
        // data inicial de date 1/1/1970
        
        // Colocando uma hora da data
        // metodo getTime serve para retornar o valor q está armazenado
        // no objeto data em milisegundos (desde 1970);
        date.setTime(date.getTime() + 3_600_000L);
        System.out.println(date);
        System.out.println("============================");
        
        //Calendar é uma classe abstrata, ou seja, com o metodo getInstance
        //(só podemos instanciala com o getInstance())
        // estamos instanciando na verdade, uma subclasse dessa.
        Calendar c = Calendar.getInstance();
        System.out.println(c);
        System.out.println("============================");
        c.setTime(date);
        //System.out.println(c);

        if (Calendar.SUNDAY == c.getFirstDayOfWeek()) {
            System.out.println("\nDomingo é o primeiro dia da semana");
        }

        System.out.println("\n" + c.get(Calendar.DAY_OF_YEAR));
        // metodos importante
        // objetoCalendar.add
        // objetoCalendar.roll
        // objetoCalendar.getTime (retorna um objeto date)
        // objetoCalendar.setTime (recebe um objeto date)
        c.add(Calendar.HOUR, 1);
        Date date1 = c.getTime();
        System.out.println("\n" + date1);
        
        
        
    }
}
