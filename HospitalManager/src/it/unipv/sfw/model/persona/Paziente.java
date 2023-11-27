package it.unipv.sfw.model.persona;

import java.util.ArrayList;

import it.unipv.sfw.jdbc.FacadeSingletonDB;
import it.unipv.sfw.model.*;

public class Paziente extends Account {
	
	private ArrayList<Prenotazione> prenotazioni;
	private CartellaClinica cartellaPersonale;	

	//costruttore 1
	public Paziente(String cf, String pw, TipoAccount tipoAcc, String nome, String cognome, String sesso,
			String dataNascita, String luogoNascita, String provinciaNascita, String regioneRes, String provinciaRes,
			String cittaRes, String indirizzo, String cap, String eMail, String cellulare,
			ArrayList<Prenotazione> prenotazioni, CartellaClinica cartellaPersonale) {
		super(cf, pw, tipoAcc, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita, regioneRes,
				provinciaRes, cittaRes, indirizzo, cap, eMail, cellulare);
		this.prenotazioni = prenotazioni;
		this.cartellaPersonale = cartellaPersonale;
	}

	//costruttore 2
	public Paziente(String cf, String pw, TipoAccount tipoAcc, String nome, String cognome, String sesso,
			String dataNascita, String luogoNascita, String provinciaNascita, String regioneRes, String provinciaRes,
			String cittaRes, String indirizzo, String cap, String eMail, String cellulare) {
		super(cf, pw, tipoAcc, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita, regioneRes,
				provinciaRes, cittaRes, indirizzo, cap, eMail, cellulare);
		this.prenotazioni = new ArrayList<>();
	}
	
	public CartellaClinica getCartellaPersonale() {
		return cartellaPersonale;
	}

	public ArrayList<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(ArrayList<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public void setCartellaPersonale(CartellaClinica cartellaPersonale) {
		this.cartellaPersonale = cartellaPersonale;
	}
	

}