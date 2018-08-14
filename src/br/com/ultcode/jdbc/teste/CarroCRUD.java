package br.com.ultcode.jdbc.teste;

import java.util.List;
import java.util.Scanner;

import br.com.ultcode.jdbc.classes.Carro;
import br.com.ultcode.jdbc.classes.Comprador;
import br.com.ultcode.jdbc.db.CarroDAO;
import br.com.ultcode.jdbc.db.CompradorDAO;

public class CarroCRUD {
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
			System.out.println("Digite o nome do carro");
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
		Carro c = new Carro();
		System.out.println("Nome veiculo: ");
		c.setNome(teclado.nextLine());
		System.out.println("Placa veiculo: ");
		c.setPlaca(teclado.nextLine());
		System.out.println("Selecione um comprador: ");
		List<Comprador> compradorList = CompradorDAO.selectAll();
		for (int i = 0; i < compradorList.size(); i++) {
			Comprador comprador = compradorList.get(i);
			System.out.println("[" + i + "]" + comprador.getNome() + " : " + comprador.getCpf());
		}
		c.setComprador(compradorList.get(Integer.parseInt(teclado.nextLine())));
		CarroDAO.save(c);
	}

	private static void atualizar() {
		System.out.println("Selecione um dos carroes abaixo");
		List<Carro> CarroList = listar();
		Carro c = CarroList.get(Integer.parseInt(teclado.nextLine()));
		System.out.println("Novo nome ou enter para manter o mesmo");
		String nome = teclado.nextLine();
		System.out.println("Nova placa ou enter para manter o mesmo");
		String placa = teclado.nextLine();
		System.out.println("Novo comprador ou enter para manter o mesmo");
		List<Comprador> compradorList = CompradorDAO.selectAll();
		for (int i = 0; i < compradorList.size(); i++) {
			Comprador comprador = compradorList.get(i);
			System.out.println("[" + i + "]" + comprador.getNome() + " : " + comprador.getCpf());
		}
		String escolhaComprador = teclado.nextLine();
		if (!nome.isEmpty()) {
			c.setNome(nome);
		}
		if (!placa.isEmpty()) {
			c.setPlaca(placa);
		}
		if (!escolhaComprador.isEmpty()) {
			int aux = Integer.parseInt(escolhaComprador);
			c.setComprador(compradorList.get(aux));
		}
		CarroDAO.update(c);
	}

	private static void deletar() {
		System.out.println("Selecione um dos Carroes abaixo");
		List<Carro> CarroList = listar();
		Carro c = CarroList.get(Integer.parseInt(teclado.nextLine()));
		System.out.println("Tem certeza? S/N");
		String confirmacao = teclado.nextLine();
		if (confirmacao.equalsIgnoreCase("s"))
			CarroDAO.delete(c);
	}

	private static List<Carro> listar() {
		List<Carro> CarroList = CarroDAO.selectAll();
		for (int i = 0; i < CarroList.size(); i++) {
			Carro c = CarroList.get(i);
			System.out.printf("[%d] \t%10s %10s : dono: %5s%n",i,c.getNome(),c.getPlaca(),c.getComprador().getNome());
		}
		return CarroList;
	}

	private static void listarPorNome(String nome) {
		List<Carro> CarroList = CarroDAO.searchByName(nome);
		for (int i = 0; i < CarroList.size(); i++) {
			Carro c = CarroList.get(i);
			System.out.printf("[%d] \t%10s %10s : dono: %5s%n",i,c.getNome(),c.getPlaca(),c.getComprador().getNome());
		}
	}
}
