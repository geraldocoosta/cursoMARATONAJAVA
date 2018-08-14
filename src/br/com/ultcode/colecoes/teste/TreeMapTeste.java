/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.colecoes.teste;

import br.com.ultcode.colecoes.classes.Consumidor;
import br.com.ultcode.colecoes.classes.Produto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 *
 * @author Geraldo
 */
public class TreeMapTeste {

    public static void main(String[] args) {
        // A classe chave do TreeMap deve implementar um comparable, ou ter um comprator
        NavigableMap<Consumidor, List<Produto>> map = new TreeMap<>(new CompararProduto());
        List<Produto> prodConsumidor1 = new ArrayList<>();
        List<Produto> prodConsumidor2 = new ArrayList<>();

        Consumidor c1 = new Consumidor("Geraldo", "777");
        Consumidor c2 = new Consumidor("Arnaldo", "555");
        Consumidor c3 = new Consumidor("Aricleudo", "888");
        Consumidor c4 = new Consumidor("Jennifer", "789");

        Produto p1 = new Produto("1234", 2000.0, "Celular", 0);
        Produto p2 = new Produto("321", 50.0, "Ventilador", 5);
        Produto p3 = new Produto("525", 2500.0, "Notebook", 8);
        Produto p4 = new Produto("4488", 50.0, "Essencia", 10);

        prodConsumidor1.add(p1);
        prodConsumidor1.add(p2);
        Collections.sort(prodConsumidor1);

        prodConsumidor2.add(p3);
        prodConsumidor2.add(p4);
        Collections.sort(prodConsumidor2);

        map.put(c1, prodConsumidor1);
        map.put(c2, prodConsumidor2);
        map.put(c3, prodConsumidor1);
        map.put(c4, prodConsumidor2);

        for (Map.Entry<Consumidor, List<Produto>> entry : map.entrySet()) {
            System.out.println(entry.getKey().getCpf() + " = " + entry.getKey().getNome() + " comprou: ");
            for (Produto p : entry.getValue()) {
                System.out.println("\t" + p.getNome());
            }
            System.out.println("");
        }

        // Retorna um map com chaves menores do que a chave que eu passei
        //  Esse mp está vinculado ao map original
        NavigableMap<Consumidor, List<Produto>> map2 = map.headMap(map.lastKey(),true);
        System.out.println(map.size());
        
        Iterator<Map.Entry<Consumidor,List<Produto>>> iterator = map2.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Consumidor,List<Produto>> entry = iterator.next();
            if (entry.getKey().equals(c2)){
                iterator.remove();
            }
        }
        
        System.out.println(map.size());
        
//        for (Map.Entry<Consumidor, List<Produto>> entry : map2.entrySet()){
//            System.out.println(entry.getKey().getNome()+":");
//            for(Produto p : entry.getValue()){
//                System.out.printf("\tProduto: %10s \t Preco: %10s%n",p.getNome(),p.getPreco());
//            }
//        }
    }
}

class CompararProduto implements Comparator<Consumidor> {

    public int compare(Consumidor o1, Consumidor o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}
