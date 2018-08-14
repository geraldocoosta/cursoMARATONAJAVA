package br.com.ultcode.threads.teste;

import javax.swing.JOptionPane;

import br.com.ultcode.threads.classes.Entregador;
import br.com.ultcode.threads.classes.ListaMembros;

public class UtilizandoEntregador {
	public static void main(String[] args) {
		ListaMembros lm = new ListaMembros();
		Thread t1 = new Thread(new Entregador(lm), "Entregador 1");
		Thread t2 = new Thread(new Entregador(lm), "Entregador 2");
		t1.start();
		t2.start();
		while (true) {
			String email = JOptionPane.showInputDialog("Entre com o email");
			if (email == null || email.isEmpty()) {
				lm.fecharLista();
				break;
			}
			
			lm.adicionarEmailMembro(email);
		}
	}
}
