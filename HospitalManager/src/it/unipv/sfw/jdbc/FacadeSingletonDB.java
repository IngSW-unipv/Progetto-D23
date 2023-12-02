package it.unipv.sfw.jdbc;

import java.time.LocalDate;
import java.util.ArrayList;

import it.unipv.sfw.jdbc.bean.calendario.*;
import it.unipv.sfw.jdbc.bean.cartellaclinica.*;
import it.unipv.sfw.jdbc.bean.prenotazione.*;
import it.unipv.sfw.jdbc.bean.prestazionesanitaria.*;
import it.unipv.sfw.jdbc.bean.profilo.IProfiloDAO;
import it.unipv.sfw.jdbc.bean.profilo.ProfiloDAO;
import it.unipv.sfw.jdbc.bean.profilo.ProfiloDB;
import it.unipv.sfw.model.calendario.SlotCalendarioSingoli;
import it.unipv.sfw.model.cartellaclinica.CartellaClinica;
import it.unipv.sfw.model.persona.Account;
import it.unipv.sfw.model.persona.Medico;
import it.unipv.sfw.model.persona.OperatoreSanitario;
import it.unipv.sfw.model.persona.OperatoreUfficio;
import it.unipv.sfw.model.persona.Paziente;
import it.unipv.sfw.model.prenotazione.Prenotazione;
import it.unipv.sfw.model.prenotazione.PrestazioneSanitaria;
import it.unipv.sfw.model.prenotazione.TipoPrestazione;
import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;

public class FacadeSingletonDB {
		
	private static FacadeSingletonDB istanzaDB = null;
	private StrutturaSanitaria struttura1;
	
	private IProfiloDAO profilo;
	private ICalendarioDAO calendario;
	private ICartellaClinicaDAO cartellaClinica;
	private IPrenotazioneDAO prenotazione;
	private IPrestazioneSanitariaDAO prestazione;	
	
	private FacadeSingletonDB() {
		super();
		this.struttura1 = new StrutturaSanitaria();
		
		this.profilo = new ProfiloDAO();
		this.calendario = new CalendarioDAO();
		this.cartellaClinica = new CartellaClinicaDAO();
		this.prenotazione = new PrenotazioneDAO();
		this.prestazione = new PrestazioneSanitariaDAO();
		
		popolaPrestazione();
		popolaPazienti();
		popolaMedici();
		popolaOperatoriSanitari();
		popolaOperatoriUfficio();
		popolaCartellaClinica(struttura1.getPazienti());
		popolaPrenotazioni(struttura1.getPazienti());
		recuperoIdUltimaPrenotazione();
		
	
	}
	
	public StrutturaSanitaria getStruttura1() {
		return struttura1;
	}



	public void setStruttura1(StrutturaSanitaria struttura1) {
		this.struttura1 = struttura1;
	}



	public static FacadeSingletonDB getIstanzaFacade() {
		if(istanzaDB == null) {
			istanzaDB = new FacadeSingletonDB();
		}
		return istanzaDB;
	}

	public void popolaPazienti() {
		ArrayList<ProfiloDB> pazienti = new ArrayList<>();
		
		pazienti = profilo.selectAllPazienti();
		
		for (ProfiloDB i: pazienti) {
			
			Paziente p = new Paziente(i.getCf(), i.getPw(), i.getTipoAcc(), i.getNome(), i.getCognome(), i.getSesso(), i.getDataNascita(), 
					i.getLuogoNascita(), i.getProvinciaNascita(), i.getRegioneRes(), i.getProvinciaRes(), i.getCittaRes(), 
					i.getIndirizzo(), i.getCap(), i.geteMail(), i.getCellulare());
			
			struttura1.getPazienti().add(p);
			struttura1.getCfPersone().put(i.getCf(), p);
		}
	}
	
	public void popolaMedici() {	
		LocalDate oggi = LocalDate.now();
		ArrayList<ProfiloDB> medici = new ArrayList<>();
		
		medici = profilo.selectAllMedici();
		
		for (ProfiloDB i: medici) {
			
			ArrayList<Prenotazione> calendarioMedico = new ArrayList<>();
			
			ArrayList<PrenotazioneDB> calendarioDB = new ArrayList<>();
			calendarioDB = prenotazione.selectPrenotazioniByPersonaleSanitario(i.getCf());
			
			
			for(PrenotazioneDB k : calendarioDB) {
				Paziente paziente = (Paziente)struttura1.getCfPersone().get(k.getPaziente());
				Account personaleSanitario = struttura1.getCfPersone().get(k.getPersonaleSanitario());
				PrestazioneSanitaria prestazione = struttura1.getTipoPrestazioni().get(k.getTipo());
				
				Prenotazione prenotazione = new Prenotazione(k.getIdPren(), paziente, personaleSanitario, 
						prestazione, k.getDataPren(), k.getOraPren());
				
				if(prenotazione.getData().isAfter(oggi) || prenotazione.getData().equals(oggi)) {
				calendarioMedico.add(prenotazione);
				}
			}
				
			Medico m = new Medico(i.getCf(), i.getPw(), i.getTipoAcc(), i.getNome(), i.getCognome(), i.getSesso(), i.getDataNascita(), 
					i.getLuogoNascita(), i.getProvinciaNascita(), i.getRegioneRes(), i.getProvinciaRes(), i.getCittaRes(), 
					i.getIndirizzo(), i.getCap(), i.geteMail(), i.getCellulare(), 
					TipoPrestazione.valueOf(i.getSpecializzazione()), calendarioMedico);
			
			struttura1.getMedici().add(m);
			struttura1.getCfPersone().put(i.getCf(), m);
			struttura1.getPersonaleSanitario().put(TipoPrestazione.valueOf(i.getSpecializzazione()), m);
		}
	}
	
	public void popolaOperatoriSanitari() {
		LocalDate oggi = LocalDate.now();

		ArrayList<ProfiloDB> operatoriSanitari = new ArrayList<>();
		
		operatoriSanitari = profilo.selectAllOperatoriSanitari();
		
		for (ProfiloDB i: operatoriSanitari) {
			
			ArrayList<Prenotazione> calendarioOperatore = new ArrayList<>();
			
			ArrayList<PrenotazioneDB> calendarioDB = new ArrayList<>();
			calendarioDB = prenotazione.selectPrenotazioniByPersonaleSanitario(i.getCf());
			
			
			for(PrenotazioneDB k : calendarioDB) {
				Paziente paziente = (Paziente)struttura1.getCfPersone().get(k.getPaziente());
				Account personaleSanitario = struttura1.getCfPersone().get(k.getPersonaleSanitario());
				PrestazioneSanitaria prestazione = struttura1.getTipoPrestazioni().get(k.getTipo());
				
				Prenotazione prenotazione = new Prenotazione(k.getIdPren(), paziente, personaleSanitario, 
						prestazione, k.getDataPren(), k.getOraPren());
				
				if(prenotazione.getData().isAfter(oggi) || prenotazione.getData().equals(oggi)) {
				calendarioOperatore.add(prenotazione);
				}
			}
			
			OperatoreSanitario os = new OperatoreSanitario(i.getCf(), i.getPw(), i.getTipoAcc(), i.getNome(), i.getCognome(), i.getSesso(), i.getDataNascita(), 
					i.getLuogoNascita(), i.getProvinciaNascita(), i.getRegioneRes(), i.getProvinciaRes(), i.getCittaRes(), 
					i.getIndirizzo(), i.getCap(), i.geteMail(), i.getCellulare(), 
					TipoPrestazione.valueOf(i.getSpecializzazione()), calendarioOperatore);
			
			struttura1.getOperatoriSanitari().add(os);
			struttura1.getCfPersone().put(i.getCf(), os);
			struttura1.getPersonaleSanitario().put(TipoPrestazione.valueOf(i.getSpecializzazione()), os);
		}
	}
	
	public void popolaOperatoriUfficio() {
		ArrayList<ProfiloDB> operatoriUfficio = new ArrayList<>();
		
		operatoriUfficio = profilo.selectAlloperatoriUfficio();
		
		for (ProfiloDB i: operatoriUfficio) {
			
			OperatoreUfficio ou = new OperatoreUfficio(i.getCf(), i.getPw(), i.getTipoAcc(), i.getNome(), i.getCognome(), i.getSesso(), i.getDataNascita(), 
					i.getLuogoNascita(), i.getProvinciaNascita(), i.getRegioneRes(), i.getProvinciaRes(), i.getCittaRes(), 
					i.getIndirizzo(), i.getCap(), i.geteMail(), i.getCellulare());
			
			struttura1.getOperatoriUfficio().add(ou);
			struttura1.getCfPersone().put(i.getCf(), ou);
		}
	}		
		
	public void popolaPrestazione() {
		ArrayList<PrestazioneSanitariaDB> prestazioni = new ArrayList<>();
		
		prestazioni = prestazione.selectAllPrestazioniSanitarie();
		
		for (PrestazioneSanitariaDB p : prestazioni) {
			
			PrestazioneSanitaria ps = new PrestazioneSanitaria(p.getTipo(), p.getDurata());
			
			struttura1.getPrestazioni().add(ps);
			struttura1.getTipoPrestazioni().put(p.getTipo(), ps);
		}
		
	}

	//passando l'arraylist del  modello si popola, per ogni paziente, la cartella clinica comprendente le prenotazioni erogate
	public void popolaCartellaClinica(ArrayList<Paziente> pazienti) {
		LocalDate oggi = LocalDate.now();
		for(Paziente paziente : pazienti) {
		
		ArrayList<PrenotazioneDB> prDB = prenotazione.selectPrenotazioniByPaziente(paziente.getCf());
		ArrayList<Prenotazione> prModello = new ArrayList<>();
		
		for(PrenotazioneDB i : prDB) {
			Account personaleSanitario = struttura1.getCfPersone().get(i.getPersonaleSanitario());
			PrestazioneSanitaria prestazione = struttura1.getTipoPrestazioni().get(i.getTipo());
			
			Prenotazione a = new Prenotazione(i.getIdPren(), paziente, personaleSanitario, prestazione, i.getDataPren(), i.getOraPren());
			if(a.getData().isBefore(oggi)) {
				prModello.add(a);
			}
		}
		
		CartellaClinicaDB cc = cartellaClinica.selectCartellaByCf(paziente.getCf());
		CartellaClinica cartellaPersonale = new CartellaClinica(cc.getAltezza(), cc.getPeso(), cc.getGruppoSanguigno(), prModello);
		paziente.setCartellaPersonale(cartellaPersonale);
		}
		
	}
	
	//passando l'arraylist del  modello si popola, per ogni paziente, la lista delle sue prenotazioni ancora da erogare
		public void popolaPrenotazioni(ArrayList<Paziente> pazienti) {
			LocalDate oggi = LocalDate.now();
			for(Paziente paziente : pazienti) {
			
			ArrayList<PrenotazioneDB> prDB = prenotazione.selectPrenotazioniByPaziente(paziente.getCf());
			
			
			for(PrenotazioneDB i : prDB) {
				Account personaleSanitario = struttura1.getCfPersone().get(i.getPersonaleSanitario());
				PrestazioneSanitaria prestazione = struttura1.getTipoPrestazioni().get(i.getTipo());
				
				Prenotazione a = new Prenotazione(i.getIdPren(), paziente, personaleSanitario, prestazione, i.getDataPren(), i.getOraPren());
				if(a.getData().isAfter(oggi) || a.getData().equals(oggi)) {
					paziente.getPrenotazioni().add(a);
				}
				
			}
			
			}
		}	
		
		public void visualizzaSlotLiberi(TipoPrestazione prest) {
			LocalDate oggi = LocalDate.now();
			ArrayList<SlotCalendarioSingoloDB> slotDB = new ArrayList<>();
			
			switch(prest) {
			case VISITA_ONCOLOGICA:
				slotDB = calendario.selectCalendarioOncologica();
				break;
			case VISITA_PSICOLOGICA:
				slotDB = calendario.selectCalendarioPsicologica();
				break;
			case ESAMI_SANGUE:
				slotDB = calendario.selectCalendarioEsamiSangue();
				break;
			case TAC:
				slotDB = calendario.selectCalendarioTac();
				break;
			case RISONANZA_MAGNETICA:
				slotDB = calendario.selectCalendarioRisonanza();
				break;
			case CHEMIOTERAPIA:
				slotDB = calendario.selectCalendarioChemio();
				break;
			case RADIOTERAPIA:
				slotDB = calendario.selectCalendarioRadio();
				break;
			case NULL:
				break;
			}
			
			for(SlotCalendarioSingoloDB i : slotDB) {
				
				SlotCalendarioSingoli slot = new SlotCalendarioSingoli(i.getData(), i.getGiorno(), i.getOrario());
				
				if(slot.getData().isAfter(oggi)) {
					struttura1.getArraySlotLiberi().add(slot);
				}
			}
			
			}	
		
		
	public void inserisciPersonaleSanitario(Account a) {
		ProfiloDB accountDB = new ProfiloDB(a.getCf(), a.getTipoAcc().toString(), a.getPw(), a.getSpecializzazione().toString(), a.getNome(), a.getCognome(), 
				a.getSesso().toString(), a.getDataNascita(), a.getLuogoNascita(), a.getProvinciaNascita(), a.getRegioneRes(), a.getProvinciaRes(),
				a.getCittaRes(), a.getIndirizzo(), a.getCap(), a.geteMail(), a.getCellulare());
		
		profilo.insertProfilo(accountDB);
	}
	
	public void inserisciPaziente(Paziente a, CartellaClinica c) {
		ProfiloDB accountDB = new ProfiloDB(a.getCf(), a.getTipoAcc().toString(), a.getPw(), null, a.getNome(), a.getCognome(), 
				a.getSesso().toString(), a.getDataNascita(), a.getLuogoNascita(), a.getProvinciaNascita(), a.getRegioneRes(), a.getProvinciaRes(),
				a.getCittaRes(), a.getIndirizzo(), a.getCap(), a.geteMail(), a.getCellulare());
		
		CartellaClinicaDB cartellaDB = new CartellaClinicaDB(a.getCf(), c.getAltezza(), c.getPeso(), c.getGruppoSanguigno().toString());

		profilo.insertProfilo(accountDB);
		cartellaClinica.insertCartelle(cartellaDB);
	
	}
	public void inserisciOperatoreUfficio(OperatoreUfficio a) {
		ProfiloDB accountDB = new ProfiloDB(a.getCf(), a.getTipoAcc().toString(), a.getPw(), null, a.getNome(), a.getCognome(), 
				a.getSesso().toString(), a.getDataNascita(), a.getLuogoNascita(), a.getProvinciaNascita(), a.getRegioneRes(), a.getProvinciaRes(),
				a.getCittaRes(), a.getIndirizzo(), a.getCap(), a.geteMail(), a.getCellulare());
		
		profilo.insertProfilo(accountDB);
	}
	
	public void inserisciCartellaClinica(Paziente p) {
		CartellaClinica cc = p.getCartellaPersonale();
		CartellaClinicaDB cartellaDB = new CartellaClinicaDB(p.getCf(), cc.getAltezza(), cc.getPeso(), cc.getGruppoSanguigno().toString());
		cartellaClinica.insertCartelle(cartellaDB);
	}
	
	public void inserisciPrenotazione(Prenotazione p) {
		
		PrenotazioneDB prenotazioneDB = new PrenotazioneDB(p.getIdPren(), p.getPaziente().getCf(), p.getPersonaleSanitario().getCf(), 
				p.getPrestazione().getTipo().name(), p.getData().toString(), p.getOrario().toString());
		
		prenotazione.insertPrenotazione(prenotazioneDB);
		calendario.updateCalendarioNewPren(prenotazioneDB);
		// INSERISCI PRENOTAZIONE IN TABLE PRENOTAZIONI E AGGIORNA TABLE CALENDARIO
		
	}
	
	public void cancellaPrenotazione(Prenotazione p) {
		
		PrenotazioneDB prenotazioneDB = new PrenotazioneDB(p.getIdPren(), p.getPaziente().getCf(), p.getPersonaleSanitario().getCf(), 
				p.getPrestazione().getTipo().name(), p.getData().toString(), p.getOrario().toString());
		
		prenotazione.deletePrenotazione(prenotazioneDB);
		calendario.updateCalendarioDelPren(prenotazioneDB);		
	}
	
	public void recuperoIdUltimaPrenotazione() {
		int n = prenotazione.selectNumeroPrenotazione();
		struttura1.setUltimaPrenotazione(n);
		
	}
	
//	public void popolaPrenotazioniTutte() {
//		
//		ArrayList<PrenotazioneDB> prDB = prenotazione.selectPrenotazioniDaErogare();
//		
//		
//		for(PrenotazioneDB i : prDB) {
//			Paziente paziente = (Paziente) struttura1.getCfPersone().get(i.getPaziente());
//			Account personaleSanitario = struttura1.getCfPersone().get(i.getPersonaleSanitario());
//			PrestazioneSanitaria prestazione = struttura1.getTipoPrestazioni().get(i.getTipo());
//			
//			Prenotazione a = new Prenotazione(i.getIdPren(), paziente, personaleSanitario, prestazione, i.getDataPren(), i.getOraPren());
//			
//			struttura1.getPrenotazioni().add(a);
//			struttura1.getIdPrenotazioni().put(i.getIdPren(), a);
//		
//		}
//	}
	
//	public void popolaCalendario() {
//		ArrayList<SlotCalendarioDB> c = calendario.selectCalendario();
//		
//		for(SlotCalendarioDB i : c) {
//			Prenotazione prenPrest1 = struttura1.getIdPrenotazioni().get(i.getIdPren1());
//			Prenotazione prenPrest2 = struttura1.getIdPrenotazioni().get(i.getIdPren2());
//			Prenotazione prenPrest3 = struttura1.getIdPrenotazioni().get(i.getIdPren3());
//			Prenotazione prenPrest4 = struttura1.getIdPrenotazioni().get(i.getIdPren4());
//			Prenotazione prenPrest5 = struttura1.getIdPrenotazioni().get(i.getIdPren5());
//			Prenotazione prenPrest6 = struttura1.getIdPrenotazioni().get(i.getIdPren6());
//			Prenotazione prenPrest7 = struttura1.getIdPrenotazioni().get(i.getIdPren7());
//
//			SlotCalendario slot = new SlotCalendario(i.getData(), i.getGiorno(), i.getVacanza(), i.getOrario(),
//					prenPrest1, prenPrest2, prenPrest3, prenPrest4, prenPrest5, prenPrest6, prenPrest7);
//			
//			struttura1.getCalendario().add(slot);
//			
//		}
//	}
	
	
	
	
}
