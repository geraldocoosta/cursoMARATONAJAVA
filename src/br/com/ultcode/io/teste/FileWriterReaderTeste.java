/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.io.teste;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Geraldo
 */
public class FileWriterReaderTeste {

    public static void main(String[] args) {
        File file = new File("arquivo.txt");

        //Obs.: Se você instanciar um arquivo que não existe na classe FILE
        // e depois instanciar um FileWrite passando esse arquivo, ele será
        // criado automaticamente!!!
        
        try (FileWriter fw = new FileWriter(file);
                FileReader fr = new FileReader(file)) {

            // metodo write da classe *FileWriter*
            //  escreve no arquivo. Qual arquivo? o que foi passado no construtor
            //  quando instanciamos a classe
            fw.write("Escrevendo outra baboseira qualquer\r\nTeste pula linha");

            // metodo flush da classe *FileWriter*
            //  Quando chamamos o método write, temos que chamar em seguida
            //  Esse método para descarregar tudo que está no write para o 
            //  arquivo, basicamente garante que não perca nada.
            fw.flush();

            char[] in = new char[500];

            //Metodo read da classe *fileReader*
            // Le um aquivo, qual arquivo? O que foi passado no construtor 
            // quando instanciamos a classe
            // Devemos passar um array para que o método o popule com o texto
            // do aquivo
            // Retorna um inteiro com o tamanho do arquivo (quantos caracteres 
            // tem)
            int size = fr.read(in);

            System.out.println(size + "\n");

            for (char a : in) {
                System.out.print(a);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

//obs.: FILEWRITER
// contrutor pode recebe o arquivo e também o
// contrutor é sobrecarregado, se passar umm segundo argumento informando um
// boolean, pode-se dizer se o que vai ser escrito vai ser por cima ou depois
// por padrão é false

//obs.2:
//Devemos chamar o método close(), tando para a classe FileWriter como para
// FileReader, porém estamos usando Try-with-resources, a jvm se encarrega de 
// fechase automaticamente