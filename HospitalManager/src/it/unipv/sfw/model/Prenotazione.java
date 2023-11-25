package it.unipv.sfw.model;
import java.time.LocalDate;
import java.time.LocalTime;

import it.unipv.sfw.model.persona.Account;
import it.unipv.sfw.model.persona.Paziente;


public class Prenotazione {
	private int idPren;
	private Paziente paziente;
	private Account personaleSanitario;
	private PrestazioneSanitaria prestazione;
	private LocalDate data;
	private LocalTime orario;
	
	public Prenotazione(int idPren, Paziente paziente, Account personaleSanitario, PrestazioneSanitaria prestazione, 
			LocalDate data, LocalTime orario) {
		super();
		this.idPren = idPren;
		this.paziente = paziente;
		this.prestazione = prestazione;
		this.personaleSanitario = personaleSanitario;
		this.data = data;
		this.orario = orario;
	}

	public int getIdPren() {
		return idPren;
	}

	public void setIdPren(int idPren) {
		this.idPren = idPren;
	}

	public Paziente getPaziente() {
		return paziente;
	}

	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	public PrestazioneSanitaria getPrestazione() {
		return prestazione;
	}

	public void setPrestazione(PrestazioneSanitaria prestazione) {
		this.prestazione = prestazione;
	}

	public Account getPersonaleSanitario() {
		return personaleSanitario;
	}

	public void setPersonaleSanitario(Account personaleSanitario) {
		this.personaleSanitario = personaleSanitario;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getOrario() {
		return orario;
	}

	public void setOrario(LocalTime orario) {
		this.orario = orario;
	}

}