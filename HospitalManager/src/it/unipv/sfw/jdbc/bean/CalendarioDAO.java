package it.unipv.sfw.jdbc.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.sfw.jdbc.ConnessioneDB;

public class CalendarioDAO implements ICalendarioDAO {
	private Connection conn;
	ArrayList<SlotCalendarioDB> calendario;
	
	
	public CalendarioDAO() {
		super();
		this.calendario = new ArrayList<>();
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
						rs1.getString("NOME_VACANZE"), rs1.getString("ORARIO"), rs1.getInt("ID_PREN_1"), rs1.getInt("ID_PREN_2"),
						rs1.getInt("ID_PREN_3"), rs1.getInt("ID_PREN_4"), rs1.getInt("ID_PREN_5"), rs1.getInt("ID_PREN_6"), 
						rs1.getInt("ID_PREN_7"), rs1.getInt("ID_PREN_8")); 
				
				calendario.add(sc);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		ConnessioneDB.closeConnection(conn);
				
		return calendario;
	}

}
