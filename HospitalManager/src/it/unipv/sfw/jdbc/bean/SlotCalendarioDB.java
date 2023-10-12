package it.unipv.sfw.jdbc.bean;

import java.time.LocalDate;
import java.time.LocalTime;

public class SlotCalendarioDB {
	private LocalDate data;
	private String giorno;
	private String vacanza;
	private LocalTime orario;
	private int idPrenVisitaOncologica;
	private int idPrenVisitaPsicologica;
	private int idPrenEsameSangue;
	private int idPrenTac;
	private int idPrenRisonanzaMagnetica;
	private int idPrenChemioterapia;
	private int idPrenRadioterapia;
	private int idPrenOperazione;
	
	public SlotCalendarioDB(String data, String giorno, String vacanza, String orario, int idPren1, int idPren2,
			int idPren3, int idPren4, int idPren5, int idPren6, int idPren7, int idPren8) {
		super();
		this.data = LocalDate.parse(data);
		this.giorno = giorno;
		this.vacanza = vacanza;
		this.orario = LocalTime.parse(orario);
		this.idPrenVisitaOncologica = idPren1;
		this.idPrenVisitaPsicologica = idPren2;
		this.idPrenEsameSangue = idPren3;
		this.idPrenTac = idPren4;
		this.idPrenRisonanzaMagnetica = idPren5;
		this.idPrenChemioterapia = idPren6;
		this.idPrenRadioterapia = idPren7;
		this.idPrenOperazione = idPren8;
	}

	public LocalDate getData() {
		return data;
	}

	public String getGiorno() {
		return giorno;
	}

	public String getVacanza() {
		return vacanza;
	}

	public LocalTime getOrario() {
		return orario;
	}

	public int getIdPrenVisitaOncologica() {
		return idPrenVisitaOncologica;
	}

	public int getIdPrenVisitaPsicologica() {
		return idPrenVisitaPsicologica;
	}

	public int getIdPrenEsameSangue() {
		return idPrenEsameSangue;
	}

	public int getIdPrenTac() {
		return idPrenTac;
	}

	public int getIdPrenRisonanzaMagnetica() {
		return idPrenRisonanzaMagnetica;
	}

	public int getIdPrenChemioterapia() {
		return idPrenChemioterapia;
	}

	public int getIdPrenRadioterapia() {
		return idPrenRadioterapia;
	}

	public int getIdPrenOperazione() {
		return idPrenOperazione;
	}
	
	

}
