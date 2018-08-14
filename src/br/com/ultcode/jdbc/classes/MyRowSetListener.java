package br.com.ultcode.jdbc.classes;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

public class MyRowSetListener implements RowSetListener {

	@Override
	public void rowSetChanged(RowSetEvent event) {
		System.out.println("O comando execute foi executado");
	}

	@Override
	public void rowChanged(RowSetEvent event) {
		System.out.println("Algo na linha mudou");
		// Exemplo pra atualizar de acordo com o banco de dados quando isso acontecer
		if (event.getSource() instanceof RowSet) {
			try {
				// Como só utilizo uma vez, cast assim mesmo.
				((RowSet) event.getSource()).execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void cursorMoved(RowSetEvent event) {
		System.out.println("cursos moveu");

	}

}
