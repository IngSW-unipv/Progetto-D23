package it.unipv.sfw.model.persona;

import it.unipv.sfw.model.TipoAccount;
import it.unipv.sfw.model.exception.LoginException;

public abstract class Account {
	private int idAcc;
	private String pw;
	private TipoAccount tipoAcc;
	
	private String cf;
	private String nome;
	private String cognome;
	private String sesso;
	private String dataNascita;
	private String luogoNascita;
	private String provinciaNascita;
	private String regioneRes;
	private String provinciaRes;
	private String cittaRes;
	private String indirizzo;
	private String cap;
	private String eMail;
	private String cellulare;
	
	
	public Account(int idAcc, String pw, TipoAccount tipoAcc, String cf, String nome,
			String cognome, String sesso, String dataNascita, String luogoNascita, String provinciaNascita,
			String regioneRes, String provinciaRes, String cittaRes, String indirizzo, String cap, String eMail,
			String cellulare) {
		super();
		this.idAcc = idAcc;
		this.pw = pw;
		this.tipoAcc = tipoAcc;
		this.cf = cf;
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.dataNascita = dataNascita;
		this.luogoNascita = luogoNascita;
		this.provinciaNascita = provinciaNascita;
		this.regioneRes = regioneRes;
		this.provinciaRes = provinciaRes;
		this.cittaRes = cittaRes;
		this.indirizzo = indirizzo;
		this.cap = cap;
		this.eMail = eMail;
		this.cellulare = cellulare;
	}

	public boolean setPw(String vecchiaPw, String nuovaPw) throws LoginException {
		boolean check = false;
		if(controllaPw(vecchiaPw)) {
			if(vecchiaPw == nuovaPw) {
				throw new LoginException("La nuova password non può essere uguale a quella corrente");
			}
			else {
				this.pw = nuovaPw;
				check = true;
			}
		}
		
		return check;
	}
	
	public boolean controllaPw(String pw) throws LoginException{
		boolean check = false;
		if(this.pw != pw) {
			throw new LoginException("La password inserita non è corretta");
		}
		else {
			check = true;
		}
		return check;
		
	}
	
		
}