/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.colecoes.classes;


/**
 *
 * @author Geraldo
 */
public class Celular {

    private String nome;
    private String IMAI;

    public Celular(String nome, String IMAI) {
        this.nome = nome;
        this.IMAI = IMAI;
    }
    
    public Celular() {
     }

    //Reflexivo = x.equals(x) deve ser true para tudo que for diferente de null
    //Simétrica = para x e y diferente de null, se x.equals(y) = true logo y.equals(x) = true;
    //Transitividade = dado x, y e z diferentes de null, se x.equals(y) = true logo y.equals(y) = true
    //   se x.equals(z) = true, y.equals(z) também é true
    //Consistencia, x.equals(y) deve sempre retornar o mesmo valor
    // Para x diferente de null, x.equals(null) deve retornar false;
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Celular otherCelular = (Celular) obj;
        return this.IMAI != null && this.IMAI.equals(otherCelular.getIMAI());
    }
    
    //Regras para o hashCode
    // Se x.equals(y) for true, y.hashCode == x.hashCode
    // y.hashCode == x.hashCode for true não significa que os objetos são iguais
    // se y.hashCode != de x.hashCode, x.equals(y) deverá ser false
    // 
    
    
    @Override
    public int hashCode() {
        return IMAI != null ? IMAI.hashCode() : 1;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIMAI() {
        return IMAI;
    }

    public void setIMAI(String IMAI) {
        this.IMAI = IMAI;
    }

    @Override
    public String toString() {
        return "Celular{" + "nome=" + nome + ", IMAI=" + IMAI + '}';
    }

    
}
