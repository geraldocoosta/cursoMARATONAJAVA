/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.enumeracao.classes;

/**
 *
 * @author Geraldo
 */
public class Cliente {

    public enum TipoPagamento {
        AVISTA, APRAZO;

    }

    private String nome;
    private TipoCliente tipoCliente;
    private TipoPagamento tipoPagamento;

    public Cliente(String nome, TipoCliente tipoCliente) {
        this.nome = nome;
        this.tipoCliente = tipoCliente;
    }

    public Cliente(String nome, TipoCliente tipoCliente, TipoPagamento tipoPagamento) {
        this.nome = nome;
        this.tipoCliente = tipoCliente;
        this.tipoPagamento = tipoPagamento;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

//    @Override
//    public String toString() {
//        if (this.tipoPagamento == null) {
//            return "Cliente{" + "nome='" + nome + "', tipoCliente='" + tipoCliente + "'}";
//        } else {
//            return "Cliente{" + "nome=" + nome + ", tipoCliente=" + tipoCliente + ", tipoPagamento=" + tipoPagamento + '}';
//        }
//    }
    @Override
    public String toString() {
        if (this.tipoPagamento != null) {

            return "Cliente: " + this.nome + "\nTipo Cliente: " + this.tipoCliente + "\nNumero Tipo Cliente: "
                    + tipoCliente.getTIPO() + "\nTipo Pagamento: " + this.tipoPagamento;
        } else {
            return "Cliente: " + this.nome + "\nTipo Cliente: " + this.tipoCliente + "\nNumero Tipo Cliente: "
                    + tipoCliente.getTIPO();
        }
    }

}
