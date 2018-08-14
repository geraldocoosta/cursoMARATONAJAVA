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
public class Local {

    private String rua;
    private String bairro;

    public Local() {

    }

    public Local(String rua, String bairro) {
        this.rua = rua;
        this.bairro = bairro;
    }

    public void print() {
        System.out.println("\n================+++ Relatorio do Local +++================");
        System.out.println("Rua: " + this.rua);
        System.out.println("Bairro: " + this.bairro);
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

}
