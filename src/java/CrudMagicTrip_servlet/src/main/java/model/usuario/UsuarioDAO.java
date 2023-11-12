package model.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Connect;

public class UsuarioDAO {

	private static String sql;

	public void cadastrar(Usuario usuario) {
		sql = "INSERT INTO USUARIO ( CPF, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, BAIRRO, CIDADE, ESTADO, NOME, EMAIL, SENHA, DATANASCIMENTO) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

		try (Connection conn = Connect.getMySQLConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			// Adiciona o valor dos parâmetros da sql
			ps.setString(1, usuario.getCpf());
			ps.setString(2, usuario.getLogradouro());
			ps.setInt(3, usuario.getNumero());
			ps.setString(4, usuario.getComplemento());
			ps.setString(5, usuario.getCep());
			ps.setString(6, usuario.getBairro());
			ps.setString(7, usuario.getCidade());
			ps.setString(8, usuario.getEstado());
			ps.setString(9, usuario.getNome());
			ps.setString(10, usuario.getEmail());
			ps.setString(11, usuario.getSenha());
			ps.setString(12, usuario.getDataNascimento());

			// Executa a sql para inserção dos dados
			ps.execute();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void atualizar(Usuario usuario) {
		String sql = "UPDATE USUARIO SET CPF = ?, LOGRADOURO = ?, NUMERO = ?, COMPLEMENTO = ?, CEP = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ?, NOME = ?, EMAIL = ?, SENHA = ?, datanascimento = ? WHERE ID_USUARIO = ?";

		try (Connection conn = Connect.getMySQLConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, usuario.getCpf());
			ps.setString(2, usuario.getLogradouro());
			ps.setInt(3, usuario.getNumero());
			ps.setString(4, usuario.getComplemento());
			ps.setString(5, usuario.getCep());
			ps.setString(6, usuario.getBairro());
			ps.setString(7, usuario.getCidade());
			ps.setString(8, usuario.getEstado());
			ps.setString(9, usuario.getNome());
			ps.setString(10, usuario.getEmail());
			ps.setString(11, usuario.getSenha());
			ps.setString(12, usuario.getDataNascimento());
			ps.setInt(13, usuario.getId_usuario());

			ps.execute();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void deletar(int id) {
		String sql = "DELETE FROM USUARIO WHERE ID_USUARIO = ?";

		try (Connection conn = Connect.getMySQLConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, id);

			ps.execute();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public List<Usuario> listar() {
		String sql = "SELECT * FROM usuario";
		List<Usuario> users = new ArrayList<Usuario>();

		try (Connection conn = Connect.getMySQLConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Usuario user = new Usuario();
				user.setCpf(rs.getString("cpf"));
				user.setLogradouro(rs.getString("logradouro"));
				user.setNumero(rs.getInt("numero"));
				user.setComplemento(rs.getString("complemento"));
				user.setCep(rs.getString("cep"));
				user.setBairro(rs.getString("bairro"));
				user.setCidade(rs.getString("cidade"));
				user.setEstado(rs.getString("estado"));
				user.setNome(rs.getString("nome"));
				user.setEmail(rs.getString("email"));
				user.setSenha(rs.getString("senha"));
				user.setDataNascimento(rs.getString("dataNascimento"));
				user.setId_usuario(rs.getInt("id_usuario"));
				users.add(user);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return users;
	}

	public Usuario listarPorID(int id) {
		String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
		Usuario user = new Usuario();

		try {
			try (Connection conn = Connect.getMySQLConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

				ps.setInt(1, id);

				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						user.setCpf(rs.getString("cpf"));
						user.setLogradouro(rs.getString("logradouro"));
						user.setNumero(rs.getInt("numero"));
						user.setComplemento(rs.getString("complemento"));
						user.setCep(rs.getString("cep"));
						user.setBairro(rs.getString("bairro"));
						user.setCidade(rs.getString("cidade"));
						user.setEstado(rs.getString("estado"));
						user.setNome(rs.getString("nome"));
						user.setEmail(rs.getString("email"));
						user.setSenha(rs.getString("senha"));
						user.setId_usuario(rs.getInt("id_usuario"));
					}
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean autenticarCredenciais(String email, String password) {
		boolean isValid = false;
		String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
		try {
			try (Connection conn = Connect.getMySQLConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setString(1, email);
				ps.setString(2, password);
				try (ResultSet rs = ps.executeQuery()) {
					isValid = rs.next();
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return isValid;

	}

};
