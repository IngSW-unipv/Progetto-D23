package it.unipv.sfw.jdbc;

import java.util.ArrayList;

import it.unipv.sfw.jdbc.bean.account.*;
import it.unipv.sfw.jdbc.bean.anagrafica.*;
import it.unipv.sfw.jdbc.bean.calendario.*;
import it.unipv.sfw.jdbc.bean.cartellaclinica.*;
import it.unipv.sfw.jdbc.bean.esiti.*;
import it.unipv.sfw.jdbc.bean.prenotazione.*;
import it.unipv.sfw.jdbc.bean.prestazionesanitaria.*;
import it.unipv.sfw.model.Account;
import it.unipv.sfw.model.StrutturaSanitaria;
import it.unipv.sfw.model.persona.Persona;

public class FacadeSingletonDB {
	
	private static FacadeSingletonDB controllerDB;
	private static StrutturaSanitaria struttura1;
	
	private IAccountDAO account;
	private IAnagraficaDAO anagrafica;
	private ICalendarioDAO calendario;
	private ICartellaClinicaDAO cartellaClinica;
	private IEsitiDAO esiti;
	private IPrenotazioneDAO prenotazione;
	private IPrestazioneSanitariaDAO prestazione;

	//costruttore
	//...
	
	public void popolaPersona() {
		ArrayList<AnagraficaDB> anagrafiche = new ArrayList<>();
		
		
		anagrafiche = anagrafica.selectAllAnagrafica();
		
		for (AnagraficaDB a: anagrafiche) {
			
			Persona p = new Persona(a.getCf(), a.getNome(), a.getCognome(), a.getSesso(), 
					a.getDataNascita(), a.getLuogoNascita(), a.getProvinciaNascita(), a.getRegioneRes(), a.getProvinciaRes(), 
					a.getCittaRes(), a.getIndirizzo(), a.getCap(), a.geteMail(), a.getCellulare());
			
			struttura1.getPersone().add(p);
			
			struttura1.getCfPersone().put(a.getCf(), p);
		}
	}
		
		public void popolaAccount() {
			ArrayList<AccountDB> accounts = new ArrayList<>();
			
			accounts = account.selectAllAccounts();
			
			for (AccountDB a: accounts) {
				struttura1.getAccounts().add(new Account(struttura1.getCfPersone().get(a.getCf()), a.getIdAcc(), a.getPw(), 
						a.getSpecializzazione(), a.getTipoAcc()));
			}
	}
	
	
	
}