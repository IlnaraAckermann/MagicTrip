package DAO;
import java.sql.PreparedStatement;
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

}
