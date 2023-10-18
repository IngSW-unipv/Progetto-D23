package it.unipv.sfw.model;

import java.util.ArrayList;

public class StrutturaSanitaria {
	String nome, indirizzo, cap, paese, id;
	
	private ArrayList<Medico> medici;
	private ArrayList<OperatoreSanitario> operatoriSanitari;
	private ArrayList<OperatoreUfficio> operatoriUfficio;
	private ArrayList<Account> accounts;
	private ArrayList<PrestazioneSanitaria> prestazioni;
	private ArrayList<Paziente> pazienti;
	private ArrayList<Prenotazione> prenotazioni;
	
	private static StrutturaSanitaria struttura1;
	
	
	private StrutturaSanitaria() {
		this.medici = new ArrayList<Medico>();
		this.operatoriSanitari = new ArrayList<OperatoreSanitario>();
		this.operatoriUfficio = new ArrayList<OperatoreUfficio>();
		this.pazienti = new ArrayList<Paziente>();
		this.prestazioni = new ArrayList<PrestazioneSanitaria>();
		this.accounts = new ArrayList<Account>();
		this.prenotazioni = new ArrayList<Prenotazione>();

	}
	
	//istanza del modello
	public static StrutturaSanitaria getInstance() {

		if (struttura1 == null) {
			struttura1 = new StrutturaSanitaria();
		}
		return struttura1;
	}
	
	//metodi set
	
	public void populateMedici(ArrayList<Medico> medici) {

		this.medici = medici;
	}
	
	public void populateOperatoriSanitari (ArrayList<OperatoreSanitario> operatoriSanitari) {
		this.operatoriSanitari = operatoriSanitari;
	}
	
	public void populateOperatoriUfficio (ArrayList<OperatoreUfficio> operatoriUfficio) {
		this.operatoriUfficio = operatoriUfficio;
	}
	
	public void populatePazienti (ArrayList<Paziente> pazienti) {
		this.pazienti = pazienti;
	}
	
	public void populateEsami (ArrayList<PrestazioneSanitaria> prestazioni) {
		this.prestazioni = prestazioni;
	}
	
	
	public void populateAccounts (ArrayList<Account> accounts) {
		this.accounts = accounts;
		
	}
	
	public void populatePrenotazioni(ArrayList<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}
	
	public void populatePrestazioneSanitaria(ArrayList<PrestazioneSanitaria> prestazioni) {
		this.prestazioni = prestazioni;
	}
	
	//metodi get
	
	public ArrayList<Medico> getMediciArray() {
		return medici;
	}

	public ArrayList<OperatoreSanitario> getOpSanArray() {
		return operatoriSanitari;
	}
	
	public ArrayList<OperatoreUfficio> getOpUffArray() {
		return operatoriUfficio;
	}
	
	public ArrayList<Paziente> getPazientiArray() {
		return pazienti;
	}
	
	public ArrayList<PrestazioneSanitaria> getEsamiArray() {
		return prestazioni;
	}
	
	public ArrayList<Account> getAccountsArray() {
		return accounts;
	}

	public ArrayList<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

}
