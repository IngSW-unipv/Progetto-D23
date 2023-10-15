package it.unipv.sfw.jdbc.bean.prenotazione;

import java.time.LocalDate;
import java.time.LocalTime;

public class PrenotazioneDB {
	private int idPren;
	private int idPaziente;
	private int idMedico;
	private int idOperatoreSanitario;
	private String idPrest;
	private LocalDate dataPren;
	private LocalTime oraPren;
	private String note;
	
	public PrenotazioneDB(int idPren, int idPaziente, int idMedico, int idOperatoreSanitario, String idPrest,
			String dataPren, String oraPren, String note) {
		super();
		this.idPren = idPren;
		this.idPaziente = idPaziente;
		this.idMedico = idMedico;
		this.idOperatoreSanitario = idOperatoreSanitario;
		this.idPrest = idPrest;
		this.dataPren = LocalDate.parse(dataPren);
		this.oraPren = LocalTime.parse(oraPren);
		this.note = note;
	}

	public int getIdPren() {
		return idPren;
	}

	public int getIdPaziente() {
		return idPaziente;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public int getIdOperatoreSanitario() {
		return idOperatoreSanitario;
	}

	public String getIdPrest() {
		return idPrest;
	}

	public LocalDate getDataPren() {
		return dataPren;
	}

	public LocalTime getOraPren() {
		return oraPren;
	}

	public String getNote() {
		return note;
	}

		
}
