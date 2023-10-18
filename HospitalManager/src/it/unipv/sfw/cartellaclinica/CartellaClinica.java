package it.unipv.sfw.cartellaclinica;

import java.util.ArrayList;

public class CartellaClinica {
	private int idAcc;
	private int altezza;
	private int peso;
	private GruppiSanguigni gruppoSanguigno;
	ArrayList <String> esiti;
	
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
	public ArrayList<String> getEsiti() {
		return esiti;
	}
	public void setIdAcc(int idAcc) {
		this.idAcc = idAcc;
	}
	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public void setGruppoSanguigno(GruppiSanguigni gruppoSanguigno) {
		this.gruppoSanguigno = gruppoSanguigno;
	}
	public void setEsiti(ArrayList<String> esiti) {
		this.esiti = esiti;
	}
	
	
}
