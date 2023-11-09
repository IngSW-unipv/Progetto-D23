//package it.unipv.sfw.jdbc.bean.esiti;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import it.unipv.sfw.jdbc.ConnessioneDB;
//import it.unipv.sfw.model.Prenotazione;
//
//public class EsitiDAO implements IEsitiDAO {
//	private Connection conn;
//	private ArrayList<EsitiDB> esiti;
//	
//	
//	
//	public EsitiDAO() {
//		super();
//		this.esiti = new ArrayList<>();
//	}
//
//	@Override
//	public ArrayList<EsitiDB> SelectAllEsiti() {
//		conn= ConnessioneDB.startConnection(conn,"hospitalmanager");
//		Statement st1;
//		ResultSet rs1;
//		
//		try {
//			st1= conn.createStatement();
//			String query= "SELECT * from hospitalmanager.ESITI";
//			rs1= st1.executeQuery(query);
//			
//			while (rs1.next()) {
//				EsitiDB e = new EsitiDB(rs1.getInt("ID_PREN"), rs1.getString("REFERTO"), rs1.getString("TERAPIA"));
//				esiti.add(e);
//			}
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//		
//		ConnessioneDB.closeConnection(conn);
//		return esiti;
//	}
//
//	@Override
//	public boolean insertEsito(Prenotazione p) {
//		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
//		PreparedStatement ps1;
//		
//		boolean check = true;
//		
//		try {
//			String query = "INSERT INTO hospitalmanager.ESITI VALUES (?,?,?)";
//			ps1 = conn.prepareStatement(query);
//			ps1.setInt(1, p.getIdPren());
//			ps1.setString(0, p.getEsiti().getReferto());
//			ps1.setString(0, p.getEsiti().getTerapia());		
//			ps1.executeUpdate(query);
//			//ps1.executeUpdate();
//		}
//		catch(Exception e){
//			e.printStackTrace();
//			check = false;
//		}
//		
//		ConnessioneDB.closeConnection(conn);
//		return check;
//	}
//
//		// selezione degli esiti passando l'idAccount del paziente
//	@Override
//	public ArrayList<EsitiDB> SelectEsitiByAccount(int idAcc) {
//		ArrayList<EsitiDB> esitiPaziente = new ArrayList<>();
//		
//		conn= ConnessioneDB.startConnection(conn,"hospitalmanager");
//		PreparedStatement ps1;
//		ResultSet rs1;
//
//		
//		try {
//			String query= "SELECT hospitalmanager.ESITI.* from hospitalmanager.PRENOTAZIONI JOIN hospitalmanager.ESITI ON PRENOTAZIONI.ID_PREN = ESITI.ID_PREN WHERE ID_PAZIENTE = ?";
//			ps1 = conn.prepareStatement(query);
//			ps1.setInt(1, idAcc);
//			rs1 = ps1.executeQuery(query);
//			
//			while (rs1.next()) {
//				EsitiDB e = new EsitiDB(rs1.getInt("ID_PREN"), rs1.getString("REFERTO"), rs1.getString("TERAPIA"));
//				esitiPaziente.add(e);
//			}
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//		
//		ConnessioneDB.closeConnection(conn);
//		return esitiPaziente;
//	}
//
//}
