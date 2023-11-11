package it.unipv.sfw.jdbc;

import java.util.ArrayList;

import it.unipv.sfw.jdbc.bean.calendario.*;
import it.unipv.sfw.jdbc.bean.cartellaclinica.*;
import it.unipv.sfw.jdbc.bean.prenotazione.*;
import it.unipv.sfw.jdbc.bean.prestazionesanitaria.*;
import it.unipv.sfw.jdbc.bean.profilo.IProfiloDAO;
import it.unipv.sfw.jdbc.bean.profilo.ProfiloDB;
import it.unipv.sfw.model.CartellaClinica;
import it.unipv.sfw.model.Prenotazione;
import it.unipv.sfw.model.PrestazioneSanitaria;
import it.unipv.sfw.model.StrutturaSanitaria;
import it.unipv.sfw.model.persona.Account;
import it.unipv.sfw.model.persona.Medico;
import it.unipv.sfw.model.persona.OperatoreSanitario;
import it.unipv.sfw.model.persona.OperatoreUfficio;
import it.unipv.sfw.model.persona.Paziente;

public class FacadeSingletonDB {
	
	
	private static StrutturaSanitaria struttura1;
	
	private IProfiloDAO profilo;
	private ICalendarioDAO calendario;
	private ICartellaClinicaDAO cartellaClinica;
	private IPrenotazioneDAO prenotazione;
	private IPrestazioneSanitariaDAO prestazione;

	//costruttore
	//...
	
	
	public void popolaPazienti() {
		ArrayList<ProfiloDB> pazienti = new ArrayList<>();
		
		pazienti = profilo.selectAllMedici();
		
		for (ProfiloDB i: pazienti) {
			
			Paziente p = new Paziente(i.getCf(), i.getPw(), i.getTipoAcc(), i.getNome(), i.getCognome(), i.getDataNascita(), 
					i.getLuogoNascita(), i.getProvinciaNascita(), i.getRegioneRes(), i.getProvinciaRes(), i.getCittaRes(), 
					i.getIndirizzo(), i.getCap(), i.getIndirizzo(), i.geteMail(), i.getCellulare());
			
			struttura1.getPazienti().add(p);
			struttura1.getCfPersone().put(i.getCf(), p);
		}
	}
	
	public void popolaMedici() {
		ArrayList<ProfiloDB> medici = new ArrayList<>();
		
		medici = profilo.selectAllPazienti();
		
		for (ProfiloDB i: medici) {
			
			Medico m = new Medico(i.getCf(), i.getPw(), i.getTipoAcc(), i.getNome(), i.getCognome(), i.getDataNascita(), 
					i.getLuogoNascita(), i.getProvinciaNascita(), i.getRegioneRes(), i.getProvinciaRes(), i.getCittaRes(), 
					i.getIndirizzo(), i.getCap(), i.getIndirizzo(), i.geteMail(), i.getCellulare());
			
			struttura1.getMedici().add(m);
			struttura1.getCfPersone().put(i.getCf(), m);
		}
	}
	
	public void popolaOperatoriSanitari() {
		ArrayList<ProfiloDB> operatoriSanitari = new ArrayList<>();
		
		operatoriSanitari = profilo.selectAllOperatoriSanitari();
		
		for (ProfiloDB i: operatoriSanitari) {
			
			OperatoreSanitario os = new OperatoreSanitario(i.getCf(), i.getPw(), i.getTipoAcc(), i.getNome(), i.getCognome(), i.getDataNascita(), 
					i.getLuogoNascita(), i.getProvinciaNascita(), i.getRegioneRes(), i.getProvinciaRes(), i.getCittaRes(), 
					i.getIndirizzo(), i.getCap(), i.getIndirizzo(), i.geteMail(), i.getCellulare());
			
			struttura1.getOperatoriSanitari().add(os);
			struttura1.getCfPersone().put(i.getCf(), os);
		}
	}
	
	public void popolaOperatoriUfficio() {
		ArrayList<ProfiloDB> operatoriUfficio = new ArrayList<>();
		
		operatoriUfficio = profilo.selectAlloperatoriUfficio();
		
		for (ProfiloDB i: operatoriUfficio) {
			
			OperatoreUfficio ou = new OperatoreUfficio(i.getCf(), i.getPw(), i.getTipoAcc(), i.getNome(), i.getCognome(), i.getDataNascita(), 
					i.getLuogoNascita(), i.getProvinciaNascita(), i.getRegioneRes(), i.getProvinciaRes(), i.getCittaRes(), 
					i.getIndirizzo(), i.getCap(), i.getIndirizzo(), i.geteMail(), i.getCellulare());
			
			struttura1.getOperatoriUfficio().add(ou);
			struttura1.getCfPersone().put(i.getCf(), ou);
		}
	}		
		
	public void popolaPrestazione() {
		ArrayList<PrestazioneSanitariaDB> prestazioni = new ArrayList<>();
		
		prestazioni = prestazione.selectAllPrestazioniSanitarie();
		
		for (PrestazioneSanitariaDB p : prestazioni) {
			
			PrestazioneSanitaria ps = new PrestazioneSanitaria(p.getIdPrest(),p.getTipo(), p.getDurata(), p.getCosto());
			
			struttura1.getPrestazioni().add(ps);
			struttura1.getIdPrestazioni().put(p.getIdPrest(), ps);
		}
		
	}

	//passando l'arraylist del  modello si popola, per ogni paziente, la cartella clinica comprendente le prenotazioni erogate
	public void popolaCartellaClinica(ArrayList<Paziente> pazienti) {
		
		for(Paziente paziente : pazienti) {
		
		ArrayList<PrenotazioneDB> prDB = prenotazione.selectPrenotazioniErogateByPaziente(paziente.getCf());
		ArrayList<Prenotazione> prModello = null;
		
		for(PrenotazioneDB i : prDB) {
			Account personaleSanitario = struttura1.getCfPersone().get(i.getPersonaleSanitario());
			PrestazioneSanitaria prestazione = struttura1.getIdPrestazioni().get(i.getIdPrest());
			
			Prenotazione a = new Prenotazione(i.getIdPren(), paziente, personaleSanitario, prestazione, i.getDataPren(), i.getOraPren(), 
					i.isAccreditamento(), i.getEsito());
			
			prModello.add(a);
		}
		
		CartellaClinicaDB cc = cartellaClinica.selectCartellaByCf(paziente.getCf());
		CartellaClinica cartellaPersonale = new CartellaClinica(cc.getAltezza(), cc.getPeso(), cc.getGruppoSanguigno(), prModello);
		paziente.setCartellaPersonale(cartellaPersonale);
		}
		
	}
	
	//passando l'arraylist del  modello si popola, per ogni paziente, la lista delle sue prenotazioni ancora da erogare
		public void popolaPrenotazioni(ArrayList<Paziente> pazienti) {
			
			for(Paziente paziente : pazienti) {
			
			ArrayList<PrenotazioneDB> prDB = prenotazione.selectPrenotazioniByPaziente(paziente.getCf());
			
			
			for(PrenotazioneDB i : prDB) {
				Account personaleSanitario = struttura1.getCfPersone().get(i.getPersonaleSanitario());
				PrestazioneSanitaria prestazione = struttura1.getIdPrestazioni().get(i.getIdPrest());
				
				Prenotazione a = new Prenotazione(i.getIdPren(), paziente, personaleSanitario, prestazione, i.getDataPren(), i.getOraPren(), 
						i.isAccreditamento(), i.getEsito());
				
				paziente.getPrenotazioni().add(a);
			}
			
			}
			
		}
	
}
