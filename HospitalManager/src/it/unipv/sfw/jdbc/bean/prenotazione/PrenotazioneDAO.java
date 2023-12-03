package it.unipv.sfw.jdbc.bean.prenotazione;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import it.unipv.sfw.jdbc.ConnessioneDB;

public class PrenotazioneDAO implements IPrenotazioneDAO {
	private Connection conn;

	public PrenotazioneDAO() {
		super();
	}

	@Override
	public ArrayList<PrenotazioneDB> selectAllPrenotazioni() {
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		Statement st1;
		ResultSet rs1;
		ArrayList<PrenotazioneDB> prenotazioni = new ArrayList<>();
		try {
			st1= conn.createStatement();
			String query= "SELECT * FROM hospitalmanager.PRENOTAZIONI";
			rs1= st1.executeQuery(query);
			
			while (rs1.next()) {
				PrenotazioneDB pren = new PrenotazioneDB(rs1.getInt("ID_PREN"), rs1.getString("PAZIENTE"), rs1.getString("PERSONALE_SANITARIO"),
						rs1.getString("TIPO_PRESTAZIONE"), rs1.getString("DATA_PREN"), rs1.getString("ORA_PREN"));
				
				prenotazioni.add(pren);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		ConnessioneDB.closeConnection(conn);
		
		return prenotazioni;
	}

	@Override
	public boolean insertPrenotazione(PrenotazioneDB p) {
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		PreparedStatement ps1;
		
		boolean check;
		
		try {
			String query = "INSERT INTO hospitalmanager.PRENOTAZIONI VALUES (?,?,?,?,?,?)";
			ps1 = conn.prepareStatement(query);
			ps1.setInt(1, p.getIdPren());
			ps1.setString(2, p.getPaziente());
			ps1.setString(3, p.getPersonaleSanitario());
			ps1.setString(4, p.getTipo().name());
			ps1.setDate(5, Date.valueOf(p.getDataPren()));
			ps1.setTime(6, Time.valueOf(p.getOraPren()));
			ps1.executeUpdate();
			
			check = true;
		}
		catch(Exception e){
			e.printStackTrace();
			check = false;
		}
		ConnessioneDB.closeConnection(conn);
		return check;
	}
	
	@Override
	public boolean deletePrenotazione(PrenotazioneDB p) {
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		PreparedStatement ps1;
		Statement st1, st2;

		boolean check;
		
		try {
			st1= conn.createStatement();
			String query1 = "SET FOREIGN_KEY_CHECKS = 0";
			st1.executeQuery(query1);
			
			String query = "DELETE FROM hospitalmanager.PRENOTAZIONI WHERE ID_PREN = ?";
			ps1 = conn.prepareStatement(query);
			ps1.setInt(1, p.getIdPren());
			ps1.executeUpdate();
			
			st2= conn.createStatement();
			String query2 = "SET FOREIGN_KEY_CHECKS = 1";
			st2.executeQuery(query2);
			
			check = true;
		}
		catch(Exception e){
			e.printStackTrace();
			check = false;
		}
		ConnessioneDB.closeConnection(conn);
		return check;
	}

	@Override
	public ArrayList<PrenotazioneDB> selectPrenotazioniByPaziente(String cf) {
		ArrayList<PrenotazioneDB> prenotazioniPaziente = new ArrayList<>();
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		PreparedStatement ps1;
		ResultSet rs1;
		
		try {
			String query= "SELECT * FROM hospitalmanager.PRENOTAZIONI WHERE PAZIENTE = ?";
			ps1 = conn.prepareStatement(query);
			ps1.setString(1, cf);
			rs1= ps1.executeQuery();
			
			while (rs1.next()) {
				PrenotazioneDB pren = new PrenotazioneDB(rs1.getInt("ID_PREN"), rs1.getString("PAZIENTE"), rs1.getString("PERSONALE_SANITARIO"),
						rs1.getString("TIPO_PRESTAZIONE"), rs1.getString("DATA_PREN"), rs1.getString("ORA_PREN"));
				
				prenotazioniPaziente.add(pren);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		ConnessioneDB.closeConnection(conn);
		
		return prenotazioniPaziente;
	}
	
//	@Override
//	public ArrayList<PrenotazioneDB> selectPrenotazioniErogateByPaziente(String cf) {
//		ArrayList<PrenotazioneDB> prenotazioniPaziente = new ArrayList<>();
//		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
//		PreparedStatement ps1;
//		ResultSet rs1;
//		
//		try {
//			String query= "SELECT * FROM hospitalmanager.PRENOTAZIONI WHERE PAZIENTE = ?";
//			ps1 = conn.prepareStatement(query);
//			ps1.setString(1, cf);
//			rs1= ps1.executeQuery();
//			
//			while (rs1.next()) {
//				PrenotazioneDB pren = new PrenotazioneDB(rs1.getInt("ID_PREN"), rs1.getString("PAZIENTE"), rs1.getString("PERSONALE_SANITARIO"),
//						rs1.getString("TIPO_PRESTAZIONE"), rs1.getString("DATA_PREN"), rs1.getString("ORA_PREN"));
//				prenotazioniPaziente.add(pren);
//			}
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//		ConnessioneDB.closeConnection(conn);
//		
//		return prenotazioniPaziente;
//	}

	@Override
	public ArrayList<PrenotazioneDB> selectPrenotazioniByPersonaleSanitario(String cf) {
		ArrayList<PrenotazioneDB> prenotazioniPS = new ArrayList<>();
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		PreparedStatement ps1;
		ResultSet rs1;
		
		try {
			String query= "SELECT * FROM hospitalmanager.PRENOTAZIONI WHERE PERSONALE_SANITARIO = ? ORDER BY DATA_PREN";
			ps1 = conn.prepareStatement(query);
			ps1.setString(1, cf);
			rs1= ps1.executeQuery();
			
			while (rs1.next()) {
				PrenotazioneDB pren = new PrenotazioneDB(rs1.getInt("ID_PREN"), rs1.getString("PAZIENTE"), rs1.getString("PERSONALE_SANITARIO"),
						rs1.getString("TIPO_PRESTAZIONE"), rs1.getString("DATA_PREN"), rs1.getString("ORA_PREN"));
				prenotazioniPS.add(pren);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		ConnessioneDB.closeConnection(conn);
		
		return prenotazioniPS;
	}

	@Override
	public PrenotazioneDB selectPrenotazioneByIdPren(int idPren) {
		PrenotazioneDB prenotazione = null;
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		PreparedStatement ps1;
		ResultSet rs1;
		
		try {
			String query= "SELECT * FROM hospitalmanager.PRENOTAZIONI WHERE ID_PREN = ?";
			ps1 = conn.prepareStatement(query);
			ps1.setInt(0, idPren);
			rs1= ps1.executeQuery();
			
			prenotazione = new PrenotazioneDB(rs1.getInt("ID_PREN"), rs1.getString("PAZIENTE"), rs1.getString("PERSONALE_SANITARIO"),
					rs1.getString("TIPO_PRESTAZIONE"), rs1.getString("DATA_PREN"), rs1.getString("ORA_PREN"));
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		ConnessioneDB.closeConnection(conn);
		
		return prenotazione;
	}

	@Override
	public int selectNumeroPrenotazione() {
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		Statement st1;
		ResultSet rs1;
		int numeroPren=0;
		
		try {
			st1= conn.createStatement();
			String query= "SELECT ID_PREN FROM hospitalmanager.PRENOTAZIONI where ID_PREN= (select max(ID_PREN) from hospitalmanager.PRENOTAZIONI)";
			rs1= st1.executeQuery(query);
			if(rs1.next()) {
				numeroPren= rs1.getInt("ID_PREN");
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		ConnessioneDB.closeConnection(conn);
		return numeroPren;
	}

	@Override
	public ArrayList<PrenotazioneDB> selectPrenotazioniDaErogare() {
		ArrayList<PrenotazioneDB> prenotazioni = new ArrayList<>();
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		Statement st1;
		ResultSet rs1;
		
		try {
			st1= conn.createStatement();
			String query= "SELECT * FROM hospitalmanager.PRENOTAZIONI WHERE ESITO IS NULL";
			rs1= st1.executeQuery(query);
			
			while (rs1.next()) {
				PrenotazioneDB pren = new PrenotazioneDB(rs1.getInt("ID_PREN"), rs1.getString("PAZIENTE"), rs1.getString("PERSONALE_SANITARIO"),
						rs1.getString("TIPO_PRESTAZIONE"), rs1.getString("DATA_PREN"), rs1.getString("ORA_PREN"));
				
				prenotazioni.add(pren);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		ConnessioneDB.closeConnection(conn);
		
		return prenotazioni;
	}	

}
