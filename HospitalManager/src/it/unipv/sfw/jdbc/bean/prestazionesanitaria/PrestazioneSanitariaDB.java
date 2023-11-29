package it.unipv.sfw.jdbc.bean.prestazionesanitaria;
import java.time.LocalTime;

import it.unipv.sfw.model.prenotazione.TipoPrestazione;

public class PrestazioneSanitariaDB {
	private TipoPrestazione tipo;
	private LocalTime durata;
	
	public PrestazioneSanitariaDB(String tipo, String durata) {
		super();
		this.tipo = TipoPrestazione.valueOf(tipo);
	    this.durata = LocalTime.parse(durata);
	}

	public TipoPrestazione getTipo() {
		return tipo;
	}

	public LocalTime getDurata() {
		return durata;
	}
	
}