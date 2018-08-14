/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.excecao.checkedexception.classes;

/**
 *
 * @author Geraldo
 */
public class LoginInvalidException extends Exception {

    public LoginInvalidException() {
        super("Foi digitado algum campo invalido");
    }

}
