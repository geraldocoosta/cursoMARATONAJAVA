/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.colecoes.teste;

import br.com.ultcode.colecoes.classes.Celular;

/**
 *
 * @author Geraldo
 */
public class EqualsTeste {
    public static void main(String[] args) {
        Celular cel1 = new Celular("Nokia", "TIJOLO");
        Celular cel2 = new Celular("Nokia", "TIJOLO");
        
        
        System.out.println(cel1.equals(cel2));
    }
}
