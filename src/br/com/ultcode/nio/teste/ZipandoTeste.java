/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.nio.teste;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author Geraldo
 */
public class ZipandoTeste {

    public static void main(String[] args) {
        Path dirZip = Paths.get("pasta");
        Path dirFiles = Paths.get("pasta/subpasta/subsubpasta");
        Path zipFile = dirZip.resolve("arquivo.zip");
        //Pacote para zipar arquivos Java.util.zip
        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(zipFile.toFile()));
                DirectoryStream<Path> stream = Files.newDirectoryStream(dirFiles)) {
            for (Path path : stream) {
                //  System.out.println(path.getFileName());
                zip.putNextEntry(new ZipEntry(path.getFileName().toString()));
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path.toFile()));
//                zip.write(bis.read());
                byte[] buff = new byte[2048];
                int bytesLidos;
                while ((bytesLidos = bis.read(buff)) > 0) {
                    zip.write(buff, 0, bytesLidos);
                }
                zip.flush();
                zip.closeEntry();
                bis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
