package it.unipv.sfw.model.persona;

import java.util.ArrayList;

import it.unipv.sfw.model.Prenotazione;
import it.unipv.sfw.model.TipoAccount;
import it.unipv.sfw.model.TipoPrestazione;

public class Medico extends Account {
	
	private TipoPrestazione specializzazione;
	private ArrayList<Prenotazione> calendario;

	public Medico(String cf, String pw, TipoAccount tipoAcc, String nome, String cognome, String sesso,
			String dataNascita, String luogoNascita, String provinciaNascita, String regioneRes, String provinciaRes,
			String cittaRes, String indirizzo, String cap, String eMail, String cellulare,
			TipoPrestazione specializzazione, ArrayList<Prenotazione> calendario) {
		super(cf, pw, tipoAcc, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita, regioneRes,
				provinciaRes, cittaRes, indirizzo, cap, eMail, cellulare);
		this.specializzazione = specializzazione;
		this.calendario = calendario;
	}
	
	public Medico(String cf, String pw, TipoAccount tipoAcc, String nome, String cognome, String sesso,
			String dataNascita, String luogoNascita, String provinciaNascita, String regioneRes, String provinciaRes,
			String cittaRes, String indirizzo, String cap, String eMail, String cellulare,
			TipoPrestazione specializzazione) {
		super(cf, pw, tipoAcc, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita, regioneRes,
				provinciaRes, cittaRes, indirizzo, cap, eMail, cellulare);
		this.specializzazione = specializzazione;
		this.calendario = new ArrayList<>();
	}

	@Override
	public TipoPrestazione getSpecializzazione() {
		return specializzazione;
	}

	public void setSpecializzazione(TipoPrestazione specializzazione) {
		this.specializzazione = specializzazione;
	}

	public ArrayList<Prenotazione> getCalendario() {
		return calendario;
	}

	public void setCalendario(ArrayList<Prenotazione> calendario) {
		this.calendario = calendario;
	}

	
}
