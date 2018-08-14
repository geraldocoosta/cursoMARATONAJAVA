/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.nio.teste;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Geraldo
 */
public class NormalizacaoNIOTeste {
    public static void main(String[] args) {
        String diretorio = "C:\\Users\\Geraldo\\Desktop\\Lorem\\Coisa\\subpastaCoisa";
        String arquivoNoDiretorio = "..\\arquivo.txt";
        
        Path path = Paths.get(diretorio,arquivoNoDiretorio);
        
        //Normalizando o diretorio
        // Tendo como ponto de partida que algum programa ou script retornou os diretorios acimas
        // O método normalize retira o ..\ e devolce o diretorio normalizado
        System.out.println(path.normalize());
        System.out.println(path);
        
        
        // Lebre-se: .\ é como se tivesse falando que é o diretorio atual
        Path path2 = Paths.get("C:\\.\\Users\\.\\Geraldo\\.\\Desktop\\.\\Lorem\\.\\Coisa\\.\\subpastaCoisa");
        System.out.println(path2);
        System.out.println(path2.normalize());
        
        // Pode ter sido passado um local totalmente aleatirio, o nomalize nao vai garantir
        // que aquele caminho é real, ele apenas vai normalizar, ou seja, retirar os ../ ou ./
    }
}
