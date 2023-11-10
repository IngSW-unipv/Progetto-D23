package it.unipv.sfw.model;
import java.time.LocalDate;
import java.time.LocalTime;

import it.unipv.sfw.model.persona.Account;
import it.unipv.sfw.model.persona.Paziente;


public class Prenotazione {
	private int idPren;
	private Paziente paziente;
	private PrestazioneSanitaria prestazione;
	private Account personaleSanitario;
	private LocalDate data;
	private LocalTime orario;
	private boolean accreditamento;
	private String esito;
	
	public Prenotazione(int idPren, Paziente paziente, PrestazioneSanitaria prestazione, Account personaleSanitario,
			LocalDate data, LocalTime orario, boolean accreditamento, String esito) {
		super();
		this.idPren = idPren;
		this.paziente = paziente;
		this.prestazione = prestazione;
		this.personaleSanitario = personaleSanitario;
		this.data = data;
		this.orario = orario;
		this.accreditamento = false;
		this.esito = null;
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

	public boolean isAccreditamento() {
		return accreditamento;
	}

	public void setAccreditamento(boolean accreditamento) {
		this.accreditamento = accreditamento;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito(String esito) {
		this.esito = esito;
	}
	
	
	
	
	
	
	
}