/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.nio.teste;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 *
 * @author Geraldo
 */
public class DirectoryStreamTeste {
    public static void main(String[] args) {
        try {
            teste();
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }
    
    //Listando arquivos de uma pasta qualquer
    public static void teste() throws IOException{
        Path dir = Paths.get("pasta\\subpasta");
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)){
            for(Path s : stream){
                System.out.println(s.getFileName());
            }
        } catch(IOException e){
            throw e;
        }
    }
    
}
