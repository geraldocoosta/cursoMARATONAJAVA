/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.polimorfismo.teste;

import br.com.ultcode.polimorfismo.classes.Funcionario;
import br.com.ultcode.polimorfismo.classes.Gerente;
import br.com.ultcode.polimorfismo.classes.Util;

/**
 *
 * @author Geraldo
 */
public class Teste {
    public static void main(String[] args) {
        Funcionario f = null;
        Gerente g = new Gerente("gg", 20000, 10000);
        f = g;
        
        Util.relatorioPagamento(g);
        
        
    }
    
}
