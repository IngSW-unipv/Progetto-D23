package it.unipv.sfw.jdbc.bean;

import java.util.ArrayList;
import it.unipv.sfw.prestazionisantarie.Prenotazione;

public interface IPrenotazioneDAO {
	ArrayList<PrenotazioneDB> selectAllPrenotazioni();
	boolean insertPrenotazione(Prenotazione p);
}