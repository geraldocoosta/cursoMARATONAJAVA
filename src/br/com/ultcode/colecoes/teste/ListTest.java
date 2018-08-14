/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.colecoes.teste;

import br.com.ultcode.colecoes.classes.Celular;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Geraldo
 */
public class ListTest {

    public static void main(String[] args) {
        // Para definir o tipo, pode-se colocar depois da váriavel de referencia
        // também pode-se colocar depois da váriavel de referencia E depois da classe instanciada.
        // É recomendado sempre definir o tipo ao utilizar uma lista
        List<String> nomes = new ArrayList<>();
        //List<String> nomes = new ArrayList<String>();
        nomes.add(new String("Geraldão"));
        nomes.add("GEGE");

        //Não se pode incluir um elemento na lista dentro de um forEach
        // Ocorre exception ConcurrentModificationException
        for (String s : nomes) {
            // nomes.add("GEGE");
            System.out.println(s);
        }

        //retorna o tamanho do arraylist
        int i = nomes.size();
        //ArrayList é baseado em array, logo tem indice, então
        // get retorna o valor de um indice
        String captura = nomes.get(1);
        // Se eu tentar pegar um valor em um indice inexistente = indexOutOfBoundException
        // Não se pode criar coleções usando tipos primitivos
        // ou seja List<int> nomes = new ArrayList<>(); não é valido
        // passa uma classe wrapper pra essa porra e já era

        captura = nomes.remove(1);
        System.out.println(captura);
        boolean removeu = nomes.remove("Geraldão");
        System.out.println(removeu);
        // podemos remover um objeto, passando o próprio objeto ou pelo index
        // se você passar um indice, ele vai retornar um objeto do tipo inserido na declaração da lista
        // se passar um objeto, ele retorna um boolean
        // Para se usar o remove passanndo objeto, esse objeto deve ser fruto de uma classe que implementa o método equals

        //juntando duas collections
        // nomes.addALL
        //verificar se existe um objeto em uma lista, método contains()
        // Metodo contains usa o método equals da classe, então implemente-o
        List<Celular> celulares = new ArrayList<>();
        celulares.add(new Celular("Samsung s1", "123654"));
        celulares.add(new Celular("Samsung s2", "djsdi"));
        celulares.add(new Celular("Samsung s3", "456dad"));
        celulares.add(new Celular("Samsung s4", "987dasd"));

        //celulares.contains(new Celular("Samsung s1","123654"));
        for (Celular c : celulares) {
            System.out.println(c);
        }

        nomes.clear();
        nomes.add("aLO");
        nomes.add("mulher");
        nomes.add("homem");
        nomes.add("zeteiro");
        nomes.add("camisa");
        nomes.add("toalha");
        nomes.add(2, "Inserindo no meio");
        Collections.sort(nomes);
        i = 0;
        for (String s : nomes) {

            System.out.printf("%d : %s%n", i, s);
            i++;
        }

        //Existe também o LinkedList, que é altamente eficaz e eficiente para adicionar 
        //   e remover elementos do começo e final da lista
        // Pode-se utilizar praticamente do mesmo jeito que uma ArrayList
        
        //   Vector
        // Basicamente um arrayList thread-safe, que aumenta um pouco mais.
        
        
    }
}
