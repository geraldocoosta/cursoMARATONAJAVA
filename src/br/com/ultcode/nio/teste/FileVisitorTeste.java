/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.nio.teste;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorTeste {

    public static void main(String[] args) {
        try {
            teste();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void teste() throws IOException {
        // Ao utilizar esse método, deve ser passado um path e um objeto de uma 
        // Classe SimpleFileVisitor<T> ou um "filho" dessa classe
        Files.walkFileTree(Paths.get("pasta"), new PrintDirs());
    }
}

/*
Listando arquivos de uma conjunto de pastas
 */
class AcharTodosOsBkp extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        System.out.println(file.getFileName().toString());
        return FileVisitResult.CONTINUE;
    }
}

class PrintDirs extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        
        System.out.println("Pre: " + dir);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        System.out.println("File: " + file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc)
            throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        System.out.println("post: " + dir);
        return FileVisitResult.CONTINUE;
    }
}
