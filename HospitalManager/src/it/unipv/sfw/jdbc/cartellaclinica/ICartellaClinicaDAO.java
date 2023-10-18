package it.unipv.sfw.jdbc.cartellaclinica;

import java.util.ArrayList;

public interface ICartellaClinicaDAO {
	ArrayList<CartellaClinicaDB> selectAllCartelle();
	boolean insertCartelle(CartellaClinicaDB cc);
	}
