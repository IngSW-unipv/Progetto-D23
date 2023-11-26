package it.unipv.sfw.model.persona;

import java.time.LocalDate;
import java.time.LocalTime;

import it.unipv.sfw.model.Prenotazione;
import it.unipv.sfw.model.TipoPrestazione;

public interface IPrenotante {
	boolean cancellaPrenotazione(Prenotazione p);
	boolean inserisciPrenotazione(TipoPrestazione prest, LocalDate data, LocalTime orario);
	
}
