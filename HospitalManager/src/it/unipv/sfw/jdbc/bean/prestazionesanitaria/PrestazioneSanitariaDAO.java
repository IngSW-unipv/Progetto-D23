package it.unipv.sfw.jdbc.bean.prestazionesanitaria;

import java.sql.*;
import java.util.ArrayList;

import it.unipv.sfw.jdbc.ConnessioneDB;

public class PrestazioneSanitariaDAO implements IPrestazioneSanitariaDAO {
	private Connection conn;
	ArrayList<PrestazioneSanitariaDB> prestazioni;
	
	public PrestazioneSanitariaDAO() {
		super();
		this.prestazioni = new ArrayList<>();
	}

	@Override
	public ArrayList<PrestazioneSanitariaDB> selectAllPrestazioniSanitarie() {
		conn= ConnessioneDB.startConnection(conn,"hospitalmanager");
		Statement st1;
		ResultSet rs1;
		
		try {
			st1= conn.createStatement();
			String query= "SELECT * from hospitalmanager.prestazioni_sanitarie";
			rs1= st1.executeQuery(query);
			
			while (rs1.next()) {
				PrestazioneSanitariaDB ps= new PrestazioneSanitariaDB(rs1.getInt("ID_PREST"), rs1.getString("TIPO"), rs1.getString("DURATA"), rs1.getDouble("COSTO"));
				prestazioni.add(ps);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		ConnessioneDB.closeConnection(conn);
		
		return prestazioni;
			
	}

	@Override
	public PrestazioneSanitariaDB selectPrestazioneByIdPrest(int idPrest) {
		// TODO Auto-generated method stub
		return null;
	}

}
