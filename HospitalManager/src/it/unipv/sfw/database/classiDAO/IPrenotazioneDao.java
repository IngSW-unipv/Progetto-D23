package it.unipv.sfw.database.classiDAO;

import java.util.ArrayList;

import it.unipv.sfw.prestazionisantarie.Prenotazione;

public interface IPrenotazioneDao {

	public ArrayList<Prenotazione> selectAll();

	public boolean insertPrenotazione(Prenotazione p);
	
	public void deletePrenotazione(int cod);
	
	public ArrayList<Prenotazione> prenotazioniOggiDueToMed(String CF_medReferente);
	
	public ArrayList<Prenotazione> prenotazioniOggi();
	
	public void updatePrenotazione(Prenotazione p);
}
