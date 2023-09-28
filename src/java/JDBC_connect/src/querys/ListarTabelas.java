package querys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import connect.Connect;

public class ListarTabelas {
    public void listarUsuario() {
        String sql = "SELECT * FROM usuario";

        Statement stmt = null;
        try {
            stmt = Connect.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Obtém o objeto `ResultSetMetaData`
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

    public void listarUsuarioID(String usuario_id) {
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
        try (Connection conn = Connect.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario_id);
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

    public void listarUsuarioEmail(String email) {
        String sql = "SELECT * FROM usuario WHERE EMAIL = ?";

        try (Connection conn = Connect.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    String coluna = rsmd.getColumnName(i);
                    Object valor = rs.getObject(coluna);

                    System.out.println(coluna + ": " + valor);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarUsuarioName(String nome) {
        String parametroNome = "%" + nome + "%";
        String sql = "SELECT * FROM usuario WHERE nome_primeiro LIKE ? OR nome_meio LIKE ? OR nome_ultimo LIKE ?";

        try (Connection conn = Connect.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, parametroNome);
            stmt.setString(2, parametroNome);
            stmt.setString(3, parametroNome);
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
