package it.unipv.sfw.jdbc.bean.cartellaclinica;

import it.unipv.sfw.model.GruppiSanguigni;

public class CartellaClinicaDB {
	private int idAcc;
	private int altezza;
	private int peso;
	GruppiSanguigni gruppoSanguigno;
	
	public CartellaClinicaDB(int idAcc, int altezza, int peso, String gruppoSanguigno) {
		super();
		this.idAcc = idAcc;
		this.altezza = altezza;
		this.peso = peso;
		this.gruppoSanguigno = GruppiSanguigni.valueOf(gruppoSanguigno);
	}

	public int getIdAcc() {
		return idAcc;
	}

	public int getAltezza() {
		return altezza;
	}

	public int getPeso() {
		return peso;
	}

	public GruppiSanguigni getGruppoSanguigno() {
		return gruppoSanguigno;
	}
	
}
