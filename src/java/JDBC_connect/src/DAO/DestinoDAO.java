package DAO;

import java.sql.PreparedStatement;
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
}
