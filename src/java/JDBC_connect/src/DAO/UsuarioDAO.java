package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connect.Connect;
import entity.Usuario;

public class UsuarioDAO {
    public void cadastrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO USUARIO ( CPF, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, BAIRRO, CIDADE, ESTADO, NOME_PRIMEIRO, NOME_MEIO, NOME_ULTIMO, EMAIL, SENHA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = Connect.getConnection().prepareStatement(sql);
            ps.setString(1, usuario.getCpf());
            ps.setString(2, usuario.getLogradouro());
            ps.setInt(3, usuario.getNumero());
            ps.setString(4, usuario.getComplemento());
            ps.setString(5, usuario.getCep());
            ps.setString(6, usuario.getBairro());
            ps.setString(7, usuario.getCidade());
            ps.setString(8, usuario.getEstado());
            ps.setString(9, usuario.getNome_primeiro());
            ps.setString(10, usuario.getNome_meio());
            ps.setString(11, usuario.getNome_ultimo());
            ps.setString(12, usuario.getEmail());
            ps.setString(13, usuario.getSenha());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarUsuario(int id, Usuario usuario) {
        String sql = "UPDATE USUARIO SET CPF = ?, LOGRADOURO = ?, NUMERO = ?, COMPLEMENTO = ?, CEP = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ?, NOME_PRIMEIRO = ?, NOME_MEIO = ?, NOME_ULTIMO = ?, EMAIL = ?, SENHA = ? WHERE ID_USUARIO = ?";
        PreparedStatement ps = null;
        try {
            ps = Connect.getConnection().prepareStatement(sql);

            ps.setString(1, usuario.getCpf());
            ps.setString(2, usuario.getLogradouro());
            ps.setInt(3, usuario.getNumero());
            ps.setString(4, usuario.getComplemento());
            ps.setString(5, usuario.getCep());
            ps.setString(6, usuario.getBairro());
            ps.setString(7, usuario.getCidade());
            ps.setString(8, usuario.getEstado());
            ps.setString(9, usuario.getNome_primeiro());
            ps.setString(10, usuario.getNome_meio());
            ps.setString(11, usuario.getNome_ultimo());
            ps.setString(12, usuario.getEmail());
            ps.setString(13, usuario.getSenha());
            ps.setInt(14, id);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Usuário atualizado com sucesso!");
            } else {
                System.out.println("Nenhum usuário foi atualizado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarUsuario(int id) {
        String sql = "DELETE FROM USUARIO WHERE ID_USUARIO = ?";
        PreparedStatement ps = null;
        try {
            ps = Connect.getConnection().prepareStatement(sql);

            ps.setInt(1, id);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Usuário deletado com sucesso!");
            } else {
                System.out.println("Nenhum usuário foi deletado. Verifique o ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario buscarUsuarioPorId(int idUsuario) {
    String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
    Connection conn = null;
    Usuario usuario = null;

    try {
        conn = Connect.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idUsuario); // Define o valor do parâmetro

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            usuario = new Usuario();
            usuario.setId_usuario(rs.getInt("id_usuario"));
            usuario.setCpf(rs.getString("cpf"));
            usuario.setLogradouro(rs.getString("logradouro"));
            usuario.setNumero(rs.getInt("numero"));
            usuario.setComplemento(rs.getString("complemento"));
            usuario.setCep(rs.getString("cep"));
            usuario.setBairro(rs.getString("bairro"));
            usuario.setCidade(rs.getString("cidade"));
            usuario.setEstado(rs.getString("estado"));
            usuario.setNome_primeiro(rs.getString("nome_primeiro"));
            usuario.setNome_meio(rs.getString("nome_meio"));
            usuario.setNome_ultimo(rs.getString("nome_ultimo"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
        }
        stmt.close();

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Feche a conexão com o banco de dados aqui, se necessário.
    }

    return usuario;
}

}
