package it.unipv.sfw.jdbc.bean.cartellaclinica;

import it.unipv.sfw.model.GruppiSanguigni;

public class CartellaClinicaDB {
	private String cf;
	private int altezza;
	private int peso;
	GruppiSanguigni gruppoSanguigno;
	
	public CartellaClinicaDB(String cf, int altezza, int peso, String gruppoSanguigno) {
		super();
		this.cf = cf;
		this.altezza = altezza;
		this.peso = peso;
		this.gruppoSanguigno = GruppiSanguigni.valueOf(gruppoSanguigno);
	}

	public String getCf() {
		return cf;
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
