/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.strings.teste;

/**
 *
 * @author Geraldo
 */
public class StringBuilderTeste {
    public static void main(String[] args) {
            String s = "Um texto qualquer";
            StringBuilder sb = new StringBuilder(s);
            sb.append(" - outro role mano");
            
            System.out.println(sb);
            
            sb.reverse();
            
            System.out.println(sb);
            
            sb = new StringBuilder(s);
            
            sb.delete(5, 7);    
            //primeiro argumento, indice, onde vai começar a excluir
            //segundo argumento, indice +1, onde vai parar  de excluir
            
            System.out.println(sb);
            
            // metodo insert: insere algo Obvius
            // Primeiro argumento: posição q vai ser inserido
            // segundo argumento, o q vai ser inserido
            // note que o caractere q estava nessa posição foi "empurrado" para frente
            // o método considera até o valor de tamanho, não de indice
            sb.insert(1, "Poxa nada a ver irmão");
            System.out.println(sb);
            System.out.println("-------------------");
            sb = new StringBuilder();
            sb.append("daf").insert(0, "um texto bem branco");
            System.out.println(sb);
            
            
    }
    
}
