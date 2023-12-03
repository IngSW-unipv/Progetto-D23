package it.unipv.sfw.model.prenotazione;
import java.time.LocalDate;
import java.time.LocalTime;

import it.unipv.sfw.model.persona.IAccount;
import it.unipv.sfw.model.persona.IPaziente;


public class Prenotazione implements IPrenotazione {
	private int idPren;
	private IPaziente paziente;
	private IAccount personaleSanitario;
	private PrestazioneSanitaria prestazione;
	private LocalDate data;
	private LocalTime orario;
	
	public Prenotazione(int idPren, IPaziente paziente, IAccount personaleSanitario, PrestazioneSanitaria prestazione, 
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

	public IPaziente getPaziente() {
		return paziente;
	}

	public void setPaziente(IPaziente paziente) {
		this.paziente = paziente;
	}

	public PrestazioneSanitaria getPrestazione() {
		return prestazione;
	}

	public void setPrestazione(PrestazioneSanitaria prestazione) {
		this.prestazione = prestazione;
	}

	public IAccount getPersonaleSanitario() {
		return personaleSanitario;
	}

	public void setPersonaleSanitario(IAccount personaleSanitario) {
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