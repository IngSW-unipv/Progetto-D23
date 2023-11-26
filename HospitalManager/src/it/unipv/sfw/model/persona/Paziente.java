package it.unipv.sfw.model.persona;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import it.unipv.sfw.jdbc.FacadeSingletonDB;
import it.unipv.sfw.model.*;

public class Paziente extends Account implements IPrenotante {
	private StrutturaSanitaria struttura = StrutturaSanitaria.getIstanzaStruttura();
	private FacadeSingletonDB istanzaDB = FacadeSingletonDB.getIstanzaFacade();
	
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
		this.cartellaPersonale = new CartellaClinica();
	}

	@Override
	public boolean inserisciPrenotazione(TipoPrestazione prest, LocalDate data, LocalTime orario) {
		boolean check = false;
		try {
			int idPren = struttura.generaIdPren();
			Account personale = struttura.getPersonaleSanitario().get(prest);
			PrestazioneSanitaria prestazione = struttura.getTipoPrestazioni().get(prest);
			Prenotazione p = new Prenotazione(idPren, this, personale, prestazione, data, orario);
			
			istanzaDB.inserisciPrenotazione(p);
			this.prenotazioni.add(p);
			
			if(personale.getTipoAcc() == TipoAccount.ME) {
				Medico m = (Medico)personale;
				m.getCalendario().add(p);
			}else {
				OperatoreSanitario op = (OperatoreSanitario)personale;
				op.getCalendario().add(p);
			}
			
			check = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return check;
	}

	@Override
	public boolean cancellaPrenotazione(Prenotazione p) {
		boolean check = false;
		try {
			istanzaDB.cancellaPrenotazione(p);
			
			for(Prenotazione i : prenotazioni) {
				if(p.getIdPren() == i.getIdPren()) {
					prenotazioni.remove(i);
				}
			}
			
			if(p.getPersonaleSanitario().getTipoAcc() == TipoAccount.ME) {
				Medico m = (Medico)p.getPersonaleSanitario();
				
				for(Prenotazione i : m.getCalendario()) {
					if(p.getIdPren() == i.getIdPren()) {
						m.getCalendario().remove(i);
					}
				}
			}else {
				OperatoreSanitario op = (OperatoreSanitario)p.getPersonaleSanitario();
				
				for(Prenotazione i : op.getCalendario()) {
					if(p.getIdPren() == i.getIdPren()) {
						op.getCalendario().remove(i);
					}
				}
	
			check = true;
			}
			
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