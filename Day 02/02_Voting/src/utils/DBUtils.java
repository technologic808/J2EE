package utils;

import java.sql.*;

public class DBUtils {
	// Static method to return Database Connection
	public static Connection fetchConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3333/technologic?useSSL=false&autoRetry=true";
		// mandatory in  Java EE
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, "root", "actscdac");
	}
}

