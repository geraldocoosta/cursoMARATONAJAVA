/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.interfaces.teste;

import br.com.ultcode.interfaces.classes.Produto;
import br.com.ultcode.interfaces.classes.Tributavel;

/**
 *
 * @author Geraldo
 */
public class TesteProduto {
    public static void main(String[] args) {
        Produto p = new Produto("Notebook", 4, 3000);
        p.calculaImposto();
        p.calculaFrete(); 
        
        
        System.out.println(p);
        Tributavel tribu = new Produto("hotdog", 500.5, 25.30);
      
    }
    
}
