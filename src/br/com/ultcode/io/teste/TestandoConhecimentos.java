/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.io.teste;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 *
 * @author Geraldo
 */
public class TestandoConhecimentos {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Geraldo\\Desktop\\Lorem\\ipsum.txt");
       
        
        try(FileReader fr = new FileReader(file)){
            System.out.println(file.exists());
            char[] text = new char[5000];
            int size = fr.read(text);
            
            System.out.println(size);
            
            for(char a : text){
                System.out.print(a);
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
