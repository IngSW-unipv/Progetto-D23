package it.unipv.sfw.jdbc.bean.cartellaclinica;

import java.util.ArrayList;

public interface ICartellaClinicaDAO {
	ArrayList<CartellaClinicaDB> selectAllCartelle();
	boolean insertCartelle(CartellaClinicaDB cc);
	CartellaClinicaDB selectCartellaByIdAcc(int idAcc);
	}
