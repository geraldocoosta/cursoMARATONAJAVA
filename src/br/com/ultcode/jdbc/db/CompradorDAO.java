package br.com.ultcode.jdbc.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ultcode.jdbc.classes.Comprador;
import br.com.ultcode.jdbc.conn.ConexaoFactory;

public class CompradorDAO {
	public static void save(Comprador comprador) {
		String sql = "INSERT INTO `agencia`.`comprador` (`cpf`, `nome`) VALUES (?, ?);";
		try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, comprador.getCpf());
			ps.setString(2, comprador.getNome());
			System.out.printf("Quantidades de linhas %d%n", ps.executeUpdate());
			System.out.println("Registro inserido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void update(Comprador comprador) {
		if (comprador == null || comprador.getId() == null) {
			System.out.println("Não foi possivel atualizar o registro");
			return;
		}
		String sql = "UPDATE `agencia`.`comprador` SET `nome`= ?  ,`cpf`= ? WHERE `id`= ? ";
		try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, comprador.getNome());
			ps.setString(2, comprador.getCpf());
			ps.setInt(3, comprador.getId());
			System.out.printf("Quantidades de linhas modificadas %d%n", ps.executeUpdate());
			System.out.println("Registro atualizado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void delete(Comprador comprador) {
		if (comprador == null || comprador.getId() == null) {
			System.out.println("Não foi possivel excluir o registro");
			return;
		}
		String sql = "DELETE FROM `agencia`.`comprador` WHERE `id`= ?";
		try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, comprador.getId());
			System.out.printf("Quantidades de linhas deletadas %d%n", ps.executeUpdate());
			System.out.println("Registro deletado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static List<Comprador> selectAll() {
		String sql = "SELECT id, nome, cpf FROM agencia.comprador";
		List<Comprador> listaCompradores = new ArrayList<>();
		try (Connection conn = ConexaoFactory.getConexao();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				listaCompradores.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
			}
			return listaCompradores;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Comprador> searchByName(String nome) {
		String sql = "SELECT id, nome, cpf FROM agencia.comprador where nome like ?";
		List<Comprador> listaCompradores = new ArrayList<>();
		ResultSet rs = null;
		try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, "%" + nome + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				listaCompradores.add(new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome")));
			}
			return listaCompradores;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoFactory.close(rs);
		}
		return null;
	}

	public static Comprador searchById(Integer id) {
		String sql = "SELECT id, nome, cpf FROM agencia.comprador where id = ?";
		ResultSet rs = null;
		try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();
			return new Comprador(rs.getInt("id"), rs.getString("cpf"), rs.getString("nome"));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoFactory.close(rs);
		}
		return null;
	}
}
