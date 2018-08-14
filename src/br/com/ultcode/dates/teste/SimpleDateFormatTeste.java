/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.dates.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Geraldo
 */
public class SimpleDateFormatTeste {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        String mascara = "dd.MM.yyyy 'horas:' HH:mm:ss z";
        SimpleDateFormat sdf =  new SimpleDateFormat(mascara);
        System.out.println(sdf.format(c.getTime()));
    }
}
