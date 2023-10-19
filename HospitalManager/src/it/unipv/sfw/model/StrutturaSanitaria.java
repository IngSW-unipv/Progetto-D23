package it.unipv.sfw.model;
import java.util.ArrayList;

import it.unipv.sfw.model.persona.*;


public class StrutturaSanitaria implements IStrutturaSanitaria {
	private String nome;
	private String indirizzo;
	private String telefono;
	private String email;

	private ArrayList<Paziente> pazienti;
	private ArrayList<Medico> medici;
	private ArrayList<OperatoreSanitario> operatoriSanitari;
	private ArrayList<OperatoreUfficio> operatoriUfficio;
	private ArrayList<Account> accounts;
	private ArrayList<PrestazioneSanitaria> prestazioni;
	private ArrayList<Prenotazione> prenotazioni;
	private ArrayList<Erogazione> erogazioni;
	
	public StrutturaSanitaria(String nome, String indirizzo, String telefono, String email,
			ArrayList<Paziente> pazienti, ArrayList<Medico> medici, ArrayList<OperatoreSanitario> operatoriSanitari,
			ArrayList<OperatoreUfficio> operatoriUfficio, ArrayList<Account> accounts,
			ArrayList<PrestazioneSanitaria> prestazioni, ArrayList<Prenotazione> prenotazioni,
			ArrayList<Erogazione> erogazioni) {
		super();
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.email = email;
		this.pazienti = pazienti;
		this.medici = medici;
		this.operatoriSanitari = operatoriSanitari;
		this.operatoriUfficio = operatoriUfficio;
		this.accounts = accounts;
		this.prestazioni = prestazioni;
		this.prenotazioni = prenotazioni;
		this.erogazioni = erogazioni;
	}

	@Override
	public boolean registrazionePaziente(String pw, String specializzazione, String cf, String nome, String cognome,
			String sesso, String dataNascita, String luogoNascita, String provinciaNascita, String regioneRes,
			String provinciaRes, String cittaRes, String indirizzo, String cap, String eMail, String cellulare) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registrazioneDipendente(TipoAccount tipoAcc, String pw, String specializzazione, String cf,
			String nome, String cognome, String sesso, String dataNascita, String luogoNascita, String provinciaNascita,
			String regioneRes, String provinciaRes, String cittaRes, String indirizzo, String cap, String eMail,
			String cellulare) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean login(int idAcc, String pw) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int generaIdAcc() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
}