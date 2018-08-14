/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.nio.teste;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;

import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 *
 * @author Geraldo
 */
public class AtributosBasicosTeste {

    public static void main(String[] args) {
        // Settando ultima atualização usando a classe File
        Date ultimaAtualizacao = new GregorianCalendar(2018, Calendar.MAY, 23).getTime();
        File arquivo = new File("pasta\\novoArquivo.txt");
        try {
            arquivo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        arquivo.setLastModified(ultimaAtualizacao.getTime());
        System.out.println(arquivo.lastModified());
        System.out.println("Arquivo excluido? " + arquivo.delete());
        System.out.println("");
        //Settando ultima atuqalização usando a classe Path
        Path arquivo2 = Paths.get("pasta\\NovoAquivo");
        FileTime fileTime = FileTime.fromMillis(ultimaAtualizacao.getTime());
        try {
            Files.createFile(arquivo2);
            Files.setLastModifiedTime(arquivo2, fileTime);
            System.out.println(Files.getLastModifiedTime(arquivo2));
            System.out.println("Arquivo excluido? " + Files.deleteIfExists(arquivo2));
        } catch (IOException e) {
            e.printStackTrace();
        }

        arquivo2 = Paths.get("C:\\Users\\Geraldo\\Documents\\NetBeansProjects\\Exercicio\\src\\br\\com\\ultcode\\heranca\\classes\\Endereco.java");
        System.out.println("é gravavel? " + Files.isWritable(arquivo2));
        System.out.println("Pode ler? " + Files.isReadable(arquivo2));
        System.out.println("É executavel? " + Files.isExecutable(arquivo2));

        try {
            //BasicFileAttributes, PosixFileAttributes, DosFileAttributes
            // Usado para verificar alguns atributos de arquivos comuns em vários
            //sistemas de arquivos
            BasicFileAttributes atributosBasicos = Files.readAttributes(arquivo2, BasicFileAttributes.class);
            System.out.println("data criação: "+ atributosBasicos.creationTime());
            System.out.println("Date ultimo acesso: " + atributosBasicos.lastAccessTime());
            System.out.println("Data da ultima modificação: "+atributosBasicos.lastModifiedTime());
            System.out.println(atributosBasicos.isDirectory());
            System.out.println(atributosBasicos.isSymbolicLink());
            System.out.println(atributosBasicos.isRegularFile());
            System.out.println("=======================================");
            //BasicFileAttributeView, PosixFileAttributeView, DosFileAttributeView
            // FileOwnerAttributeView, AclFileAttributeView
            
            BasicFileAttributeView basicView = Files.getFileAttributeView(arquivo2, BasicFileAttributeView.class);
            FileTime lastModified = atributosBasicos.lastModifiedTime();
            FileTime created = atributosBasicos.creationTime();
            FileTime acessTime = FileTime.fromMillis(System.currentTimeMillis());
           
            basicView.setTimes(acessTime, acessTime, created);
            atributosBasicos = Files.readAttributes(arquivo2, BasicFileAttributes.class);
            System.out.println("data criação: "+ atributosBasicos.creationTime());
            System.out.println("Date ultimo acesso: " + atributosBasicos.lastAccessTime());
            System.out.println("Data da ultima modificação: "+atributosBasicos.lastModifiedTime());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
    }
}
