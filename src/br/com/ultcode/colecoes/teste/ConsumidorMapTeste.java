/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.colecoes.teste;

import br.com.ultcode.colecoes.classes.Consumidor;
import br.com.ultcode.colecoes.classes.Produto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Geraldo
 */
public class ConsumidorMapTeste {

    public static void main(String[] args) {
        Consumidor c = new Consumidor("Geraldo", "777");
        Consumidor c2 = new Consumidor("otherPerson", "555");
       
        Produto p1 = new Produto("1234", 2000.0, "Celular", 0);
        Produto p2 = new Produto("321", 50.0, "Ventilador", 5);
        Produto p3 = new Produto("525", 2500.0, "Notebook", 8);
        Produto p4 = new Produto("4488", 50.0, "Essencia", 10);

        Map<Consumidor, List<Produto>> testMap = new HashMap<>();

        List<Produto> produtosComprados = new ArrayList<>();
        produtosComprados.add(p1);
        produtosComprados.add(p2);

        List<Produto> produtosComprados2 = new ArrayList<>();
        produtosComprados2.add(p4);
        produtosComprados2.add(p3);

        testMap.put(c, produtosComprados);
        testMap.put(c2, produtosComprados2);
       
        // Lembre-se, map utiliza o equals e não aceita duas chaves iguais
        //  se eu passar outros valores para uma chave já existenet, o map substitui os antigos pelos novos
        //  Se fizer alguma alteração na chave, porém essa alteração não seja nos atributos utilizados no equals
        //    ele não muda.

        for (Map.Entry<Consumidor, List<Produto>> entry : testMap.entrySet()) {
            System.out.printf("Consumidor %s comprou:%n", entry.getKey().getNome() );
            for (Produto p : entry.getValue()) {
                System.out.printf("%15s%n",p.getNome());
            }
            System.out.println("");
        }

        
        //Métodos legais
        // remove
        // replace (substitui os valores)
        // contains key, containsValue
        
     
    }
}
