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
import it.unipv.sfw.model.persona.IAccount;
import it.unipv.sfw.model.persona.IPaziente;
import it.unipv.sfw.model.persona.IPersonaleSanitario;
import it.unipv.sfw.model.persona.Medico;
import it.unipv.sfw.model.persona.OperatoreSanitario;
import it.unipv.sfw.model.persona.OperatoreUfficio;
import it.unipv.sfw.model.persona.Paziente;
import it.unipv.sfw.model.prenotazione.IPrenotazione;
import it.unipv.sfw.model.prenotazione.Prenotazione;
import it.unipv.sfw.model.prenotazione.PrestazioneSanitaria;
import it.unipv.sfw.model.prenotazione.TipoPrestazione;
import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;

public class FacadeSingletonDB {
		
	private static FacadeSingletonDB istanzaDB = null;
	private IStrutturaSanitaria struttura;
	
	private IProfiloDAO profilo;
	private ICalendarioDAO calendario;
	private ICartellaClinicaDAO cartellaClinica;
	private IPrenotazioneDAO prenotazione;
	private IPrestazioneSanitariaDAO prestazione;	
	
	private FacadeSingletonDB() {
		super();
		this.struttura = new StrutturaSanitaria();
		
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
		popolaCartellaClinica(struttura.getPazienti());
		popolaPrenotazioni(struttura.getPazienti());
		recuperoIdUltimaPrenotazione();
		
	
	}
	
	public IStrutturaSanitaria getStruttura() {
		return struttura;
	}

	public void setStruttura(StrutturaSanitaria struttura) {
		this.struttura = struttura;
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
			
			struttura.getPazienti().add(p);
			struttura.getCfPersone().put(i.getCf(), p);
		}
	}
	
	public void popolaMedici() {	
		LocalDate oggi = LocalDate.now();
		ArrayList<ProfiloDB> medici = new ArrayList<>();
		
		medici = profilo.selectAllMedici();
		
		for (ProfiloDB i: medici) {
			
			ArrayList<IPrenotazione> calendarioMedico = new ArrayList<>();
			
			ArrayList<PrenotazioneDB> calendarioDB = new ArrayList<>();
			calendarioDB = prenotazione.selectPrenotazioniByPersonaleSanitario(i.getCf());
			
			
			for(PrenotazioneDB k : calendarioDB) {
				IPaziente paziente = (Paziente)struttura.getCfPersone().get(k.getPaziente());
				IAccount personaleSanitario = struttura.getCfPersone().get(k.getPersonaleSanitario());
				PrestazioneSanitaria prestazione = struttura.getTipoPrestazioni().get(k.getTipo());
				
				IPrenotazione prenotazione = new Prenotazione(k.getIdPren(), paziente, personaleSanitario, 
						prestazione, k.getDataPren(), k.getOraPren());
				
				if(prenotazione.getData().isAfter(oggi) || prenotazione.getData().equals(oggi)) {
				calendarioMedico.add(prenotazione);
				}
			}
				
			IAccount m = new Medico(i.getCf(), i.getPw(), i.getTipoAcc(), i.getNome(), i.getCognome(), i.getSesso(), i.getDataNascita(), 
					i.getLuogoNascita(), i.getProvinciaNascita(), i.getRegioneRes(), i.getProvinciaRes(), i.getCittaRes(), 
					i.getIndirizzo(), i.getCap(), i.geteMail(), i.getCellulare(), 
					TipoPrestazione.valueOf(i.getSpecializzazione()), calendarioMedico);
			
			struttura.getMedici().add((IPersonaleSanitario) m);
			struttura.getCfPersone().put(i.getCf(), m);
			struttura.getPersonaleSanitario().put(TipoPrestazione.valueOf(i.getSpecializzazione()), m);
		}
	}
	
	public void popolaOperatoriSanitari() {
		LocalDate oggi = LocalDate.now();

		ArrayList<ProfiloDB> operatoriSanitari = new ArrayList<>();
		
		operatoriSanitari = profilo.selectAllOperatoriSanitari();
		
		for (ProfiloDB i: operatoriSanitari) {
			
			ArrayList<IPrenotazione> calendarioOperatore = new ArrayList<>();
			
			ArrayList<PrenotazioneDB> calendarioDB = new ArrayList<>();
			calendarioDB = prenotazione.selectPrenotazioniByPersonaleSanitario(i.getCf());
			
			
			for(PrenotazioneDB k : calendarioDB) {
				IPaziente paziente = (Paziente)struttura.getCfPersone().get(k.getPaziente());
				IAccount personaleSanitario = struttura.getCfPersone().get(k.getPersonaleSanitario());
				PrestazioneSanitaria prestazione = struttura.getTipoPrestazioni().get(k.getTipo());
				
				IPrenotazione prenotazione = new Prenotazione(k.getIdPren(), paziente, personaleSanitario, 
						prestazione, k.getDataPren(), k.getOraPren());
				
				if(prenotazione.getData().isAfter(oggi) || prenotazione.getData().equals(oggi)) {
				calendarioOperatore.add(prenotazione);
				}
			}
			
			IAccount os = new OperatoreSanitario(i.getCf(), i.getPw(), i.getTipoAcc(), i.getNome(), i.getCognome(), i.getSesso(), i.getDataNascita(), 
					i.getLuogoNascita(), i.getProvinciaNascita(), i.getRegioneRes(), i.getProvinciaRes(), i.getCittaRes(), 
					i.getIndirizzo(), i.getCap(), i.geteMail(), i.getCellulare(), 
					TipoPrestazione.valueOf(i.getSpecializzazione()), calendarioOperatore);
			
			struttura.getOperatoriSanitari().add((IPersonaleSanitario) os);
			struttura.getCfPersone().put(i.getCf(), os);
			struttura.getPersonaleSanitario().put(TipoPrestazione.valueOf(i.getSpecializzazione()), os);
		}
	}
	
	public void popolaOperatoriUfficio() {
		ArrayList<ProfiloDB> operatoriUfficio = new ArrayList<>();
		
		operatoriUfficio = profilo.selectAlloperatoriUfficio();
		
		for (ProfiloDB i: operatoriUfficio) {
			
			IAccount ou = new OperatoreUfficio(i.getCf(), i.getPw(), i.getTipoAcc(), i.getNome(), i.getCognome(), i.getSesso(), i.getDataNascita(), 
					i.getLuogoNascita(), i.getProvinciaNascita(), i.getRegioneRes(), i.getProvinciaRes(), i.getCittaRes(), 
					i.getIndirizzo(), i.getCap(), i.geteMail(), i.getCellulare());
			
			struttura.getOperatoriUfficio().add((OperatoreUfficio) ou);
			struttura.getCfPersone().put(i.getCf(), ou);
		}
	}		
		
	public void popolaPrestazione() {
		ArrayList<PrestazioneSanitariaDB> prestazioni = new ArrayList<>();
		
		prestazioni = prestazione.selectAllPrestazioniSanitarie();
		
		for (PrestazioneSanitariaDB p : prestazioni) {
			
			PrestazioneSanitaria ps = new PrestazioneSanitaria(p.getTipo(), p.getDurata());
			
			struttura.getPrestazioni().add(ps);
			struttura.getTipoPrestazioni().put(p.getTipo(), ps);
		}
		
	}

	//passando l'arraylist del  modello si popola, per ogni paziente, la cartella clinica comprendente le prenotazioni erogate
	public void popolaCartellaClinica(ArrayList<IPaziente> pazienti) {
		LocalDate oggi = LocalDate.now();
		for(IPaziente paziente : pazienti) {
		
		ArrayList<PrenotazioneDB> prDB = prenotazione.selectPrenotazioniByPaziente(paziente.getCf());
		ArrayList<IPrenotazione> prModello = new ArrayList<>();
		
		for(PrenotazioneDB i : prDB) {
			IAccount personaleSanitario = struttura.getCfPersone().get(i.getPersonaleSanitario());
			PrestazioneSanitaria prestazione = struttura.getTipoPrestazioni().get(i.getTipo());
			
			IPrenotazione a = new Prenotazione(i.getIdPren(), paziente, personaleSanitario, prestazione, i.getDataPren(), i.getOraPren());
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
		public void popolaPrenotazioni(ArrayList<IPaziente> pazienti) {
			LocalDate oggi = LocalDate.now();
			for(IPaziente paziente : pazienti) {
			
			ArrayList<PrenotazioneDB> prDB = prenotazione.selectPrenotazioniByPaziente(paziente.getCf());
			
			
			for(PrenotazioneDB i : prDB) {
				IAccount personaleSanitario = struttura.getCfPersone().get(i.getPersonaleSanitario());
				PrestazioneSanitaria prestazione = struttura.getTipoPrestazioni().get(i.getTipo());
				
				IPrenotazione a = new Prenotazione(i.getIdPren(), paziente, personaleSanitario, prestazione, i.getDataPren(), i.getOraPren());
				if(a.getData().isAfter(oggi) || a.getData().equals(oggi)) {
					paziente.getPrenotazioni().add(a);
				}
				struttura.getIdPrenotazioni().put(a.getIdPren(), a);
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
					struttura.getArraySlotLiberi().add(slot);
				}
			}
			
			}	
	
	public void inserisciPaziente(IPaziente a, CartellaClinica c) {
		ProfiloDB accountDB = new ProfiloDB(a.getCf(), a.getTipoAcc().toString(), a.getPw(), null, a.getNome(), a.getCognome(), 
				a.getSesso().toString(), a.getDataNascita(), a.getLuogoNascita(), a.getProvinciaNascita(), a.getRegioneRes(), a.getProvinciaRes(),
				a.getCittaRes(), a.getIndirizzo(), a.getCap(), a.geteMail(), a.getCellulare());
		
		CartellaClinicaDB cartellaDB = new CartellaClinicaDB(a.getCf(), c.getAltezza(), c.getPeso(), c.getGruppoSanguigno().toString());

		profilo.insertProfilo(accountDB);
		cartellaClinica.insertCartelle(cartellaDB);
	}
	
	public void inserisciCartellaClinica(IPaziente p) {
		CartellaClinica cc = p.getCartellaPersonale();
		CartellaClinicaDB cartellaDB = new CartellaClinicaDB(p.getCf(), cc.getAltezza(), cc.getPeso(), cc.getGruppoSanguigno().toString());
		cartellaClinica.insertCartelle(cartellaDB);
	}
	
	public void inserisciPrenotazione(IPrenotazione p) {
		
		PrenotazioneDB prenotazioneDB = new PrenotazioneDB(p.getIdPren(), p.getPaziente().getCf(), p.getPersonaleSanitario().getCf(), 
				p.getPrestazione().getTipo().name(), p.getData().toString(), p.getOrario().toString());
		
		prenotazione.insertPrenotazione(prenotazioneDB);
		calendario.updateCalendarioNewPren(prenotazioneDB);	
	}
	
	public void cancellaPrenotazione(IPrenotazione p) {
		
		PrenotazioneDB prenotazioneDB = new PrenotazioneDB(p.getIdPren(), p.getPaziente().getCf(), p.getPersonaleSanitario().getCf(), 
				p.getPrestazione().getTipo().name(), p.getData().toString(), p.getOrario().toString());
		
		prenotazione.deletePrenotazione(prenotazioneDB);
		calendario.updateCalendarioDelPren(prenotazioneDB);		
	}
	
	public void recuperoIdUltimaPrenotazione() {
		int n = prenotazione.selectNumeroPrenotazione();
		struttura.setUltimaPrenotazione(n);
		
	}
	
	public void aggiornaPw(IAccount a) {		
		profilo.updatePw(a.getCf(), a.getTipoAcc(), a.getPw());
	}
	
}
