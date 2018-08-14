/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.regex.teste;


/**
 *
 * @author Geraldo
 */
public class TokensTeste {
    public static void main(String[] args) {
        String g = "Willian,Paulo,Geraldo,Joana,Joaquin,Jhon";
        String[] arraySplit = g.split(",");
        for (int i = 0; i < arraySplit.length; i++) {
            System.out.println(i + " : " + arraySplit[i].trim());
        }
        
        // token com classe String
   
    }
}
