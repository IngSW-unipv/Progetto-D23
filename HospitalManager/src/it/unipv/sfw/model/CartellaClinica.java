package it.unipv.sfw.model;

import java.util.ArrayList;

public class CartellaClinica {
	private double altezza;
	private double peso;
	private GruppiSanguigni gruppoSanguigno;
	private ArrayList<Prenotazione> prenotazioni;
	//private ArrayList <Erogazione> erogazioni;
	
	public CartellaClinica(double altezza, double peso, GruppiSanguigni gruppoSanguigno, ArrayList<Prenotazione> prenotazioni) {
		super();
		this.altezza = altezza;
		this.peso = peso;
		this.gruppoSanguigno = gruppoSanguigno;
		this.prenotazioni = prenotazioni;
	}

	public double getAltezza() {
		return altezza;
	}

	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public GruppiSanguigni getGruppoSanguigno() {
		return gruppoSanguigno;
	}

	public void setGruppoSanguigno(GruppiSanguigni gruppoSanguigno) {
		this.gruppoSanguigno = gruppoSanguigno;
	}

	public ArrayList<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(ArrayList<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}
	

}