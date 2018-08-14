/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.colecoes.teste;

import br.com.ultcode.colecoes.classes.Produto;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 *
 * @author Geraldo
 */
public class TreeSetTeste {

    public static void main(String[] args) {
        Produto p1 = new Produto("1234", 2000.0, "Celular", 0);
        Produto p2 = new Produto("321", 50.0, "Ventilador", 5);
        Produto p3 = new Produto("525", 2500.0, "Notebook", 8);
        Produto p4 = new Produto("4488", 50.0, "Essencia", 10);

        //Para adicionar um objeto em um navigableSet, ele deve implementar a classe
        //   comparable, ou precisa de um comparator
        NavigableSet<Produto> nsProduto = new TreeSet<>();
        
        nsProduto.add(p1);
        nsProduto.add(p2);
        nsProduto.add(p3);
        nsProduto.add(p4);
        
        for (Produto p: nsProduto){
            System.out.println(p);
        }
            
        // metodos interessantes
        // lower <
        // floor <=
        // higher >
        // celling >=
        
        //Digamos que estamos fazendo uma busca por essa estrutura de dados e passamos um objeto como
        //  argumento. Essa lista deve ser organizada segundo um comprable ou um comparator
        //  Então esses métodos retornarão objetos que sejam iguais (provavelmente usam o equals)
        //  ou menor, maior, provavelmente usando o comparable ou comparator
        
        // outro método interessante
        // descendingSet(), inverte a ordem da lista
        // poolFirst - busca o primeiro objeto e remove ele da lista
        // poolLast - busca o ultimo objeto e o remove da lista
        
        
       
     
        
    }
}
