package it.unipv.sfw.jdbc;
import java.sql.*;

public class ConnessioneDB {

	public static Connection startConnection(Connection conn, String schema){
		//String driverDB = null;
		String URL = null;
		String username = null;
		String password = null;
		

		//driverDB = "";
		URL = "jdbc:mysql://localhost:3306/"+schema; // schema = hospitalmanager
		username = "root";
		password = "";
		
		if(isOpen(conn)) {
			closeConnection(conn);
		}
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, username, password); // apertura connessione	
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
		
		return conn;
	}
	
	public static boolean isOpen(Connection conn) {
		if(conn == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static Connection closeConnection(Connection conn) {
		if(!isOpen(conn)) {
			return null;
		}
		try {
			conn.close();
			conn = null;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return conn;
	}
}
