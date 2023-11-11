package it.unipv.sfw.jdbc.bean.prenotazione;

import java.time.LocalDate;
import java.time.LocalTime;

public class PrenotazioneDB {
	private int idPren;
	private String Paziente;
	private String PersonaleSanitario;
	private String idPrest;
	private LocalDate dataPren;
	private LocalTime oraPren;
	private boolean accreditamento;
	private String esito;
	
	public PrenotazioneDB(int idPren, String paziente, String personaleSanitario, String idPrest, String dataPren,
			String oraPren, boolean accreditamento, String esito) {
		super();
		this.idPren = idPren;
		Paziente = paziente;
		PersonaleSanitario = personaleSanitario;
		this.idPrest = idPrest;
		this.dataPren = LocalDate.parse(dataPren);
		this.oraPren = LocalTime.parse(oraPren);
		this.accreditamento = accreditamento;
		this.esito = esito;
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

	public String getIdPrest() {
		return idPrest;
	}

	public void setIdPrest(String idPrest) {
		this.idPrest = idPrest;
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
