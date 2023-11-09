package it.unipv.sfw.jdbc.bean.prenotazione;

import java.util.ArrayList;

import it.unipv.sfw.model.Prenotazione;

public interface IPrenotazioneDAO {
	ArrayList<PrenotazioneDB> selectAllPrenotazioni();
	ArrayList<PrenotazioneDB> selectPrenotazioniByIdPaziente(int idPaziente);
	ArrayList<PrenotazioneDB> selectPrenotazioniByIdMedico(int idMedico);
	ArrayList<PrenotazioneDB> selectPrenotazioniByIdOperatore(int idOperatoreSanitario);
	PrenotazioneDB selectPrenotazioneByIdPren(int idPren);
	boolean insertPrenotazione(Prenotazione p);
	boolean updateAccreditamento(Prenotazione p, boolean pagamento);
	ArrayList<PrenotazioneDB> selectPrenotazioniErogateByIdPaziente(int idPaziente);
}
