package it.unipv.sfw.jdbc.bean.profilo;

import java.sql.Connection;
import java.sql.DataTruncation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

import it.unipv.sfw.jdbc.ConnessioneDB;
import it.unipv.sfw.model.persona.TipoAccount;

public class ProfiloDAO implements IProfiloDAO {
	private Connection conn;
	ArrayList<ProfiloDB> accounts;
	ArrayList<ProfiloDB> medici;
	ArrayList<ProfiloDB> operatoriSanitari;
	ArrayList<ProfiloDB> operatoriUfficio;
	//ArrayList<ProfiloDB> pazienti;
	
	

	public ProfiloDAO(ArrayList<ProfiloDB> accounts, ArrayList<ProfiloDB> medici,
			ArrayList<ProfiloDB> operatoriSanitari, ArrayList<ProfiloDB> operatoriUfficio,
			ArrayList<ProfiloDB> pazienti) {
		super();
		this.accounts = new ArrayList<>();
		this.medici = new ArrayList<>();
		this.operatoriSanitari = new ArrayList<>();
		this.operatoriUfficio = new ArrayList<>();
		//this.pazienti = new ArrayList<>();
	}

	public ProfiloDAO() {
		this.accounts = new ArrayList<>();
		this.medici = new ArrayList<>();
		this.operatoriSanitari = new ArrayList<>();
		this.operatoriUfficio = new ArrayList<>();
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
						rs1.getString("SESSO"), rs1.getString("DATA_NASCITA"), rs1.getString("LUOGO_NASCITA"), rs1.getString("PROVINCIA_NASCITA"),
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
		ArrayList<ProfiloDB> pazienti = new ArrayList<>();
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
						rs1.getString("SESSO"), rs1.getString("DATA_NASCITA"), rs1.getString("LUOGO_NASCITA"), rs1.getString("PROVINCIA_NASCITA"),
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
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = conn.createStatement();
			String query = "SELECT * FROM hospitalmanager.PROFILI WHERE tipo = 'ME'";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				ProfiloDB a = new ProfiloDB(rs1.getString("CF"), rs1.getString("TIPO"),
						rs1.getString("PW"), rs1.getString("SPECIALIZZAZIONE"), rs1.getString("NOME"), rs1.getString("COGNOME"),
						rs1.getString("SESSO"), rs1.getString("DATA_NASCITA"), rs1.getString("LUOGO_NASCITA"), rs1.getString("PROVINCIA_NASCITA"),
						rs1.getString("REGIONE_RESIDENZA"), rs1.getString("PROVINCIA_RESIDENZA"), rs1.getString("CITTA_RESIDENZA"), rs1.getString("INDIRIZZO"),
						rs1.getString("CAP"), rs1.getString("EMAIL"), rs1.getString("CELLULARE"));
				medici.add(a);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		ConnessioneDB.closeConnection(conn);
		return medici;
	}

	@Override
	public ArrayList<ProfiloDB> selectAllOperatoriSanitari() {
		// TODO Auto-generated method stub
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = conn.createStatement();
			String query = "SELECT * FROM hospitalmanager.PROFILI WHERE tipo = 'OS'";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				ProfiloDB a = new ProfiloDB(rs1.getString("CF"), rs1.getString("TIPO"),
						rs1.getString("PW"), rs1.getString("SPECIALIZZAZIONE"), rs1.getString("NOME"), rs1.getString("COGNOME"),
						rs1.getString("SESSO"), rs1.getString("DATA_NASCITA"), rs1.getString("LUOGO_NASCITA"), rs1.getString("PROVINCIA_NASCITA"),
						rs1.getString("REGIONE_RESIDENZA"), rs1.getString("PROVINCIA_RESIDENZA"), rs1.getString("CITTA_RESIDENZA"), rs1.getString("INDIRIZZO"),
						rs1.getString("CAP"), rs1.getString("EMAIL"), rs1.getString("CELLULARE"));
				operatoriSanitari.add(a);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		ConnessioneDB.closeConnection(conn);
		return operatoriSanitari;
	}

	@Override
	public ArrayList<ProfiloDB> selectAlloperatoriUfficio() {
		// TODO Auto-generated method stub
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = conn.createStatement();
			String query = "SELECT * FROM hospitalmanager.PROFILI WHERE tipo = 'OU'";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				ProfiloDB a = new ProfiloDB(rs1.getString("CF"), rs1.getString("TIPO"),
						rs1.getString("PW"), rs1.getString("SPECIALIZZAZIONE"), rs1.getString("NOME"), rs1.getString("COGNOME"),
						rs1.getString("SESSO"), rs1.getString("DATA_NASCITA"), rs1.getString("LUOGO_NASCITA"), rs1.getString("PROVINCIA_NASCITA"),
						rs1.getString("REGIONE_RESIDENZA"), rs1.getString("PROVINCIA_RESIDENZA"), rs1.getString("CITTA_RESIDENZA"), rs1.getString("INDIRIZZO"),
						rs1.getString("CAP"), rs1.getString("EMAIL"), rs1.getString("CELLULARE"));
				operatoriUfficio.add(a);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		ConnessioneDB.closeConnection(conn);
		return operatoriUfficio;
	}

	@Override
	public ProfiloDB selectProfiloByCF(String cf, TipoAccount tipo) {
		// TODO Auto-generated method stub
		ProfiloDB p = null;
		
					conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
					PreparedStatement ps1;
					ResultSet rs1;
		
					
					try {
						String query= "SELECT * from hospitalmanager.ANAGRAFICA WHERE CF = ? and TIPO=?";
						ps1 = conn.prepareStatement(query);
						ps1.setString(1, cf);
						ps1.setString(2, tipo.toString());
						rs1 = ps1.executeQuery();
						
						while (rs1.next()) {
							 p= new ProfiloDB(rs1.getString("CF"), rs1.getString("TIPO"),
										rs1.getString("PW"), rs1.getString("SPECIALIZZAZIONE"), rs1.getString("NOME"), rs1.getString("COGNOME"),
										rs1.getString("SESSO"), rs1.getString("DATA_NASCITA"), rs1.getString("LUOGO_NASCITA"), rs1.getString("PROVINCIA_NASCITA"),
										rs1.getString("REGIONE_RESIDENZA"), rs1.getString("PROVINCIA_RESIDENZA"), rs1.getString("CITTA_RESIDENZA"), rs1.getString("INDIRIZZO"),
										rs1.getString("CAP"), rs1.getString("EMAIL"), rs1.getString("CELLULARE"));
						}
					}
					catch(Exception e){
						e.printStackTrace();
					}
					
					ConnessioneDB.closeConnection(conn);
					return p;
	}

	@Override
	public boolean insertProfilo(ProfiloDB a) {
		// TODO Auto-generated method stub
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		PreparedStatement ps1;
		
		boolean check = true;
		
		System.out.println(a.getSesso().name());
		
		try {
			String query = "INSERT INTO hospitalmanager.PROFILI VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps1 = conn.prepareStatement(query);
			ps1.setString(1, a.getCf());
			ps1.setString(2, a.getTipoAcc().name());
			ps1.setString(3, a.getPw());
			ps1.setString(4, a.getNome());
			ps1.setString(5, a.getCognome());
			ps1.setString(6, a.getSesso().name());
			ps1.setString(7, a.getDataNascita());
			ps1.setString(8, a.getLuogoNascita());
			ps1.setString(9, a.getProvinciaNascita());
			ps1.setString(10, a.getRegioneRes());
			ps1.setString(11, a.getProvinciaRes());
			ps1.setString(12, a.getCittaRes());
			ps1.setString(13, a.getIndirizzo());
			ps1.setString(14, a.getCap());
			ps1.setString(15, a.geteMail());
			ps1.setString(16, a.getCellulare());
			ps1.setString(17, a.getSpecializzazione());
			
			//ps1.executeUpdate(query);
			ps1.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
			check = false;
		}
		
		ConnessioneDB.closeConnection(conn);
		return check;
	}

	@Override
	public boolean updatePw(String cf, TipoAccount tipo, String pw) {
		// TODO Auto-generated method stub
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		PreparedStatement ps1;
		
		boolean check = true;
		
		try {
			String query = "UPDATE hospitalmanager.PROFILI SET PW = ? WHERE CF = ?";
			ps1 = conn.prepareStatement(query);
			ps1.setString(1, pw);	
			ps1.setString(2, cf);
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

