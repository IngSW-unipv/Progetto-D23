package it.unipv.sfw.jdbc.bean.cartellaclinica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import it.unipv.sfw.jdbc.ConnessioneDB;
import it.unipv.sfw.jdbc.bean.anagrafica.AnagraficaDB;

public class CartellaClinicaDAO implements ICartellaClinicaDAO {
	private Connection conn;
	private ArrayList<CartellaClinicaDB> cartelleCliniche;
	private CartellaClinicaDB cc;

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
				CartellaClinicaDB cc = new CartellaClinicaDB(rs1.getInt("ID_ACC"), rs1.getInt("ALTEZZA"), rs1.getInt("PESO"), rs1.getString("GRUPPO_SANGUIGNO"));
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
			ps1.setInt(1, cc.getIdAcc());
			ps1.setInt(2, cc.getAltezza());
			ps1.setInt(3, cc.getPeso());
			ps1.setString(4,  cc.getGruppoSanguigno().name());
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

	@Override
	public CartellaClinicaDB selectCartellaByIdAcc(String idAcc) {
		conn = ConnessioneDB.startConnection(conn, "hospitalmanager");
		PreparedStatement ps1;
		ResultSet rs1;

		
		try {
			String query= "SELECT * from hospitalmanager.CARTELLA_CLINICA WHERE ID_ACC = ? ";
			ps1 = conn.prepareStatement(query);
			ps1.setString(1, idAcc);
			rs1 = ps1.executeQuery();
			
			while (rs1.next()) {
				CartellaClinicaDB cc = new CartellaClinicaDB(rs1.getInt("ID_ACC"), rs1.getInt("ALTEZZA"), rs1.getInt("PESO"), rs1.getString("GRUPPO_SANGUIGNO"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		ConnessioneDB.closeConnection(conn);
		return cc;
	}

}