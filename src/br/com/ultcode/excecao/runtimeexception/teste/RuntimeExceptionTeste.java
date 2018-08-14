/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.excecao.runtimeexception.teste;

/**
 *
 * @author Geraldo
 */
public class RuntimeExceptionTeste {

    Object o;
    public static void main(String[] args) {

        RuntimeExceptionTeste e = new RuntimeExceptionTeste();

        double a = 0;
        int b = 0;
        double c = a / b;
        System.out.println(c); //ArithmeticException, numeros inteiros não podem ser divididos por 0

        System.out.println(e.o.toString());  // NullPointerException: Nao é possivel acessar um método em uma variavel de referencia não inicializada

        int[] inteirinho = new int[2];
        System.out.println(inteirinho[2]); //ArrayIndexOutOfBoundsException: Não é possivel acessar uma posição que não existe em um array
        
    }
    
    public static void teste(){
       
       
    }
}
