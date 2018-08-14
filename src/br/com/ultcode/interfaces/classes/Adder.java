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
import java.util.List;

public interface Adder {

    void add(Number value);

    Number getTotal();

    void setTotal(Number initValue);

    void reset();

    default void add(Adder adder) {
        add(adder.getTotal());
    }
    
    static void add(Adder adder, List<Number> list) {
    list.stream().forEach((value)->{ adder.add(value); });
}

}
