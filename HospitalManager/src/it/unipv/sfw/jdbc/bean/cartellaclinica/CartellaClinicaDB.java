package it.unipv.sfw.jdbc.bean.cartellaclinica;

import it.unipv.sfw.model.cartellaclinica.GruppiSanguigni;

public class CartellaClinicaDB {
	private String cf;
	private double altezza;
	private double peso;
	GruppiSanguigni gruppoSanguigno;
	
	public CartellaClinicaDB(String cf, double altezza, double peso, String gruppoSanguigno) {
		super();
		this.cf = cf;
		this.altezza = altezza;
		this.peso = peso;
		this.gruppoSanguigno = GruppiSanguigni.valueOf(gruppoSanguigno);
	}

	public String getCf() {
		return cf;
	}

	public double getAltezza() {
		return altezza;
	}

	public double getPeso() {
		return peso;
	}

	public GruppiSanguigni getGruppoSanguigno() {
		return gruppoSanguigno;
	}
	
}
