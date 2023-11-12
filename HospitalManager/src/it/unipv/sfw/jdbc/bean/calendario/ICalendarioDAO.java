package it.unipv.sfw.jdbc.bean.calendario;

import java.util.ArrayList;

import it.unipv.sfw.jdbc.bean.prenotazione.PrenotazioneDB;
import it.unipv.sfw.model.Prenotazione;

public interface ICalendarioDAO {
	ArrayList<SlotCalendarioDB> SelectCalendario();
	ArrayList<SlotCalendarioDB> SelectVoidSlot(String idPrest);
	boolean UpdateCalendario(PrenotazioneDB p);
}
