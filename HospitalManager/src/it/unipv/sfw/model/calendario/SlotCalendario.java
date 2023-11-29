package it.unipv.sfw.model.calendario;

import java.time.LocalDate;
import java.time.LocalTime;

import it.unipv.sfw.model.prenotazione.Prenotazione;

public class SlotCalendario {
	private LocalDate data;
	private String giornoSettimana;
	private String nomeVacanze;
	private LocalTime orario;
	private Prenotazione prest1;
	private Prenotazione prest2;
	private Prenotazione prest3;
	private Prenotazione prest4;
	private Prenotazione prest5;
	private Prenotazione prest6;
	private Prenotazione prest7;
	
	public SlotCalendario(LocalDate data, String giornoSettimana, String nomeVacanze, LocalTime orario,
			Prenotazione prest1, Prenotazione prest2, Prenotazione prest3, Prenotazione prest4, Prenotazione prest5,
			Prenotazione prest6, Prenotazione prest7) {
		super();
		this.data = data;
		this.giornoSettimana = giornoSettimana;
		this.nomeVacanze = nomeVacanze;
		this.orario = orario;
		this.prest1 = prest1;
		this.prest2 = prest2;
		this.prest3 = prest3;
		this.prest4 = prest4;
		this.prest5 = prest5;
		this.prest6 = prest6;
		this.prest7 = prest7;
	}
	
	
}
