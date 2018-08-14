package br.com.ultcode.concorrencia.test;

import javax.swing.JOptionPane;

import br.com.ultcode.concorrencia.classes.Entregador;
import br.com.ultcode.concorrencia.classes.ListaMembros;

public class EntregadorConditionTest {
	public static void main(String[] args) {
		ListaMembros lm = new ListaMembros();
		Thread t1 = new Thread(new Entregador(lm), "Thread 1");
		Thread t2 = new Thread(new Entregador(lm), "Thread 2");
		t1.start();
		t2.start();
		
		while (true) {
			String email = JOptionPane.showInputDialog("Digite um email");
			if (email == null || email.isEmpty()) {
				lm.fecharLista();
				break;
			}
			lm.adicionarEmail(email);
		}
	}	
}
