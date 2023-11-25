package it.unipv.sfw.jdbc.bean.calendario;

import java.util.ArrayList;

import it.unipv.sfw.jdbc.bean.prenotazione.PrenotazioneDB;
import it.unipv.sfw.model.Prenotazione;
import it.unipv.sfw.model.TipoPrestazione;

public interface ICalendarioDAO {
	ArrayList<SlotCalendarioDB> SelectCalendario();
	boolean UpdateCalendario(PrenotazioneDB p);
	ArrayList<SlotCalendarioSingoloDB> SelectVoidSlot(TipoPrestazione prest);
}
