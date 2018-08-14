/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.resourcebundles.teste;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Geraldo
 */
public class ResourceBundlesTeste {

    public static void main(String[] args) {
//        System.out.println(Locale.getDefault());
        ResourceBundle rb = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));
        System.out.println(rb.getString("Bom.dia"));
        System.out.println(rb.getString("Ola"));
        System.out.println(rb.getString("show"));

        
        System.out.println("==================================================");
        
        rb = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        System.out.println(rb.getString("Bom.dia"));
        System.out.println(rb.getString("Ola"));
        System.out.println(rb.getString("show"));
//        System.out.println(rb.getString("algo"));
        
        // Locale locale = new Locale("fr","CA");
        // ResorceBundle.getBundle("messages",locale)
        
        // Se tivesse um resouceBundle assim o java ia
        //  1 = tentar buscar um arquivo chamado messages_fr_CA.properties
        //  2 - não encontrou, ele procura o messages_fr.properties
        //  3 - Não encontrou de novo, ele procura o messages com a localização 
        //    padrao da maquina (meu caso, messages_pt_BR.properties)
        //  4 - Se ainda não tiver, vai procurar somente com a lingua padrão
        //   (messages_pt.properties)
        //  5 - Caso não encontre, agora vai messages.properties
        // Se não tiver encontrado nenhum desses, exception MissingResourceException
    }

}
