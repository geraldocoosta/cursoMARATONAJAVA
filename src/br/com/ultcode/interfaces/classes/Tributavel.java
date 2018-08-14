/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.interfaces.classes;

/**
 *
 * @author Geraldo
 */
public interface Tributavel {
    // Todo método em uma interface é publico e abstrato
    // Todos atributos declarados em uma interface são constantes pubilcas
    // ou seja, public static final
    // todas constantes devem ser inicializadas na sua declaração
    double IMPOSTO = 0.2;
    void calculaImposto();
    
    static void calculaImposto2(){
        
    }
}
