/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.colecoes.teste;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Geraldo
 */
public class MapTeste {
    public static void main(String[] args) {
        Map<String,String> mapTeste = new HashMap<>();
        // put = colocar algo no dicionario.
        // Não aceita Chaves iguais, mas não acusa nenhum erro, somente substitui o valor
        mapTeste.put("mapa", "dados");
        mapTeste.put("teste", "muleke doido");
        mapTeste.put("cafunga", "carequinha");
        mapTeste.put("mapa", "dados2"); // Esse valor que vai ficar, pois substitui o primeiro
        
        // HashMap e LinkedHashMap s�o bem rapidos, mt desempenho (LIKE!!)
        
        // iterando sobre a chave
        // usando o método keySet (Não pode ter elementos duplicados, por isso set)
        // HashMap não fica ordenado meu bom, lembre-se disso
        for (String s : mapTeste.keySet()){
            System.out.println(s);
        }
            System.out.println("==========================================");
        // iterando sobre os valores
        for (String s : mapTeste.values()){
            System.out.println(s);
        }
            System.out.println("==========================================");
            
        // Para iterar a chave e o valor
        // Entry é uma interface interna da interface Map, que disponibiliza métodos para
        //   trabalhar com o Map
        for (Map.Entry<String,String> entry : mapTeste.entrySet()  ){
            System.out.printf("chave: %s \t=> valor: %s%n",entry.getKey(),entry.getValue());
        }
    }
}
