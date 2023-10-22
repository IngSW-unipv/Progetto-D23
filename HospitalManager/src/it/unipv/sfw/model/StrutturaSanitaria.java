package it.unipv.sfw.model;
import java.util.ArrayList;

import it.unipv.sfw.jdbc.bean.account.AccountDAO;
import it.unipv.sfw.jdbc.bean.anagrafica.AnagraficaDAO;
import it.unipv.sfw.model.exception.LoginException;
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
	//private ArrayList<Erogazione> erogazioni;
	
	private int accountAttivi;
	private int numeroPrenotazioni;
	
	private AnagraficaDAO anagraficaDAO;
	private AccountDAO accountDAO;

	
	//costruttore 1
	public StrutturaSanitaria() {
		super();
		
		this.anagraficaDAO = new AnagraficaDAO();
		this.accountDAO = new AccountDAO();
	}

	@Override
	public boolean registrazionePaziente(String specializzazione, String cf, String nome, String cognome,
			String sesso, String dataNascita, String luogoNascita, String provinciaNascita, String regioneRes,
			String provinciaRes, String cittaRes, String indirizzo, String cap, String eMail, String cellulare) {
		boolean check = false;
		try {
			Paziente p = new Paziente(cf, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita, regioneRes,
					provinciaRes, cittaRes, indirizzo, cap, eMail, cellulare);
			Account a = new Account(p, this.generaIdAcc(), this.generaPwTemp(), null, TipoAccount.PA);
			//CartellaClinica cc = new CartellaClinica();
			
			anagraficaDAO.insertAnagrafica(p);
			accountDAO.insertAccount(a);
			
			pazienti.add(p);
			accounts.add(a);
			
			check = true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean registrazioneDipendente(TipoAccount tipoAcc, String pw, String specializzazione, String cf,
			String nome, String cognome, String sesso, String dataNascita, String luogoNascita, String provinciaNascita,
			String regioneRes, String provinciaRes, String cittaRes, String indirizzo, String cap, String eMail,
			String cellulare) {
		boolean check = false;
		try {
			switch(tipoAcc) {
			case ME:
				Medico m = new Medico(cf, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita, regioneRes,
						provinciaRes, cittaRes, indirizzo, cap, eMail, cellulare);
				Account a1 = new Account(m, this.generaIdAcc(), this.generaPwTemp(), specializzazione, TipoAccount.ME);
				
				anagraficaDAO.insertAnagrafica(m);
				accountDAO.insertAccount(a1);
				
				medici.add(m);
				accounts.add(a1);
				
				check = true;
				break;
				
			case OS:
				OperatoreSanitario os = new OperatoreSanitario(cf, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita, regioneRes,
						provinciaRes, cittaRes, indirizzo, cap, eMail, cellulare);
				Account a2 = new Account(os, this.generaIdAcc(), this.generaPwTemp(), specializzazione, TipoAccount.OS);
				
				anagraficaDAO.insertAnagrafica(os);
				accountDAO.insertAccount(a2);
				
				operatoriSanitari.add(os);
				accounts.add(a2);
				
				check = true;
				break;
				
			case OU:
				OperatoreUfficio ou = new OperatoreUfficio(cf, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita, regioneRes,
						provinciaRes, cittaRes, indirizzo, cap, eMail, cellulare);
				Account a3 = new Account(ou, this.generaIdAcc(), this.generaPwTemp(), specializzazione, TipoAccount.OU);
				
				anagraficaDAO.insertAnagrafica(ou);
				accountDAO.insertAccount(a3);
				
				operatoriUfficio.add(ou);
				accounts.add(a3);
				
				check = true;
				break;
				
			default:
				check = false;
				break;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int generaIdAcc() {
		accountAttivi++;
		return accountAttivi;
	}

	@Override
	public int generaIdPren() {
		numeroPrenotazioni++;
		return numeroPrenotazioni;
	}
	
	@Override
	public String generaPwTemp() {
		int lunghezzaPw = 10;
		String alfabeto = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz?!<>-*[]{}/";
		int lungAlfabeto = alfabeto.length();
		String password = "";
		for (int i = 0; i < lunghezzaPw; i++) {
		    // Scelgo una delle lettere dell'alfabeto.
		    int indiceRandom = (int)(Math.random()*lungAlfabeto);
		    password += alfabeto.charAt(indiceRandom);
		}
		return password;
	}

	@Override
	public boolean cambioPw(int idAcc, String vecchiaPw, String nuovaPw) {
		Account a = accounts.get(idAcc);
		boolean check1 = false;
		boolean check2 = false;
		try {
			check1 = accountDAO.updatePw(idAcc, nuovaPw);
			check2 = a.setPw(vecchiaPw, nuovaPw);
		}
		catch(LoginException e) {
			check2 = false;
		}
		catch(Exception e) {
			e.printStackTrace();
			check1 = false;
		}
		return check1 && check2;
	}
	
	@Override
	public boolean login(int idAcc, String pw) {
		Account a = accounts.get(idAcc);
		boolean check = false;
		try {
			check = a.controllaPw(pw);
		}
		catch(LoginException e) {
			check = false;
		}
		return check;
	}

	
	
	
	
	
	
}