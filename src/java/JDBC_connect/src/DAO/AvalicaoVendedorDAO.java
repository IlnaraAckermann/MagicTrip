package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import connect.Connect;
import model.AvaliacaoVendedor;

public class AvalicaoVendedorDAO {

    public void cadastrar(AvaliacaoVendedor avaliacaoVendedor) {
        String sql = "INSERT INTO avaliacao_vendedor ( COMENTARIO, NOTA, ID_VENDEDOR, ID_USUARIO) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = Connect.getConnection().prepareStatement(sql);
            ps.setString(1, avaliacaoVendedor.getComentario());
            ps.setInt(2, avaliacaoVendedor.getNota());
            ps.setInt(3, avaliacaoVendedor.getVendedor().getId_vendedor());
            ps.setInt(4, avaliacaoVendedor.getUsuario().getId_usuario());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(String comentario, int nota, int id) {
        String sql = "UPDATE avaliacao_vendedor SET COMENTARIO = ?, NOTA = ? WHERE ID_avalicao_VENDEDOR = ?";
        PreparedStatement ps = null;
        try {
            ps = Connect.getConnection().prepareStatement(sql);
            ps.setString(1, comentario);
            ps.setInt(2, nota);
            ps.setInt(3, id);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println(String.format("Avaliação %s atualizada com sucesso!", id));
            } else {
                System.out.println("Nenhuma avaliação foi atualizada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM avaliacao_vendedor WHERE ID = ?";
        PreparedStatement ps = null;
        try {
            ps = Connect.getConnection().prepareStatement(sql);

            ps.setInt(1, id);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Avaliação deletada com sucesso!");
            } else {
                System.out.println("Nenhuma avaliação foi deletada. Verifique o ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listar() {
        String sql = "SELECT * FROM avaliacao_vendedor";

        Connection conn = null;
        try {
            conn = Connect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            System.out.println("--------------------------");
            System.out.println("Todas as Avaliações");
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
        String sql = "SELECT * FROM avaliacao_vendedor WHERE id_avalicao_vendedor = ?";
        Connection conn = null;
        try {
            conn = Connect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            System.out.println("--------------------------");
            System.out.println("Avaliações do id: " + id);
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

    public void listarPorVendedor(int id) {
        String sql = "SELECT * FROM avaliacao_vendedor WHERE id_vendedor = ?";
        Connection conn = null;
        try {
            conn = Connect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            System.out.println("--------------------------");
            System.out.println("Avaliações do Vendedor id: " + id);
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

    public void listarPorUsuario(int id) {
        String sql = "SELECT * FROM avaliacao_vendedor WHERE id_usuario = ?";
        Connection conn = null;
        try {
            conn = Connect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            System.out.println("--------------------------");
            System.out.println("Avaliações do Usuario id: " + id);
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
