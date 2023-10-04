package it.unipv.sfw.prestazionisantarie;

import java.sql.Date;
import java.sql.Time;

import it.unipv.sfw.persona.Medico;
import it.unipv.sfw.persona.Paziente;

public class PrestazioneSanitaria {
	private TipoPrestazione type;
	private CatPrestazione categoria;
	private DurataPrestazione durata;
	private int id;
	private Date data;
	private Paziente paziente;
	private Medico medico;
	private Time orario;

	public PrestazioneSanitaria(int id, Date data, Paziente paziente, Medico medico,
			DurataPrestazione durata,TipoPrestazione type, CatPrestazione categoria, Time orario) {
		this.id = id;
		this.data = data;
		this.paziente = paziente;
		this.medico = medico;
		this.durata = durata;
		this.type = type;
		this.categoria = categoria;
		this.orario = orario;
	}
	
	public int getId() {
		return id;
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
	
	public CatPrestazione getCat() {
		return categoria;
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
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setDurata(DurataPrestazione durata) {
		this.durata = durata;
	}
	
	public void setCatPrestazione(CatPrestazione categoria) {
		this.categoria = categoria;
	}
}
