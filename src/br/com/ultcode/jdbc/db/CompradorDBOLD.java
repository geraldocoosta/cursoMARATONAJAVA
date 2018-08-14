package br.com.ultcode.jdbc.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;

import br.com.ultcode.jdbc.classes.Comprador;
import br.com.ultcode.jdbc.classes.MyRowSetListener;
import br.com.ultcode.jdbc.conn.ConexaoFactory;

public class CompradorDBOLD {
	
	public static void save(Comprador comprador) {
		// Insert para rodar no banco e inserir um dado
		String sql = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ('" + comprador.getCpf() + "', '"
				+ comprador.getNome() + "');";
		Connection conn = null; // adquirindo conexão com o banco
		Statement stmt = null;
		try {
			// Criando um statemente, (VEJA QUE PRA CRIAR UM STATEMENT USAMOS O MÈTODO
			// createStatement de um objeto tipo Connection)
			conn = ConexaoFactory.getConexao();
			stmt = conn.createStatement();
			System.out.printf("Quantidades de linhas %d%n", stmt.executeUpdate(sql)); // executeUpdate -> método para
																						// alterar tupulas, fazer crud
																						// basicamente
			System.out.println("Registro inserido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
			// Diferenças entre executeUpdate, execute, executeQuery, executeBatch
			// executeQuery -> Retorna uma result Set, conjunto de resultados, bom para
			// buscas no bd, como selects dos mais variados
			// executeUpdate -> padrão, informa numero de linhas afetadas, então é bom pra
			// insert, update, delete.
			// executeBatch -> faz menos idas ao BD, executa um conjunto de ações
			// execute -> pode executar select quando os métodos update, porém é mais
			// trabalhoso de usar o resultado
		} finally {
			if (conn != null && stmt != null) {
				ConexaoFactory.close(conn, stmt);
			} else if (conn != null) {
				ConexaoFactory.close(conn);
			}

		}
	}

	public static void update(Comprador comprador) {
		// Para update ou delete, não se esquece de chegar se o objeto tem id
		if (comprador == null || comprador.getId() == null) {
			System.out.println("Não foi possivel atualizar o registro");
			return;
		}
		String sql = "UPDATE `agencia`.`comprador` SET `nome`='" + comprador.getNome() + "',`cpf`='"
				+ comprador.getCpf() + "' WHERE `id`='" + comprador.getId() + "';";
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ConexaoFactory.getConexao();
			stmt = conn.createStatement();
			System.out.printf("Quantidades de linhas %d", stmt.executeUpdate(sql));
			ConexaoFactory.close(conn, stmt);
			System.out.println("Registro atualizado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null && stmt != null) {
				ConexaoFactory.close(conn, stmt);
			} else if (conn != null) {
				ConexaoFactory.close(conn);
			}
		}
	}

	public static void delete(Comprador comprador) {
		if (comprador == null || comprador.getId() == null) {
			System.out.println("Não foi possivel excluir o registro");
			return;
		}
		String sql = "DELETE FROM `agencia`.`comprador` WHERE `id`='" + comprador.getId() + "';";
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ConexaoFactory.getConexao();
			stmt = conn.createStatement();
			System.out.printf("Quantidades de linhas %d%n", stmt.executeUpdate(sql));
			ConexaoFactory.close(conn, stmt);
			System.out.println("Registro excluido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null && stmt != null) {
				ConexaoFactory.close(conn, stmt);
			} else if (conn != null) {
				ConexaoFactory.close(conn);
			}
		}

	}

	public static List<Comprador> selectAll() {
		String sql = "SELECT id, nome, cpf FROM agencia.comprador";
		Connection conn = null;
		Statement stmt = null;
		ResultSet resultados = null;

		try {
			conn = ConexaoFactory.getConexao();
			stmt = conn.createStatement();
			resultados = stmt.executeQuery(sql);

			List<Comprador> listaCompradores = new ArrayList<>();
			// Método para percorrer os resultados
			// Eles são retornados em linhas, o next ve se tem uma prox linha ou não
			// Obviamente retorna um boolean
			while (resultados.next()) {
				listaCompradores.add(
						new Comprador(resultados.getInt(1), resultados.getString("nome"), resultados.getString(3)));
				// Pegando os dados
				// Os dados são representados pelos tipos do java
				// System.out.print(resultados.getInt(1) + " \t"); // retorna pelo nome ou pelo
				// indice, SEMPRE COMEÇA DO 1!!!!!¹¹¹¹!!
				// System.out.print(resultados.getString("nome") + " \t");
				// System.out.print(resultados.getString(3));
				// System.out.println();
			}
			return listaCompradores;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null && stmt != null && resultados != null) {
				ConexaoFactory.close(conn, stmt, resultados);
			} else if (conn != null && stmt != null) {
				ConexaoFactory.close(conn, stmt);
			} else if (conn != null) {
				ConexaoFactory.close(conn);
			}
		}
		return null;

	}

	public static List<Comprador> searchByName(String nome) {
		String sql = "SELECT id, nome, cpf FROM agencia.comprador where nome like '%" + nome + "%'";
		Connection conn = null;
		Statement stmt = null;
		ResultSet resultados = null;

		try {
			conn = ConexaoFactory.getConexao();
			stmt = conn.createStatement();
			resultados = stmt.executeQuery(sql);
			List<Comprador> listaCompradores = new ArrayList<>();
			while (resultados.next()) {
				listaCompradores.add(
						new Comprador(resultados.getInt(1), resultados.getString("nome"), resultados.getString(3)));
			}
			return listaCompradores;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null && stmt != null && resultados != null) {
				ConexaoFactory.close(conn, stmt, resultados);
			} else if (conn != null && stmt != null) {
				ConexaoFactory.close(conn, stmt);
			} else if (conn != null) {
				ConexaoFactory.close(conn);
			}
		}
		return null;

	}

	// Veremos agora como ver os métadados do tabela
	public static void SelectMetadados() {
		String sql = "SELECT * FROM agencia.comprador"; // partindo do ponto que não sabemos esse SQL, ou está fora da
														// nossa jurisdição
		Connection conn = null;
		Statement stmt = null;
		ResultSet resultado = null;

		try {
			conn = ConexaoFactory.getConexao();
			stmt = conn.createStatement();
			resultado = stmt.executeQuery(sql);
			// Para ver as informações, é necessario um obj da Classe ResultSetMetaData
			// Esse objeto é retornado do método getMetaData de um objeto da classe
			// ResultSet
			ResultSetMetaData resultadoMetadata = resultado.getMetaData();
			// resultado.next();
			int qtdColunas = resultadoMetadata.getColumnCount(); // Pegando qtd de colunas de uma table
			System.out.printf("Qtd de colunas: %d%n", qtdColunas);
			for (int i = 1; i <= qtdColunas; i++) {
				System.out.printf(
						"Tabela \t\t\t%s%nNome colunas: \t\t%s%nTamanho da coluna: \t%d%n"
								+ "Tipo dado da coluna: \t%s%n%n",
						resultadoMetadata.getTableName(i), resultadoMetadata.getColumnName(i),
						resultadoMetadata.getColumnDisplaySize(i), resultadoMetadata.getColumnTypeName(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null && stmt != null && resultado != null) {
				ConexaoFactory.close(conn, stmt, resultado);
			} else if (conn != null && stmt != null) {
				ConexaoFactory.close(conn, stmt);
			} else if (conn != null) {
				ConexaoFactory.close(conn);
			}
		}
	}

	public static void checkDriverStatus() {
		Connection conn = null;
		try {
			conn = ConexaoFactory.getConexao();
			DatabaseMetaData metaDataDB = conn.getMetaData();

			// Verificando como podemos navergar entre os registros

			if (metaDataDB.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
				// TYPE_FORWARD_ONLY é quando só pode ir do inicio até o final, sentido top down
				System.out.println("Suporta TYPE_FORWARD_ONLY");

				// O result set fornece um meio de atualizar uma linha sem ter noção de sql, o
				// CONCUR_UPDATABLE é pra verificar se o bd suporta alterações nesse formato
				if (metaDataDB.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
					System.out.println("Suporta CONCUR_UPDATABLE");
				}
			} else {
				System.out.println("Não suporta TYPE_FORWARD_ONLY");
			}

			System.out.println();

			// TYPE_SCROLL_INSENSITIVE -> Pode mover o cursos pra frente e para trás, ir
			// diretamente pra uma linha
			// Da pra fazer um update em uma linha sem o SQL se o SetConcurrency retornar
			// true
			// Mudanças no BD não serão vistas enquanto o ResultSet estiver aberto
			if (metaDataDB.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
				System.out.println("Suporta TYPE_SCROLL_INSENSITIVE");

				if (metaDataDB.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE)) {
					System.out.println("Suporta CONCUR_UPDATABLE");
				}
			} else {
				System.out.println("Não suporta TYPE_SCROLL_INSENSITIVE");
			}

			System.out.println();

			// Qualquer alteração no BD altera o ResultSet em tempo real praticamente
			if (metaDataDB.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
				System.out.println("Suporta TYPE_SCROLL_SENSITIVE");
				if (metaDataDB.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE)) {
					System.out.println("Suporta CONCUR_UPDATABLE");
				}
			} else {
				System.out.println("Não suporta TYPE_SCROLL_INSENSITIVE");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				ConexaoFactory.close(conn);
		}

	}

	// Partindo de que sabemos que o driver suporta driver scroll insensitive e
	// concur updatable
	public static void testTypeScroll() {
		String sql = "SELECT id, nome, cpf FROM agencia.comprador";
		Connection conn = null;
		Statement stmt = null;
		ResultSet resultados = null;
		try {
			conn = ConexaoFactory.getConexao();
			// O certo mesmo é falar pro statement na sua criação qual o tipeScroll ele vai
			// ter no seu construtor
			// O padrão do sql define que podemos usar o type scroll insensitive
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			resultados = stmt.executeQuery(sql);
			// resultSet.last() -> Vai direto pra ultima linha, retorna boolean
			// Ultima linha de acordo com o select que foi passado no statement
			// (Cursor foi pra ultima linha)
			if (resultados.last()) {
				System.out.println("Ultima linha: "
						+ new Comprador(resultados.getInt(1), resultados.getString("nome"), resultados.getString(3)));
				// ResultSet.getRow() -> Método para saber qual o numero do registro
				// LEMBRE-SE: COMEÇA EM 1!!!
				System.out.println("Numero da ultima linha: " + resultados.getRow());
				System.out.println();
			}

			// Movendo o cursos de volta para a primeira linha
			System.out.println("Retornou para a primeira linha? " + resultados.first());
			System.out.println("num linha: " + resultados.getRow());
			System.out.println(
					new Comprador(resultados.getInt(1), resultados.getString("nome"), resultados.getString(3)));
			System.out.println();

			// Poderia também usar o método absolute(numLinha) que vai diretamente para a
			// linha especificada
			System.out.println("Retornou para a linha especificada? " + resultados.absolute(4));
			System.out.println("num linha: " + resultados.getRow());
			System.out.println(
					new Comprador(resultados.getInt(1), resultados.getString("nome"), resultados.getString(3)));
			System.out.println();

			// relative() -> move baseado na linha o cursor está, aceita inteiros negativos
			// Mover para mais do que o que deve pode resultar em exception se tentar pegar
			// os resultados
			System.out.println("Retornou para a linha especificada? " + resultados.relative(-10));
			System.out.println("num linha: " + resultados.getRow());
			// System.out.println(new Comprador(resultados.getInt(1),
			// resultados.getString("nome"), resultados.getString(3)));
			System.out.println();

			// Checando a posição (Se está no começo, antes do começo, final ou antes do
			// final) do cursor sem o mover -> isLast(), isAfterLast(), isFirst(),
			// isBeforeFirst()
			System.out.println("Está antes do começo? " + resultados.isBeforeFirst());
			System.out.println("Está no começo? " + resultados.isFirst());
			System.out.println("Está no final? " + resultados.isLast());
			System.out.println("Está depois do final? " + resultados.isAfterLast());
			System.out.println();

			// previus() -> partindo do suposto que estamos na ultima linha, ele vai
			// voltando o cursor
			// Usei um gatilho tecnico para retornar todos os dados
			// Porém descobri que existi o método afterLast(), provavelmente tem um
			// beforeFirst();
			resultados.afterLast();
			while (resultados.previous()) {
				System.out.println(resultados.getRow() + " : "
						+ new Comprador(+resultados.getInt(1), resultados.getString("nome"), resultados.getString(3)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null && stmt != null && resultados != null) {
				ConexaoFactory.close(conn, stmt, resultados);
			} else if (conn != null && stmt != null) {
				ConexaoFactory.close(conn, stmt);
			} else if (conn != null) {
				ConexaoFactory.close(conn);
			}
		}

	}

	// Verificando outros métodos de update, delete e insert
	public static void updateNameToLowerCaser() {
		String sql = "SELECT id, nome, cpf FROM agencia.comprador";
		Connection conn = null;
		Statement stmt = null;
		ResultSet resultados = null;
		DatabaseMetaData dbmd = null;
		try {
			conn = ConexaoFactory.getConexao();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			resultados = stmt.executeQuery(sql);
			dbmd = conn.getMetaData();

			// verificando algumas coisas, como se o resultset detecta alterações sem consultar o banco
			System.out.println("Detecta update? " + dbmd.updatesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
			System.out.println("Detecta delete? " + dbmd.deletesAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));
			System.out.println("Detecta insert? " + dbmd.insertsAreDetected(ResultSet.TYPE_SCROLL_INSENSITIVE));

			while (resultados.next()) {
				// trabalhdno com update sem sql, perceba que fiz um select apenas
				// Da mesma forma que temos os gets String, integer... temo os updates.
				// esse update atualiza os registros no resultSet, não no BD
				// Método aceita dois argumentos, primeiro a posição da coluna ou nome, depois o
				// valor que vamos passar
				// Só são atualizados realmente
				resultados.updateString("nome", resultados.getString(2).toLowerCase());
				// if (resultado.getString(2).equals("Geraldão"))
				// resultados.cancelRowUpdate();
				// updateRow que atualiza efetivamente no Banco de Dados e no ResultSet Pelo visto
				// resultados.updateRow();
				// updateString não é confiavel se chamado 2 vezes no mesmo bloco
				// se em algum momento desejar desfazer a alteração, usar o cancelRowUpdate()
				// ser usado antes do update Row()
			}

			// rowUpdated -> Metodo para verificar se esse updaterow funcionou, como o drive é insensitive
			// este retorna uma exception
			// boolean atualizado = resultados.rowUpdated();
			// System.out.println(atualizado);

			resultados.beforeFirst();
			while (resultados.next()) {
				// Na proxima linha, o result set irá mostrar os dados (coluna nome) em lowerCase
				// porém, não foi feita uma nova consulta. Ele está mostrando os dados atualizados
				// em memoria. Ele atualiza no banco, porém não faz uma nova consulta
				System.out.println(resultados.getString("nome"));
			}

			// inicio update
			resultados.absolute(2);
			String nome = resultados.getString("nome");

			// movendo pra uma linha temporaria, usada para inserir dados na tabela
			resultados.moveToInsertRow();
			resultados.updateString("nome", nome.toUpperCase());
			resultados.updateString("cpf", "99999999999");
			// para atualizar, update row, logo, para inserir , insertRow
			resultados.insertRow();
			resultados.moveToCurrentRow(); // retorna o cursor para aonde estava
			// fim update

			// delete registro
			resultados.absolute(7);
			resultados.deleteRow();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null && stmt != null && resultados != null) {
				ConexaoFactory.close(conn, stmt, resultados);
			} else if (conn != null && stmt != null) {
				ConexaoFactory.close(conn, stmt);
			} else if (conn != null) {
				ConexaoFactory.close(conn);
			}
		}

	}

	// Pelo o que eu entendi, preparedStatement é uma subclasse de Statement que adiciona segurança
	// A interface, prevenindo SQL injection por exemplo.
	// usuarios maldosos podem colocar em um campo algum código para ter acesso aos dados do BD
	// também ajuda na performace da execução pelo sql, pré compilando a query
	// quando executamos um sql, a query é enviada para o bd, em seguida o bd executa vários passos
	// para chegar essa query
	// primeiro o bd executa um parse, e verifica todas as palavras reservadas para checar a sintaxe
	// em seguida o bd checa as tabelas e colunas para ter certeza que existe essas tabelas
	// após isso o bd cria um plano de execução para essa query, buscando melhor desempenho(achismo)

	// Exemplo de sql injection
	// O preparedStatement não permite o '' nos argumentos, por isso dificulta o sql Injection
	// Algumas coisas mudam
	public static List<Comprador> searchByNamePreparedStatement(String nome) {
		// Em vez de colocar o parametro na query, será colocado um wildcard (latin=coringa) ?
		String sql = "SELECT id, nome, cpf FROM agencia.comprador where nome like ?";
		Connection conn = null;
		// Lembre-se que, tbm é preciso fechar um PreparedStatement
		// Como essa classe é um subclasse de Statement, é só chamar o close padrão
		PreparedStatement ps = null;
		ResultSet resultados = null;

		try {
			conn = ConexaoFactory.getConexao();
			// Muda também aqui, em vez de criar um statement, criamos um objeto de preparedStatement
			ps = conn.prepareStatement(sql);
			// Agora que temos um preparedStatement, devemos substituir os parametros do wildcard
			// Como Geraldão?
			// atraves do método abaixo jovem gafanhoto
			// setTipo(index,param) -> onde index quer dizer, posição na sql, começando de 1, e o segundo, o que
			// vai substituir aquele ?
			ps.setString(1, "%" + nome.trim() + "%"); // subtitui o primeiro ? por nome, para colocar o %%, agora é aqui
			resultados = ps.executeQuery(); // executeQuery em um preparedStatement é SEM ARGUMENTOS!!!
											// se não vai retornar uma exception MySQLSyntaxErrorException
			List<Comprador> listaCompradores = new ArrayList<>();
			while (resultados.next()) {
				listaCompradores.add(
						new Comprador(resultados.getInt(1), resultados.getString("nome"), resultados.getString(3)));
			}
			return listaCompradores;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null && ps != null && resultados != null) {
				ConexaoFactory.close(conn, ps, resultados);
			} else if (conn != null && ps != null) {
				ConexaoFactory.close(conn, ps);
			} else if (conn != null) {
				ConexaoFactory.close(conn);
			}
		}
		return null;

	}

	public static void updatePreparedStatement(Comprador comprador) {
		// Para update ou delete, não se esquece de chegar se o objeto tem id
		if (comprador == null || comprador.getId() == null) {
			System.out.println("Não foi possivel atualizar o registro");
			return;
		}
		String sql = "UPDATE `agencia`.`comprador` SET `cpf`=?,`nome`=? WHERE `id`=?"; // Não colocar aspas entre o ?
																						// (coringa em tailandes)
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = ConexaoFactory.getConexao();
			ps = conn.prepareStatement(sql);
			ps.setString(2, comprador.getNome()); // Lembre-se, index de acordo com a query, não com o BD (achismo)
			ps.setString(1, comprador.getCpf());
			ps.setInt(3, comprador.getId());
			System.out.printf("Quantidades de linhas %d%n", ps.executeUpdate()); // assim como no statement, temos
																					// vários executes, como
																					// executeQuery,executeUpdate,execetuBatch,
																					// execute etc
			System.out.println("Registro atualizado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null && ps != null) {
				ConexaoFactory.close(conn, ps);
			} else if (conn != null) {
				ConexaoFactory.close(conn);
			}
		}
	}

	// Quase a mesma coisa do prepared statement, só muda a interface e o método que transforma o statement
	// para um CallableStatement
	// Lembre-se que, quando quiser usar SP no JAVA, essa é a classe
	// Deve dar pra usar no statement, porém sou preguiçoso para tentar
	public static List<Comprador> searchByNameCallableStamemente(String nome) {
		String sql = "CALL `agencia`.`SP_GetCompradorPorNome`(?);";
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet resultados = null;

		try {
			conn = ConexaoFactory.getConexao();
			cs = conn.prepareCall(sql);
			cs.setString(1, "%" + nome.trim() + "%");
			resultados = cs.executeQuery();
			List<Comprador> listaCompradores = new ArrayList<>();
			while (resultados.next()) {
				listaCompradores.add(new Comprador(resultados.getInt("id"), resultados.getString("cpf"),
						resultados.getString("nome")));
			}
			return listaCompradores;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null && cs != null && resultados != null) {
				ConexaoFactory.close(conn, cs, resultados);
			} else if (conn != null && cs != null) {
				ConexaoFactory.close(conn, cs);
			} else if (conn != null) {
				ConexaoFactory.close(conn);
			}
		}
		return null;

	}

	// ROWSET -> Um resultSet, porém com algumas diferenças
	// Existem 2 tipos de rowSet, 1 que é conectado sempre com o bd para poder trabalhar
	// o segundo tipo engloba vários tipos (willian é doido) são desconectados
	// pega os dados do bd, pega os dados e salva em memoria, a pessoa trabalha o dado e quando for persistir acessa o
	// bd de novo para salvar
	// HOJE É ROWSET CONECTADÃO MEU BOM
	// -> vantagens do rowSet: É mais simples
	// no row set não trabalhamos com a connection
	// perceba que no JdbcRowSet, não precisamos nem de Statement e nem de Connections e nem de ResultSet
	// tudo em um
	// porém, não podemos utilizar update, nem insert, nem delete com o rowSet executando a query
	// o jeito de se fazer isso, é usando o concurUpdate, ou seja, sem query
	public static List<Comprador> searchByNameRowSet(String nome) {
		String sql = "SELECT id, nome, cpf FROM agencia.comprador where nome like ?";
		JdbcRowSet jrs = null;
		try {
			jrs = ConexaoFactory.getRowSetConnection();
			jrs.setCommand(sql); // em vez de prepareStatement, setCommand
			// ps = jrs.prepareStatement(sql);
			jrs.setString(1, "%" + nome.trim() + "%"); // setParadas que nem no prepareStatement
			jrs.execute(); // -> em vez de vários executes diferentes, só esse
			List<Comprador> listaCompradores = new ArrayList<>();
			while (jrs.next()) {
				listaCompradores.add(new Comprador(jrs.getInt(1), jrs.getString("nome"), jrs.getString(3)));
			}
			return listaCompradores;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoFactory.close(jrs);
		}
		return null;

	}

	public static void buscaPorNomeRowSet(String nome) {

		String sql = "SELECT * FROM `agencia`.`comprador`";
		JdbcRowSet jrs = null;
		// PreparedStatement ps = null;
		try {
			jrs = ConexaoFactory.getRowSetConnection();
			// Método para adicionar comportamentos a cada vez que o bagulho muda
			// ou cursor anda
			// poderia fazer que o jrs conectase toda vez que muda-se uma linha por ex
			jrs.addRowSetListener(new MyRowSetListener());
			jrs.setCommand(sql);
			// jrs.setInt(1, comprador.getId());
			jrs.execute();
			while (jrs.next()) {
				if (jrs.getString("nome").equals(nome))
					System.out.println(new Comprador(jrs.getInt("id"), jrs.getString("nome"), jrs.getString("cpf")));

			}
			// Por algum motivo não funciona, nem vou perder tempo
			// A cada atualização, troca de curso ou

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoFactory.close(jrs);

		}
	}

	// O CachedRowSet trabalha com bd de forma desconectada
	// O que é isso? Ele vai no banco, busca os dados, fecha a conexão
	// armazena esses dados em cache, trabalha os dados, e quando for persistir esses
	// dados ele abre a conexão de novo para tal.
	// A mudança é basicamente o metodo acceptChanges, que persiste os dados
	// Não é preciso chamar o método close, pois o próprio CachedRowSet efetua o close
	// outros rowSet desconectados => filterRowSet(filtra os conteudos), WebRowSet(XML), joinRowSet(Combina vários dados
	// de muitos row sets em um unico)
	public static void insertCachedRowSet() {
		String sql = "SELECT * FROM `agencia`.`comprador` where id = ?";
		CachedRowSet crs = null;
		try {
			crs = ConexaoFactory.getCachedRowSetConnection();
			crs.setCommand(sql);
			crs.setInt(1, 16);
			crs.execute();
			crs.next();
			crs.updateString("nome", "João");
			crs.updateRow();
			crs.acceptChanges();
			
			
			
		//	crs.acceptChanges();
			System.out.println("Chegou no final");
		}catch (SQLException e) {
 			e.printStackTrace();
		}
	}
	
	//Transação, rolback, commit
	public static void insertTransaction() throws SQLException {
		String sql = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ('45645645612','teste1') ";
		String sql2 = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES ('78978978956','teste2') ";
		Connection conn = null;
		Statement stmt = null;
		Savepoint savepoint = null;
		try {
			conn = ConexaoFactory.getConexao();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			savepoint = conn.setSavepoint("PONTOUM");
			if (true)	
				throw new SQLException("Erro planejado");
			stmt.executeUpdate(sql2);
			conn.commit();
			conn.setAutoCommit(true);
			
		}catch (SQLException e) {
			e.printStackTrace();
			conn.rollback(savepoint);
			conn.commit();
		}finally {
			ConexaoFactory.close(conn,stmt);
		}
		
	}

}
