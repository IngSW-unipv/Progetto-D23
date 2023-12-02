package it.unipv.sfw.model.persona;

import java.time.LocalDate;
import java.util.ArrayList;

import it.unipv.sfw.model.cartellaclinica.CartellaClinica;
import it.unipv.sfw.model.prenotazione.Prenotazione;

public class Paziente extends Account implements IPaziente {
	
	private ArrayList<Prenotazione> prenotazioni;
	private CartellaClinica cartellaPersonale;	

	//costruttore 1
	public Paziente(String cf, String pw, TipoAccount tipoAcc, String nome, String cognome, Sesso sesso,
			String dataNascita, String luogoNascita, String provinciaNascita, String regioneRes, String provinciaRes,
			String cittaRes, String indirizzo, String cap, String eMail, String cellulare, CartellaClinica cartellaPersonale) {
		super(cf, pw, tipoAcc, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita, regioneRes,
				provinciaRes, cittaRes, indirizzo, cap, eMail, cellulare);
		this.prenotazioni = new ArrayList<>();
		this.cartellaPersonale = cartellaPersonale;
	}
	
	//costruttore 2
		public Paziente(String cf, String pw, TipoAccount tipoAcc, String nome, String cognome, Sesso sesso,
				String dataNascita, String luogoNascita, String provinciaNascita, String regioneRes, String provinciaRes,
				String cittaRes, String indirizzo, String cap, String eMail, String cellulare) {
			super(cf, pw, tipoAcc, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita, regioneRes,
					provinciaRes, cittaRes, indirizzo, cap, eMail, cellulare);
			this.prenotazioni = new ArrayList<>();
			this.cartellaPersonale = new CartellaClinica();
		}
		
	public boolean spostaPrenotazioniErogate() {
		boolean check = false;
		try {
			LocalDate oggi = LocalDate.now();
			for(Prenotazione p : this.prenotazioni) {
				if(p.getData().isBefore(oggi)) {
					this.prenotazioni.remove(p);
					this.cartellaPersonale.getPrenotazioni().add(p);
				}
			}
			check = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return check;
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