package DAO;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connect.Connect;
import entity.Compra;
import entity.Destinos;

public class CompraDAO {
    public void cadastrarCompra(BigDecimal valor, int qnt_pessoas, String tipo_pacote, BigDecimal comissao,
            String data_fim, String data_inicio, int id_destino, int id_usuario, int id_vendedor) {
        String sql = "INSERT INTO COMPRA ( VALOR, QT_PESSOAS, TIPO_PACOTE, COMMISSAO, DATA_FIM, DATA_INICIO, ID_DESTINO, ID_VENDEDOR, ID_USUARIO ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = Connect.getConnection().prepareStatement(sql);
            ps.setBigDecimal(1, valor);
            ps.setInt(2, qnt_pessoas);
            ps.setString(3, tipo_pacote);
            ps.setBigDecimal(4, comissao);
            ps.setString(5, data_fim);
            ps.setString(6, data_inicio);
            ps.setInt(7, id_destino);
            ps.setInt(8, id_usuario);
            ps.setInt(9, id_vendedor);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarCompra(Compra compra) {
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

    

}
