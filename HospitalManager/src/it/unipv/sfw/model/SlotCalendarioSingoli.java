package it.unipv.sfw.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class SlotCalendarioSingoli {
	private LocalDate data;
	private String giornoSettimana;
	private String nomeVacanze;
	private LocalTime orario;
	private Prenotazione pren;
	
	public SlotCalendarioSingoli(LocalDate data, String giornoSettimana, String nomeVacanze, LocalTime orario,
			Prenotazione pren) {
		super();
		this.data = data;
		this.giornoSettimana = giornoSettimana;
		this.nomeVacanze = nomeVacanze;
		this.orario = orario;
		this.pren = pren;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public LocalTime getOrario() {
		return orario;
	}
}
