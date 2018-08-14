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
public class Vendedor extends Funcionario {

    private double totalVendas;

    public Vendedor() {
    }

    public Vendedor(String nome, String clt, double salario, double totalVendas) {
        super(nome, clt, salario);
        this.totalVendas = totalVendas;
    }

    @Override
    public void calculaSalario() {
        double aux = this.getSalario();
        aux += (this.totalVendas * 0.05);
        this.setSalario(aux);
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }
    
    @Override
     public void imprime() {
        System.out.println(this.getNome());
    }

}
