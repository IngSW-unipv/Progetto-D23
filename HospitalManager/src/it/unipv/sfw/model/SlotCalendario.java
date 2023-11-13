package it.unipv.sfw.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class SlotCalendario {
	private LocalDate data;
	private String giornoSettimana;
	private String nomeVacanze;
	private LocalTime orario;
	private Prenotazione pren;
	
	public SlotCalendario(LocalDate data, String giornoSettimana, String nomeVacanze, LocalTime orario,
			Prenotazione pren) {
		super();
		this.data = data;
		this.giornoSettimana = giornoSettimana;
		this.nomeVacanze = nomeVacanze;
		this.orario = orario;
		this.pren = pren;
	}
	
	
}
