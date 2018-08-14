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
public class LancandoExceptionChecked {

    public static void main(String[] args) {
        
        try {
            CriarArquivo();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void CriarArquivo() throws IOException{
        File file = new File("Arquivo.txt");
        try {
            file.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
