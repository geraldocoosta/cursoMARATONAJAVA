/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.io.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author Geraldo
 */
public class BufferedTeste {

    //Estou codificando sem usar o try with resource
    // Repare o quanto é exaustivo fechar todos os objetos
    //  Em outra classe, implementei usando Try With Resources para simplificar
    public static void main(String[] args) {
        File file = new File("Arquivo.txt");
        FileWriter fw;
        FileReader fr;
        BufferedWriter bw = null;
        BufferedReader br = null;
        try {

            //Escrevendo em arquivo usando BufferedWriter
            // Lembre-se que: BufferedWriter recebe um objeto de algum Writer
            //  FileWriter recebe um objeto file, ou um caminho de um arquivo
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write("Qualquer coisa, testando rapidin");
            bw.newLine();
            bw.write("Teste para verificar se o bufferedWriter pula linha");
            bw.flush();

            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            
            /*
             Se um arquivo for lido por um fileReade ou um BufferedReader, ele
            não pode ser lido novamente por aquele BufferedReader ou um
            FileReader que esteja encadeado. Como ele já foi lido, irá retornar
            -1
            
            Código comentado abaixo deixa de funcionar pois o arquivo já foi lido
            pelo BufferedReader acima!!!
            */
          
//            System.out.println();
//            char[] in = new char[500];
//            int size = fr.read(in);
//            System.out.println(size);
//            for (char caractere : in) {
//                System.out.print(caractere);
//            }
            System.out.println();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            //Quando chamamos essas classes encadeadas só precisamos executar 
            // O metodo close da classe mais externa, esta se encarrega de 
            //  fechar a classe mais internar
            // Ex.: chamei o metodo close da classe BufferedWriter, este, por sua
            //  vez, chama o close da classe FileWriter
            // CLASSE FILE NÃO TEM MÉTODOO CLOSE!!!!!!!
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        System.out.println();
        Date date = new Date(file.lastModified());
        DateFormat df = DateFormat.getInstance();
        System.out.println("Ultima modificação no arquivo: " + df.format(date));
    }
}
