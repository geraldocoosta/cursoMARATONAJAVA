/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.nio.teste;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author Geraldo
 */
public class PathMatherTeste {

    public static void main(String[] args) {
        Path path1 = Paths.get("pasta2/subpasta/subsub/ArquivoTesteDOS.txt");
        Path path2 = Paths.get("ArquivoTesteDOS.txt");
        Path path3 = Paths.get("GEGE-ARROCHA");

        //O pathMatcher reconhece somento o / como separador de diretorio
        // \\ não é reconhecido
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        // O * no glob considera qualquer coisa, menos o /
        System.out.println(matcher.matches(path1));
        System.out.println(matcher.matches(path2));
        System.out.println("=================================");
        matches(path1, "glob:*.txt"); //Qualquer coisa que não tenha /
        matches(path1, "glob:**.txt"); // Qualquer coisa incluindo /
        matches(path1, "glob:*"); // Qualquer coisa que não tenha *
        matches(path1, "glob:**"); // Qualquer coisa incluindo /
        System.out.println("=================================");
        matches(path1, "glob:*.???"); // 
        matches(path1, "glob:**/*.???"); // 
        matches(path1, "glob:**.???"); // 
        System.out.println("=================================");
        matches(path3, "glob:{GEGE*,ARROCHA*}"); // 
        matches(path3, "glob:{GEGE,ARROCHA}*"); // 
        matches(path3, "glob:{GEGE,ARROCHA}"); // 
        System.out.println("=============================");
        path1 = Paths.get("C:\\Users\\Geraldo\\Documents\\NetBeansProjects\\Exercicio");
        try {
            Files.walkFileTree(path1, new AchandoTodosTeste());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void matches(Path path, String glob) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob + ": " + matcher.matches(path));
       
    }
}

class AchandoTodosTeste extends SimpleFileVisitor<Path> {

    private PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*{Teste*}.{Java,Class}*");

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException {
        if (matcher.matches(file)) {
            System.out.println(file.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }
}
