package it.unipv.sfw.model.strutturasanitaria;

import java.time.LocalDate;
import java.time.LocalTime;

import it.unipv.sfw.model.cartellaclinica.GruppiSanguigni;
import it.unipv.sfw.model.persona.Paziente;
import it.unipv.sfw.model.persona.Sesso;
import it.unipv.sfw.model.persona.TipoAccount;
import it.unipv.sfw.model.prenotazione.Prenotazione;
import it.unipv.sfw.model.prenotazione.TipoPrestazione;

public interface IStrutturaSanitaria {
	boolean login(String cf, String pw);
	int generaIdPren();
	public String generaPwTemp();
	boolean inserisciPrenotazione(TipoPrestazione prest, Paziente paziente, LocalDate data, LocalTime orario);
	boolean cancellaPrenotazione(Prenotazione p);
	boolean aggiornaDatiSanitariPaziente(Paziente p, double altezza, double peso, GruppiSanguigni gruppoSanguigno);
	boolean cambioPw(String cf, String vecchiaPw, String nuovaPw);
	boolean registrazioneAccount(String cf, String pw, TipoAccount tipo, String nome, String cognome, Sesso sesso,
			String dataNascita, String luogoNascita, String provinciaNascita, String regioneRes, String provinciaRes,
			String cittaRes, String indirizzo, String cap, String eMail, String cellulare,
			TipoPrestazione specializzazione);
}
