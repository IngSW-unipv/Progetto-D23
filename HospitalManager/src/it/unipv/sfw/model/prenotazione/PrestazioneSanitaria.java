package it.unipv.sfw.model.prenotazione;

import java.time.LocalTime;

public class PrestazioneSanitaria {
	private TipoPrestazione tipo;
	private LocalTime durata;
	
	public PrestazioneSanitaria(TipoPrestazione tipo, LocalTime durata) {
		super();
		this.tipo = tipo;
		this.durata = durata;
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

	
	
	
	

	
	
}