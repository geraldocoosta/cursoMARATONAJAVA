/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.io.teste;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Geraldo
 */
public class FileDiretorio {

    public static void main(String[] args) {
        File diretorio = new File("folder");
        boolean mkdir = diretorio.mkdir();
        //Metodo mkdir da classe File cria um diretorio com o nome que foi passado
        // no construtor!!!
        // Caso o diretorio já exista, ele não será criado duplicado    
        System.out.println("Diretorio criado? " + mkdir);
        //criando um arquivo dentro do diretorio criado anteriormente
        File arquivo = new File(diretorio,"Arquivo.txt");
        boolean arquivoCriado;
        
        // bloco try catch por que o metodo creteNewFile pode lançar um exceção
        try {
            arquivoCriado = arquivo.createNewFile();
            System.out.println("Arquivo criado? " + arquivoCriado);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        //Modificando o nome do arquivo daquele diretorio
        File renomearArquivo = new File(diretorio,"Arquivorenomeado.txt");
        System.out.println("Arquivo renomeado? " +arquivo.renameTo(renomearArquivo));
        
        //Renomeando pasta
        File renomearDiretorio = new File("folder2");
        System.out.println("Diretorio renomeado? "+diretorio.renameTo(renomearDiretorio));
            
        System.out.println("======================================================");
        buscarArquivo();
        
    }
    
    public static void buscarArquivo(){
        File file = new File("C:\\Users\\Geraldo\\Documents\\NetBeansProjects\\Exercicio");
        String[] list =file.list();
        for(String s : list){
            System.out.println(s);
        }
    }
}
