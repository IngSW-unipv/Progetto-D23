package it.unipv.sfw.model;


public class PrestazioneSanitaria {
	private int idPrest;
	private TipoPrestazione tipo;
	private DurataPrestazione durata;
	private double costo;
	
	public PrestazioneSanitaria(int idPrest, TipoPrestazione tipo, DurataPrestazione durata, double costo) {
		super();
		this.idPrest = idPrest;
		this.tipo = tipo;
		this.durata = durata;
		this.costo = costo;
	}

	public int getIdPrest() {
		return idPrest;
	}

	public void setIdPrest(int idPrest) {
		this.idPrest = idPrest;
	}

	public TipoPrestazione getTipo() {
		return tipo;
	}

	public void setTipo(TipoPrestazione tipo) {
		this.tipo = tipo;
	}

	public DurataPrestazione getDurata() {
		return durata;
	}

	public void setDurata(DurataPrestazione durata) {
		this.durata = durata;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	
	
	
	

	
	
}
