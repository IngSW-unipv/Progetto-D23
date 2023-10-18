package it.unipv.sfw.model.persona;

import it.unipv.sfw.model.Prenotazione;

public interface IPrenotante {
	boolean inserisciPrenotazione(String idPrest);
	boolean cancellaPrenotazione(Prenotazione p);
}
