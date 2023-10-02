package it.unipv.sfw.strutturasanitaria;

import java.util.ArrayList;
import it.unipv.sfw.persona.*;
import it.unipv.sfw.prestazionisantarie.*;

public class StrutturaSanitaria implements HospitalManager {
	String struttura, indirizzo, cap, paese;
	private ArrayList<Medico> medici;
	private ArrayList<OperatoreSanitario> operatoriSanitari;
	private ArrayList<OperatoreUfficio> operatoriUfficio;
	private ArrayList<Paziente> pazienti;
	private ArrayList<Esame> esami;
	private ArrayList<Operazione> operazioni;
	private ArrayList<Terapia> terapie;
	private ArrayList<Visita> visite;
	private ArrayList<Account> accounts;
	
	private static StrutturaSanitaria struttura1;
	
	
	private StrutturaSanitaria() {
		this.medici = new ArrayList<Medico>();
		this.operatoriSanitari = new ArrayList<OperatoreSanitario>();
		this.operatoriUfficio = new ArrayList<OperatoreUfficio>();
		this.pazienti = new ArrayList<Paziente>();
		this.esami = new ArrayList<Esame>();
		this.operazioni = new ArrayList<Operazione>();
		this.terapie = new ArrayList<Terapia>();
		this.visite = new ArrayList<Visita>();
		this.accounts = new ArrayList<Account>();

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
	
	public void populateEsami (ArrayList<Esame> esami) {
		this.esami = esami;
	}
	
	public void populateOperazioni (ArrayList<Operazione> operazioni) {
		this.operazioni = operazioni;
	}
	
	public void populateTerapie (ArrayList<Terapia> terapie) {
		this.terapie = terapie;
	}
	
	public void populateVisite (ArrayList<Visita> visite) {
		this.visite = visite;
	}
	
	public void populateAccounts (ArrayList<Account> accounts) {
		this.accounts = accounts;
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
	
	public ArrayList<Esame> getEsamiArray() {
		return esami;
	}
	
	public ArrayList<Operazione> getOperazioniArray() {
		return operazioni;
	}
	
	public ArrayList<Terapia> getTerapieArray() {
		return terapie;
	}
	
	public ArrayList<Visita> getVisiteArray() {
		return visite;
	}
	
	public ArrayList<Account> getAccountsArray() {
		return accounts;
	}

}
