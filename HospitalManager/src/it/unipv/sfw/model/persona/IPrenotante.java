package it.unipv.sfw.model.persona;

import java.time.LocalDate;
import java.time.LocalTime;

import it.unipv.sfw.model.Prenotazione;

public interface IPrenotante {
	boolean inserisciPrenotazione(String idPrest, LocalDate data, LocalTime orario);
	boolean cancellaPrenotazione(Prenotazione p);
	boolean scorriPrenotazioni();
	
}
