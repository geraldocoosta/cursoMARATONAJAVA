/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.heranca.classes;

public class Funcionario extends Pessoa {

    private double salario;

    static {
        System.out.println("Bloco de inicialização static funcionario");
    }
    
    {
        System.out.println("Bloco de inicialização normal funcionario");
    }

    public Funcionario(String nome, String cpf, Endereco endereco, double salario) {
        super(nome, cpf, endereco);
        this.salario = salario;
    }

    public Funcionario() {
        System.out.println("Construtor funcionario");
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public void imprime() {
        super.imprime();
        System.out.println("Salario: " + this.salario);
    }
    
    @Override
    public String toString(){
        String aux = super.toString();
        aux += "\nSalario: " + this.salario;
        return aux;
    }
    

}
