/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.colecoes.teste;

import br.com.ultcode.colecoes.classes.Produto;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Geraldo
 */
public class SetTeste {

    public static void main(String[] args) {

        Produto p1 = new Produto("1234", 2000.0, "Celular", 0);
        Produto p2 = new Produto("321", 50.0, "Ventilador", 5);
        Produto p3 = new Produto("525", 2500.0, "Notebook", 8);
        Produto p4 = new Produto("4488", 50.0, "Essencia", 10);

        //Todas collections que tem hash no nome fazem uso do hashcode
        // HashSet = coleção de alto desempenho, porém fica tudo desorganizado
        // collections que implementam a interface Set não permitem elementos duplicados
        Set<Produto> setProduto = new HashSet<>();
        setProduto.add(p1);
        setProduto.add(p1);
        setProduto.add(p2);
        setProduto.add(p3);
        setProduto.add(p4);
        //Set não é indexado, o que é isso gege? Não da pra pegar pelo index bb
        //  Ele não parece um array que tem relação index - objeto
       
        //LinkedHashSet, guarda na ordem de inserção
        //HashSet, a ordem é baseada no hashCode
        
        for (Produto p : setProduto){
            System.out.println(p);
        }
    }
}
