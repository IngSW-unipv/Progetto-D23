package it.unipv.sfw.model;
import java.time.LocalDate;
import java.time.LocalTime;

import it.unipv.sfw.model.persona.Medico;
import it.unipv.sfw.model.persona.OperatoreSanitario;
import it.unipv.sfw.model.persona.Paziente;

public class Prenotazione {
	private int idPren;
	private Paziente paziente;
	private PrestazioneSanitaria prestazione;
	private Medico medico;
	private OperatoreSanitario opSanitario;
	private LocalDate data;
	private LocalTime orario;
	
	public Prenotazione(int idPren, Paziente paziente, PrestazioneSanitaria prestazione, Medico medico, OperatoreSanitario opSanitario,
			LocalDate data, LocalTime orario) {
		super();
		this.idPren = idPren;
		this.paziente = paziente;
		this.prestazione= prestazione;
		this.medico = medico;
		this.opSanitario = opSanitario;
		this.data = data;
		this.orario = orario;
	}


	public int getIdPren() {
		return idPren;
	}


	public Paziente getPaziente() {
		return paziente;
	}




	public Medico getMedico() {
		return medico;
	}




	public OperatoreSanitario getOpSanitario() {
		return opSanitario;
	}




	public LocalDate getData() {
		return data;
	}




	public LocalTime getOrario() {
		return orario;
	}




	public void setIdPren(int idPren) {
		this.idPren = idPren;
	}




	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}




	public void setMedico(Medico medico) {
		this.medico = medico;
	}




	public void setOpSanitario(OperatoreSanitario opSanitario) {
		this.opSanitario = opSanitario;
	}




	public void setData(LocalDate data) {
		this.data = data;
	}




	public void setOrario(LocalTime orario) {
		this.orario = orario;
	}




	public PrestazioneSanitaria getPrestazione() {
		return prestazione;
	}




	public void setPrestazione(PrestazioneSanitaria prestazione) {
		this.prestazione = prestazione;
	}
	
}