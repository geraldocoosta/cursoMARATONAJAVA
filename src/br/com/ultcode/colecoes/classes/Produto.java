/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.colecoes.classes;

/**
 *
 * @author Geraldo
 */
public class Produto implements Comparable<Produto> {

    private String serialNumber;
    private double preco;
    private String nome;
    private int qtd;

    public Produto(String serialNumber, double preco, String nome) {
        this.serialNumber = serialNumber;
        this.preco = preco;
        this.nome = nome;
    }

    public Produto(String serialNumber, double preco, String nome, int qtd) {
        this.serialNumber = serialNumber;
        this.preco = preco;
        this.nome = nome;
        this.qtd = qtd;
    }

    @Override
    public String toString() {
        return "Produto{" + "serialNumber=" + serialNumber + ", preco=" + preco + ", nome=" + nome + ", qtd=" + qtd + '}';
    }

    @Override
    public int hashCode() {
        return serialNumber != null ? serialNumber.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        
        return serialNumber != null && serialNumber.equals(other.getSerialNumber());
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int compareTo(Produto outroObjeto) {
        // retorna int
        // int negativo esse objeto < que outro objeto
        // 0 se thisObject = outroObjeto
        // Positivo se esseObjeto > outroObjeto
        return this.nome.compareTo(outroObjeto.getNome());
    }

}
