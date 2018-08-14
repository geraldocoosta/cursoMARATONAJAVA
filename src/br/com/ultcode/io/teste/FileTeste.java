/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.io.teste;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Geraldo
 */
public class FileTeste {

    public static void main(String[] args) {
        File file = new File("arquivo.txt"); // No contrutor, só foi passado
        // o nome do arquivo que será criado
        try {
            // com esse metodo (createNewFile) que será realmente criado o arquivo
            // especificado no construtor do objeto
            // obs.: não é pq ta dentro de um println q o método não foi executado
            System.out.println("Arquivo criado? " + file.createNewFile());
            // file.exists() Para saber se o arquivo já existe
            System.out.println("Arquivo existe? " + file.exists());
            //file.delete() Deleta o arquivo com aquele nome
            //System.out.println(file.delete());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Pode executar? " + file.canExecute()
                + "\nPode ler? " + file.canRead()
                + "\nPode escrever? " + file.canWrite()
                + "\nQual o path absoluto? " + file.getAbsolutePath()
                + "\nQual o path? " + file.getPath()
                + "\nisDirectory: " + file.isDirectory()
                + "\nArquivo oculto? " + file.isHidden()
                + "\nUltima modificação: " + file.lastModified()
                + "\nQual o tamanho? " + file.length()
                + "\nDiretorio pai: " + file.getParent());
                
        URI uri;
                
        uri = file.toURI();
        System.out.println("\nTESTE URI");
        System.out.println(uri);
        //  path = caminho que usou no construtor de File
        //  AbsolutPath = caminho completo do arquivo
        //  isDirectory = saber se é um diretorio ou é um arquivo
        //  lastModified = quando o arquivo foi modificado pela ultima vez
        //  retorna um long = provavelmente em ms
        System.out.println("");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(file.lastModified()));

        DateFormat df = DateFormat.getInstance();
        System.out.println(df.format(c.getTime()));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy 'horas:' HH:mm:ss:SSS");
        System.out.println(sdf.format(c.getTime()));

    }
}
