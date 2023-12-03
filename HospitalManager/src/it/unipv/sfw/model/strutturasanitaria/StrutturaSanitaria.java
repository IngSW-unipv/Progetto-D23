package it.unipv.sfw.model.strutturasanitaria;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList; 
import java.util.HashMap;
import java.util.Iterator;

import it.unipv.sfw.controller.facadecontroller.FacadeController;
import it.unipv.sfw.jdbc.FacadeSingletonDB;
import it.unipv.sfw.model.calendario.SlotCalendarioSingoli;
import it.unipv.sfw.model.cartellaclinica.CartellaClinica;
import it.unipv.sfw.model.cartellaclinica.GruppiSanguigni;
import it.unipv.sfw.model.persona.*;
import it.unipv.sfw.model.prenotazione.IPrenotazione;
import it.unipv.sfw.model.prenotazione.Prenotazione;
import it.unipv.sfw.model.prenotazione.PrestazioneSanitaria;
import it.unipv.sfw.model.prenotazione.TipoPrestazione;
import it.unipv.sfw.view.ViewController;


public class StrutturaSanitaria implements IStrutturaSanitaria {
	private String nome;
	private String indirizzo;
	private String telefono;
	private String email;
	
	private ArrayList<IPaziente> pazienti;
	private ArrayList<IPersonaleSanitario> medici;
	private ArrayList<IPersonaleSanitario> operatoriSanitari;
	private ArrayList<OperatoreUfficio> operatoriUfficio;
	private ArrayList<PrestazioneSanitaria> prestazioni;
	
	private ArrayList<SlotCalendarioSingoli> slotLiberi;
	private int indiceArraySlotLiberi;
	
	HashMap<String,IAccount> cfPersone;
	HashMap<TipoPrestazione,PrestazioneSanitaria> tipoPrestazioni;
	HashMap<Integer, IPrenotazione> idPrenotazioni;
	HashMap<TipoPrestazione, IAccount> personaleSanitario;
	
	private IAccount utenteCorrente = null;
	
	private int ultimaPrenotazione;
	
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
	
	public static void main(String[] args) {
		FacadeSingletonDB db = FacadeSingletonDB.getIstanzaFacade();
		IStrutturaSanitaria model = db.getStruttura();
		ViewController view = new ViewController();
		new FacadeController(model, view);		
	}
	
	@Override
	public boolean registrazioneAccount(String cf, String pw, TipoAccount tipo, String nome, String cognome,
			Sesso sesso, String dataNascita, String luogoNascita, String provinciaNascita, String regioneRes,
			String provinciaRes, String cittaRes, String indirizzo, String cap, String eMail, String cellulare, 
			double altezza, double peso, GruppiSanguigni gruppoSanguigno) {
		boolean check = false;
		try {
				CartellaClinica c = new CartellaClinica(altezza, peso, gruppoSanguigno);
				Paziente p = new Paziente(cf, pw, tipo, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita,
						regioneRes, provinciaRes, cittaRes, indirizzo, cap, eMail, cellulare, c);
				
				FacadeSingletonDB.getIstanzaFacade().inserisciPaziente(p, c);
				pazienti.add(p);
				this.getCfPersone().put(p.getCf(), p);
				
				check = true;			
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
			IAccount a = this.getCfPersone().get(cf);
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
			IAccount a = this.getCfPersone().get(cf);
			if(a.controllaPw(vecchiaPw) == true) {
				a.setPw(vecchiaPw, nuovaPw);
				FacadeSingletonDB.getIstanzaFacade().aggiornaPw(a);
			}
			check = true;
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
			IAccount personale = this.getPersonaleSanitario().get(prest);
			PrestazioneSanitaria prestazione = this.getTipoPrestazioni().get(prest);
			IPrenotazione p = new Prenotazione(idPren, paziente, personale, prestazione, data, orario);
			
			FacadeSingletonDB.getIstanzaFacade().inserisciPrenotazione(p);
			paziente.getPrenotazioni().add(p);
			this.idPrenotazioni.put(idPren, p);
			
			if(personale.getTipoAcc() == TipoAccount.ME) {
				IPersonaleSanitario m = (Medico)personale;
				m.getCalendario().add(p);
			}else {
				IPersonaleSanitario op = (OperatoreSanitario)personale;
				op.getCalendario().add(p);
			}
			
			check = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return check;
	}

	@Override
	public boolean cancellaPrenotazione(IPrenotazione p) {
		boolean check = false;
		try {
			FacadeSingletonDB.getIstanzaFacade().cancellaPrenotazione(p);
			
			Iterator<IPrenotazione> iterator1 = p.getPaziente().getPrenotazioni().iterator();

	        while (iterator1.hasNext()) {
	        	if(iterator1.next().equals(p)) {
	        		iterator1.remove();
	        	}	            
			
			}
			
			if(p.getPersonaleSanitario().getTipoAcc() == TipoAccount.ME) {
				Medico m = (Medico)p.getPersonaleSanitario();
				
				Iterator<IPrenotazione> iterator2 = m.getCalendario().iterator();

		        while (iterator2.hasNext()) {
		        	if(iterator2.next().equals(p)) {
		        		iterator2.remove();
		        	}	            
				}
			}else {
				OperatoreSanitario op = (OperatoreSanitario)p.getPersonaleSanitario();
				
				Iterator<IPrenotazione> iterator3 = op.getCalendario().iterator();

		        while (iterator3.hasNext()) {
		        	if(iterator3.next().equals(p)) {
		        		iterator3.remove();
		        	}
				}
				
			this.idPrenotazioni.remove(p.getIdPren());
	
			}
			
			check = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return check;
	}
	
	public boolean aggiornaPrenotazioni() {
		boolean check = false;
		try {
			for(IPaziente p : this.pazienti) {
				p.spostaPrenotazioniErogate();
			}
			for(IPersonaleSanitario m : this.medici) {
				m.eliminaPrenotazioniErogate();
				}
			for(IPersonaleSanitario op : this.operatoriSanitari) {
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

	public ArrayList<IPaziente> getPazienti() {
		return pazienti;
	}

	public void setPazienti(ArrayList<IPaziente> pazienti) {
		this.pazienti = pazienti;
	}

	public ArrayList<IPersonaleSanitario> getMedici() {
		return medici;
	}

	public void setMedici(ArrayList<IPersonaleSanitario> medici) {
		this.medici = medici;
	}

	public ArrayList<IPersonaleSanitario> getOperatoriSanitari() {
		return operatoriSanitari;
	}

	public void setOperatoriSanitari(ArrayList<IPersonaleSanitario> operatoriSanitari) {
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

	public HashMap<String, IAccount> getCfPersone() {
		return cfPersone;
	}

	public void setCfPersone(HashMap<String, IAccount> cfPersone) {
		this.cfPersone = cfPersone;
	}

	public HashMap<TipoPrestazione, PrestazioneSanitaria> getTipoPrestazioni() {
		return tipoPrestazioni;
	}

	public void setIdPrestazioni(HashMap<TipoPrestazione, PrestazioneSanitaria> tipoPrestazioni) {
		this.tipoPrestazioni = tipoPrestazioni;
	}

	public HashMap<Integer, IPrenotazione> getIdPrenotazioni() {
		return idPrenotazioni;
	}

	public void setIdPrenotazioni(HashMap<Integer, IPrenotazione> idPrenotazioni) {
		this.idPrenotazioni = idPrenotazioni;
	}
	
	public void setUtenteCorrente(String cf) {
		this.utenteCorrente = this.cfPersone.get(cf);
	}
	
	public IAccount getUtenteCorrente() {
		return utenteCorrente;
	}
	
	public HashMap<TipoPrestazione, IAccount> getPersonaleSanitario() {
		return personaleSanitario;
	}

	public void setPersonaleSanitario(HashMap<TipoPrestazione, IAccount> personaleSanitario) {
		this.personaleSanitario = personaleSanitario;
	}
	
	
	public int getIndexArraySlotLiberi() {
		return indiceArraySlotLiberi;
	}
	
	public ArrayList<SlotCalendarioSingoli> getArraySlotLiberi() {
		return slotLiberi;
	}
	
}
	
