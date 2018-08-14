/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.colecoes.teste;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Geraldo
 */
public class QueueTeste {

    public static void main(String[] args) {
        //PriorityQueue utiliza ou ordenamento natural ou um ordenamento definido pelo usuário
        // Pelos meus testes, ele não vai mostrar na ordem correta, porém ele retira certo
        //  Prioriti queue não é uma fila normal, ela usa da prioridade para remover
        //   ou seja, Ela manipula objetos que devem implementar a interface Comparable
        //    ou deve-se passar um Comparator 
        Queue<String> queue = new PriorityQueue<>();
        queue.offer("E");
        queue.offer("D");
        queue.offer("A");
        queue.offer("G");
        queue.offer("C");
        queue.offer("F");
        queue.offer("B");
        
        for (String s : queue) {
            System.out.println(s);
        }
        
        System.out.println("");

        String d = queue.poll();
        System.out.println(d);
        d = queue.poll();
        System.out.println(d);
        d = queue.poll();
        System.out.println(d); 
        d = queue.poll();
        System.out.println(d);
         d = queue.poll();
        System.out.println(d);
      
        System.out.println("");
        
        for (String s : queue) {
            System.out.println(s);
        }

    }
}
