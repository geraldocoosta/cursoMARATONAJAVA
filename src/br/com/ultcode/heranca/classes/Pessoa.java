/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.heranca.classes;

/**
 *
 * @author Geraldo
 */
public class Pessoa {

    private String nome;
    private String cpf;
    private Endereco endereco;
    

    static {
        System.out.println("Bloco de inicialização static Pessoa");
    }

    {
        System.out.println("Bloco de inicialização Pessoa 1");
    }

    public Pessoa() {
        System.out.println("Construtor Pessoa");
    }

    public Pessoa(String nome, String cpf, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public void imprime() {
        System.out.println("Nome: " + this.nome);
        System.out.println("cpf: " + this.cpf);
        if (endereco != null) {
            System.out.println("Endereco: rua: " + this.endereco.getRua() + " bairro: " + this.endereco.getBairro());
            return;
        }
        System.out.println("Não há endereço para essa pessoa");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        if (this.endereco != null) {
            return "Nome: " + this.nome + "\nCpf: " + this.cpf + "\nEndereco: "
                    + this.endereco;
        } else {
            return "Nome: " + this.nome + "\nCpf: " + this.cpf;
        }
    }

    

}
