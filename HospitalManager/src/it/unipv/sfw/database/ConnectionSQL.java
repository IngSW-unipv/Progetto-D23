package it.unipv.sfw.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Serve per connettersi al database.
 */

public class ConnectionSQL {
	/**
	 * inizializza connessione col db
	 */
	public static Connection startConnection(Connection conn, String schema) {

		String DbURL = null;
		String username = null;
		String password = null;

		DbURL = "";
		username = "";
		password = "";
		
		if (isOpen(conn))
			closeConnection(conn);
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(DbURL, username, password);// Apertura connessione

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return conn;
	}

	/**
	 * restituisce true se connessione db è aperta
	 */
	public static boolean isOpen(Connection conn) {
		if (conn == null)
			return false;
		else
			return true;
	}

	/**
	 * chiude connessione col db
	 */
	public static Connection closeConnection(Connection conn) {
		if (!isOpen(conn))
			return null;
		try {

			conn.close();
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return conn;
	}
}
