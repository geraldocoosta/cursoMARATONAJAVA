/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.io.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Geraldo
 */
public class BufferedTesteOtimizado {
    public static void main(String[] args) {
        File file = new File("Arquivo.txt");
        /*
        Fiz a mesma coisa da classe BufferedTeste, porém, com o try with resource
        o código fica mais legivel e mais limpo
        */
        try(BufferedReader br = new BufferedReader(new FileReader(file));
                BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))){
            System.out.println(file.exists());
            
            bw.write("Teste para ver se estou escrevendo em sequencia ou substituindo");
            bw.newLine();
            bw.write("Só pra lembrar da baguncinha");
            bw.flush();
            
            String s;
            while ( (s=br.readLine()) != null){
                System.out.println(s);
            }
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
