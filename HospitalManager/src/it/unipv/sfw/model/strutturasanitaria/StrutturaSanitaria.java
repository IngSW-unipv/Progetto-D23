package it.unipv.sfw.model.strutturasanitaria;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList; 
import java.util.HashMap;

import it.unipv.sfw.jdbc.FacadeSingletonDB;
import it.unipv.sfw.model.calendario.SlotCalendario;
import it.unipv.sfw.model.calendario.SlotCalendarioSingoli;
import it.unipv.sfw.model.cartellaclinica.CartellaClinica;
import it.unipv.sfw.model.cartellaclinica.GruppiSanguigni;
import it.unipv.sfw.model.persona.*;
import it.unipv.sfw.model.prenotazione.Prenotazione;
import it.unipv.sfw.model.prenotazione.PrestazioneSanitaria;
import it.unipv.sfw.model.prenotazione.TipoPrestazione;


public class StrutturaSanitaria implements IStrutturaSanitaria {
	
	//private static StrutturaSanitaria struttura1 = null;
	//private static FacadeSingletonDB istanzaDB = null;
	//private static FacadeSingletonDB istanzaDB = FacadeSingletonDB.getIstanzaFacade();

	private String nome;
	private String indirizzo;
	private String telefono;
	private String email;
	
	private ArrayList<Paziente> pazienti;
	private ArrayList<Medico> medici;
	private ArrayList<OperatoreSanitario> operatoriSanitari;
	private ArrayList<OperatoreUfficio> operatoriUfficio;
	private ArrayList<PrestazioneSanitaria> prestazioni;
	//private ArrayList<SlotCalendario> calendario;	//DA ELIMINARE??? INFORMAZIONI RIDONDANTI
	
	private ArrayList<SlotCalendarioSingoli> slotLiberi;
	private int indiceArraySlotLiberi;
	
	HashMap<String,Account> cfPersone;
	HashMap<TipoPrestazione,PrestazioneSanitaria> tipoPrestazioni;
	HashMap<Integer, Prenotazione> idPrenotazioni;
	HashMap<TipoPrestazione, Account> personaleSanitario;
	
	private Account utenteCorrente;
	
	private int ultimaPrenotazione;
	
	
	//costruttore 1
	public StrutturaSanitaria() {
		super();
		
		this.nome = "Clinica Oncologica Pavia";
		this.indirizzo = "Via Minerva 1, Pavia(PV), Lombaridia, Italia";
		this.telefono = "0382 00000";
		this.email = "clinicaoncologicapavia@hm.it";
		
		this.pazienti = new ArrayList<>();
		this.medici = new ArrayList<>();
		this.operatoriSanitari = new ArrayList<>();
		this.operatoriUfficio = new ArrayList<>();
		this.prestazioni = new ArrayList<>();
		this.slotLiberi = new ArrayList<>();
		
		this.cfPersone = new HashMap<>();
		this.tipoPrestazioni = new HashMap<>();
		this.idPrenotazioni = new HashMap<>();
		this.personaleSanitario = new HashMap<>();
		
		//this.istanzaDB = FacadeSingletonDB.getIstanzaFacade();
		
		
//		FacadeSingletonDB.getIstanzaFacade().popolaPazienti();
//		FacadeSingletonDB.getIstanzaFacade().popolaMedici();
//		FacadeSingletonDB.getIstanzaFacade().popolaOperatoriSanitari();
//		FacadeSingletonDB.getIstanzaFacade().popolaOperatoriUfficio();
//		FacadeSingletonDB.getIstanzaFacade().popolaPrestazione();
	}

//	public static StrutturaSanitaria getIstanzaStruttura() {
//		if(struttura1 == null) {
//			struttura1 = new StrutturaSanitaria();
//		}
//		return struttura1;
//	}
	
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
				
				FacadeSingletonDB.getIstanzaFacade().inserisciProfilo(p);
				pazienti.add(p);
				
				check = true;			
				break;
				
			case ME:
				Medico m = new Medico(cf, pw, tipo, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita,
						regioneRes, provinciaRes, cittaRes, indirizzo, cap, eMail, cellulare, specializzazione);
				
				FacadeSingletonDB.getIstanzaFacade().inserisciProfilo(m);
				medici.add(m);
							
				check = true;
				break;
				
			case OS:
				OperatoreSanitario os = new OperatoreSanitario(cf, pw, tipo, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita,
						regioneRes, provinciaRes, cittaRes, indirizzo, cap, eMail, cellulare, specializzazione);
				
				FacadeSingletonDB.getIstanzaFacade().inserisciProfilo(os);
				operatoriSanitari.add(os);
							
				check = true;
				break;
				
			case OU:
				OperatoreUfficio ou = new OperatoreUfficio(cf, pw, tipo, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita,
						regioneRes, provinciaRes, cittaRes, indirizzo, cap, eMail, cellulare);
				
				FacadeSingletonDB.getIstanzaFacade().inserisciProfilo(ou);
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
		boolean check = false;
		try {
			Account a = this.getCfPersone().get(cf);
			check = a.controllaPw(pw);
			if(check) {
				setUtenteCorrente(cf);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return check;
	}

	@Override
	public boolean cambioPw(String cf, String vecchiaPw, String nuovaPw) {
		boolean check = false;
		try {
			Account a = this.getCfPersone().get(cf);
			if(a.controllaPw(vecchiaPw) == true) {
				a.setPw(vecchiaPw, nuovaPw);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return check;
	}
	
	@Override
	public boolean inserisciPrenotazione(TipoPrestazione prest, Paziente paziente, LocalDate data, LocalTime orario) {
		boolean check = false;
		try {
			int idPren = this.generaIdPren();
			Account personale = this.getPersonaleSanitario().get(prest);
			PrestazioneSanitaria prestazione = this.getTipoPrestazioni().get(prest);
			Prenotazione p = new Prenotazione(idPren, paziente, personale, prestazione, data, orario);
			
			FacadeSingletonDB.getIstanzaFacade().inserisciPrenotazione(p);
			paziente.getPrenotazioni().add(p);
			
			if(personale.getTipoAcc() == TipoAccount.ME) {
				Medico m = (Medico)personale;
				m.getCalendario().add(p);
			}else {
				OperatoreSanitario op = (OperatoreSanitario)personale;
				op.getCalendario().add(p);
			}
			
			check = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return check;
	}

	@Override
	public boolean cancellaPrenotazione(Prenotazione p) {
		boolean check = false;
		try {
			FacadeSingletonDB.getIstanzaFacade().cancellaPrenotazione(p);
			
			for(Prenotazione i : p.getPaziente().getPrenotazioni()) {
				if(p.getIdPren() == i.getIdPren()) {
					p.getPaziente().getPrenotazioni().remove(i);
				}
			}
			
			if(p.getPersonaleSanitario().getTipoAcc() == TipoAccount.ME) {
				Medico m = (Medico)p.getPersonaleSanitario();
				
				for(Prenotazione i : m.getCalendario()) {
					if(p.getIdPren() == i.getIdPren()) {
						m.getCalendario().remove(i);
					}
				}
			}else {
				OperatoreSanitario op = (OperatoreSanitario)p.getPersonaleSanitario();
				
				for(Prenotazione i : op.getCalendario()) {
					if(p.getIdPren() == i.getIdPren()) {
						op.getCalendario().remove(i);
					}
				}
	
			check = true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return check;
	}

	@Override
	public boolean aggiornaDatiSanitariPaziente(Paziente p, double altezza, double peso, GruppiSanguigni gruppoSanguigno) {
		boolean check = false;
		try {
			CartellaClinica cc = new CartellaClinica(altezza, peso, gruppoSanguigno);
			p.setCartellaPersonale(cc);
			FacadeSingletonDB.getIstanzaFacade().inserisciCartellaClinica(p);
			check = true;
			
		}catch(Exception e) {
			e.printStackTrace();
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

	public ArrayList<PrestazioneSanitaria> getPrestazioni() {
		return prestazioni;
	}

	public void setPrestazioni(ArrayList<PrestazioneSanitaria> prestazioni) {
		this.prestazioni = prestazioni;
	}

	public int getUltimaPrenotazione() {
		return ultimaPrenotazione;
	}
	
	public void setUltimaPrenotazione(int ultimaPrenotazione) {
		this.ultimaPrenotazione = ultimaPrenotazione;
	}

	public HashMap<String, Account> getCfPersone() {
		return cfPersone;
	}

	public void setCfPersone(HashMap<String, Account> cfPersone) {
		this.cfPersone = cfPersone;
	}

	public HashMap<TipoPrestazione, PrestazioneSanitaria> getTipoPrestazioni() {
		return tipoPrestazioni;
	}

	public void setIdPrestazioni(HashMap<TipoPrestazione, PrestazioneSanitaria> tipoPrestazioni) {
		this.tipoPrestazioni = tipoPrestazioni;
	}

	public HashMap<Integer, Prenotazione> getIdPrenotazioni() {
		return idPrenotazioni;
	}

	public void setIdPrenotazioni(HashMap<Integer, Prenotazione> idPrenotazioni) {
		this.idPrenotazioni = idPrenotazioni;
	}

//	public ArrayList<SlotCalendario> getCalendario() {
//		return calendario;
//	}
//
//	public void setCalendario(ArrayList<SlotCalendario> calendario) {
//		this.calendario = calendario;
//	}
	
	public void setUtenteCorrente(String cf) {
		this.utenteCorrente = this.cfPersone.get(cf);
	}
	
	public Account getUtenteCorrente() {
		return utenteCorrente;
	}
	
	public HashMap<TipoPrestazione, Account> getPersonaleSanitario() {
		return personaleSanitario;
	}

	public void setPersonaleSanitario(HashMap<TipoPrestazione, Account> personaleSanitario) {
		this.personaleSanitario = personaleSanitario;
	}
	
	
	
	
	
	
	//////////////////////////////	

	public void setArraySlotLiberi(ArrayList<SlotCalendarioSingoli> slotLiberi) {
		this.slotLiberi = slotLiberi;
		indiceArraySlotLiberi = 0;
	}
	
	public void incIndexArraySlotLiberi() {
		indiceArraySlotLiberi++;
	}
	
	public void decIndexArraySlotLiberi() {
		indiceArraySlotLiberi--;
	}
	
	public int getIndexArraySlotLiberi() {
		return indiceArraySlotLiberi;
	}
	
	public ArrayList<SlotCalendarioSingoli> getArraySlotLiberi() {
		return slotLiberi;
	}
	
	public ArrayList<SlotCalendarioSingoli> getArraySlotLiberiOriginale(TipoPrestazione tipoPrest){
		return FacadeSingletonDB.getIstanzaFacade().visualizzaSlotLiberi(tipoPrest);
	}	
	
}
	
