package it.unipv.sfw.jdbc.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.sfw.jdbc.ConnessioneDB;
import it.unipv.sfw.prestazionisantarie.Prenotazione;
import it.unipv.sfw.prestazionisantarie.PrestazioneSanitaria;

public class CalendarioDAO implements ICalendarioDAO {
	private Connection conn;
	ArrayList<SlotCalendarioDB> calendario;
	ArrayList<SlotCalendarioDB> slotLiberi;
	
	public CalendarioDAO() {
		super();
		this.calendario = new ArrayList<>();
		this.slotLiberi = new ArrayList<>();

	}


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
				SlotCalendarioDB sc = new SlotCalendarioDB(rs1.getString("CALENDARIO_DATA"), rs1.getString("GIORNO_SETTIMANA"),
						rs1.getString("NOME_VACANZE"), rs1.getString("ORARIO"), rs1.getInt("PREST01"), rs1.getInt("PREST02"),
						rs1.getInt("PREST03"), rs1.getInt("PREST04"), rs1.getInt("PREST05"), rs1.getInt("PREST06"), 
						rs1.getInt("PREST07"), rs1.getInt("PREST08")); 
				
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
	public ArrayList<SlotCalendarioDB> SelectVoidSlot(String idPrest){
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = conn.createStatement();
			String query = "SELECT * FROM hospitalmanager.CALENDARI WHERE ? IS NULL";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				SlotCalendarioDB sc = new SlotCalendarioDB(rs1.getString("CALENDARIO_DATA"), rs1.getString("GIORNO_SETTIMANA"),
						rs1.getString("NOME_VACANZE"), rs1.getString("ORARIO"), rs1.getInt("PREST01"), rs1.getInt("PREST02"),
						rs1.getInt("PREST03"), rs1.getInt("PREST04"), rs1.getInt("PREST05"), rs1.getInt("PREST06"), 
						rs1.getInt("PREST07"), rs1.getInt("PREST08")); 
				
				slotLiberi.add(sc);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		ConnessioneDB.closeConnection(conn);
				
		return calendario;
	}
	
	//inserimento appuntamenti nel calendario
	@Override
	public boolean UpdateCalendario(Prenotazione p) {
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		PreparedStatement ps1;
		
		boolean check = true;
		
		try {
			String query = "UPDATE hospitalmanager.CALENDARI SET ? = ? WHERE CALENDARIO_DATA = ? AND ORARIO = ?";
			ps1 = conn.prepareStatement(query);
			ps1.setString(1, p.getIdPrest());	//identifica la colonna della table CALENDARI
			ps1.setInt(2, p.getIdPren());		//identificatore prenotazione da inserire a calendario
			ps1.setDate(3, p.getData());
			ps1.setTime(4, p.getOrario());
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
