package querys;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import connect.Connect;

public class ListarUsuarios {
    public void listarUsuario() {
        String sql = "SELECT * FROM usuario";
        
            Statement stmt =null;
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

}
