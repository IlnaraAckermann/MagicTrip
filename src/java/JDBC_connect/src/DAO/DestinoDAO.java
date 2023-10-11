package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import connect.Connect;
import model.Destinos;

public class DestinoDAO {
    public void cadastrar(Destinos destino) {
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

    public void atualizar(int id_destino, String nome, String descricao) {
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

    public void deletar(int id) {
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

    public Destinos criarExistentePorID(int id) {
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

    public void listar() {
        String sql = "SELECT * FROM destinos";
        Connection conn = null;
        try {
            conn = Connect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            System.out.println("--------------------------");
            System.out.println("Todos os Destinos");
            System.out.println("--------------------------");
            while (rs.next()) {
                System.out.println(" ");
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    String coluna = rsmd.getColumnName(i).toUpperCase();
                    Object valor = rs.getObject(coluna);
                    System.out.println(coluna + ": " + valor);
                }
                System.out.println("\n--------------------------");

            }
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarPorNome(String nome) {
        String parametroNome = "%" + nome + "%";
        String sql = "SELECT * FROM destinos WHERE NOME = ?";
        Connection conn = null;
        try {
            conn = Connect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, parametroNome);
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            System.out.println("--------------------------");
            System.out.println("Destinos : " + nome);
            System.out.println("--------------------------");
            while (rs.next()) {
                System.out.println(" ");
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    String coluna = rsmd.getColumnName(i).toUpperCase();
                    Object valor = rs.getObject(coluna);
                    System.out.println(coluna + ": " + valor);
                }
                System.out.println("\n--------------------------");

            }
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarPorID(int id) {
        String sql = "SELECT * FROM destinos WHERE id_destino = ?";
        Connection conn = null;
        try {
            conn = Connect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();


            System.out.println("--------------------------");
            System.out.println("Destino id : " + id);
            System.out.println("--------------------------");
            while (rs.next()) {
                System.out.println(" ");
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    String coluna = rsmd.getColumnName(i).toUpperCase();
                    Object valor = rs.getObject(coluna);
                    System.out.println(coluna + ": " + valor);
                }
                System.out.println("\n--------------------------");

            }
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
