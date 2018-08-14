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
public class ArquivoDAOImpl implements IGenericDAO{

    public ArquivoDAOImpl() {
        System.out.println("ArquivoDAOImpl");
    }

    
    @Override
    public void save() {
        System.out.println("Salvando em arquivo");
    }
    
}
