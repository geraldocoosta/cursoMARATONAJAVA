/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.serializacao.classe;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Geraldo
 */
public class Aluno implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1150740937941753974L;
	private long id;
    private String nome;
    private transient String senha;
    private static String nomeEscola = "Faciplac";
    private transient Turma turma;

    public Aluno(long id, String nome, String senha, String turma) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.turma = new Turma(turma);

    }
    
    private void writeObject(ObjectOutputStream oos){
        try{
            oos.defaultWriteObject();
            oos.writeUTF(turma.getNomeTurma());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private void readObject(ObjectInputStream ois){
        try{
            ois.defaultReadObject();
            turma = new Turma(ois.readUTF());
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public static String getNomeEscola() {
        return nomeEscola;
    }

    public static void setNomeEscola(String nomeEscola) {
        Aluno.nomeEscola = nomeEscola;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Aluno{" + "id=" + id + ", nome=" + nome + ", senha=" + senha
                + ", Escola=" + nomeEscola + ", Turma=" + turma.getNomeTurma() + '}';
    }

}
