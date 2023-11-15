package it.unipv.sfw.jdbc.bean.prenotazione;

import java.util.ArrayList;

public interface IPrenotazioneDAO {
	ArrayList<PrenotazioneDB> selectAllPrenotazioni();
	PrenotazioneDB selectPrenotazioneByIdPren(int idPren);
	ArrayList<PrenotazioneDB> selectPrenotazioniErogateByPaziente(String cf);
	ArrayList<PrenotazioneDB> selectPrenotazioniByPersonaleSanitario(String cf);
	ArrayList<PrenotazioneDB> selectPrenotazioniByPaziente(String cf);
	boolean insertPrenotazione(PrenotazioneDB p);
	boolean updateAccreditamento(PrenotazioneDB p, boolean pagamento);
	int selectNumeroPrenotazione();
	ArrayList<PrenotazioneDB> selectPrenotazioniDaErogare();
}
