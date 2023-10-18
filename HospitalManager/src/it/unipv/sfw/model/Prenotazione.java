package it.unipv.sfw.model;

import java.sql.Date;
import java.sql.Time;

import it.unipv.sfw.model.persona.Medico;
import it.unipv.sfw.model.persona.OperatoreSanitario;
import it.unipv.sfw.model.persona.Paziente;

public class Prenotazione {
	private int idPren;
	private Paziente paziente;
	private Medico medico;
	private OperatoreSanitario opSanitario;
	private String idPrest;
	private Date data;
	private Time orario;
	private String note;
	
	
	
	
	public Prenotazione(int idPren, Paziente paziente, Medico medico, OperatoreSanitario opSanitario, String idPrest,
			Date data, Time orario, String note) {
		super();
		this.idPren = idPren;
		this.paziente = paziente;
		this.medico = medico;
		this.opSanitario = opSanitario;
		this.idPrest = idPrest;
		this.data = data;
		this.orario = orario;
		this.note = note;
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




	public String getIdPrest() {
		return idPrest;
	}




	public Date getData() {
		return data;
	}




	public Time getOrario() {
		return orario;
	}




	public String getNote() {
		return note;
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




	public void setIdPrest(String idPrest) {
		this.idPrest = idPrest;
	}




	public void setData(Date data) {
		this.data = data;
	}




	public void setOrario(Time orario) {
		this.orario = orario;
	}




	public void setNote(String note) {
		this.note = note;
	}
	
	
	
}
	