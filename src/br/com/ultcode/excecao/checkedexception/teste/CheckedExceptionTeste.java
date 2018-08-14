/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.excecao.checkedexception.teste;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Geraldo
 */
public class CheckedExceptionTeste {

    public static void main(String[] args) {
        System.out.println("\tTeste 1");
        try {
            abrirArquivo();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("\t===============================\n\t Teste 2");

        testeFinally();
        boolean algo = testeFinallyBoolean();
        System.out.println(algo);
        System.out.println("\t===============================\n\t Teste 3");
        try {
            testeTryFinally();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void abrirArquivo() throws IOException {
        File file = new File("Arquivo.txt");
        file.createNewFile();
    }

    public static void testeFinally() {
        try {
            System.out.println("Dentro do try");
            //throw new Exception("Lançando exceção qualquer para testar o finally");

        } catch (Exception e) {
            System.out.println("Dentro do catch");
        } finally {
            System.out.println("Finaly");
        }
    }

    public static boolean testeFinallyBoolean() {
        try {
            System.out.println("Dentro do try");
//            throw new Exception("Lançando exceção qualquer para testar o finally");

             return true;
        } catch (Exception e) {
            System.out.println("Dentro do catch");
        } finally {
            System.out.println("Finaly");
        }

        return false;
    }

    public static void testeTryFinally() throws Exception {
        try {
            System.out.println("Dentro do try");
            throw new Exception();
        } finally {
            System.out.println("Finaly");
        }
    }
}
