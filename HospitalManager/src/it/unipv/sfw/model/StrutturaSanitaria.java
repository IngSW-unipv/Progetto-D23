package it.unipv.sfw.model;
import java.util.ArrayList; 
import java.util.HashMap;

import it.unipv.sfw.jdbc.FacadeSingletonDB;
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
	private ArrayList<PrestazioneSanitaria> prestazioni;
	private ArrayList<Prenotazione> prenotazioni;
	private ArrayList<SlotCalendario> calendario;
	
	HashMap<String,Account> cfPersone;
	HashMap<String,PrestazioneSanitaria> idPrestazioni;
	HashMap<Integer, Prenotazione> idPrenotazioni;
	
	// aggiunta di Aldin
	private Account utenteCorrente;
	//////////
	
	private int ultimaPrenotazione;
	
	private static FacadeSingletonDB controllerDB;
	
	//costruttore 1
	public StrutturaSanitaria() {
		super();
		this.cfPersone = new HashMap<>();
		this.idPrestazioni = new HashMap<>();
		this.idPrenotazioni = new HashMap<>();
	}

	@Override
	public boolean registrazioneAccount(String cf, String pw, TipoAccount tipo, String nome, String cognome,
			String sesso, String dataNascita, String luogoNascita, String provinciaNascita, String regioneRes,
			String provinciaRes, String cittaRes, String indirizzo, String cap, String eMail, String cellulare, 
			TipoPrestazione specializzazione) {
		boolean check = false;
		try {
			switch(tipo) {
			case PA:
				Paziente p = new Paziente(cf, pw, tipo, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita,
						regioneRes, provinciaRes, cittaRes, indirizzo, cap, eMail, cellulare);
				
				controllerDB.inserisciProfilo(p);
				pazienti.add(p);
				
				check = true;			
				break;
				
			case ME:
				Medico m = new Medico(cf, pw, tipo, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita,
						regioneRes, provinciaRes, cittaRes, indirizzo, cap, eMail, cellulare, specializzazione);
				
				controllerDB.inserisciProfilo(m);
				medici.add(m);
							
				check = true;
				break;
				
			case OS:
				OperatoreSanitario os = new OperatoreSanitario(cf, pw, tipo, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita,
						regioneRes, provinciaRes, cittaRes, indirizzo, cap, eMail, cellulare, specializzazione);
				
				controllerDB.inserisciProfilo(os);
				operatoriSanitari.add(os);
							
				check = true;
				break;
				
			case OU:
				OperatoreUfficio ou = new OperatoreUfficio(cf, pw, tipo, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita,
						regioneRes, provinciaRes, cittaRes, indirizzo, cap, eMail, cellulare);
				
				controllerDB.inserisciProfilo(ou);
				operatoriUfficio.add(ou);
							
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
	public int generaIdPren() {
		ultimaPrenotazione++;
		return ultimaPrenotazione;
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
	public boolean login(String cf, String pw) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cambioPw(int idAcc, String vecchiaPw, String nuovaPw) {
		// TODO Auto-generated method stub
		return false;
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

	public int getUltimaPrenotazione() {
		return ultimaPrenotazione;
	}
	
	public void setUltimaPrenotazione() {
		this.ultimaPrenotazione = controllerDB.idUltimaPrenotazione();
	}

	public HashMap<String, Account> getCfPersone() {
		return cfPersone;
	}

	public void setCfPersone(HashMap<String, Account> cfPersone) {
		this.cfPersone = cfPersone;
	}

	public HashMap<String, PrestazioneSanitaria> getIdPrestazioni() {
		return idPrestazioni;
	}

	public void setIdPrestazioni(HashMap<String, PrestazioneSanitaria> idPrestazioni) {
		this.idPrestazioni = idPrestazioni;
	}

	public HashMap<Integer, Prenotazione> getIdPrenotazioni() {
		return idPrenotazioni;
	}

	public void setIdPrenotazioni(HashMap<Integer, Prenotazione> idPrenotazioni) {
		this.idPrenotazioni = idPrenotazioni;
	}

	public ArrayList<SlotCalendario> getCalendario() {
		return calendario;
	}

	public void setCalendario(ArrayList<SlotCalendario> calendario) {
		this.calendario = calendario;
	}
	
	public void setUtenteCorrente(String cf) {
		this.utenteCorrente = this.cfPersone.get(cf);
	}
	
	public Account getUtenteCorrente() {
		return utenteCorrente;
	}
}
	
