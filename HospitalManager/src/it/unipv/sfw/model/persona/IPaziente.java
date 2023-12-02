package it.unipv.sfw.model.persona;

import java.util.ArrayList;

import it.unipv.sfw.model.cartellaclinica.CartellaClinica;
import it.unipv.sfw.model.prenotazione.Prenotazione;

public interface IPaziente {
	boolean spostaPrenotazioniErogate();	
	CartellaClinica getCartellaPersonale();
	ArrayList<Prenotazione> getPrenotazioni();
	void setPrenotazioni(ArrayList<Prenotazione> prenotazioni);
	void setCartellaPersonale(CartellaClinica cartellaPersonale);
	String getCf();
	String getNome();
	String getCognome();
}
