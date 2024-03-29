package it.unipv.sfw.model.cartellaclinica;

import java.util.ArrayList;

import it.unipv.sfw.model.prenotazione.IPrenotazione;

public class CartellaClinica {
	private double altezza;
	private double peso;
	private GruppiSanguigni gruppoSanguigno;
	private ArrayList<IPrenotazione> prenotazioni;
	
	public CartellaClinica(double altezza, double peso, GruppiSanguigni gruppoSanguigno, ArrayList<IPrenotazione> prenotazioni) {
		super();
		this.altezza = altezza;
		this.peso = peso;
		this.gruppoSanguigno = gruppoSanguigno;
		this.prenotazioni = prenotazioni;
	}

	public CartellaClinica(double altezza, double peso, GruppiSanguigni gruppoSanguigno) {
		super();
		this.altezza = altezza;
		this.peso = peso;
		this.gruppoSanguigno = gruppoSanguigno;
		this.prenotazioni = new ArrayList<>();
	}
	
	public CartellaClinica() {
		super();
		this.prenotazioni = new ArrayList<>();
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

	public ArrayList<IPrenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(ArrayList<IPrenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}
	

}