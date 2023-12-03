package it.unipv.sfw.model.persona;

import java.util.ArrayList;

import it.unipv.sfw.model.prenotazione.IPrenotazione;
import it.unipv.sfw.model.prenotazione.TipoPrestazione;

public interface IPersonaleSanitario {
	boolean eliminaPrenotazioniErogate();
	TipoPrestazione getSpecializzazione();
	void setSpecializzazione(TipoPrestazione specializzazione);
	ArrayList<IPrenotazione> getCalendario();
	void setCalendario(ArrayList<IPrenotazione> calendario);
}
