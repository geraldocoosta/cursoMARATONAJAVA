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
public interface IGenericDAO {
    public abstract void save();
    
    default void fecharConexão(){
        System.out.println("Fechando conexão");
    }
}
