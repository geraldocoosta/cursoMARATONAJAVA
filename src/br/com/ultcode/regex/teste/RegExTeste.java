/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultcode.regex.teste;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Geraldo
 */
public class RegExTeste {

    public static void main(String[] args) {
        
        // \d = metacaractere q retorna apenas os digitos [0-9]
        // \D = tudo o q não for digito [^0-9]
        // \s = procura por espaços em branco \t \n \f \r
        // \S = caractere que não é branco
        // \w  (w minusculo)= retorna caracteres de palavras a - z A - Z digitos e _
        // \W = tudo que não é carctere de palavra
        // [] - da pra colocar pra achar A ou B ou C assim [A-C]
        // ? - 0 ou 1
        // * - o ou mais
        // + - 1 ou mais
        // {n,m} - customizavel de até m
        // {n} - apenas n
        // {n,} - de n ao infinito
        // () = agrupar expressão
        // | - OU
        // $ - Fim de linha
        // ^ - Começo de linha ou negação
        // . - coringa ex regex =  "1.3" , pode casar com "123 133 1#3 1.3 1 3"
        
        
        //encontrando exadecimal em um texto
        String padrao = "0[xX]([0-9a-fA-F])+(\\s|$)";
        String texto = "0x00ff0f 0x 0x185ggh 0x125ff 0xabf";
        
        //encontrando email em um texto
//        String padrao2 = "([A-Za-z1-9\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
        String padrao2 = "([\\w\\.-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";

        String texto2= "geraldocoosta@gmail.com 23/05/1997 125g oitudobom@hotmail.com"
                + " abraao@meil. teste@gmail.dot mail@mail fulano@coisa.com.br";
        
        //Encontrando hora em um texto
        String padrao3 = "[0-2][0-9](:|-|\\.)[0-5][0-9]";
        String texto3 = "23:52 55:55 23-05 01 01 01:01";
        
        //Encontrando data em um texto
        String padrao4 = "\\d{1,2}/\\d{1,2}/\\d{2,4}";
        String texto4 = "05/05/2015 05/5/2013 1/1/01 01/05/95 1/1/1"; // dd/MM/yyyy
        
        
    //===================================================================================    
        
        //devemso compilar o padrão a ser buscado em um texto
        // pattern = padrão
        Pattern pattern = Pattern.compile(padrao4);
        
        //matcher = combinar = usa o padrão para encontrar esse padrão em alguma fonte
        // de texto
        Matcher matcher = pattern.matcher(texto4);
        System.out.println("Texto:  " + texto4 );
        System.out.println("Indice: 0123456789");
        // metodo que mostra qual padrão ele vai o objeto matcher vai procurar
        System.out.println("Expressão: " + matcher.pattern());
        System.out.println("posições encontradas: " );
        
        //enquanto achar correspondentes (MEMORIZAR ESSA PORRA MEO)
        // Assim é ativado o motor de busca
        while(matcher.find()){
            //matcher start - indice inicial de quando achar algo
            //matcher group - tras o grupo q encontrou
            //matcher end - indice final (um indice dps do caractere final)
            System.out.println(matcher.start() + " \t " + matcher.group() + "  \t "
            + matcher.end());
        } 
        
        //Para validar uma string de acordo com um regex, podemos usar o metodo 
        // matches da String ou da Pattern
        // Ex:
        
        System.out.println("Email valido? " + "mail@mail.com.br".matches(padrao2));
        
        System.out.println();
    }

}

/*
Seguem anotações sobre o assunto feitas (principalmente) ao longo das 
aulas, dúvidas nos comentários e alguma pesquisa:

MODIFICADORES:
    (?i)    - Ignora maiúsulas e minúsculas.
    (?x)    - Comentários.
    (?m)    - Multilinhas.
    \x      - Fuga literal.
 
  obs:   Para utilizar o caractere "\" na expressão (sem valer como caractere 
de escape e sim como o caractere de texto normal) usar "\\x{005C}", onde "\\x" 
é para "\x" e "{005C}" é o código hexadecimal no padrão Unicode para "\". Também
pode-se usar "\\u005C". Mais detalhes e opções nas observações dos metacaracteres.


 
    METACARACTERES:
    \b       - Limite de palavras (entre o fim da palavra e um espaço ou etc.).
    \d       - Todos os dígitos.
    \D       - Tudo o que não for dígito.
    \s       - Espaços em branco (\t , \n , \f , \r, " ").
    \S      - Carecteres que não são espaço em branco.
    \w      - Caracteres de palavras (a-z , A-Z , dígitos , "_").
    \W     - Tudo o que não for caractere de palavra.
    .         - Qualquer caractere.
  
    ()       - Usado para agrupar uma expressão (ou parte de uma).
    -        - Usado para indicar range (intervalo).
    |        - Usado para indicar o operador lógico "ou" (lembrar do "||").
    $      - Usado para indicar fim de linha (o final da String sendo analisada).
    ^       - Usado para indicar começo de linha (o começo da String sendo analisada).

  
  obs:   Como o caractere "\" usado pelos metacaracteres é um caractere de 
escape do Java, ao utilizar um metacaractere em uma expressão regular é 
necessário adicionar um "\" extra. Ex: \\d
  

  obs:   O metacaractere "^" é um metacaractere de fronteira nesse contexto.
  

  obs:   Indicação de range (intervalo): [1-9] , [a-d], [A-Z]

  
  obs:   Quando se quer utilizar um caractere com significado especial nas 
expressões regulares sem esse significado especial, ou seja, como um caractere 
de texto ordinário (escaping characteres),pode-se:

           - Usar o caractere de escape "\", adicionando-o antes do caractere em 
questão (por ser caractere de escape tanto para literais Strings no Java quanto 
para as expressões regulares, dobrasse o caractere de escape). Ex: \\.

           - Usar "\\Q" e "\\E" para delimitar a área de caracteres que se quer 
considerar com o significado ordinário. Ex: \\Q$\\E

           - Usar o método "Pattern.quote(String s)" passando como parâmetros 
os metacaracteres que deseja-se fazer o escape (ele vai considerar qualquer 
caractere passado com o valor de um caractere ordinário).

           - Usar "\\x{Hexadecimal}" ou "\\uHexadecimal" passando-se o 
código hexadecimal do caractere desejado no padrão Unicode no lugar do 
"Hexadecimal". O valor hexadecimal que corresponde a determinado caractere 
pode ser facilmente encontrado na internet.
  
  
  AGRUPAMENTOS:
    [...]                     - Qualquer um dos caracteres que estejam dentro dos colchetes.
    [a-z]                     - Qualquer caractere de "a" a "z".
    [a-z&&[a-e]]              - Intersecção (nesse caso, de "a" a "e").
    [a-e][p-z]                - Sequência (de "a" a "e" seguido de "p" a "z").
    [^a-e]                    - Exceção (qualquer valor, exceto estes).
    [a-z&&[^e-q]]             - Subtração (qualquer valor do primeiro intervalo menos os do
                                segundo intervalo).
  

  obs: O "^" é um metacaractere de negação nesse contexto.
  
  
  QUANTIFICADORES:
    ?               - Zero ou uma ocorrência.
    *               - Zero ou mais ocorrências.
    +               - Uma ou mais ocorrências.
    {n}             - Exatamente "n" ocorrências.
    {n, }           - Pelo menos "n" ocorrências.
    {n, m}          - De "n" até "m" ocorrências.
  
obs: Quantificadores são colocados logo após o elemento, 
agrupamento ou metacaractere o qual se deseja especificar a quantidade. 
Ex: \\d{3} , 3? , [age]+ , (ad|da)*﻿




*/
