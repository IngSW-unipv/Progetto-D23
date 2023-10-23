package it.unipv.sfw.model;
import java.util.ArrayList;
import java.util.HashMap;

import it.unipv.sfw.jdbc.bean.account.AccountDAO;
import it.unipv.sfw.jdbc.bean.anagrafica.AnagraficaDAO;
import it.unipv.sfw.model.exception.LoginException;
import it.unipv.sfw.model.persona.*;


public class StrutturaSanitaria implements IStrutturaSanitaria {
	private String nome;
	private String indirizzo;
	private String telefono;
	private String email;
	
	private ArrayList<Persona> persone;
	private ArrayList<Paziente> pazienti;
	private ArrayList<Medico> medici;
	private ArrayList<OperatoreSanitario> operatoriSanitari;
	private ArrayList<OperatoreUfficio> operatoriUfficio;
	private ArrayList<Account> accounts;
	private ArrayList<PrestazioneSanitaria> prestazioni;
	private ArrayList<Prenotazione> prenotazioni;
	//private ArrayList<Erogazione> erogazioni;
	
	HashMap<String,Persona> cfPersone;

	
	private int accountAttivi;
	private int numeroPrenotazioni;
	
	private AnagraficaDAO anagraficaDAO;
	private AccountDAO accountDAO;

	
	//costruttore 1
	public StrutturaSanitaria() {
		super();
		
		this.anagraficaDAO = new AnagraficaDAO();
		this.accountDAO = new AccountDAO();
		this.cfPersone = new HashMap<>();
	}

	@Override
	public boolean registrazionePaziente(String specializzazione, String cf, String nome, String cognome,
			String sesso, String dataNascita, String luogoNascita, String provinciaNascita, String regioneRes,
			String provinciaRes, String cittaRes, String indirizzo, String cap, String eMail, String cellulare, String pw) {
		boolean check = false;
		try {
			Paziente p = new Paziente(cf, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita, regioneRes,
					provinciaRes, cittaRes, indirizzo, cap, eMail, cellulare);
			Account a = new Account(p, this.generaIdAcc(), pw, null, TipoAccount.PA);
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Paziente> getPazienti() {
		return pazienti;
	}

	public void setPazienti(ArrayList<Paziente> pazienti) {
		this.pazienti = pazienti;
	}

	public ArrayList<Medico> getMedici() {
		return medici;
	}

	public void setMedici(ArrayList<Medico> medici) {
		this.medici = medici;
	}

	public ArrayList<OperatoreSanitario> getOperatoriSanitari() {
		return operatoriSanitari;
	}

	public void setOperatoriSanitari(ArrayList<OperatoreSanitario> operatoriSanitari) {
		this.operatoriSanitari = operatoriSanitari;
	}

	public ArrayList<OperatoreUfficio> getOperatoriUfficio() {
		return operatoriUfficio;
	}

	public void setOperatoriUfficio(ArrayList<OperatoreUfficio> operatoriUfficio) {
		this.operatoriUfficio = operatoriUfficio;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public ArrayList<PrestazioneSanitaria> getPrestazioni() {
		return prestazioni;
	}

	public void setPrestazioni(ArrayList<PrestazioneSanitaria> prestazioni) {
		this.prestazioni = prestazioni;
	}

	public ArrayList<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(ArrayList<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public int getAccountAttivi() {
		return accountAttivi;
	}

	public void setAccountAttivi(int accountAttivi) {
		this.accountAttivi = accountAttivi;
	}

	public int getNumeroPrenotazioni() {
		return numeroPrenotazioni;
	}

	public void setNumeroPrenotazioni(int numeroPrenotazioni) {
		this.numeroPrenotazioni = numeroPrenotazioni;
	}

	public AnagraficaDAO getAnagraficaDAO() {
		return anagraficaDAO;
	}

	public void setAnagraficaDAO(AnagraficaDAO anagraficaDAO) {
		this.anagraficaDAO = anagraficaDAO;
	}

	public AccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public ArrayList<Persona> getPersone() {
		return persone;
	}

	public void setPersone(ArrayList<Persona> persone) {
		this.persone = persone;
	}

	public HashMap<String, Persona> getCfPersone() {
		return cfPersone;
	}

	public void setCfPersone(HashMap<String, Persona> cfPersone) {
		this.cfPersone = cfPersone;
	}	
	
}