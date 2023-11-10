//package it.unipv.sfw.jdbc.bean.anagrafica;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import it.unipv.sfw.jdbc.ConnessioneDB;
//import it.unipv.sfw.model.persona.Account;
//
//
//public class AnagraficaDAO implements IAnagraficaDAO {
//	private Connection conn;
//	ArrayList<AnagraficaDB> persone;
//	
//	
//	public AnagraficaDAO() {
//		super();
//		this.persone = new ArrayList<>();
//	}
//
//	@Override
//	public ArrayList<AnagraficaDB> selectAllAnagrafica() {
//		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
//		Statement st1;
//		ResultSet rs1;
//		
//		try {
//			st1= conn.createStatement();
//			String query= "SELECT * from hospitalmanager.anagrafica";
//			rs1= st1.executeQuery(query);
//			
//			while (rs1.next()) {
//				AnagraficaDB af= new AnagraficaDB(rs1.getString("CF"), rs1.getString("NOME"), rs1.getString("COGNOME"),
//						rs1.getString("GENERE"), rs1.getString("DATA_NASCITA"), rs1.getString("LUOGO_NASCITA"), rs1.getString("PROVINCIA_NASCITA"),
//						rs1.getString("REGIONE_RESIDENZA"), rs1.getString("PROVINCIA_RESIDENZA"), rs1.getString("CITTA_RESIDENZA"), rs1.getString("INDIRIZZO"),
//						rs1.getString("CAP"), rs1.getString("EMAIL"), rs1.getString("CELLULARE"));
//				persone.add(af);
//			}
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//		ConnessioneDB.closeConnection(conn);
//		
//		return persone;
//		
//	}
//	
//	//inserimento anagrafica passando i relativi parametri
//		@Override
//		public boolean insertAnagrafica(Account p) {
//			conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
//			PreparedStatement ps1;
//			
//			boolean check = true;
//			
//			try {
//				String query = "INSERT INTO hospitalmanager.ANAGRAFICA VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
//				ps1 = conn.prepareStatement(query);
//				ps1.setString(1, p.getCf());
//				ps1.setString(2, p.getNome());
//				ps1.setString(3, p.getCognome());
//				ps1.setString(4, p.getSesso());
//				ps1.setString(5, p.getDataNascita());
//				ps1.setString(6, p.getLuogoNascita());
//				ps1.setString(7, p.getProvinciaNascita());
//				ps1.setString(8, p.getRegioneRes());
//				ps1.setString(9, p.getProvinciaRes());
//				ps1.setString(10, p.getCittaRes());
//				ps1.setString(11, p.getIndirizzo());
//				ps1.setString(12, p.geteMail());
//				ps1.setString(13, p.getCellulare());
//				ps1.executeUpdate(query);
//				//ps1.executeUpdate();
//			}
//			catch(Exception e){
//				e.printStackTrace();
//				check = false;
//			}
//			
//			ConnessioneDB.closeConnection(conn);
//			return check;
//
//		}
//
//		@Override
//		public AnagraficaDB selectAnagraficaByCf(String cf) {
//			AnagraficaDB af = null;
//
//			conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
//			PreparedStatement ps1;
//			ResultSet rs1;
//
//			
//			try {
//				String query= "SELECT * from hospitalmanager.ANAGRAFICA WHERE CF = ? ";
//				ps1 = conn.prepareStatement(query);
//				ps1.setString(1, cf);
//				rs1 = ps1.executeQuery();
//				
//				while (rs1.next()) {
//					 af = new AnagraficaDB(rs1.getString("CF"), rs1.getString("NOME"), rs1.getString("COGNOME"),
//							rs1.getString("GENERE"), rs1.getString("DATA_NASCITA"), rs1.getString("LUOGO_NASCITA"), rs1.getString("PROVINCIA_NASCITA"),
//							rs1.getString("REGIONE_RESIDENZA"), rs1.getString("PROVINCIA_RESIDENZA"), rs1.getString("CITTA_RESIDENZA"), rs1.getString("INDIRIZZO"),
//							rs1.getString("CAP"), rs1.getString("EMAIL"), rs1.getString("CELLULARE"));
//				}
//			}
//			catch(Exception e){
//				e.printStackTrace();
//			}
//			
//			ConnessioneDB.closeConnection(conn);
//			return af;
//		}
//		
//		@Override
//		public ArrayList<AnagraficaDB> selectAnagraficaMedici() {
//			ArrayList<AnagraficaDB> medici = new  ArrayList<>();
//
//			conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
//			Statement st1;
//			ResultSet rs1;
//			
//			try {
//				st1= conn.createStatement();
//				String query= "SELECT ANAGRAFICA.* from hospitalmanager.PROFILI JOIN hospitalmanager.ANAGRAFICA ON PROFILI.CF = ANAGRAFICA.CF WHERE PROFILI.TIPO = 'ME'";
//				rs1= st1.executeQuery(query);
//				
//				while (rs1.next()) {
//					 AnagraficaDB m = new AnagraficaDB(rs1.getString("CF"), rs1.getString("NOME"), rs1.getString("COGNOME"),
//							rs1.getString("GENERE"), rs1.getString("DATA_NASCITA"), rs1.getString("LUOGO_NASCITA"), rs1.getString("PROVINCIA_NASCITA"),
//							rs1.getString("REGIONE_RESIDENZA"), rs1.getString("PROVINCIA_RESIDENZA"), rs1.getString("CITTA_RESIDENZA"), rs1.getString("INDIRIZZO"),
//							rs1.getString("CAP"), rs1.getString("EMAIL"), rs1.getString("CELLULARE"));
//					 medici.add(m);
//				}
//			}
//			catch(Exception e){
//				e.printStackTrace();
//			}
//			
//			ConnessioneDB.closeConnection(conn);
//			return medici;
//		}
//}
