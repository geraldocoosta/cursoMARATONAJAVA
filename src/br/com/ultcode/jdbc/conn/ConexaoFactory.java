package br.com.ultcode.jdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class ConexaoFactory {
	// O que é o jdbc?
	// pacote desde os primordios do java que:
	// foi criado para abstrair o desenvolvedor dos problemas de banco de dados
	// ou seja, aprenda a usar algumas interfaces, e poderá conectar com vários
	// bancos
	// java.sql (interdaces) -> Connection, Statement, ResultSet
	// 3 principais interfaces para utilizar o jdbc
	// Connection -> busca a conexão
	// Statement -> Realizar operações que afetem o estado do banco
	// ResultSet -> Resultados de uma consulta
	// A conexão é realizada atraves de um driver chamado DriverManeger
	// Essa classe busca o conector especifico de um sgbdr e devolve uma conexão
	// a partir da conexão o dev consegue trabalhar com outras interfaces
	// Para conseguir o drive para conexão, devemos baixar do site do fabricante do
	// sgbdr

	// Obtendo Conexao
	public static Connection getConexao() {
		// Primeiro devemos passar o url, usuario, password
		// Obs.: a forma da url depende do fabricante do sgbd, tem que correr atrás pra
		// ver!!
		// A forma do url permite ao DriverManeger saber qual tipo de conector ele vai
		// usar

		// Para se realizar a conexão, não podemos esquecer de :
		// Ligar o wamp, pois ai liga o mysql
		// verificar a string de conexão, que contem informações sobre o SGBD, o
		// endereço do Banco
		// A porta e o BD propriamente dito
		// Não se esquecer de importar a lib para o projeto
		// URL unica para cada banco, ESSA É PRA MYSQL
		String url = "jdbc:mysql://localhost:3306/agencia?useTimezone=true&serverTimezone=UTC&useSSL=false";
		String user = "root";
		String password = null;
		try {
			// A partir do JDBC4, não precisa mais carregar o driver mysql
			// Antes do JDBC4, o java não descobriria sozinho qual o sgbdr só com a string,
			// então devia passar o driver pelo seguinte método:
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
// Método para fechar a conexão
	public static void close(Connection c) {
		try {
			if (c != null)
				c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//O statement também deve ser fechado, então esse é um método sobrecarregado para fechar tanto o statement
	// Quanto a Connection
	public static void close(Connection c, Statement stmt) {
		close(c);
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(JdbcRowSet jrs) {
		try {
			if (jrs != null)
				jrs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection c, Statement stmt, ResultSet resultSet) {
		close(c,stmt);
		try {
			if (resultSet != null)
				resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close( ResultSet resultSet) {
		try {
			if (resultSet != null)
				resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static JdbcRowSet getRowSetConnection() {
		String url = "jdbc:mysql://localhost:3306/agencia?useTimezone=true&serverTimezone=UTC&useSSL=false";
		String user = "root";
		String password = null;
		try {
			// Como fazer para pegar um objeto JdbcRowSet???
			// A partir do 4.1 do jdbc, é assim:
			//new Factory() é um método que retorna um objeto RowSetFactory 
			// usamos o método createJdbcRowSet desse objeto para instanciar um objeto JdbcRowSet
			JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
			jdbcRowSet.setUrl(url);
			jdbcRowSet.setUsername(user);
			jdbcRowSet.setPassword(password);
			return jdbcRowSet;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	// Não está funcionando, acredito que seja algo com o driver de conexão do mysql
	public static CachedRowSet getCachedRowSetConnection() {
		String url = "jdbc:mysql://localhost:3306/agencia?useTimezone=true&serverTimezone=UTC&useSSL=false"
				+ "&relaxAutoCommit=true";
		String user = "root";
		String password = null;
		try {
			CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
			cachedRowSet.setUrl(url);
			cachedRowSet.setUsername(user);
			cachedRowSet.setPassword(password);
			return cachedRowSet;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
