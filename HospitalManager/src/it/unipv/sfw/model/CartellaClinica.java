package it.unipv.sfw.model;

import java.util.ArrayList;

public class CartellaClinica {
	private double altezza;
	private double peso;
	private GruppiSanguigni gruppoSanguigno;
	private ArrayList <Erogazione> erogazioni;
	
	
	public CartellaClinica(double altezza, double peso, GruppiSanguigni gruppoSanguigno) {
		super();
		this.altezza = altezza;
		this.peso = peso;
		this.gruppoSanguigno = gruppoSanguigno;
		this.erogazioni = new ArrayList<>();
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
	public ArrayList<Erogazione> getErogazioni() {
		return erogazioni;
	}
	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public void setGruppoSanguigno(GruppiSanguigni gruppoSanguigno) {
		this.gruppoSanguigno = gruppoSanguigno;
	}
	public void setErogazioni(ArrayList<Erogazione> erogazioni) {
		this.erogazioni = erogazioni;
	}
	
	
}