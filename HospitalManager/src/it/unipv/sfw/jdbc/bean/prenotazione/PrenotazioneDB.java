package it.unipv.sfw.jdbc.bean.prenotazione;

import java.time.LocalDate;
import java.time.LocalTime;

import it.unipv.sfw.model.prenotazione.TipoPrestazione;

public class PrenotazioneDB {
	private int idPren;
	private String Paziente;
	private String PersonaleSanitario;
	private TipoPrestazione tipo;
	private LocalDate dataPren;
	private LocalTime oraPren;
	
	public PrenotazioneDB(int idPren, String paziente, String personaleSanitario, String tipo,
			String dataPren, String oraPren) {
		super();
		this.idPren = idPren;
		Paziente = paziente;
		PersonaleSanitario = personaleSanitario;
		this.tipo = TipoPrestazione.valueOf(tipo);
		this.dataPren = LocalDate.parse(dataPren);
		this.oraPren = LocalTime.parse(oraPren);
	}

	public int getIdPren() {
		return idPren;
	}

	public void setIdPren(int idPren) {
		this.idPren = idPren;
	}

	public String getPaziente() {
		return Paziente;
	}

	public void setPaziente(String paziente) {
		Paziente = paziente;
	}

	public String getPersonaleSanitario() {
		return PersonaleSanitario;
	}

	public void setPersonaleSanitario(String personaleSanitario) {
		PersonaleSanitario = personaleSanitario;
	}

	public TipoPrestazione getTipo() {
		return tipo;
	}

	public void setTipo(TipoPrestazione tipo) {
		this.tipo = tipo;
	}

	public LocalDate getDataPren() {
		return dataPren;
	}

	public void setDataPren(LocalDate dataPren) {
		this.dataPren = dataPren;
	}

	public LocalTime getOraPren() {
		return oraPren;
	}

	public void setOraPren(LocalTime oraPren) {
		this.oraPren = oraPren;
	}
	

	
}
