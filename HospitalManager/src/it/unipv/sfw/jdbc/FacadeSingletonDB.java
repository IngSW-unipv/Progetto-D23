package it.unipv.sfw.jdbc;

import java.util.ArrayList;

import it.unipv.sfw.jdbc.bean.account.*;
import it.unipv.sfw.jdbc.bean.anagrafica.*;
import it.unipv.sfw.jdbc.bean.calendario.*;
import it.unipv.sfw.jdbc.bean.cartellaclinica.*;
//import it.unipv.sfw.jdbc.bean.esiti.*;
import it.unipv.sfw.jdbc.bean.prenotazione.*;
import it.unipv.sfw.jdbc.bean.prestazionesanitaria.*;
import it.unipv.sfw.model.Account;
import it.unipv.sfw.model.Prenotazione;
import it.unipv.sfw.model.PrestazioneSanitaria;
import it.unipv.sfw.model.StrutturaSanitaria;
import it.unipv.sfw.model.persona.Medico;
import it.unipv.sfw.model.persona.Paziente;

public class FacadeSingletonDB {
	
	private static FacadeSingletonDB controllerDB;
	private static StrutturaSanitaria struttura1;
	
	private IAccountDAO account;
	private IAnagraficaDAO anagrafica;
	private ICalendarioDAO calendario;
	private ICartellaClinicaDAO cartellaClinica;
	//private IEsitiDAO esito;
	private IPrenotazioneDAO prenotazione;
	private IPrestazioneSanitariaDAO prestazione;

	//costruttore
	//...
	
	
	public void popolaMedici() {
		ArrayList<AnagraficaDB> medici = new ArrayList<>();
		
		medici = anagrafica.selectAnagraficaMedici();
		
		for (AnagraficaDB a: medici) {
			
			Medico m = new Medico(a.getCf(), a.getNome(), a.getCognome(), a.getSesso(), 
					a.getDataNascita(), a.getLuogoNascita(), a.getProvinciaNascita(), a.getRegioneRes(), a.getProvinciaRes(), 
					a.getCittaRes(), a.getIndirizzo(), a.getCap(), a.geteMail(), a.getCellulare());
			
			struttura1.getMedici().add(m);
			
			struttura1.getCfPersone().put(a.getCf(), m);
		}
	}
	
	
	// popola pazienti, opsan, opuff uguali a popola medici
		
		public void popolaAccount() {
			ArrayList<AccountDB> accounts = new ArrayList<>();
			
			accounts = account.selectAllAccounts();
			
			for (AccountDB a: accounts) {
				
				Account acc = new Account(struttura1.getCfPersone().get(a.getCf()), a.getIdAcc(), a.getPw(), 
						a.getSpecializzazione(), a.getTipoAcc());
				
				struttura1.getAccounts().add(acc);

			}
	}
	
	public void popolaPrestazione() {
		ArrayList<PrestazioneSanitariaDB> prestazioni = new ArrayList<>();
		
		prestazioni = prestazione.selectAllPrestazioniSanitarie();
		
		for (PrestazioneSanitariaDB ps: prestazioni) {
			struttura1.getPrestazioni().add(new PrestazioneSanitaria(ps.getIdPrest(),ps.getTipo(), ps.getDurata(), ps.getCosto()));
		}
		
	}
	
//	public void popolaPrenotazioniErogate(Paziente p, Account a) {
//		ArrayList<PrenotazioneDB> prenotazioniDB = new ArrayList<>();
//		prenotazioniDB = prenotazione.selectPrenotazioniErogateByIdPaziente(a.getIdAcc());
//		
//		for (PrenotazioneDB i : prenotazioniDB) {
//			
//			Prenotazione PrenotazioniModello = new Prenotazione(a.getIdAcc(), , null, a, a, null, null)
//
//		}
//		
//	}
//	
//	public void popolaCartellaClinica(Paziente p, Account a) {
//		CartellaClinicaDB cc = cartellaClinica.selectCartellaByIdAcc(a.getIdAcc());
//		
//		CartellaClinica cartellaPersonale = new CartellaClinica(cc.getAltezza(), cc.getPeso(), cc.getGruppoSanguigno(), );
//		
//			p.setCartellaPersonale(null);
//		
//	}
	
	
	
	
	
}
