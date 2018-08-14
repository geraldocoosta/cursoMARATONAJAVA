package br.com.ultcode.padraodeprojeto.classes;

public class PadraoBuilder {
	private String nome;
	private int idade;
	private String dtNascimento;
	private String sobrenome;

	public static class PadraoBuilderBuilder {
		private String nome;
		private int idade;
		private String dtNascimento;
		private String sobrenome;

		public PadraoBuilderBuilder nome(String nome) {
			this.nome = nome;
			return this;
		}

		public PadraoBuilderBuilder idade(int idade) {
			this.idade = idade;
			return this;
		}

		public PadraoBuilderBuilder dtNascimento(String dtNascimento) {
			this.dtNascimento = dtNascimento;
			return this;
		}

		public PadraoBuilderBuilder sobrenome(String sobrenome) {
			this.sobrenome = sobrenome;
			return this;
		}

		public PadraoBuilder build() {
			PadraoBuilder pessoa = new PadraoBuilder();
			pessoa.setNome(nome);
			pessoa.setIdade(idade);
			pessoa.setDtNascimento(dtNascimento);
			pessoa.setSobrenome(sobrenome);

			return pessoa;
		}
	}

	public PadraoBuilder() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@Override
	public String toString() {
		return "PadraoBuilder [nome=" + nome + ", idade=" + idade + ", dtNascimento=" + dtNascimento + ", sobrenome="
				+ sobrenome + "]";
	}
	
	

}
