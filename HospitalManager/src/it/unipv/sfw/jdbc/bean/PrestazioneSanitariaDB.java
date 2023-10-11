package it.unipv.sfw.jdbc.bean;
import java.time.LocalTime;

public class PrestazioneSanitariaDB {
	private int id_prest;
	private String tipo;
	private LocalTime durata;
	private double costo;
	
	public PrestazioneSanitariaDB(int id_prest, String tipo, String durata, double costo) {
		super();
		this.id_prest = id_prest;
		this.tipo = tipo;
	    this.durata = LocalTime.parse(durata);
		this.costo = costo;
	}

	public int getId_prest() {
		return id_prest;
	}

	public String getTipo() {
		return tipo;
	}

	public LocalTime getDurata() {
		return durata;
	}

	public double getCosto() {
		return costo;
	}
	
}
