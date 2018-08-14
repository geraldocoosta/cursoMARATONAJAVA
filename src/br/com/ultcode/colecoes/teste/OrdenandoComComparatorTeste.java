/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.colecoes.teste;

import br.com.ultcode.colecoes.classes.Produto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Geraldo
 */
class Ordenacao implements Comparator<Produto> {
    // Ao implementar a interface comparato, devemos implementar o método
    //    compare

    //Pra que serve essa interface? organizar uma collection ou um array de forma
    //  diferente a implementada na classe pela interface Comparable<t>
    // Não é uma boa praticar alterar o comparable na classe original. Por isso essa solução
    @Override
    public int compare(Produto o1, Produto o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}

public class OrdenandoComComparatorTeste {

    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("1234", 2000.0, "Celular"));
        produtos.add(new Produto("321", 50.0, "Ventilador"));
        produtos.add(new Produto("525", 2500.0, "Notebook"));
        produtos.add(new Produto("4488", 50.0, "Essencia"));
        // Para usarmos uma ordenação diferente da padrão estabelecida na classe produto
        // usamos como segundo argumento uma classe que implementa a interface comparator
        // e que compara objetos da classe produto.
        // Lembre-se, usamos a classe collections para ordenar
        Collections.sort(produtos, new Ordenacao()); // Ordena
        // Também podemos usar o método sort do objeto de uma ArrayList, passando uma 
        //  instancia de uma classe que implementa a interface comparator como argumento
        produtos.sort(new Ordenacao()); // Ordena também
        for(Produto p : produtos){
            System.out.println(p);
        }
        
        // Foi comentado também que pode-se ordenar arrays utilizando a classe Arrays
        //   porém estou com preguiça, é nois GEGE
        //Arrays.sort();
        
        //Método para pesquisa de objetos em um arrat ou Collaction
        // binarySearch, pra esse métdo ser consistente, ele deve ser ordenado
        // Formula -(ponto de inserção) - 1
        // caso tenha-se usado um comparetor na lista, deve-se usar um comparator no binarySearch
        Integer posicao = Collections.binarySearch(produtos, new Produto("12x4", 2000.0, "Sofá"),new Ordenacao());
        System.out.println();
        produtos.add(Math.abs(posicao)-1,new Produto("12x4", 2000.0, "Sofá"));
        
        for(Produto p : produtos){
            System.out.println(p);
        }
         
        // Se retornar um numero positivo, é o numero do indice que está o objeto/coisa que você está proucurando
        // Se retornar um numero negativo, é o indice em que pode se inserir esse objeto/coisa, mantendo ordenado
        // tendo em vista que -1 = indice 0
        //                    -2 = indice 1, assim por diante
        
        
        
        System.out.println(Collections.binarySearch(produtos, new Produto("12x4", 2000.0, "Sofá"),new Ordenacao()));
        
        
        //Conversão de Lista em Array, Array em Lista ta ligado né?
        // Só usar o método toArray em uma lista, em uma lista tu usa toList
        
        // Array para Lista
        // Temso que ter cuidado ao fazer isso, pois, o array e a lista ficam
        // alocados no mesmo local no heap
        //    ou seja, fez em um, alterou outro
        Produto[] produtos1 = new Produto[3];
        produtos1[0] = new Produto("5566s",1500,"TV");
        produtos1[1] = new Produto("55698",20,"Carvão");
        produtos1[2] = new Produto("88796",25.5,"Picanha");
        Arrays.sort(produtos1, new Ordenacao());
        List<Produto> produtinhos = Arrays.asList(produtos1);        
        for (Produto p : produtinhos){
          
            System.out.println(p);
        }
        
        // lista para Array
        Produto[] p1 = new Produto[produtinhos.size()];
        produtinhos.toArray(p1);
        System.out.println(Arrays.toString(p1));
    }

}
