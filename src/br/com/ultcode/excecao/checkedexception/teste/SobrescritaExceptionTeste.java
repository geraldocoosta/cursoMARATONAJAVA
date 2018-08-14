/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.excecao.checkedexception.teste;

import br.com.ultcode.excecao.checkedexception.classes.SobrescritaMetodoComException1;
import br.com.ultcode.excecao.checkedexception.classes.SobrescritaMetodoComException2;
import java.io.CharConversionException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Geraldo
 */
public class SobrescritaExceptionTeste {

    public static void main(String[] args) {

        SobrescritaMetodoComException1 teste = new SobrescritaMetodoComException1();
        SobrescritaMetodoComException2 teste2 = new SobrescritaMetodoComException2();
        
        try {
            teste2.testeSobrescritaException();
        } catch (Exception ex) {
            Logger.getLogger(SobrescritaExceptionTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
