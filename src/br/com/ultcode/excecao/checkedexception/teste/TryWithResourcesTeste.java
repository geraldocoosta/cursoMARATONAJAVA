/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.excecao.checkedexception.teste;

import br.com.ultcode.excecao.checkedexception.classes.Leitor1;
import br.com.ultcode.excecao.checkedexception.classes.Leitor2;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author Geraldo
 */
public class TryWithResourcesTeste {

    public static void main(String[] args) {
        lerArquivo2();
    }
    //A partir do java 7, o recurso try-with-resource foi implementado
    // Esse recurso trata de fechar um objeto, sem o uso do finally
    // A classe que vamos instanciar dentro do try() deve implementar
    // as interfaces closeable ou autocloseable

    public static void testandoTryWithResource1() {
        try (Leitor1 leitor = new Leitor1();
                Leitor2 leitor2 = new Leitor2();) {

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            System.out.println("teste");
        }

    }

    public static void lerArquivo2() {
        try (Reader reader = new BufferedReader(new FileReader("oi.txt"))) {
            // No try with resource, você pode capturar a exceção ou não
            // é recomendado que capture a exceção
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    //Metodo usual para ler arquivos no java 6
    //Repare no try- catch - finaly(try catch)
    public static void lerArquivo() {
        Reader reader = null;
        try {
            
            reader = new BufferedReader(new FileReader("oi.txt"));
            System.out.println("Leu");
        } catch (FileNotFoundException e) {
            System.out.println("Erro");
            e.printStackTrace();

        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Erro2");
            }

        }
    }

}
