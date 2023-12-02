package it.unipv.sfw.model.strutturasanitaria;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import it.unipv.sfw.model.calendario.SlotCalendarioSingoli;
import it.unipv.sfw.model.cartellaclinica.GruppiSanguigni;
import it.unipv.sfw.model.persona.Account;
import it.unipv.sfw.model.persona.Medico;
import it.unipv.sfw.model.persona.OperatoreSanitario;
import it.unipv.sfw.model.persona.OperatoreUfficio;
import it.unipv.sfw.model.persona.Paziente;
import it.unipv.sfw.model.persona.Sesso;
import it.unipv.sfw.model.persona.TipoAccount;
import it.unipv.sfw.model.prenotazione.Prenotazione;
import it.unipv.sfw.model.prenotazione.PrestazioneSanitaria;
import it.unipv.sfw.model.prenotazione.TipoPrestazione;

public interface IStrutturaSanitaria {
	boolean registrazioneAccount(String cf, String pw, TipoAccount tipo, String nome, String cognome,
			Sesso sesso, String dataNascita, String luogoNascita, String provinciaNascita, String regioneRes,
			String provinciaRes, String cittaRes, String indirizzo, String cap, String eMail, String cellulare, 
			TipoPrestazione specializzazione, double altezza, double peso, GruppiSanguigni gruppoSanguigno);	
	int generaIdPren();
	String generaPwTemp();
	boolean login(String cf, String pw);
	boolean cambioPw(String cf, String vecchiaPw, String nuovaPw);
	boolean inserisciPrenotazione(TipoPrestazione prest, Paziente paziente, LocalDate data, LocalTime orario);
	boolean cancellaPrenotazione(Prenotazione p);
	boolean aggiornaDatiSanitariPaziente(Paziente p, double altezza, double peso, GruppiSanguigni gruppoSanguigno);
	boolean aggiornaPrenotazioni();
	void incIndexArraySlotLiberi();
	void decIndexArraySlotLiberi();
	void impostaSlotLiberiPerPrestazione(TipoPrestazione tipoPrest);
	String getNome();
	void setNome(String nome);
	String getIndirizzo();
	void setIndirizzo(String indirizzo);
	String getTelefono();
	void setTelefono(String telefono);
	String getEmail();
	void setEmail(String email);
	ArrayList<Paziente> getPazienti();
	void setPazienti(ArrayList<Paziente> pazienti);
	ArrayList<Medico> getMedici();
	void setMedici(ArrayList<Medico> medici);
	ArrayList<OperatoreSanitario> getOperatoriSanitari();
	void setOperatoriSanitari(ArrayList<OperatoreSanitario> operatoriSanitari);
	ArrayList<OperatoreUfficio> getOperatoriUfficio();
	void setOperatoriUfficio(ArrayList<OperatoreUfficio> operatoriUfficio);
	ArrayList<PrestazioneSanitaria> getPrestazioni();
	void setPrestazioni(ArrayList<PrestazioneSanitaria> prestazioni);
	int getUltimaPrenotazione();
	void setUltimaPrenotazione(int ultimaPrenotazione);
	HashMap<String, Account> getCfPersone();
	void setCfPersone(HashMap<String, Account> cfPersone);
	HashMap<TipoPrestazione, PrestazioneSanitaria> getTipoPrestazioni();
	void setIdPrestazioni(HashMap<TipoPrestazione, PrestazioneSanitaria> tipoPrestazioni);
	HashMap<Integer, Prenotazione> getIdPrenotazioni();
	void setIdPrenotazioni(HashMap<Integer, Prenotazione> idPrenotazioni);
	void setUtenteCorrente(String cf);
	Account getUtenteCorrente();
	HashMap<TipoPrestazione, Account> getPersonaleSanitario();
	void setPersonaleSanitario(HashMap<TipoPrestazione, Account> personaleSanitario);	
	int getIndexArraySlotLiberi();
	ArrayList<SlotCalendarioSingoli> getArraySlotLiberi();

}
