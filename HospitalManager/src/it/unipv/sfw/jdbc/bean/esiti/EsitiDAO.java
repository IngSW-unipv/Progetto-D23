package it.unipv.sfw.jdbc.bean.esiti;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.sfw.jdbc.ConnessioneDB;
import it.unipv.sfw.model.Esito;

public class EsitiDAO implements IEsitiDAO {
	private Connection conn;
	private ArrayList<EsitiDB> esiti;
	
	
	
	public EsitiDAO() {
		super();
		this.esiti = new ArrayList<>();
	}

	@Override
	public ArrayList<EsitiDB> SelectAllEsiti() {
		conn= ConnessioneDB.startConnection(conn,"hospitalmanager");
		Statement st1;
		ResultSet rs1;
		
		try {
			st1= conn.createStatement();
			String query= "SELECT * from hospitalmanager.ESITI";
			rs1= st1.executeQuery(query);
			
			while (rs1.next()) {
				EsitiDB e = new EsitiDB(rs1.getInt("ID_PRESN"), rs1.getString("REFERTO"), rs1.getString("TERAPIA"));
				esiti.add(e);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		ConnessioneDB.closeConnection(conn);
		return esiti;
	}

	@Override
	public boolean insertEsito(Esito e) {
		// TODO Auto-generated method stub
		return false;
	}

}
