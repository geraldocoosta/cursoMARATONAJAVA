/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.interfaces.classes;

/**
 *
 * @author Geraldo
 */
public class Produto implements Tributavel, Transportavel {

    private String produto;
    private double peso;
    private double preco;
    private double precoFinal;
    private double valorFrete;

    public Produto(String produto, double peso, double preco) {
        this.produto = produto;
        this.peso = peso;
        this.preco = preco;
    }

    @Override
    public void calculaImposto() {
        this.precoFinal = this.preco + (this.preco * Tributavel.IMPOSTO);
    }

    @Override
    public void calculaFrete() {
        this.valorFrete = this.preco / this.peso * 0.1;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public double getValorFrete() {
        return valorFrete;
    }

    @Override
    public String toString() {
        return "Produto{" + "produto=" + produto + ", peso=" + peso + ", preco=" + preco + ", precoFinal com imposto="
                + precoFinal + ", valorFrete=" + valorFrete + '}';
    }

  

}
