/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.excecao.checkedexception.classes;

import java.io.CharConversionException;

/**
 *
 * @author Geraldo
 */
public class SobrescritaMetodoComException2 extends SobrescritaMetodoComException1 {
    
    //Posso sobrescrever:
    //colocando, ou uma exceção q esteja lá, ou todas elas, ou 
    //uma exceção filha de alguma exceção declarada no throws do metodo da superclasse
    //ou filhas de runtimeExceptin incluindo ela
    //Se o metodo~não for sobrescrito explicitamente, ele herda todos os throws
    //
    //Não posso colocar: 
    //subclasse de uma exceção declara no throws do metodo da superclasse
    //mais exceções no metodo

    public void testeSobrescritaException() throws CharConversionException, LoginInvalidException{

    }

}
