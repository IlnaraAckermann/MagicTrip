package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import connect.Connect;

public class VendedorDAO {

    public void cadastrarVendedor(int id_usuario) {
        String sql = "INSERT INTO VENDEDOR ( ID_USUARIO ) VALUES (?)";
        PreparedStatement ps = null;
        try {
            ps = Connect.getConnection().prepareStatement(sql);
            ps.setInt(1, id_usuario);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarVendedor(int id_vendedor, int id_usuario) {
        String sql = "UPDATE VENDEDOR SET ID_USUARIO = ? WHERE ID_VENDEDOR = ?";
        PreparedStatement ps = null;
        try {
            ps = Connect.getConnection().prepareStatement(sql);
            ps.setInt(1, id_usuario);
            ps.setInt(2, id_vendedor);

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

    public void deletarVendedor(int id) {
        String sql = "DELETE FROM VENDEDOR WHERE ID = ?";
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

    public void listarVendedor() {
        String sql = "SELECT * FROM VENDEDOR";

        Connection conn = null;
        try {
            conn = Connect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    String coluna = rsmd.getColumnName(i);
                    Object valor = rs.getObject(coluna);
                    System.out.println(coluna + ": " + valor);
                }

            }
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     public void listarVendedorID(String vendedor_id) {
        String sql = "SELECT * FROM vendedor WHERE id_vendedor = ?";
        Connection conn = null;
        try {
            conn = Connect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, vendedor_id);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    String coluna = rsmd.getColumnName(i);
                    Object valor = rs.getObject(coluna);
                    System.out.println(coluna + ": " + valor);
                }
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
