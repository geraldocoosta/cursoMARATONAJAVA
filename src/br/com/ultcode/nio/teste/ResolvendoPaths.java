/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.nio.teste;

//import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Geraldo
 */
public class ResolvendoPaths {

    public static void main(String[] args) {
        Path path = Paths.get("pasta2\\subpasta");
        Path path2 = Paths.get("subpasta\\subsub");
        Path resolvido = path.resolve(path2);
        System.out.println(resolvido);
        // out: 
        // pasta2\subpasta\subpasta\subsub
        // O resolve basicamente junta dois dois paths
        // Se tentarmos passar o caminho absoluto como argumento
        // Ele "pega o caminho todo"
        //ex.:
        
        System.out.println("");
        Path absoluto = Paths.get("\\pasta\\subpasta");
        Path relativo = Paths.get("pastadentrodaSubpasta");
        Path arquivo = Paths.get("texto.txt");

        System.out.println("1: " + absoluto.resolve(relativo));
        System.out.println("2: " + absoluto.resolve(arquivo));
        System.out.println("3: " + relativo.resolve(absoluto));
        System.out.println("4: " + relativo.resolve(arquivo));
        System.out.println("5: " + arquivo.resolve(absoluto));
        System.out.println("6: " + arquivo.resolve(relativo));
        
        //Passar caminho absoluto como argumento pro metodo resolve() == problema
        // O caminho absoluto sobrepõe um relativo
        System.out.println("");
        //E se forem dois absolutos?
        Path absoluto2 = Paths.get("\\pasta1\\pasta2");
        System.out.println("1: "+absoluto.resolve(absoluto2));
        System.out.println("2: "+absoluto2.resolve(absoluto));
        
       
        
       
       
    }

}
