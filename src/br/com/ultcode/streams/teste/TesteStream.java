package br.com.ultcode.streams.teste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.ultcode.streams.classes.Pessoa;

public class TesteStream {
	public static void main(String[] args) {
		List<Pessoa> listaPessoas = Pessoa.getList();
		List<String> result = listaPessoas
				.stream()
				.filter(p -> p.getIdade() < 25)
				.sorted(Comparator.comparing(Pessoa::getNome))
				.limit(3)
				.skip(1)
				.distinct()
				.map(Pessoa::getNome)
				.collect(Collectors.toList());
		result.forEach(System.out::println);
		
		List<List<String>> nomes = new ArrayList<>();
		nomes.add(Arrays.asList("Geraldão","Maluco bom"));
		nomes.add(Arrays.asList("Brabo","Formoso"));
		
		nomes.stream();    //Stream<List<String>> -> esse comando retorna isto
		
		//nomes.stream().flatMap(l -> l.stream()) // equivalente
		nomes.stream().flatMap(Collection::stream); // Usando esse método, ele retorna um Stream<String>
		
		List<String> AGORASIM = nomes
				.stream()
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
		System.out.println(AGORASIM);
		
		// O flat map serve para -> tenho um valor dentro do outro, quero extrair esse valores
		// flat -> achatar, ou seja, se tenho um array de 2 dimensões, achato em uma só
		
		// COMO CRIAR UMA LIST DE STRING POR CARACTERE?
		List<String> palavra = Arrays.asList("Ola","GEGE"); // agora a parte pica
		
		//Arrays.stream((String[])palavra.toArray()); // ISSO AQUI RETORNA UM STREAMM DE STREAM
		List<String> collect = palavra
				.stream()                    //retorna uma stream de string stream<String>
				.map(p -> p.split(""))		 // retorna uma stream de arrays de string Stream<String[]>
				.flatMap(Arrays::stream)	 // retorna uma stream de strings stream<String>
				.collect(Collectors.toList()); // coleta tuto!
		System.out.println(collect);
		
		// map -> é uma função que é aplicada para cada um dos elementos e vai retornar os valores
		// coletados em uma nova stream, trabalha os valores individuais
		// flatmap -> uma função que recebe uma stream e retorna uma stream de valores combinando
		// todos os valores, ou seja, extrai os valores de dentro de algum lugar
		// dale uma achatada nervousa
		
	}
}
