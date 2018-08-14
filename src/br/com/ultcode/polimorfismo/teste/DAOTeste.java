/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.polimorfismo.teste;

import br.com.ultcode.polimorfismo.classes.ArquivoDAOImpl;
import br.com.ultcode.polimorfismo.classes.DatabaseDAOImpl;
import br.com.ultcode.polimorfismo.classes.IGenericDAO;
import br.com.ultcode.polimorfismo.classes.Util;


/**
 *
 * @author Geraldo
 */
public class DAOTeste {
    public static void main(String[] args) {
        IGenericDAO generico = new ArquivoDAOImpl();
        Util.polimorfismoInterface(generico);        
        System.out.println("\t===================================");
        IGenericDAO generico2 = new DatabaseDAOImpl();
        Util.polimorfismoInterface(generico2);
    }
    
}
