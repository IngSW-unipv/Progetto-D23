package it.unipv.sfw.jdbc.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.sfw.jdbc.ConnessioneDB;

public class AnagraficaDAO implements IAnagraficaDAO {
	private Connection conn;
	ArrayList<AnagraficaDB> persone;
	
	
	
	public AnagraficaDAO() {
		super();
		this.persone = new ArrayList<>();
	}

	@Override
	public ArrayList<AnagraficaDB> selectAllAnagrafica() {
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		Statement st1;
		ResultSet rs1;
		
		try {
			st1= conn.createStatement();
			String query= "SELECT * from hospitalmanager.anagrafica";
			rs1= st1.executeQuery(query);
			
			while (rs1.next()) {
				AnagraficaDB af= new AnagraficaDB(rs1.getString("CF"), rs1.getString("NOME"), rs1.getString("COGNOME"),
						rs1.getString("GENERE"), rs1.getString("DATA_NASCITA"), rs1.getString("LUOGO_NASCITA"), rs1.getString("PROVINCIA_NASCITA"),
						rs1.getString("REGIONE_RESIDENZA"), rs1.getString("PROVINCIA_RESIDENZA"), rs1.getString("CITTA_RESIDENZA"), rs1.getString("INDIRIZZO"),
						rs1.getString("EMAIL"), rs1.getString("CELLULARE"));
				persone.add(af);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		ConnessioneDB.closeConnection(conn);
		
		return persone;
		
	}

}
