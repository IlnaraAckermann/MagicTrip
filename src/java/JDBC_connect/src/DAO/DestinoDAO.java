package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connect.Connect;
import entity.Destinos;

public class DestinoDAO {
    public void cadastrarDestino(Destinos destino) {
        String sql = "INSERT INTO DESTINOS ( NOME, DESCRICAO) VALUES (?, ?)";
        PreparedStatement ps = null;
        try {
            ps = Connect.getConnection().prepareStatement(sql);
            ps.setString(1, destino.getNome());
            ps.setString(2, destino.getDescricao());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarDestino(int id_destino, String nome, String descricao) {
        String sql = "UPDATE DESTINOS SET NOME = ?, SET DESCRICAO = ? WHERE ID_DESTINO = ?";
        PreparedStatement ps = null;
        try {
            ps = Connect.getConnection().prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, descricao);

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

    public void deletarDestino(int id) {
        String sql = "DELETE FROM DESTINOS WHERE ID_DESTINO = ?";
        PreparedStatement ps = null;
        try {
            ps = Connect.getConnection().prepareStatement(sql);

            ps.setInt(1, id);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Vendedor deletado com sucesso!");
            } else {
                System.out.println("Nenhum vendedor foi deletado. Verifique o ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 public Destinos criarDestinoExistenteId(int id) {
    String sql = "SELECT * FROM DESTINOS WHERE id_destino = ?";
    Connection conn = null;
    Destinos destino = null;

    try {
        conn = Connect.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id); 
        ResultSet rs = stmt.executeQuery();
              if (rs.next()) {
            destino = new Destinos();
            destino.setId_destino(id);
            destino.setDescricao(rs.getString("descricao"));
            destino.setNome(rs.getString("nome"));
        }
        stmt.close();

    } catch (SQLException e) {
        e.printStackTrace();
    } 
    return destino;
 };

}
