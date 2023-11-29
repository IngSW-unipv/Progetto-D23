package it.unipv.sfw.jdbc.bean.cartellaclinica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import it.unipv.sfw.jdbc.ConnessioneDB;

public class CartellaClinicaDAO implements ICartellaClinicaDAO {
	private Connection conn;
	private ArrayList<CartellaClinicaDB> cartelleCliniche;

	
	
	public CartellaClinicaDAO(Connection conn, ArrayList<CartellaClinicaDB> cartelleCliniche) {
		super();
		this.cartelleCliniche = new ArrayList<>();
	}

	public CartellaClinicaDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<CartellaClinicaDB> selectAllCartelle() {
		conn= ConnessioneDB.startConnection(conn,"hospitalmanager");
		Statement st1;
		ResultSet rs1;
		
		try {
			st1= conn.createStatement();
			String query= "SELECT * from hospitalmanager.CARTELLE_CLINICHE";
			rs1= st1.executeQuery(query);
			
			while (rs1.next()) {
				CartellaClinicaDB cc = new CartellaClinicaDB(rs1.getString("CF"), rs1.getInt("ALTEZZA"), rs1.getInt("PESO"), rs1.getString("GRUPPO_SANGUIGNO"));
				cartelleCliniche.add(cc);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		ConnessioneDB.closeConnection(conn);
		return cartelleCliniche;
	}

	@Override
	public boolean insertCartelle(CartellaClinicaDB cc) {
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		PreparedStatement ps1;
		
		boolean check = true;
		
		try {
			String query = "INSERT INTO hospitalmanager.CARTELLE_CLINICHE VALUES (?,?,?,?)";
			ps1 = conn.prepareStatement(query);
			ps1.setString(1, cc.getCf());
			ps1.setDouble(2, cc.getAltezza());
			ps1.setDouble(3, cc.getPeso());
			ps1.setString(4,  cc.getGruppoSanguigno().name());
			ps1.executeUpdate();
			//ps1.executeUpdate();
		}
		catch(Exception e){
			e.printStackTrace();
			check = false;
		}
		
		ConnessioneDB.closeConnection(conn);
		return check;
	}

	@Override
	public CartellaClinicaDB selectCartellaByCf(String cf) {
		// TODO Auto-generated method stub
		CartellaClinicaDB cc = null;
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		PreparedStatement ps1;
		ResultSet rs1;

		
		try {
			String query= "SELECT * from hospitalmanager.CARTELLE_CLINICHE WHERE CF = ? ";
			ps1 = conn.prepareStatement(query);
			ps1.setString(1, cf);
			rs1 = ps1.executeQuery();
			
			while (rs1.next()) {
				cc = new CartellaClinicaDB(rs1.getString("CF"), rs1.getInt("ALTEZZA"), rs1.getInt("PESO"), rs1.getString("GRUPPO_SANGUIGNO"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		ConnessioneDB.closeConnection(conn);
		return cc;
	}

}
