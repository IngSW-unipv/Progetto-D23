package it.unipv.sfw.prestazionisantarie;

import java.sql.Date;
import java.sql.Time;
import it.unipv.sfw.persona.Medico;
import it.unipv.sfw.persona.OperatoreSanitario;
import it.unipv.sfw.persona.Paziente;

public class Prenotazione {
	private int id;
	private Date data;
	private Paziente paziente;
	private Medico medico;
	private OperatoreSanitario opSanitario;
	private Time orario;
	
	
	public Prenotazione(int id, Date data, Paziente paziente, Medico medico, OperatoreSanitario opSanitario, Time orario) {
		this.id = id;
		this.data = data;
		this.paziente = paziente;
		this.medico = medico;
		this.opSanitario = opSanitario;
		this.orario = orario;
	}
	
	//METODI GET
	
	public int getId() {
		return id;
	}

	public Date getData() {
		return data;
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
	
	public Time getOrario() {
		return orario;
	}
	
	// METODI SET
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setData (Date data) {
		this.data = data;
	}
	
	public void setPaziente(Paziente paz) {
		this.paziente = paz;
	}
	
	public void setMedico(Medico med) {
		this.medico = med;
	}
	
	public void setOrario(Time orario) {
		this.orario = orario;
	}
	
	public void setOpSanitario(OperatoreSanitario opSan) {
		this.opSanitario = opSan;
	}
	
	
	
	
}
