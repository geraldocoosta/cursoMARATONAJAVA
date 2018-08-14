package br.com.ultcode.padroesdeprojetostrategy.teste;

import br.com.ultcode.padroesdeprojetostrategy.classes.Cargo;
import br.com.ultcode.padroesdeprojetostrategy.classes.Funcionario;
import br.com.ultcode.padroesdeprojetostrategy.classes.Venda;

public class TesteStrategy {
	public static void main(String[] args) {
		Funcionario func1 = new Funcionario("JOÃO", 2000, Cargo.VENDEDOR);
		Funcionario func2 = new Funcionario("MARIA", 3000, Cargo.GERENTE);
		Funcionario func3 = new Funcionario("RODOLFO", 1100, Cargo.ATENDENTE);
		
		Venda venda = new Venda(func1,2000.0);
		System.out.printf("Venda do funcionario %s foi de %.2f com comissão de %.2f%n",func1.getNome(),
				venda.getValorVenda(), venda.calcularComissao());
		venda = new Venda(func2,5000.0);
		System.out.printf("Venda do funcionario %s foi de %.2f com comissão de %.2f%n",func2.getNome(),
				venda.getValorVenda(), venda.calcularComissao());
		venda = new Venda(func3,500.0);
		System.out.printf("Venda do funcionario %s foi de %.2f com comissão de %.2f%n",func3.getNome(),
				venda.getValorVenda(), venda.calcularComissao());
		
	}
}
