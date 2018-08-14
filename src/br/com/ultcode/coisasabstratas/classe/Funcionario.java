/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.coisasabstratas.classe;

/**
 *
 * @author Geraldo
 */
public abstract class Funcionario extends Pessoa {
    
    private String clt;
    private double salario;

    public Funcionario() {
    }

    public Funcionario(String nome, String clt, double salario) {
        super(nome);
        this.clt = clt;
        this.salario = salario;
    }
    
    public abstract void calculaSalario();



    public String getClt() {
        return clt;
    }

    public void setClt(String clt) {
        this.clt = clt;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + this.getNome() + ", clt=" + clt + ", salario=" + salario + '}';
    }
    
    
    
    
}
