/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.polimorfismo.classes;

/**
 *
 * @author Geraldo
 */
public class Util {

    public static void relatorioPagamento(Funcionario funcionario) {
        System.out.println("Gerando relatorio de pagamento ");
        funcionario.calcularPagamento();
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Salario: " + funcionario.getSalario());
        if(funcionario instanceof Gerente){
            //cast normal, iremos usar a variavel de referencia para mais coisas
            Gerente g = (Gerente)funcionario;
            System.out.println("Participação nas vendas: " + g.getParticipacaoNoLucro());
        }
        if(funcionario instanceof Vendedor){
            //Cast direto
            //Quando só vamos utilizar o cast para uma execução
            System.out.println("Total de vendas: " + ((Vendedor)funcionario).getTotalVendas());
        }
    }
    
    public static void polimorfismoInterface(IGenericDAO generico){
        generico.save();
        System.out.println("Fazendo outras coisa compativeis com todas as classes que implementem a Interface IGenericDAO");
        generico.fecharConexão();
    }
}
