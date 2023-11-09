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
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		PreparedStatement ps1;
		
		boolean check;
		
		try {
			String query = "INSERT INTO hospitalmanager.PRENOTAZIONE VALUES (?,?,?,?,?,?,?,?)";
			ps1 = conn.prepareStatement(query);
			ps1.setInt(1, p.getIdPren());
			ps1.setInt(2, p.getPaziente().getIdAcc());
			ps1.setInt(3, p.getMedico().getIdAcc());
			ps1.setInt(4, p.getOpSanitario().getIdAcc());
			ps1.setString(5, p.getPrestazione().getIdPrest());
			ps1.setDate(6, Date.valueOf(p.getData()));
			ps1.setTime(7, Time.valueOf(p.getOrario()));
			ps1.setBoolean(8, p.isAccreditamento());
			ps1.executeUpdate(query);
			
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
	public ArrayList<PrenotazioneDB> selectPrenotazioniByIdPaziente(int idPaziente) {
		ArrayList<PrenotazioneDB> prenotazioniPaziente = new ArrayList<>();
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		PreparedStatement ps1;
		ResultSet rs1;
		
		try {
			String query= "SELECT * FROM hospitalmanager.PRENOTAZIONI WHERE ID_PAZIENTE = ? AND ESITO IS NULL";
			ps1 = conn.prepareStatement(query);
			ps1.setInt(0, idPaziente);
			rs1= ps1.executeQuery(query);
			
			while (rs1.next()) {
				PrenotazioneDB pren= new PrenotazioneDB(rs1.getInt("ID_PREN"), rs1.getInt("ID_PAZIENTE"), rs1.getInt("ID_MEDICO"),
						rs1.getInt("ID_OSS"), rs1.getString("ID_PREST"), rs1.getString("DATA_PREN"), rs1.getString("ORA_PREN"),
						rs1.getString("NOTE"));
				prenotazioniPaziente.add(pren);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		ConnessioneDB.closeConnection(conn);
		
		return prenotazioniPaziente;
	}
	
	@Override
	public ArrayList<PrenotazioneDB> selectPrenotazioniErogateByIdPaziente(int idPaziente) {
		ArrayList<PrenotazioneDB> prenotazioniPaziente = new ArrayList<>();
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		PreparedStatement ps1;
		ResultSet rs1;
		
		try {
			String query= "SELECT * FROM hospitalmanager.PRENOTAZIONI WHERE ID_PAZIENTE = ? AND ESITO IS NOT NULL";
			ps1 = conn.prepareStatement(query);
			ps1.setInt(0, idPaziente);
			rs1= ps1.executeQuery(query);
			
			while (rs1.next()) {
				PrenotazioneDB pren= new PrenotazioneDB(rs1.getInt("ID_PREN"), rs1.getInt("ID_PAZIENTE"), rs1.getInt("ID_MEDICO"),
						rs1.getInt("ID_OSS"), rs1.getString("ID_PREST"), rs1.getString("DATA_PREN"), rs1.getString("ORA_PREN"),
						rs1.getString("NOTE"));
				prenotazioniPaziente.add(pren);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		ConnessioneDB.closeConnection(conn);
		
		return prenotazioniPaziente;
	}

	@Override
	public ArrayList<PrenotazioneDB> selectPrenotazioniByIdMedico(int idMedico) {
		ArrayList<PrenotazioneDB> prenotazioniMedico = new ArrayList<>();
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		PreparedStatement ps1;
		ResultSet rs1;
		
		try {
			String query= "SELECT * FROM hospitalmanager.PRENOTAZIONI WHERE ID_MEDICO = ?";
			ps1 = conn.prepareStatement(query);
			ps1.setInt(0, idMedico);
			rs1= ps1.executeQuery(query);
			
			while (rs1.next()) {
				PrenotazioneDB pren= new PrenotazioneDB(rs1.getInt("ID_PREN"), rs1.getInt("ID_PAZIENTE"), rs1.getInt("ID_MEDICO"),
						rs1.getInt("ID_OSS"), rs1.getString("ID_PREST"), rs1.getString("DATA_PREN"), rs1.getString("ORA_PREN"),
						rs1.getString("NOTE"));
				prenotazioniMedico.add(pren);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		ConnessioneDB.closeConnection(conn);
		
		return prenotazioniMedico;
	}

	@Override
	public ArrayList<PrenotazioneDB> selectPrenotazioniByIdOperatore(int idOperatoreSanitario) {
		ArrayList<PrenotazioneDB> prenotazioniOpSanitario = new ArrayList<>();
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		PreparedStatement ps1;
		ResultSet rs1;
		
		try {
			String query= "SELECT * FROM hospitalmanager.PRENOTAZIONI WHERE ID_OSS = ?";
			ps1 = conn.prepareStatement(query);
			ps1.setInt(0, idOperatoreSanitario);
			rs1= ps1.executeQuery(query);
			
			while (rs1.next()) {
				PrenotazioneDB pren= new PrenotazioneDB(rs1.getInt("ID_PREN"), rs1.getInt("ID_PAZIENTE"), rs1.getInt("ID_MEDICO"),
						rs1.getInt("ID_OSS"), rs1.getString("ID_PREST"), rs1.getString("DATA_PREN"), rs1.getString("ORA_PREN"),
						rs1.getString("NOTE"));
				prenotazioniOpSanitario.add(pren);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		ConnessioneDB.closeConnection(conn);
		
		return prenotazioniOpSanitario;
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
			rs1= ps1.executeQuery(query);
			
			prenotazione = new PrenotazioneDB(rs1.getInt("ID_PREN"), rs1.getInt("ID_PAZIENTE"), rs1.getInt("ID_MEDICO"),
				rs1.getInt("ID_OSS"), rs1.getString("ID_PREST"), rs1.getString("DATA_PREN"), rs1.getString("ORA_PREN"),
				rs1.getString("NOTE"));
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		ConnessioneDB.closeConnection(conn);
		
		return prenotazione;
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
