/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.serializacao.classe;


/**
 *
 * @author Geraldo
 */
public class Turma {
    private String nomeTurma;

    public Turma() {
    }

    
    
    public Turma(String nome) {
        this.nomeTurma = nome;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    @Override
    public String toString() {
        return "Turma{" + "nome=" + nomeTurma + '}';
    }

    
    
    
}
