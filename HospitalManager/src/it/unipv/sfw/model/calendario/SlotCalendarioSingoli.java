package it.unipv.sfw.model.calendario;

import java.time.LocalDate;
import java.time.LocalTime;

public class SlotCalendarioSingoli {
	private LocalDate data;
	private String giornoSettimana;
	private LocalTime orario;
	
	public SlotCalendarioSingoli(LocalDate data, String giornoSettimana, LocalTime orario) {
		super();
		this.data = data;
		this.giornoSettimana = giornoSettimana;
		this.orario = orario;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getGiornoSettimana() {
		return giornoSettimana;
	}

	public void setGiornoSettimana(String giornoSettimana) {
		this.giornoSettimana = giornoSettimana;
	}

	public LocalTime getOrario() {
		return orario;
	}

	public void setOrario(LocalTime orario) {
		this.orario = orario;
	}
	
	
	
}
