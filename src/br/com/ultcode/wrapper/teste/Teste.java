/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.wrapper.teste;

/**
 *
 * @author Geraldo
 */
public class Teste {

    public static void main(String[] args) {
        Integer inteiro = 5;

        System.out.println(inteiro);

        // valueOf é um método statico q 
        //retorna um objeto do tipo da classe wrapper
         
        Short teste = Short.valueOf("50");
        System.out.println(teste);
        
        
        //retorna de um objeto wapper convertido em algo
        // ex.: longValue = retorna um tipo primitivo long
        double valor = teste.doubleValue();
        
        // Parse é um metodo statico que converte string e retorna um primitivo
        String teste3 = "56.2";
        double valorDouble = Double.parseDouble(teste3);
        
    }
    
    

}
