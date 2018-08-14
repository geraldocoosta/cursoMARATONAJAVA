package br.com.ultcode.jdbc.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ultcode.jdbc.classes.Carro;
import br.com.ultcode.jdbc.classes.Comprador;
import br.com.ultcode.jdbc.conn.ConexaoFactory;

public class CarroDAO {
	public static void save(Carro carro) {
		String sql = "INSERT INTO `agencia`.`carro` (`nome`, `placa`,`comprador_id`) VALUES (?, ?, ?)";
		try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, carro.getNome());
			ps.setString(2, carro.getPlaca());
			ps.setInt(3, carro.getComprador().getId());
			System.out.printf("Quantidades de linhas %d%n", ps.executeUpdate());
			System.out.println("Registro inserido com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void update(Carro carro) {
		if (carro == null || carro.getId() == null) {
			System.out.println("Não foi possivel atualizar o registro");
			return;
		}
		String sql = "UPDATE `agencia`.`carro` SET `nome`= ?, `placa` = ?,`comprador_id` = ? WHERE `id`= ? ";
		try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, carro.getNome());
			ps.setString(2, carro.getPlaca());
			ps.setInt(3, carro.getComprador().getId());
			ps.setInt(4, carro.getId());
			System.out.printf("Quantidades de linhas modificadas %d%n", ps.executeUpdate());
			System.out.println("Registro atualizado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void delete(Carro carro) {
		if (carro == null || carro.getId() == null) {
			System.out.println("Não foi possivel excluir o registro");
			return;
		}
		String sql = "DELETE FROM `agencia`.`carro` WHERE `id`= ?";
		try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, carro.getId());
			System.out.printf("Quantidades de linhas deletadas %d%n", ps.executeUpdate());
			System.out.println("Registro deletado com sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static List<Carro> selectAll() {
		String sql = "SELECT id, nome, placa, comprador_id FROM agencia.carro";
		List<Carro> listaCarroes = new ArrayList<>();
		try (Connection conn = ConexaoFactory.getConexao();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Comprador c = CompradorDAO.searchById(rs.getInt("comprador_id"));
				listaCarroes.add(new Carro(rs.getInt("id"), rs.getString("nome"), rs.getString("placa"), c));
			}
			return listaCarroes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Carro> searchByName(String nome) {
		String sql = "SELECT id, nome, placa, comprador_id FROM agencia.carro where nome like ?";
		List<Carro> listaCarroes = new ArrayList<>();
		ResultSet rs = null;
		try (Connection conn = ConexaoFactory.getConexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, "%" + nome + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				Comprador c = CompradorDAO.searchById(rs.getInt("comprador_id"));
				listaCarroes.add(new Carro(rs.getInt("id"), rs.getString("nome"), rs.getString("placa"), c));
			}
			return listaCarroes;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoFactory.close(rs);
		}
		return null;
	}
}
