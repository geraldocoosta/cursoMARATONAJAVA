/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.nio.teste;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Geraldo
 */
public class RelativizandoTeste {

    public static void main(String[] args) {
        // O método relativize da classe Path, basicamente de da um diretorio o path
        // de um doretorio/arquivo com relação a outro
        Path dir = Paths.get("/home/PastaDoGERALDÃO");
        Path dir2 = Paths.get("/home/PastaDoGERALDÃO/almofodado/alcochoado/teste");
        Path relativizandoORole = dir.relativize(dir2);
        System.out.println(relativizandoORole);

        Path absoluto0 = Paths.get("/home/PastaDoGERALDÃO");
        Path absoluto1 = Paths.get("/user/local");
        Path absoluto2 = Paths.get("/home/PastaDoGERALDÃO/teste/Arquivo.txt");
        Path relatividade = Paths.get("temp/Teste.java");
        Path relativo = Paths.get("temp/");
        System.out.println();
        //Como ler isso?
        // Do caminho um como posso chegar ao caminho2
        System.out.println("1: " + absoluto0.relativize(absoluto2));
        System.out.println("2: " + absoluto2.relativize(absoluto0));
        System.out.println("3: " + absoluto0.relativize(absoluto1));
        System.out.println("4: " + relatividade.relativize(relativo));
//       System.out.println("5: " + absoluto0.relativize(relativo));
        
       
       
       // Você só pode relativizar paths se os dois começarem do mesmo lugar
       // se ele for absoluto, provavelmente começa do c:/, então o path do 
       // argumento deve começar do c:/
       // se for relativo, o outro deve ser relativo, ou seja, ambos devem
       // partir da pasta do projeto
    }

}
