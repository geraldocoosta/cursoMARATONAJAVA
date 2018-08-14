package br.com.ultcode.streams.teste;

import java.util.Comparator;
import java.util.List;

import br.com.ultcode.streams.classes.Pessoa;

public class TesteStream2 {
	public static void main(String[] args) {
		List<Pessoa> pessoas = Pessoa.getList();
		// -> anyMatch : verifica se algum elemento dentro dessa stream bate com o predicate passado
		System.out.println(pessoas.stream().anyMatch(p -> p.getSalario() > 4000.0));
		// verifica se todo mundo dentro dessa lista bate com o teste.
		System.out.println(pessoas.stream().allMatch(p -> p.getIdade() >= 12)); // todo mundo é maior ou igual a 18
																				// anos?
		// pergunta se nenhum elemento desse fluxo corresponde a tal criterio
		System.out.println(pessoas.stream().noneMatch(p -> p.getNome().equals(""))); // dentro dessa lista, nenhum
																						// elemento corresponde a equals
																						// ""?

		// usando optional com stream
		// retorna qualquer um que tiver menos de 25 anos, retornando optional
		// lembre-se q, ele retorna qualquer um, não tem garantia de qual vai vir
		pessoas.stream().filter(p -> p.getIdade() < 25).findAny().ifPresent(p -> System.out.println(p.getNome()));

		// O primeiro que ele encontrar, ele retorna
		pessoas.stream().filter(p -> p.getIdade() > 30).sorted(Comparator.comparing(Pessoa::getNome).reversed())
				.findFirst().ifPresent(p -> System.out.println(p.getNome()));

		// Depois do método compare.comparing(Function) pode-se usar o método reversed para buscar uma ordem reversa

		System.out.println(pessoas.stream().map(Pessoa::getIdade).reduce(0, (x, y) -> x + y));
	}
}
