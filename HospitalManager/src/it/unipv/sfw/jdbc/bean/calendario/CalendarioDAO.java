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
import it.unipv.sfw.model.Prenotazione;

public class CalendarioDAO implements ICalendarioDAO {
	private Connection conn;
	ArrayList<SlotCalendarioSingoloDB> calendarioSingolo;
	ArrayList<SlotCalendarioDB> calendario;
	
	
	public CalendarioDAO() {
		super();
		this.calendarioSingolo = new ArrayList<>();
	}

//	String giorno, String vacanza, String orario, int idPren1, int idPren2, int idPren3,
//	int idPren4, int idPren5, int idPren6, int idPren7) {


	@Override
	public ArrayList<SlotCalendarioDB> SelectCalendario() {
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = conn.createStatement();
			String query = "SELECT * FROM hospitalmanager.CALENDARI";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				SlotCalendarioDB sc = new SlotCalendarioDB(rs1.getString("CALENDARIO_DATA"), rs1.getString("NOME_VACANZE"),
						rs1.getString("GIORNO_SETTIMANA"), rs1.getString("ORARIO"), rs1.getInt("PREST01"), rs1.getInt("PREST02"),
						rs1.getInt("PREST03"), rs1.getInt("PREST04"), rs1.getInt("PREST05"), rs1.getInt("PREST06"), 
						rs1.getInt("PREST07")); 
				
				calendario.add(sc);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		ConnessioneDB.closeConnection(conn);
				
		return calendario;
	}
	
	// ricerca slot liberi per prestazione

	@Override
	public ArrayList<SlotCalendarioSingoloDB> SelectVoidSlot(String idPrest){
		ArrayList<SlotCalendarioSingoloDB> slotLiberi = new ArrayList<>();
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		PreparedStatement ps1;
		ResultSet rs1;
		
		Date dataCorrente = new Date(System.currentTimeMillis());
		
		try {
			String query = "SELECT CALENDARIO_DATA, GIORNO_SETTIMANA, NOME_VACANZE, ORARIO, ?  FROM hospitalmanager.CALENDARI "
					+ "WHERE ? IS NULL "
					+ "AND CALENDARIO_DATA > ? "
					+ "AND NOME_VACANZE IS NULL "
					+ "AND GIORNO_SETTIMANA <> 'Domenica'";
			ps1 = conn.prepareStatement(query);
			ps1.setString(1, idPrest);
			ps1.setString(2, idPrest);
			ps1.setDate(3, dataCorrente);
			rs1 = ps1.executeQuery(query);
			
			while(rs1.next()) {
				SlotCalendarioSingoloDB sc = new SlotCalendarioSingoloDB(rs1.getString("CALENDARIO_DATA"), rs1.getString("GIORNO_SETTIMANA"),
						rs1.getString("NOME_VACANZE"), rs1.getString("ORARIO"), rs1.getInt(idPrest));
				
				slotLiberi.add(sc);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		ConnessioneDB.closeConnection(conn);
				
		return calendarioSingolo;
	}
	
	//inserimento appuntamenti nel calendario
	@Override
	public boolean UpdateCalendario(PrenotazioneDB p) {
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		PreparedStatement ps1;
		
		boolean check = true;
		
		try {
			String query = "UPDATE hospitalmanager.CALENDARI SET ? = ? WHERE CALENDARIO_DATA = ? AND ORARIO = ?";
			ps1 = conn.prepareStatement(query);
			ps1.setString(1, p.getIdPrest());	//identifica la colonna della table CALENDARI
			ps1.setInt(2, p.getIdPren());		//identificatore prenotazione da inserire a calendario
			ps1.setDate(3, Date.valueOf(p.getDataPren()));
			ps1.setTime(4, Time.valueOf(p.getOraPren()));
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
