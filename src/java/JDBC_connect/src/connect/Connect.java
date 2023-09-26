package connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    
    
    private static final String url = "jdbc:mysql://localhost:3306/db_magictrip";
    private static final String user = "root";
    private static final String password = "MySQL@JDBC";
    private static Connection conn;
    

    public static Connection getConnection() throws SQLException {
        
        
        try {
            if(conn==null) {
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            }else{
                return conn;
            }
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

}
