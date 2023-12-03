package it.unipv.sfw.model.strutturasanitaria;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import it.unipv.sfw.model.calendario.SlotCalendarioSingoli;
import it.unipv.sfw.model.cartellaclinica.GruppiSanguigni;
import it.unipv.sfw.model.persona.IAccount;
import it.unipv.sfw.model.persona.IPaziente;
import it.unipv.sfw.model.persona.IPersonaleSanitario;
import it.unipv.sfw.model.persona.OperatoreUfficio;
import it.unipv.sfw.model.persona.Paziente;
import it.unipv.sfw.model.persona.Sesso;
import it.unipv.sfw.model.persona.TipoAccount;
import it.unipv.sfw.model.prenotazione.IPrenotazione;
import it.unipv.sfw.model.prenotazione.PrestazioneSanitaria;
import it.unipv.sfw.model.prenotazione.TipoPrestazione;

public interface IStrutturaSanitaria {
//	boolean registrazioneAccount(String cf, String pw, TipoAccount tipo, String nome, String cognome,
//			Sesso sesso, String dataNascita, String luogoNascita, String provinciaNascita, String regioneRes,
//			String provinciaRes, String cittaRes, String indirizzo, String cap, String eMail, String cellulare, 
//			TipoPrestazione specializzazione, double altezza, double peso, GruppiSanguigni gruppoSanguigno);
	boolean registrazioneAccount(String cf, String pw, TipoAccount tipo, String nome, String cognome,
			Sesso sesso, String dataNascita, String luogoNascita, String provinciaNascita, String regioneRes,
			String provinciaRes, String cittaRes, String indirizzo, String cap, String eMail, String cellulare, 
			double altezza, double peso, GruppiSanguigni gruppoSanguigno);
	int generaIdPren();
	String generaPwTemp();
	boolean login(String cf, String pw);
	boolean cambioPw(String cf, String vecchiaPw, String nuovaPw);
	boolean inserisciPrenotazione(TipoPrestazione prest, Paziente paziente, LocalDate data, LocalTime orario);
//	boolean aggiornaDatiSanitariPaziente(Paziente p, double altezza, double peso, GruppiSanguigni gruppoSanguigno);
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
	ArrayList<IPaziente> getPazienti();
	void setPazienti(ArrayList<IPaziente> pazienti);
	ArrayList<IPersonaleSanitario> getMedici();
	void setMedici(ArrayList<IPersonaleSanitario> medici);
	ArrayList<IPersonaleSanitario> getOperatoriSanitari();
	void setOperatoriSanitari(ArrayList<IPersonaleSanitario> operatoriSanitari);
	ArrayList<OperatoreUfficio> getOperatoriUfficio();
	void setOperatoriUfficio(ArrayList<OperatoreUfficio> operatoriUfficio);
	ArrayList<PrestazioneSanitaria> getPrestazioni();
	void setPrestazioni(ArrayList<PrestazioneSanitaria> prestazioni);
	int getUltimaPrenotazione();
	void setUltimaPrenotazione(int ultimaPrenotazione);
	HashMap<String, IAccount> getCfPersone();
	void setCfPersone(HashMap<String, IAccount> cfPersone);
	HashMap<TipoPrestazione, PrestazioneSanitaria> getTipoPrestazioni();
	void setIdPrestazioni(HashMap<TipoPrestazione, PrestazioneSanitaria> tipoPrestazioni);
	HashMap<Integer, IPrenotazione> getIdPrenotazioni();
	void setIdPrenotazioni(HashMap<Integer, IPrenotazione> idPrenotazioni);
	void setUtenteCorrente(String cf);
	IAccount getUtenteCorrente();
	HashMap<TipoPrestazione, IAccount> getPersonaleSanitario();
	void setPersonaleSanitario(HashMap<TipoPrestazione, IAccount> personaleSanitario);	
	int getIndexArraySlotLiberi();
	ArrayList<SlotCalendarioSingoli> getArraySlotLiberi();
	boolean cancellaPrenotazione(IPrenotazione p);

}
