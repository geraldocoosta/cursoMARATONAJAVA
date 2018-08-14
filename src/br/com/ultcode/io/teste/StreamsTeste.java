/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.io.teste;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Geraldo
 */
public class StreamsTeste {

    public static void main(String[] args) {
        gravadorTunado();
        leitor();
    }

    private static void gravador() {
        byte[] dados = {65, 66, 67, 68, 69, 70};
        try (FileOutputStream gravador = new FileOutputStream("pasta/stream.txt")) {
            gravador.write(dados);
            gravador.flush();
            System.out.println("Dados gravados com sucesso");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void gravadorTunado() {
        byte[] dados = {65, 66, 67, 68, 69, 70};
        try (BufferedOutputStream gravador = new BufferedOutputStream(new FileOutputStream("pasta/stream.txt"),4098)) {
            gravador.write(dados);
            gravador.flush();
            System.out.println("Dados gravados com sucesso");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leitor() {
        try (FileInputStream leitor = new FileInputStream("pasta/stream.txt")) {
//              byte[] b = new byte[25];
//              leitor.read(b);
//              for (byte dados: b) {
//                  System.out.print((char)dados);
//              }
            int leitura;
            while ((leitura = leitor.read()) != -1) {
                byte b = (byte) leitura;
                System.out.println(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void leitorTunado() {
        try (BufferedInputStream leitor = new BufferedInputStream(new FileInputStream("pasta/stream.txt"))) {
//              byte[] b = new byte[25];
//              leitor.read(b);
//              for (byte dados: b) {
//                  System.out.print((char)dados);
//              }
           
            int leitura;
            while ((leitura = leitor.read()) != -1) {
                byte b = (byte) leitura;
                System.out.println(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
