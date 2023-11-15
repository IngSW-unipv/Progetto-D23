package it.unipv.sfw.jdbc.bean.calendario;

import java.time.LocalDate;
import java.time.LocalTime;

public class SlotCalendarioSingoloDB {
	private LocalDate data;
	private String giorno;
	private String vacanza;
	private LocalTime orario;
	private int idPren;
	
	public SlotCalendarioSingoloDB(String data, String giorno, String vacanza, String orario, int idPren) {
		super();
		this.data = LocalDate.parse(data);
		this.giorno = giorno;
		this.vacanza = vacanza;
		this.orario = LocalTime.parse(orario);
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getGiorno() {
		return giorno;
	}

	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}

	public String getVacanza() {
		return vacanza;
	}

	public void setVacanza(String vacanza) {
		this.vacanza = vacanza;
	}

	public LocalTime getOrario() {
		return orario;
	}

	public void setOrario(LocalTime orario) {
		this.orario = orario;
	}

	public int getIdPren() {
		return idPren;
	}

	public void setIdPren(int idPren) {
		this.idPren = idPren;
	}

}