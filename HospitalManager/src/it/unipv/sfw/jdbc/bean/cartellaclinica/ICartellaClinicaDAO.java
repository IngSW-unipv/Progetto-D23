package it.unipv.sfw.jdbc.bean.cartellaclinica;

import java.util.ArrayList;

public interface ICartellaClinicaDAO {
	ArrayList<CartellaClinicaDB> selectAllCartelle();
	CartellaClinicaDB selectCartellaByCf(String cf);
	boolean insertCartelle(CartellaClinicaDB cc);
	}
