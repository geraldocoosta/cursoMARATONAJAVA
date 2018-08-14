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
public class Professor {

    private String nome;
    private String especializacao;
    private Seminario[] seminarios;

    public Professor() {
    }

    public Professor(String nome, String especializacao) {
        this.nome = nome;
        this.especializacao = especializacao;
    }

    public void print() {
        System.out.println("\n================+++ Relatorio do Professor +++================");
        System.out.println("Nome do professor: " + this.nome);
        System.out.println("Especialização: " + this.especializacao);

        if (seminarios != null && seminarios.length != 0) {
            System.out.print("Seminario Participantes: ");
            for (Seminario sem : this.seminarios) {
                System.out.println(sem.getTitulo() + " ");
            }
            return;
        }
        System.out.println("Professor não inscrito em nenhum seminario");
    }

    public String getNome() {
        return nome;
    }

   
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public String getEspecializacao() {
        return especializacao;
    }

    
    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public Seminario[] getSeminarios() {
        return seminarios;
    }

    public void setSeminarios(Seminario[] seminarios) {
        this.seminarios = seminarios;
    }

}
