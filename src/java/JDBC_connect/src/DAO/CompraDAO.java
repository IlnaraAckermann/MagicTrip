package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import connect.Connect;
import model.Compra;

public class CompraDAO {
    public void cadastrar(Compra compra) {
        String sql = "INSERT INTO COMPRA ( VALOR, QT_PESSOAS, TIPO_PACOTE, COMMISSAO, DATA_FIM, DATA_INICIO, ID_DESTINO, ID_VENDEDOR, ID_USUARIO ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = Connect.getConnection().prepareStatement(sql);
            ps.setBigDecimal(1, compra.getValor());
            ps.setInt(2, compra.getQnt_pessoas());
            ps.setString(3, compra.getTipo_pacote());
            ps.setBigDecimal(4, compra.getComissao());
            ps.setDate(5, compra.getData_fim());
            ps.setDate(6, compra.getData_inicio());
            ps.setInt(7, compra.getDestino().getId_destino());
            ps.setInt(8, compra.getVendedor().getId_vendedor());
            ps.setInt(9, compra.getUsuario().getId_usuario());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Compra compra, int id_compra) {
        String sql = "UPDATE COMPRA SET VALOR = ?, QT_PESSOAS = ?, TIPO_PACOTE = ?, COMMISSAO = ?, DATA_FIM = ?, DATA_INICIO = ?, ID_DESTINO = ?, ID_VENDEDOR = ?, ID_USUARIO = ? WHERE ID_COMPRA = ?";
        PreparedStatement ps = null;
        try {
            ps = Connect.getConnection().prepareStatement(sql);
            ps.setBigDecimal(1, compra.getValor());
            ps.setInt(2, compra.getQnt_pessoas());
            ps.setString(3, compra.getTipo_pacote());
            ps.setBigDecimal(4, compra.getComissao());
            ps.setDate(5, compra.getData_fim());
            ps.setDate(6, compra.getData_inicio());
            ps.setInt(7, compra.getDestino().getId_destino());
            ps.setInt(8, compra.getVendedor().getId_vendedor());
            ps.setInt(9, compra.getUsuario().getId_usuario());
            ps.setInt(10, id_compra);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listar() {
        String sql = "SELECT * FROM compra";
        Connection conn = null;
        try {
            conn = Connect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                System.out.println("-------------------");
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    String coluna = rsmd.getColumnName(i);
                    Object valor = rs.getObject(coluna);

                    System.out.println(coluna + ": " + valor);
                }
                System.out.println("-------------------");

            }
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
