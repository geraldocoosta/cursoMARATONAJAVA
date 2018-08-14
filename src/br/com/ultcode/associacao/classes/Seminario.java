/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.associacao.classes;

/**
 *
 * @author Geraldo
 */
public class Seminario {

    private String titulo;
    private Local local;
    private Professor professor;
    private Aluno[] alunos;

    public Seminario(String titulo) {
        this.titulo = titulo;
    }

    public Seminario() {
    }

    public void print() {
        System.out.println("\n================+++ Relatorio do Seminario +++================");
        System.out.println("Titulo: " + this.titulo);

        if (professor != null) {
            System.out.println("Professor palestrante: " + this.professor.getNome());
        } else {
            System.out.println("Sem professor palestrante");
        }

        if (local != null) {
            System.out.println("Local: rua: " + this.local.getRua() + " Bairro: " + this.local.getBairro());
        } else {
            System.out.println("Sem local definido");
        }

        if (alunos != null && alunos.length != 0) {
            System.out.println("Alunos participante: ");
            for (Aluno aluno : alunos) {
                System.out.println("\t" + aluno.getNome());
            }
        } else {
            System.out.println("Sem alunos participantes");
        }
    }

    public String getTitulo() {
        return titulo;
    }

    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno[] alunos) {
        this.alunos = alunos;
    }

   
}
