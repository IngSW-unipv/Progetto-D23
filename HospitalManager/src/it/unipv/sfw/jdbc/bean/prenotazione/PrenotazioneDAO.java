package it.unipv.sfw.jdbc.bean.prenotazione;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

import it.unipv.sfw.jdbc.ConnessioneDB;
import it.unipv.sfw.model.Prenotazione;

public class PrenotazioneDAO implements IPrenotazioneDAO {
	private Connection conn;
	private ArrayList<PrenotazioneDB> prenotazioni;
	
	

	public PrenotazioneDAO() {
		super();
		this.prenotazioni = new ArrayList<>();
	}

	@Override
	public ArrayList<PrenotazioneDB> selectAllPrenotazioni() {
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		Statement st1;
		ResultSet rs1;
		
		try {
			st1= conn.createStatement();
			String query= "SELECT * FROM hospitalmanager.PRENOTAZIONI";
			rs1= st1.executeQuery(query);
			
			while (rs1.next()) {
				PrenotazioneDB pren= new PrenotazioneDB(rs1.getInt("ID_PREN"), rs1.getInt("ID_PAZIENTE"), rs1.getInt("ID_MEDICO"),
						rs1.getInt("ID_OSS"), rs1.getString("ID_PREST"), rs1.getString("DATA_PREN"), rs1.getString("ORA_PREN"),
						rs1.getString("NOTE"));
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
	public boolean insertPrenotazione(Prenotazione p) {
		return false;
	}

	@Override
	public ArrayList<PrenotazioneDB> selectPrenotazioniByIdPaziente(int idPaziente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PrenotazioneDB> selectPrenotazioniByIdMedico(int idMedico) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PrenotazioneDB> selectPrenotazioniByIdOperatore(int idOperatoreSanitario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrenotazioneDB selectPrenotazioneByIdPren(int idPren) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAccreditamento(Prenotazione p, boolean pagamento) {
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		PreparedStatement ps1;
		
		boolean check = true;
		
		try {
			String query = "UPDATE hospitalmanager.PRENOTAZIONI SET ACCREDITAMENTO = ? WHERE ID_PREN = ?";
			ps1 = conn.prepareStatement(query);
			ps1.setBoolean(1, pagamento);
			ps1.setInt(2, p.getIdPren());
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
