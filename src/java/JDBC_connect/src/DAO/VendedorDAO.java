package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import connect.Connect;
import model.Usuario;
import model.Vendedor;

public class VendedorDAO {

    public void cadastrar(int id_usuario) {
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

    public void atualizar(int id_vendedor, int id_usuario) {
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

    public void deletar(int id) {
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

    public Vendedor criarExistentePorID(int id) {
        String sql = "SELECT * FROM Vendedor WHERE id_vendedor = ?";
        Connection conn = null;
        Vendedor vendedor = null;

        try {
            conn = Connect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                vendedor = new Vendedor();
                vendedor.setId_vendedor(id);
                Usuario usuario = new UsuarioDAO().criarExistentePorID(rs.getInt("id_usuario"));
                vendedor.setUsuario(usuario);
            }
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vendedor;
    };

    public void listar() {
        String sql = "SELECT * FROM VENDEDOR";

        Connection conn = null;
        try {
            conn = Connect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            System.out.println("--------------------------");
            System.out.println("Todos os Vendedores");
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

    public void listarPorID(String vendedor_id) {
        String sql = "SELECT * FROM vendedor WHERE id_vendedor = ?";
        Connection conn = null;
        try {
            conn = Connect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, vendedor_id);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            System.out.println("--------------------------");
            System.out.println("Vendedores id: " + vendedor_id);
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
