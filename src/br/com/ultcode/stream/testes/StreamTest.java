package com.ultcode.stream.testes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.ultcode.stream.classes.Pessoa;

public class StreamTest {
	public static void main(String[] args) {
		List<Pessoa> listaPessoa = Pessoa.bancoDePessoas();

		// Forma dificil, sem java 8 => isso tudo pra pegar as 3 pessoas com menos de 25 anos
		listaPessoa.sort(new Comparator<Pessoa>() {
			@Override
			public int compare(Pessoa o1, Pessoa o2) {
				return ((Integer) o1.getIdade()).compareTo(o2.getIdade());
			}
		});
		List<String> nomes3PrimeirasPessoas = new ArrayList<>();
		for (Pessoa p : listaPessoa) {
			if (p.getIdade() < 25) {
				nomes3PrimeirasPessoas.add(p.getNome());
			}
			if (nomes3PrimeirasPessoas.size() >= 3)
				break;
		}
		System.out.println(nomes3PrimeirasPessoas);

		// Forma Simples
		nomes3PrimeirasPessoas = listaPessoa
				.stream() // retorna stream
				.filter(p -> p.getIdade() < 25) // filtrando, aceita um predicate, ou seja, um lambda																				
				.sorted(Comparator.comparing(Pessoa::getNome)) // compara, aceita um comparator, o comparator tem o método novo chamado comparing(default) que compara por um atributo
				.limit(3) // Limitando o retorno a 3
				.map(p -> p.getNome()) // map. aceita funcion, ou seja, ele pega a stream e retorna outra coisa
				.collect(Collectors.toList()); // Aqui é mais embaixo, mas coletou a lista e retornou pra lista usando uma constante, terminal
												
		// Existem dois tipos de métodos de stream	
		// intermediate -> intermediario -> todos os métodos desse tipo retornou um objeto stream, permitindo encadear vários métodos!
		// os métodos intermediate não vão fazer nenhum tipo de processamento até que uma operação terminal seja invocada em um stream
		// pq o encadeamento são do tipo lazy(preguiça em hebraico), pq elas podem sofrer um merge, ou seja, ser mesclada e processadas
		// em um unico passo pela operação terminal
		// terminal -> final -> retorna um valor que não é um stream
		
		System.out.println(nomes3PrimeirasPessoas);
		
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// Outros métodos uteis
		System.out.println(listaPessoa
		.stream()
		.distinct() // -> retorna pessoas distintas, de acordo com o hash e equals
		.filter(p -> p.getIdade() < 25) 																
		.map(p -> p.getNome()) 
		.count()); //-> retorna o total, terminal
		
		listaPessoa.stream().forEach(System.out::println); // -> para mostrar todas as pessoas, iterar pela collection, método terminal
	}
}
