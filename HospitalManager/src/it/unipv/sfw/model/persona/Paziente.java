package it.unipv.sfw.model.persona;

import java.util.ArrayList;

import it.unipv.sfw.model.*;

public class Paziente extends Persona implements IPrenotante {

	private ArrayList<Prenotazione> prenotazioni;
	private CartellaClinica cartellaPersonale;
	
	//costruttore 1
	public Paziente(String cf, String nome, String cognome, String sesso, String dataNascita, String luogoNascita,
			String provinciaNascita, String regioneRes, String provinciaRes, String cittaRes, String indirizzo,
			String cap, String eMail, String cellulare) {
		super(cf, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita, regioneRes, provinciaRes, cittaRes,
				indirizzo, cap, eMail, cellulare);
		this.prenotazioni = new ArrayList<>();
	}

	//costruttore 2
	public Paziente(String cf, String nome, String cognome, String sesso, String dataNascita, String luogoNascita,
			String provinciaNascita, String regioneRes, String provinciaRes, String cittaRes, String indirizzo,
			String cap, String eMail, String cellulare, double altezza, double peso, GruppiSanguigni gruppoSanguigno) {
		super(cf, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita, regioneRes, provinciaRes, cittaRes,
				indirizzo, cap, eMail, cellulare);
		this.prenotazioni = new ArrayList<>();
		this.cartellaPersonale = new CartellaClinica(altezza, peso, gruppoSanguigno);
	}

	@Override
	public boolean inserisciPrenotazione(String idPrest) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancellaPrenotazione(Prenotazione p) {
		// TODO Auto-generated method stub
		return false;
	}
	
	ArrayList<Prenotazione> mostraPrenotazioni(){
		
		return null;
	}
	
	CartellaClinica getCartellaPersonale() {
		return cartellaPersonale;
	}
	
	

}