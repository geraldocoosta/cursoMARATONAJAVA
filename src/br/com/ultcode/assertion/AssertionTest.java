/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.assertion;

/**
 *
 * @author Geraldo
 */
public class AssertionTest {
    public static void main(String[] args) {
        AssertionTest.calculaNumeroPositivo(-40);
        
    }
    
    private static void calculaNumeroPositivo(int a){
        assert(a > 0) : "Passe um argumento positivo e legal";
        System.out.println(a);
    }
    
}
