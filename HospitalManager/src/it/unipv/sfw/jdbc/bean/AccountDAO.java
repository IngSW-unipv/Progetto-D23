package it.unipv.sfw.jdbc.bean;
import java.sql.*;
import java.util.ArrayList;

import it.unipv.sfw.jdbc.ConnessioneDB;

public class AccountDAO implements IAccountDAO {
	private Connection conn;
	ArrayList<AccountDB> accounts;
	
	

	public AccountDAO() {
		super();
		this.accounts = new ArrayList<>();
	}


	@Override
	public ArrayList<AccountDB> selectAllAccounts() {
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = conn.createStatement();
			String query = "SELECT * FROM hospitalmanager.profili";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				AccountDB a = new AccountDB(rs1.getInt("ID_ACC"), rs1.getString("TIPO"), rs1.getString("CF"), 
						rs1.getString("PW"), rs1.getString("SPECIALIZZAZIONE"));
				accounts.add(a);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		ConnessioneDB.closeConnection(conn);
		
		return accounts;
	}


	@Override
	public ArrayList<AccountDB> selectAllMedici() {
		return null;
	}



	@Override
	public ArrayList<AccountDB> selectAllOperatoriSanitari() {
		return null;
	}



	@Override
	public ArrayList<AccountDB> selectAllOperatoriUfficio() {
		return null;
	}



	@Override
	public ArrayList<AccountDB> selectAllPazienti() {
		return null;
	}

}
