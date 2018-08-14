/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.modificadorfinal.classes;

public final class Carro {

    private String nome;
    private final double VELOCIDADE_LIMITE = 240;
    private final Comprador comprador;
    private static final double VELOCIDADE_MAXIMA;

    public Carro() {
        comprador = new Comprador();
    }
    
    static{
        VELOCIDADE_MAXIMA = 240;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Comprador getComprador() {
        return comprador;
    }
    
    
}
