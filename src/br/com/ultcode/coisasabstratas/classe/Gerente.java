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
public class Gerente extends Funcionario {

    public Gerente(String nome, String clt, double salario) {
        super(nome, clt, salario);
    }

    @Override
    public void calculaSalario() {
        double aux = this.getSalario();
        aux += (aux * 0.2);
        this.setSalario(aux);
    }

    @Override
    public void imprime() {
        System.out.println(this.getNome());
    }

}
