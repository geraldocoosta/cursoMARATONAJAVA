/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.exercicioPP;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


/**
 *
 * @author Geraldo
 */
public class ExercicioScanner {
    public static void main(String[] args) {
        String dataNascimento;
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Digite sua data de nascimento");
            dataNascimento = s.next();
        }
        
        Date date;
        try {
            date = convertendoStringParaDate(dataNascimento);
            if (date != null){
                Calendar c = Calendar.getInstance();
                int anoAtual = c.get(Calendar.YEAR);
                c.setTime(date);
                int anoNascimento = c.get(Calendar.YEAR);
                System.out.println("Você tem: " + (anoAtual - anoNascimento) + " anos");
            }else{
                System.out.println("Foi digitado uma data invalida, fim de aplicação");
            }
            
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        
        
     
        
    }
    
    public static Date convertendoStringParaDate(String s) throws ParseException{
         String padrao = "[0-3][0-9]/[01][0-9]/(19|20)[0-9][0-9]";
         if(s.matches(padrao)){
             SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
             Date date = sdf.parse(s);
             return date;
         }
            return null;
         
         
    }
    
    
}
