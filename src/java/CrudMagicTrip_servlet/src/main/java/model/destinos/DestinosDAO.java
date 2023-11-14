package model.destinos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Connect;

public class DestinosDAO {

	public void cadastrar(Destinos destino) {
		String sql = "INSERT INTO DESTINOS ( NOME, DESCRICAO) VALUES (?, ?)";
		try (Connection conn = Connect.getMySQLConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, destino.getNome());
			ps.setString(2, destino.getDescricao());
			ps.execute();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Destinos destino) {
		String sql = "UPDATE DESTINOS SET NOME = ?, DESCRICAO = ? WHERE ID_DESTINO = ?";
		try (Connection conn = Connect.getMySQLConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, destino.getNome());
			ps.setString(2, destino.getDescricao());
			ps.setInt(3, destino.getId_destino());
			ps.execute();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void deletar(int id) {
		String sql = "DELETE FROM DESTINOS WHERE ID_DESTINO = ?";
		try (Connection conn = Connect.getMySQLConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<Destinos> listar() {
		String sql = "SELECT * FROM destinos";
		List<Destinos> destinos = new ArrayList<Destinos>();

		try (Connection conn = Connect.getMySQLConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			
			while (rs.next()) {
				Destinos destino = new Destinos();
				destino.setId_destino(rs.getInt("id_destino"));
		        destino.setNome(rs.getString("nome"));
		        destino.setDescricao(rs.getString("descricao"));
		        destinos.add(destino);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return destinos;
	}

	public List<Destinos> listarPorNome(String nome) {
		String parametroNome = "%" + nome + "%";
		String sql = "SELECT * FROM destinos WHERE NOME = ?";
		List<Destinos> destinos = new ArrayList<Destinos>();
		try {
			try (Connection conn = Connect.getMySQLConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, parametroNome);
				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						Destinos destino = new Destinos();
						destino.setId_destino(rs.getInt("id_destino"));
				        destino.setNome(rs.getString("nome"));
				        destino.setDescricao(rs.getString("descricao"));
				        destinos.add(destino);
					}
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return destinos;
	}

	public Destinos listarPorID(int id) {
		String sql = "SELECT * FROM destinos WHERE id_destino = ?";
		Destinos destino = new Destinos();
		try {
			try (Connection conn = Connect.getMySQLConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setInt(1, id);
				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
	                    destino.setDescricao(rs.getString("descricao"));
	                    destino.setNome(rs.getString("nome"));
	                    destino.setId_destino(rs.getInt("id_destino"));
					}
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return destino;
	}

};
