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
public class StringTest {

    public static void main(String[] args) {
        String nome = "Geraldo";
        String sobrenome = new String(" Costa");

        //concat, retorna um objeto String concatenando o que foi passado como parametro no final dela
        nome = nome.concat(sobrenome);
        System.out.println(nome);

        String teste = "teste";
        String teste2 = new String("teste");
        /*
        Quando fazemos o new String, estamos criança uma variavel de referencia
        um objeto na memoria
        e referenciando esse objeto ao literal teste na string pool
         */

        if (teste == teste2) {
            System.out.println("igual");
        } else {
            System.out.println("diferente");
        }
        System.out.println("\n");
        // indexOf, retorna a posição de um caractere na String
        System.out.println(nome.indexOf(" ") + "\n");

        //METODOS STRING
        String testeConcat = "Geraldo";
        testeConcat.concat(" Teste");
        // Observe q, como as strings são IMUTAVEIS, o método será executado, 
        // não há mudanças na variavel testeConcat
        System.out.println(testeConcat);
        testeConcat = testeConcat.concat("Teste");
        //AGORA SIM!!!
        System.out.println(testeConcat);

        //charAt = Encontrar qual carctere está naquela posição
        System.out.println("\n" + testeConcat.charAt(5));
        
        //REPLACE, troca um carctere por outro
        System.out.println("\n" + testeConcat.replaceAll("Geraldo", "Maria"));
    }
}
