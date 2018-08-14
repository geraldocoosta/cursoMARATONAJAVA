package br.com.ultcode.jdbc.teste;

import java.sql.SQLException;
import java.util.List;

import br.com.ultcode.jdbc.classes.Comprador;
import br.com.ultcode.jdbc.db.CompradorDBOLD;

public class ConexaoTeste {

	public static void main(String[] args) {

		// Exemplo de SQL Injection
		// Com esse comando, retornei todos os registros
//		Comprador comprador = new Comprador(13,"78945612325","Alfredo");
//		CompradorDB.updatePreparedStatement(comprador);
		try {
			CompradorDBOLD.insertTransaction();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void incluirRegistro(Comprador comprador) {
		CompradorDBOLD.save(comprador);
	}

	public static void excluirRegistro(Comprador comprador) {
		CompradorDBOLD.delete(comprador);
	}

	public static void alterarRegistro(Comprador comprador) {
		CompradorDBOLD.update(comprador);
	}

	public static List<Comprador> buscarRegistros() {
		return CompradorDBOLD.selectAll();
	}

	public static List<Comprador> buscarPorNome(String nome) {
		return CompradorDBOLD.searchByName(nome);
	}
}