package it.unipv.sfw.model;

import java.sql.Date;
import java.sql.Time;

import it.unipv.sfw.model.persona.Medico;
import it.unipv.sfw.model.persona.Paziente;

public class PrestazioneSanitaria {
	private TipoPrestazione type;
	private DurataPrestazione durata;
	private int idPrest;
	private Date data;
	private Paziente paziente;
	private Medico medico;
	private Time orario;

	public PrestazioneSanitaria(int idPrest, Date data, Paziente paziente, Medico medico,
			DurataPrestazione durata,TipoPrestazione type, Time orario) {
		this.idPrest = idPrest;
		this.data = data;
		this.paziente = paziente;
		this.medico = medico;
		this.durata = durata;
		this.type = type;
		this.orario = orario;
	}
	
	public int getIdPrest() {
		return idPrest;
	}

	public TipoPrestazione getTipo() {
		return type;
	}

	public Paziente getPaziente() {
		return paziente;
	}

	public Medico getMedico() {
		return medico;
	}

	public java.sql.Date getData() {
		return data;
	}

	public DurataPrestazione getDurataPrestazione() {
		return durata;
	}
	
	public Time getOrario() {
		return orario;
	}
		
	
	//METODI SET
	
	public void setPaziente(Paziente paziente) {
		this.paziente = paziente;
	}

	public void setTipoPrestazione(TipoPrestazione tipo) {
		this.type = tipo;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setTime(Time orario) {
		this.orario = orario;
	}

	public void setMedico(Medico med) {
		this.medico = med;
	}
	
	public void setIdPrest(int idPrest) {
		this.idPrest = idPrest;
	}
	
	public void setDurata(DurataPrestazione durata) {
		this.durata = durata;
	}
	
}
