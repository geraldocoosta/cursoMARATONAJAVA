/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.excecao.checkedexception.classes;

import java.io.Closeable;
import java.io.IOException;

/**
 *
 * @author Geraldo
 */
public class Leitor2 implements Closeable {

    @Override
    public void close() throws IOException {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Fechando leitor 2");
    }
    
}
