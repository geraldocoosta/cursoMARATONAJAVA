/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.colecoes.teste;

import br.com.ultcode.colecoes.classes.Produto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Geraldo
 */
public class IteratorTeste {

    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("1234", 2000.0, "Celular",0));
        produtos.add(new Produto("321", 50.0, "Ventilador",5));
        produtos.add(new Produto("525", 2500.0, "Notebook",8));
        produtos.add(new Produto("4488", 50.0, "Essencia",10));
        
        Iterator<Produto> iteratorProduto = produtos.iterator();
        //Para se utilizar o iterator, pode-se instancialo como váriavel de 
        //  referencia da classe Iterator<TipoQueEstaInterando>
        // Para instancialo, vocÇe utiliza um método de uma Collection iterator
        
        // O metodo has next pergunta se tem um proximo, se tiver, ele itera por ele
        while (iteratorProduto.hasNext()){
            // Metodo next retorna o objeto iterado
            Produto produto = iteratorProduto.next();
            if (produto.getQtd() == 0){
                //Remove da lista original
                iteratorProduto.remove();
            }
        }
        
        for(Produto p : produtos){
            System.out.println(p);
        }
        System.out.println(produtos.size());
            
    }
}
