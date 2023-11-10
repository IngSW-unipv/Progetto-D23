package it.unipv.sfw.jdbc.bean.profilo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.sfw.jdbc.ConnessioneDB;
import it.unipv.sfw.model.TipoAccount;
import it.unipv.sfw.model.persona.Account;

public class ProfiloDAO implements IProfiloDAO {
	private Connection conn;
	ArrayList<ProfiloDB> accounts;
	ArrayList<ProfiloDB> medici;
	ArrayList<ProfiloDB> operatoriSanitari;
	ArrayList<ProfiloDB> operatoriUfficio;
	ArrayList<ProfiloDB> pazienti;
	
	

	public ProfiloDAO(ArrayList<ProfiloDB> accounts, ArrayList<ProfiloDB> medici,
			ArrayList<ProfiloDB> operatoriSanitari, ArrayList<ProfiloDB> operatoriUfficio,
			ArrayList<ProfiloDB> pazienti) {
		super();
		this.accounts = new ArrayList<>();
		this.medici = new ArrayList<>();
		this.operatoriSanitari = new ArrayList<>();
		this.operatoriUfficio = new ArrayList<>();
		this.pazienti = new ArrayList<>();
	}

	@Override
	public ArrayList<ProfiloDB> selectAllProfili() {
		// TODO Auto-generated method stub
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = conn.createStatement();
			String query = "SELECT * FROM hospitalmanager.PROFILI";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				ProfiloDB a = new ProfiloDB(rs1.getString("CF"), rs1.getString("TIPO"),
						rs1.getString("PW"), rs1.getString("SPECIALIZZAZIONE"), rs1.getString("NOME"), rs1.getString("COGNOME"),
						rs1.getString("GENERE"), rs1.getString("DATA_NASCITA"), rs1.getString("LUOGO_NASCITA"), rs1.getString("PROVINCIA_NASCITA"),
						rs1.getString("REGIONE_RESIDENZA"), rs1.getString("PROVINCIA_RESIDENZA"), rs1.getString("CITTA_RESIDENZA"), rs1.getString("INDIRIZZO"),
						rs1.getString("CAP"), rs1.getString("EMAIL"), rs1.getString("CELLULARE"));
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
	public ArrayList<ProfiloDB> selectAllPazienti() {
		// TODO Auto-generated method stub
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = conn.createStatement();
			String query = "SELECT * FROM hospitalmanager.PROFILI WHERE tipo = 'PA'";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				ProfiloDB a = new ProfiloDB(rs1.getString("CF"), rs1.getString("TIPO"),
						rs1.getString("PW"), rs1.getString("SPECIALIZZAZIONE"), rs1.getString("NOME"), rs1.getString("COGNOME"),
						rs1.getString("GENERE"), rs1.getString("DATA_NASCITA"), rs1.getString("LUOGO_NASCITA"), rs1.getString("PROVINCIA_NASCITA"),
						rs1.getString("REGIONE_RESIDENZA"), rs1.getString("PROVINCIA_RESIDENZA"), rs1.getString("CITTA_RESIDENZA"), rs1.getString("INDIRIZZO"),
						rs1.getString("CAP"), rs1.getString("EMAIL"), rs1.getString("CELLULARE"));
				pazienti.add(a);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		ConnessioneDB.closeConnection(conn);
		
		return pazienti;
	}

	@Override
	public ArrayList<ProfiloDB> selectAllMedici() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProfiloDB> selectAllOperatoriSanitari() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProfiloDB> selectAlloperatoriUfficio() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProfiloDB selectProfiloByCF(String CF, TipoAccount tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertProfilo(Account a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePw(String CF, TipoAccount tipo, String pw) {
		// TODO Auto-generated method stub
		return false;
	}



}
