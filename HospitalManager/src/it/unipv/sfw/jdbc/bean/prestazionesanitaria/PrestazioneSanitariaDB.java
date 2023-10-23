package it.unipv.sfw.jdbc.bean.prestazionesanitaria;
import java.time.LocalTime;
import it.unipv.sfw.model.TipoPrestazione;

public class PrestazioneSanitariaDB {
	private String idPrest;
	private TipoPrestazione tipo;
	private LocalTime durata;
	private double costo;
	
	public PrestazioneSanitariaDB(String idPrest, TipoPrestazione tipo, String durata, double costo) {
		super();
		this.idPrest = idPrest;
		this.tipo = tipo;
	    this.durata = LocalTime.parse(durata);
		this.costo = costo;
	}

	public String getIdPrest() {
		return idPrest;
	}

	public TipoPrestazione getTipo() {
		return tipo;
	}

	public LocalTime getDurata() {
		return durata;
	}

	public double getCosto() {
		return costo;
	}
	
}