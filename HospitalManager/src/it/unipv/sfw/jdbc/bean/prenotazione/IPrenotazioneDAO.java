package it.unipv.sfw.jdbc.bean.prenotazione;

import java.util.ArrayList;

import it.unipv.sfw.model.Prenotazione;

public interface IPrenotazioneDAO {
	ArrayList<PrenotazioneDB> selectAllPrenotazioni();
	PrenotazioneDB selectPrenotazioneByIdPren(int idPren);
	boolean insertPrenotazione(Prenotazione p);
	boolean updateAccreditamento(Prenotazione p, boolean pagamento);
	ArrayList<PrenotazioneDB> selectPrenotazioniErogateByPaziente(String cf);
	ArrayList<PrenotazioneDB> selectPrenotazioniByPersonaleSanitario(String cf);
	ArrayList<PrenotazioneDB> selectPrenotazioniByPaziente(String cf);
}
