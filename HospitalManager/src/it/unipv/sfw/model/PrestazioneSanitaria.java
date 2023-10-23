package it.unipv.sfw.model;

import java.time.LocalTime;

public class PrestazioneSanitaria {
	private String idPrest;
	private TipoPrestazione tipo;
	private LocalTime durata;
	private double costo;
	
	public PrestazioneSanitaria(String idPrest, TipoPrestazione tipo, LocalTime durata, double costo) {
		super();
		this.idPrest = idPrest;
		this.tipo = tipo;
		this.durata = durata;
		this.costo = costo;
	}

	public String getIdPrest() {
		return idPrest;
	}

	public void setIdPrest(String idPrest) {
		this.idPrest = idPrest;
	}

	public TipoPrestazione getTipo() {
		return tipo;
	}

	public void setTipo(TipoPrestazione tipo) {
		this.tipo = tipo;
	}

	public LocalTime getDurata() {
		return durata;
	}

	public void setDurata(LocalTime durata) {
		this.durata = durata;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	
	
	
	

	
	
}