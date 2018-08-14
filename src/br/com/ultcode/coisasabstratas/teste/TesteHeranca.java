/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.coisasabstratas.teste;


import br.com.ultcode.coisasabstratas.classe.Gerente;
import br.com.ultcode.coisasabstratas.classe.Vendedor;

/**
 *
 * @author Geraldo
 */
public class TesteHeranca {
    public static void main(String[] args) {
        Gerente g = new Gerente("Rodolfo","22252-1",4000.0);
        Vendedor v = new Vendedor("Roberto","25552-1",1500.0,5000.0);
        g.calculaSalario();
        v.calculaSalario();
       
        System.out.println(g);
        System.out.println("=========================");
        System.out.println(v);
        
        
    }
    
}
