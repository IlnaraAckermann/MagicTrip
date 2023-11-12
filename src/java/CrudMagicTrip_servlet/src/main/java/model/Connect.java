package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

	private static final String url = "jdbc:mysql://localhost:3306/db_magictrip";
	private static final String user = "root";
	private static final String password = "MySQL@JDBC";
	
	public static Connection getMySQLConnection() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection(url, user, password);

		return connection;
	}

}
