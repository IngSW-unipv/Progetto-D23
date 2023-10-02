package it.unipv.sfw.cartellaclinica;

import it.unipv.sfw.prestazionisantarie.Prenotazione;

public class Erogazione {
	private Prenotazione prenotazione;
	private String esito;
	
	
	public Erogazione(Prenotazione prenotazione, String esito) {
		super();
		this.prenotazione = prenotazione;
		this.esito = esito;
	}
	
	
	
}
