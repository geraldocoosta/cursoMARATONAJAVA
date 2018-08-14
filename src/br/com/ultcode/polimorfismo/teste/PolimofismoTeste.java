/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.polimorfismo.teste;


import br.com.ultcode.polimorfismo.classes.Gerente;
import br.com.ultcode.polimorfismo.classes.Util;
import br.com.ultcode.polimorfismo.classes.Vendedor;

/**
 *
 * @author Geraldo
 */
public class PolimofismoTeste {
    public static void main(String[] args) {
        Gerente g = new Gerente("Rodolfo",5000.0,2000.0);
        Vendedor v = new Vendedor("Yuri",2000,20000);
         
        Util.relatorioPagamento(v);
        System.out.println("\n");
        Util.relatorioPagamento(g);

        
//        relatorio.relatorioPagamentoGerente(g);
//        System.out.println("\t=================");
//        relatorio.relatorioPagamentoVendedor(v);
    }
}
