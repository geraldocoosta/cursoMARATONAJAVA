package br.com.ultcode.threads.classes;

public class Entregador implements Runnable {

	private final ListaMembros lm;

	public Entregador(ListaMembros lm) {
		this.lm = lm;
	}

	@Override
	public void run() {
		String nomeThread = Thread.currentThread().getName();
		System.out.println(nomeThread + "Começando o job de entrega");
		int quantidadePendente = lm.getEmailsPendentes();
		boolean aberta = lm.isAberta();
		while (aberta || quantidadePendente > 0) {
			try {
				String email = lm.obterEmailMembro();
				if (email != null) {
					System.out.println(nomeThread + " Enviando email para " + email);
					Thread.sleep(2000);
					System.out.println("Envio para " + email + " concluido com sucesso");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			aberta = lm.isAberta();
			quantidadePendente = lm.getEmailsPendentes();
		}
		System.out.println("Atividade finalizadas");
	}

}
