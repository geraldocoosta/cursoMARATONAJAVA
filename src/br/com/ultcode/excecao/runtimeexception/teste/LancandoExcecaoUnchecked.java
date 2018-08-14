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
public class LancandoExcecaoUnchecked {
    
    public static void main(String[] args) {
        DivisaoInteiros(5, 0);
    }
    
    public static void DivisaoInteiros(int a, int b){
        if(b == 0){
            throw new IllegalArgumentException("Não é aceito 0 no segundo argumento");
        }
        System.out.println(a/b);
    }
            
    
}


