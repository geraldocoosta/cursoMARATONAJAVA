/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.enumeracao.teste;

import br.com.ultcode.enumeracao.classes.Cliente;
import br.com.ultcode.enumeracao.classes.TipoCliente;

/**
 *
 * @author Geraldo
 */
public class EnumeracaoTeste {

    public static void main(String[] args) {

        Cliente cliente = new Cliente("GEGE", TipoCliente.PESSOA_JURIDICA);
        System.out.println(cliente);
        System.out.println(cliente.getTipoCliente().getId());
        
        System.out.println("================");
        Cliente cliente1 = new Cliente("PEDRO", TipoCliente.PESSOA_FISICA, Cliente.TipoPagamento.APRAZO);
        
        System.out.println(cliente1);
        System.out.println(cliente1.getTipoCliente().getId());
        
        TipoCliente tipoCliente;
        tipoCliente = TipoCliente.PESSOA_FISICA;
        System.out.println(tipoCliente.getTIPO());
         
    }
}
