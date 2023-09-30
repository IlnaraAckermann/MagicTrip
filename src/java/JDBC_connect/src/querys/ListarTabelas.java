package querys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import connect.Connect;

public class ListarTabelas {
    public void listarUsuario() {
        String sql = "SELECT * FROM usuario";
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

    public void listarUsuarioID(String usuario_id) {
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
        Connection conn = null;
        try {
            conn = Connect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
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
        Connection conn = null;
        try {
            conn = Connect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
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
        Connection conn = null;
        try {
            conn = Connect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
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


    public void listarDestino() {
        String sql = "SELECT * FROM destinos";
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
    public void listarDestinoNome(String nome) {
        String parametroNome = "%" + nome + "%";
        String sql = "SELECT * FROM destinos WHERE NOME = ?";
        Connection conn = null;
        try {
            conn = Connect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, parametroNome);
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

    public void listarDestinoNome(int id) {
        String sql = "SELECT * FROM destinos WHERE id_destino = ?";
        Connection conn = null;
        try {
            conn = Connect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
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


   public void listarCompras() {
        String sql = "SELECT * FROM compra";
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


}
