package it.unipv.sfw.model.persona;

import java.util.ArrayList;

import it.unipv.sfw.model.prenotazione.Prenotazione;
import it.unipv.sfw.model.prenotazione.TipoPrestazione;

public interface IPersonaleSanitario {
	boolean eliminaPrenotazioniErogate();
	TipoPrestazione getSpecializzazione();
	void setSpecializzazione(TipoPrestazione specializzazione);
	ArrayList<Prenotazione> getCalendario();
	void setCalendario(ArrayList<Prenotazione> calendario);
}
