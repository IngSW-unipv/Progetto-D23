package it.unipv.sfw.model.prenotazione;

import java.time.LocalDate;
import java.time.LocalTime;

import it.unipv.sfw.model.persona.Account;
import it.unipv.sfw.model.persona.Paziente;

public interface IPrenotazione {
	int getIdPren();
	void setIdPren(int idPren);
	Paziente getPaziente();
	void setPaziente(Paziente paziente);
	PrestazioneSanitaria getPrestazione();
	void setPrestazione(PrestazioneSanitaria prestazione);
	Account getPersonaleSanitario();
	void setPersonaleSanitario(Account personaleSanitario);
	LocalDate getData();
	void setData(LocalDate data);
	LocalTime getOrario();
	void setOrario(LocalTime orario);
}
