package br.com.ultcode.jdbc.teste;

import java.util.List;
import java.util.Scanner;

import br.com.ultcode.jdbc.classes.Comprador;
import br.com.ultcode.jdbc.db.CompradorDAO;

public class CompradorCRUD {
	private static Scanner teclado = new Scanner(System.in);

	protected final static void executar(int op) {
		switch (op) {
		case 1:
			inserir();
			break;
		case 2:
			atualizar();
			break;
		case 3:
			listar();
			break;
		case 4:
			System.out.println("Digite o nome");
			listarPorNome(teclado.nextLine());
			break;
		case 5:
			deletar();
			break;
		case 9:
			break;
		default:
			System.out.println("Digite um valor valido");
			break;
		}
	}

	private static void inserir() {
		Comprador c = new Comprador();
		System.out.println("Nome: ");
		c.setNome(teclado.nextLine());
		System.out.println("Cpf: ");
		c.setCpf(teclado.nextLine());
		CompradorDAO.save(c);
	}

	private static void atualizar() {
		System.out.println("Selecione um dos compradores abaixo");
		List<Comprador> compradorList = listar();
		Comprador c = compradorList.get(Integer.parseInt(teclado.nextLine()));
		System.out.println("Novo nome ou enter para manter o mesmo");
		String nome = teclado.nextLine();
		System.out.println("Novo cpf ou enter para manter o mesmo");
		String cpf = teclado.nextLine();
		if (!nome.isEmpty()) {
			c.setNome(nome);
		}
		if (!cpf.isEmpty()) {
			c.setCpf(cpf);
		}
		CompradorDAO.update(c);
	}

	private static void deletar() {
		System.out.println("Selecione um dos compradores abaixo");
		List<Comprador> compradorList = listar();
		Comprador c = compradorList.get(Integer.parseInt(teclado.nextLine()));
		System.out.println("Tem certeza? S/N");
		String confirmacao = teclado.nextLine();
		if (confirmacao.equalsIgnoreCase("s"))
			CompradorDAO.delete(c);
	}

	private static List<Comprador> listar() {
		List<Comprador> compradorList = CompradorDAO.selectAll();
		for (int i = 0; i < compradorList.size(); i++) {
			Comprador c = compradorList.get(i);
			System.out.println("[" + i + "]" + c.getNome() + " : " + c.getCpf());
		}
		return compradorList;
	}

	private static void listarPorNome(String nome) {
		List<Comprador> compradorList = CompradorDAO.searchByName(nome);
		for (int i = 0; i < compradorList.size(); i++) {
			Comprador c = compradorList.get(i);
			System.out.println("[" + i + "]" + c.getNome() + " : " + c.getCpf());
		}
	}
}
