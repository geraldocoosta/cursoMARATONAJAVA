/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.heranca.teste;

import br.com.ultcode.heranca.classes.Endereco;
import br.com.ultcode.heranca.classes.Funcionario;
import br.com.ultcode.heranca.classes.Pessoa;

/**
 *
 * @author Geraldo
 */
public class TesteHeranca {

    public static void main(String[] args) {
        Endereco endereco = new Endereco("Rua das palmeira", "bairo dos burros");
        Pessoa p = new Pessoa("GEGE", "74584284282", endereco);
        Funcionario f = new Funcionario("Toin", "00000000000", endereco, 2000.0);

        System.out.println(p);
        System.out.println("===============================");
        System.out.println(f);
        System.out.println("===============================");
        
        if(p instanceof Funcionario){
            System.out.println("true");
        }else{
            System.out.println("falso");
        }
        
        if (f instanceof Pessoa){
            System.out.println("true");
            Pessoa d = f;
        }
        
        System.out.println("===============================");
       
        
    }

}
