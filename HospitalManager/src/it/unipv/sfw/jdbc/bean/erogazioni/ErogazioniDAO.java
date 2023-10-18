package it.unipv.sfw.jdbc.bean.erogazioni;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.sfw.jdbc.ConnessioneDB;
import it.unipv.sfw.model.Erogazione;

public class ErogazioniDAO implements IErogazioniDAO {
	private Connection conn;
	private ArrayList<ErogazioniDB> erogazioni;
	
	public ErogazioniDAO() {
		super();
		this.erogazioni = new ArrayList<>();
	}

	@Override
	public ArrayList<ErogazioniDB> SelectAllErogazioni() {
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		Statement st1;
		ResultSet rs1;
		
		try {
			st1 = conn.createStatement();
			String query = "SELECT * FROM hospitalmanager.EROGAZIONI";
			rs1 = st1.executeQuery(query);
			
			while(rs1.next()) {
				ErogazioniDB e = new ErogazioniDB(rs1.getInt("ID_PREN"), rs1.getString("DATA_EROG"), rs1.getString("ORA_EROG"), rs1.getBoolean("ACCREDITAMENTO"));
				erogazioni.add(e);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		ConnessioneDB.closeConnection(conn);
		
		return erogazioni;
	}

	@Override
	public boolean insertErogazione(Erogazione e) {
		// TODO Auto-generated method stub
		return false;
	}

}
