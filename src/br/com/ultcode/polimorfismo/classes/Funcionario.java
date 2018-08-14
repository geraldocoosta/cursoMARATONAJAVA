/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.polimorfismo.classes;

/**
 *
 * @author Geraldo
 */
public abstract class Funcionario {

    protected String nome;
    protected double salario;

    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", salario=" + salario + '}';
    }

    public Funcionario() {
    }

    
    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

   public abstract void calcularPagamento();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
