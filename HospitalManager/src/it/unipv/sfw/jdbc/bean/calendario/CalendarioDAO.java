package it.unipv.sfw.jdbc.bean.calendario;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import it.unipv.sfw.jdbc.ConnessioneDB;
import it.unipv.sfw.jdbc.bean.prenotazione.PrenotazioneDB;

public class CalendarioDAO implements ICalendarioDAO {
	private Connection conn;
	ArrayList<SlotCalendarioSingoloDB> calendarioSingolo;
	ArrayList<SlotCalendarioDB> calendario;
	
	
	public CalendarioDAO() {
		super();
		this.calendarioSingolo = new ArrayList<>();
	}

	@Override
	public ArrayList<SlotCalendarioDB> selectCalendario() {
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = conn.createStatement();
			String query = "SELECT * FROM hospitalmanager.CALENDARI";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				SlotCalendarioDB sc = new SlotCalendarioDB(rs1.getString("CALENDARIO_DATA"), rs1.getString("NOME_VACANZE"),
						rs1.getString("GIORNO_SETTIMANA"), rs1.getString("ORARIO"), rs1.getInt("VISITA_ONCOLOGICA"), rs1.getInt("VISITA_PSICOLOGICA"),
						rs1.getInt("ESAMI_SANGUE"), rs1.getInt("TAC"), rs1.getInt("RISONANZA_MAGNETICA"), rs1.getInt("CHEMIOTERAPIA"), 
						rs1.getInt("RADIOTERAPIA")); 
				
				calendario.add(sc);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		ConnessioneDB.closeConnection(conn);
				
		return calendario;
	}
	
	@Override
	public ArrayList<SlotCalendarioSingoloDB> selectCalendarioOncologica() {
		ArrayList<SlotCalendarioSingoloDB> s = new ArrayList<>();
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = conn.createStatement();
			String query = "SELECT * FROM hospitalmanager.CALENDARIO_VISITA_ONCOLOGICA";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				SlotCalendarioSingoloDB sc = new SlotCalendarioSingoloDB(rs1.getString("CALENDARIO_DATA"), rs1.getString("GIORNO_SETTIMANA"),
						rs1.getString("NOME_VACANZE"), rs1.getString("ORARIO"), rs1.getInt("VISITA_ONCOLOGICA")); 
				
				s.add(sc);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		ConnessioneDB.closeConnection(conn);
				
		return s;
	}
	
	@Override
	public ArrayList<SlotCalendarioSingoloDB> selectCalendarioPsicologica() {
		ArrayList<SlotCalendarioSingoloDB> s = new ArrayList<>();
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = conn.createStatement();
			String query = "SELECT * FROM hospitalmanager.CALENDARIO_VISITA_PSICOLOGICA";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				SlotCalendarioSingoloDB sc = new SlotCalendarioSingoloDB(rs1.getString("CALENDARIO_DATA"), rs1.getString("GIORNO_SETTIMANA"),
						rs1.getString("NOME_VACANZE"), rs1.getString("ORARIO"), rs1.getInt("VISITA_PSICOLOGICA")); 
				
				s.add(sc);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		ConnessioneDB.closeConnection(conn);
				
		return s;
	}
	
	@Override
	public ArrayList<SlotCalendarioSingoloDB> selectCalendarioTac() {
		ArrayList<SlotCalendarioSingoloDB> s = new ArrayList<>();
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = conn.createStatement();
			String query = "SELECT * FROM hospitalmanager.CALENDARIO_TAC";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				SlotCalendarioSingoloDB sc = new SlotCalendarioSingoloDB(rs1.getString("CALENDARIO_DATA"), rs1.getString("GIORNO_SETTIMANA"),
						rs1.getString("NOME_VACANZE"), rs1.getString("ORARIO"), rs1.getInt("TAC")); 
				
				s.add(sc);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		ConnessioneDB.closeConnection(conn);
				
		return s;
	}
	
	@Override
	public ArrayList<SlotCalendarioSingoloDB> selectCalendarioEsamiSangue() {
		ArrayList<SlotCalendarioSingoloDB> s = new ArrayList<>();
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = conn.createStatement();
			String query = "SELECT * FROM hospitalmanager.CALENDARIO_ESAMI_SANGUE";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				SlotCalendarioSingoloDB sc = new SlotCalendarioSingoloDB(rs1.getString("CALENDARIO_DATA"), rs1.getString("GIORNO_SETTIMANA"),
						rs1.getString("NOME_VACANZE"), rs1.getString("ORARIO"), rs1.getInt("ESAMI_SANGUE")); 
				
				s.add(sc);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		ConnessioneDB.closeConnection(conn);
				
		return s;
	}
	
	@Override
	public ArrayList<SlotCalendarioSingoloDB> selectCalendarioRisonanza() {
		ArrayList<SlotCalendarioSingoloDB> s = new ArrayList<>();
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = conn.createStatement();
			String query = "SELECT * FROM hospitalmanager.CALENDARIO_RISONANZA";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				SlotCalendarioSingoloDB sc = new SlotCalendarioSingoloDB(rs1.getString("CALENDARIO_DATA"), rs1.getString("GIORNO_SETTIMANA"),
						rs1.getString("NOME_VACANZE"), rs1.getString("ORARIO"), rs1.getInt("RISONANZA")); 
				
				s.add(sc);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		ConnessioneDB.closeConnection(conn);
				
		return s;
	}
	
	@Override
	public ArrayList<SlotCalendarioSingoloDB> selectCalendarioChemio() {
		ArrayList<SlotCalendarioSingoloDB> s = new ArrayList<>();
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = conn.createStatement();
			String query = "SELECT * FROM hospitalmanager.CALENDARIO_CHEMIOTERAPIA";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				SlotCalendarioSingoloDB sc = new SlotCalendarioSingoloDB(rs1.getString("CALENDARIO_DATA"), rs1.getString("GIORNO_SETTIMANA"),
						rs1.getString("NOME_VACANZE"), rs1.getString("ORARIO"), rs1.getInt("CHEMIOTERAPIA")); 
				
				s.add(sc);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		ConnessioneDB.closeConnection(conn);
				
		return s;
	}
	
	@Override
	public ArrayList<SlotCalendarioSingoloDB> selectCalendarioRadio() {
		ArrayList<SlotCalendarioSingoloDB> s = new ArrayList<>();
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = conn.createStatement();
			String query = "SELECT * FROM hospitalmanager.CALENDARIO_RADIOTERAPIA";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				SlotCalendarioSingoloDB sc = new SlotCalendarioSingoloDB(rs1.getString("CALENDARIO_DATA"), rs1.getString("GIORNO_SETTIMANA"),
						rs1.getString("NOME_VACANZE"), rs1.getString("ORARIO"), rs1.getInt("RADIOTERAPIA")); 
				
				s.add(sc);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		ConnessioneDB.closeConnection(conn);
				
		return s;
	}
	
	
	
	
	
//	@Override
//	public ArrayList<SlotCalendarioSingoloDB> selectVoidSlot(TipoPrestazione prest){
//		ArrayList<SlotCalendarioSingoloDB> slotLiberi = new ArrayList<>();
//		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
//		PreparedStatement ps1;
//		ResultSet rs1;
//		
//		Date dataCorrente = new Date(System.currentTimeMillis());
//		System.out.println(dataCorrente.toString());
//		
//		try {
//			String query = "SELECT CALENDARIO_DATA, GIORNO_SETTIMANA, NOME_VACANZE, ORARIO, ? FROM hospitalmanager.CALENDARI WHERE ? IS NULL AND CALENDARIO_DATA > ? AND NOME_VACANZE IS NULL AND GIORNO_SETTIMANA <> 'Domenica' ORDER BY CALENDARIO_DATA LIMIT 0, 200";
//			ps1 = conn.prepareStatement(query);
//			ps1.setString(1, prest.name());
//			ps1.setString(2, prest.name());
//			ps1.setDate(3, dataCorrente);
//			rs1 = ps1.executeQuery();
//			
//			while(rs1.next()) {
//				SlotCalendarioSingoloDB sc = new SlotCalendarioSingoloDB(rs1.getString("CALENDARIO_DATA"), rs1.getString("GIORNO_SETTIMANA"),
//						rs1.getString("NOME_VACANZE"), rs1.getString("ORARIO"), rs1.getInt(prest.name()));
//				//test
//				System.out.println(sc.toString());
//				/////////////
//				slotLiberi.add(sc);
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		ConnessioneDB.closeConnection(conn);
//				
//		return calendarioSingolo;
//	}
	
	//inserimento appuntamenti nel calendario
	@Override
	public boolean updateCalendarioNewPren(PrenotazioneDB p) {
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		PreparedStatement ps1;
		
		boolean check = true;
		
		try {
			String query = "UPDATE hospitalmanager.CALENDARI SET ? = ? WHERE CALENDARIO_DATA = ? AND ORARIO = ?";
			ps1 = conn.prepareStatement(query);
			ps1.setString(1, p.getTipo().name());	//identifica la colonna della table CALENDARI
			ps1.setInt(2, p.getIdPren());		//identificatore prenotazione da inserire a calendario
			ps1.setDate(3, Date.valueOf(p.getDataPren()));
			ps1.setTime(4, Time.valueOf(p.getOraPren()));
			ps1.executeUpdate();
			//ps1.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace();
			check = false;
		}
		
		ConnessioneDB.closeConnection(conn);
		return check;
	}

	//cancella appuntamenti nel calendario
	@Override
	public boolean updateCalendarioDelPren(PrenotazioneDB p) {
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		PreparedStatement ps1;
		
		boolean check = true;
		
		try {
			String query = "UPDATE hospitalmanager.CALENDARI SET ? = NULL WHERE CALENDARIO_DATA = ? AND ORARIO = ?";
			ps1 = conn.prepareStatement(query);
			ps1.setString(1, p.getTipo().name());	//identifica la colonna della table CALENDARI
			ps1.setDate(2, Date.valueOf(p.getDataPren()));
			ps1.setTime(3, Time.valueOf(p.getOraPren()));
			ps1.executeUpdate();
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
