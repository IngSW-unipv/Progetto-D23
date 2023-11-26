package it.unipv.sfw.jdbc.bean.calendario;

import java.util.ArrayList;

import it.unipv.sfw.jdbc.bean.prenotazione.PrenotazioneDB;
import it.unipv.sfw.model.TipoPrestazione;

public interface ICalendarioDAO {
	ArrayList<SlotCalendarioDB> selectCalendario();
	boolean updateCalendarioNewPren(PrenotazioneDB p);
	ArrayList<SlotCalendarioSingoloDB> selectVoidSlot(TipoPrestazione prest);
	boolean updateCalendarioDelPren(PrenotazioneDB p);
}
