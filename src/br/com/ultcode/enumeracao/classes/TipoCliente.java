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
public enum TipoCliente {
    //constant specific class body
    PESSOA_FISICA(1){
        @Override
        public String getId(){
            return "A";
        }
    },PESSOA_JURIDICA(2);
    
    private final int TIPO;

    
    public String getId(){
        return "B";
    }
    
    private TipoCliente(int tipo) {
        this.TIPO = tipo;
    }

    public int getTIPO() {
        return this.TIPO;
    }
    
    
}
