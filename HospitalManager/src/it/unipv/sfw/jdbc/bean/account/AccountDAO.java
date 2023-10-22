package it.unipv.sfw.jdbc.bean.account;
import java.sql.*;
import java.util.ArrayList;

import it.unipv.sfw.jdbc.ConnessioneDB;
import it.unipv.sfw.model.Account;

public class AccountDAO implements IAccountDAO {
	private Connection conn;
	ArrayList<AccountDB> accounts;
	ArrayList<AccountDB> medici;
	ArrayList<AccountDB> operatoriSanitari;
	ArrayList<AccountDB> operatoriUfficio;
	ArrayList<AccountDB> pazienti;

	public AccountDAO() {
		super();
		this.accounts = new ArrayList<>();
		this.medici = new ArrayList<>();
		this.operatoriSanitari = new ArrayList<>();
		this.operatoriUfficio = new ArrayList<>();
		this.pazienti = new ArrayList<>();
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

	// seleziono gli account per tipo passando l'array in cui memorizzare i dati e la stringa che definisce il tipo di account
	@Override
	public ArrayList<AccountDB> selectAllType(ArrayList<AccountDB> arraylist, String tipo) {
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		PreparedStatement ps1;
		ResultSet rs1;
		
		try {
			String query = "SELECT * FROM hospitalmanager.profili WHERE tipo = ?";
			ps1 = conn.prepareStatement(query);
			ps1.setString(1, tipo);
			rs1 = ps1.executeQuery(query);
			
			while(rs1.next()) {
				AccountDB a = new AccountDB(rs1.getInt("ID_ACC"), rs1.getString("TIPO"), rs1.getString("CF"), 
						rs1.getString("PW"), rs1.getString("SPECIALIZZAZIONE"));
				arraylist.add(a);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		ConnessioneDB.closeConnection(conn);
		
		return arraylist;
	}
	
	//inserimento account passando i relativi parametri
	@Override
	public boolean insertAccount(Account a) {
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		PreparedStatement ps1;
		
		boolean check = true;
		
		try {
			String query = "INSERT INTO hospitalmanager.PROFILI VALUES (?,?,?,?,?)";
			ps1 = conn.prepareStatement(query);
			ps1.setInt(1, a.getIdAcc());
			ps1.setString(2, a.getTipoAcc().name());
			ps1.setString(3, a.getP().getCf());
			ps1.setString(4, a.getPw());
			ps1.setString(5, a.getSpecializzazione());
			ps1.executeUpdate(query);
			//ps1.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
			check = false;
		}
		
		ConnessioneDB.closeConnection(conn);
		return check;
	
	}


	@Override
	public boolean updatePw(int idAcc, String pw) {
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		PreparedStatement ps1;
		
		boolean check = true;
		
		try {
			String query = "UPDATE hospitalmanager.PROFILI SET PW = ? WHERE ID_ACC = ?";
			ps1 = conn.prepareStatement(query);
			ps1.setString(1, pw);	
			ps1.setInt(2, idAcc);
			ps1.executeUpdate(query);
			//ps1.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace();
			check = false;
		}
		
		ConnessioneDB.closeConnection(conn);
		return check;
	}
}
