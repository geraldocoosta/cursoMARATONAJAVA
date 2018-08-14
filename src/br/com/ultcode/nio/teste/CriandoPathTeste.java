/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.nio.teste;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author Geraldo
 */
public class CriandoPathTeste {

    public static void main(String[] args) {

        //C:\Users\Geraldo\Documents\NetBeansProjects\Exercicio
        Path p4 = Paths.get("C:", "Users", "Geraldo", "Documents", "NetBeansProjects", "Exercicio", "arquivo.txt");
//        System.out.println(p4.toAbsolutePath());

        //Todas essas formas são validas para se passar um diretorio/arquivo para um Path
        // Nota-se que deve ser utilizado o método statico get da classe Paths para isso.
        // Lembre-se:   Path = Interface
        //              Paths = Classe
        File file = p4.toFile(); // Convertendo de path para file (obviamente retorna um file)
        Path path = file.toPath(); // convertendo file para patch (retorna path)
        
        //====================================================================================
        
        //Se utilizarmos o \\, nao estaremos utilizando o caminho relativo ao projeto
        // se utilizar o \\, cria no c:\
        Path path1 = Paths.get("pasta");
        Path path2 = Paths.get("pasta2\\subpasta\\subsub");
        Path arquivo = Paths.get("pasta2\\subpasta\\subsub\\arquivoDulin.txt");
       

        try {
            // Metodo createDirectory da classe Files lança 4 exceções
            // capturando as 2 que são checked

            //Método da classe File notExists, se não existir retorna true
            if (Files.notExists(path1)) {
                Files.createDirectory(path1);
            }

            // Se o diretorio já existir, lança a exceção FileAlreadyExistsException
            // O método createDirectories cria várias pastas
            if (Files.notExists(path2)) {
                Files.createDirectories(path2);
            }
            //  Metodo para criação de arquivos
            if (Files.notExists(arquivo)) {
                Files.createFile(arquivo);
            }
          

            //Atenção, se passar um objeto Path que supostamente deveria criar um arquivo
            // em um método createDirectories, ele vai criar uma pasta com o que era pra
            // ser do arquivo. Usar método getParent() quando isso acontecer
//            Files.createDirectories(arquivo.getParent());
        } catch (FileAlreadyExistsException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path source = Paths.get("C:\\Users\\Geraldo\\Documents\\NetBeansProjects\\Exercicio\\pasta\\arquivo.txt");
        Path target = Paths.get(path2.toString() + "\\NovoArquivoCopiado.txt");
        try {
            //Metodo copy, copia um arquivo de um lugar para outro
            // como terceiro argumento opcional, temos o CopyOption
            // esse argumento recebe um enum StandardCopyOption.
            // Esse enum, diz se vai copiar por cima, copiar os atributos, ou
            // outro modo atomico que não sei pra q serve
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            
            // Metodo move, move um arquivo de um lugar para outro
//        Files.move(source, target);
            //Deleta se existir
            System.out.println(Files.deleteIfExists(arquivo));
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

}
