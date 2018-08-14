/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.nio.teste;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

/**
 *
 * @author Geraldo
 */
public class DosFileAttributesTeste {

    public static void main(String[] args) {
        try {
            testandoClasseDosFileAttributes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testandoClasseDosFileAttributes() throws IOException {
        Path path = Paths.get("pasta2\\subpasta\\subsub\\ArquivoTesteDOS.txt");
        if (Files.notExists(path)) {
            Files.createFile(path);
        }
        // Settando um arquivo como oculto
        Files.setAttribute(path, "dos:hidden", true);
        // Settando um arquivo como apenasLeitura
        Files.setAttribute(path, "dos:readonly", true);

        DosFileAttributes dfa = Files.readAttributes(path, DosFileAttributes.class);
        System.out.println("É oculto? " + dfa.isHidden());
        System.out.println("É somente leitura? " + dfa.isReadOnly());

        DosFileAttributeView dfav = Files.getFileAttributeView(path, DosFileAttributeView.class);
        dfav.setHidden(false);
        dfav.setReadOnly(false);
        
        dfa = Files.readAttributes(path, DosFileAttributes.class);
        System.out.println("É oculto? " + dfa.isHidden());
        System.out.println("É somente leitura? " + dfa.isReadOnly());
        
        
        
    }
}
