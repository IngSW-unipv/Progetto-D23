package it.unipv.sfw.model.prenotazione;

import java.time.LocalDate;
import java.time.LocalTime;

import it.unipv.sfw.model.persona.IAccount;
import it.unipv.sfw.model.persona.IPaziente;

public interface IPrenotazione {
	int getIdPren();
	void setIdPren(int idPren);
	IPaziente getPaziente();
	void setPaziente(IPaziente paziente);
	PrestazioneSanitaria getPrestazione();
	void setPrestazione(PrestazioneSanitaria prestazione);
	IAccount getPersonaleSanitario();
	void setPersonaleSanitario(IAccount personaleSanitario);
	LocalDate getData();
	void setData(LocalDate data);
	LocalTime getOrario();
	void setOrario(LocalTime orario);
}
