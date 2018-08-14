package br.com.ultcode.concorrencia.classes;


public class Entregador implements Runnable {

	private final ListaMembros lm;

	public Entregador(ListaMembros lm) {
		this.lm = lm;
	}

	@Override
	public void run() {
		String nomeThread = Thread.currentThread().getName();
		System.out.println(nomeThread + "Começando o job de entrega");
		int quantidadePendente = lm.getQtdEmailsPendentes();
		boolean aberta = lm.isAberta();
		while (aberta || quantidadePendente > 0) {
			try {
				String email = lm.obterEmail();
				if (email != null) {
					System.out.println(nomeThread + " Enviando email para " + email);
					Thread.sleep(2000);
					System.out.println("Envio para " + email + " concluido com sucesso");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			aberta = lm.isAberta();
			quantidadePendente = lm.getQtdEmailsPendentes();
		}
		System.out.println("Atividade finalizadas");
	}

}
