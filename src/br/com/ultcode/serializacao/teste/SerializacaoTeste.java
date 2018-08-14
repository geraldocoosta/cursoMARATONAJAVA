/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.serializacao.teste;

import br.com.ultcode.serializacao.classe.Aluno;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Geraldo
 */
public class SerializacaoTeste {

    public static void main(String[] args) {
        gravarAluno();
        lerObjetoDeAluno();
    }

    private static void gravarAluno() {
        Aluno aluno = new Aluno(1, "Geraldo", "123456", "SISTEMAS");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ArquivoObjeto.ser"))) {
            oos.writeObject(aluno);
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void lerObjetoDeAluno() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ArquivoObjeto.ser"))) {
            Object obj = ois.readObject();
            Aluno aluno = null;
            if (obj instanceof Aluno) {
                aluno = (Aluno) obj;
            }
            System.out.println(aluno);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
