package it.unipv.sfw.model.strutturasanitaria;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList; 
import java.util.HashMap;
import java.util.Iterator;

import it.unipv.sfw.jdbc.FacadeSingletonDB;
import it.unipv.sfw.model.calendario.SlotCalendarioSingoli;
import it.unipv.sfw.model.cartellaclinica.CartellaClinica;
import it.unipv.sfw.model.cartellaclinica.GruppiSanguigni;
import it.unipv.sfw.model.persona.*;
import it.unipv.sfw.model.prenotazione.Prenotazione;
import it.unipv.sfw.model.prenotazione.PrestazioneSanitaria;
import it.unipv.sfw.model.prenotazione.TipoPrestazione;


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
	
	private ArrayList<SlotCalendarioSingoli> slotLiberi;
	private int indiceArraySlotLiberi;
	
	HashMap<String,Account> cfPersone;
	HashMap<TipoPrestazione,PrestazioneSanitaria> tipoPrestazioni;
	HashMap<Integer, Prenotazione> idPrenotazioni;
	HashMap<TipoPrestazione, Account> personaleSanitario;
	
	private Account utenteCorrente = null;
	
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
		
		this.indiceArraySlotLiberi = 0;

		

	}
	
	@Override
	public boolean registrazioneAccount(String cf, String pw, TipoAccount tipo, String nome, String cognome,
			Sesso sesso, String dataNascita, String luogoNascita, String provinciaNascita, String regioneRes,
			String provinciaRes, String cittaRes, String indirizzo, String cap, String eMail, String cellulare, 
			TipoPrestazione specializzazione, double altezza, double peso, GruppiSanguigni gruppoSanguigno) {
		boolean check = false;
		try {
			switch(tipo) {
			case PA:
				CartellaClinica c = new CartellaClinica(altezza, peso, gruppoSanguigno);
				Paziente p = new Paziente(cf, pw, tipo, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita,
						regioneRes, provinciaRes, cittaRes, indirizzo, cap, eMail, cellulare, c);
				
				FacadeSingletonDB.getIstanzaFacade().inserisciPaziente(p, c);
				pazienti.add(p);
				this.getCfPersone().put(p.getCf(), p);
				
				check = true;			
				break;
				
			case ME:
				Medico m = new Medico(cf, pw, tipo, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita,
						regioneRes, provinciaRes, cittaRes, indirizzo, cap, eMail, cellulare, specializzazione);
				
				FacadeSingletonDB.getIstanzaFacade().inserisciPersonaleSanitario(m);
				medici.add(m);
				this.getCfPersone().put(m.getCf(), m);
							
				check = true;
				break;
				
			case OS:
				OperatoreSanitario os = new OperatoreSanitario(cf, pw, tipo, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita,
						regioneRes, provinciaRes, cittaRes, indirizzo, cap, eMail, cellulare, specializzazione);
				
				FacadeSingletonDB.getIstanzaFacade().inserisciPersonaleSanitario(os);
				operatoriSanitari.add(os);
				this.getCfPersone().put(os.getCf(), os);
							
				check = true;
				break;
				
			case OU:
				OperatoreUfficio ou = new OperatoreUfficio(cf, pw, tipo, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita,
						regioneRes, provinciaRes, cittaRes, indirizzo, cap, eMail, cellulare);
				
				FacadeSingletonDB.getIstanzaFacade().inserisciOperatoreUfficio(ou);
				operatoriUfficio.add(ou);
				this.getCfPersone().put(ou.getCf(), ou);
							
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
			this.idPrenotazioni.put(idPren, p);
			
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
			
			Iterator<Prenotazione> iterator1 = p.getPaziente().getPrenotazioni().iterator();

	        while (iterator1.hasNext()) {
	        	if(iterator1.next().equals(p)) {
	        		iterator1.remove();
	        	}	            
			
//			for(Prenotazione i : p.getPaziente().getPrenotazioni()) {
//				if(p.getIdPren() == i.getIdPren()) {
//					p.getPaziente().getPrenotazioni().remove(i);
//				}
			}
			
			if(p.getPersonaleSanitario().getTipoAcc() == TipoAccount.ME) {
				Medico m = (Medico)p.getPersonaleSanitario();
				
				Iterator<Prenotazione> iterator2 = m.getCalendario().iterator();

		        while (iterator2.hasNext()) {
		        	if(iterator2.next().equals(p)) {
		        		iterator2.remove();
		        	}	            
				
//				for(Prenotazione i : m.getCalendario()) {
//					if(p.getIdPren() == i.getIdPren()) {
//						m.getCalendario().remove(i);
//					}
				}
			}else {
				OperatoreSanitario op = (OperatoreSanitario)p.getPersonaleSanitario();
				
				Iterator<Prenotazione> iterator3 = op.getCalendario().iterator();

		        while (iterator3.hasNext()) {
		        	if(iterator3.next().equals(p)) {
		        		iterator3.remove();
		        	}
				
//				for(Prenotazione i : op.getCalendario()) {
//					if(p.getIdPren() == i.getIdPren()) {
//						op.getCalendario().remove(i);
//					}
				}
				
			this.idPrenotazioni.remove(p.getIdPren());
	
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
	
	public boolean aggiornaPrenotazioni() {
		boolean check = false;
		try {
			for(Paziente p : this.pazienti) {
				p.spostaPrenotazioniErogate();
			}
			for(Medico m : this.medici) {
				m.eliminaPrenotazioniErogate();
				}
			for(OperatoreSanitario op : this.operatoriSanitari) {
				op.eliminaPrenotazioniErogate();
				}
			check = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public void incIndexArraySlotLiberi() {
		indiceArraySlotLiberi++;
	}
	
	public void decIndexArraySlotLiberi() {
		indiceArraySlotLiberi--;
	}
	
	public void impostaSlotLiberiPerPrestazione(TipoPrestazione tipoPrest){
		this.indiceArraySlotLiberi = 0;
		this.slotLiberi.clear();
		FacadeSingletonDB.getIstanzaFacade().visualizzaSlotLiberi(tipoPrest); 
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
	
	
	public int getIndexArraySlotLiberi() {
		return indiceArraySlotLiberi;
	}
	
	public ArrayList<SlotCalendarioSingoli> getArraySlotLiberi() {
		return slotLiberi;
	}
	
}
	
