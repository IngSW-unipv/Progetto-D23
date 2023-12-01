package it.unipv.sfw.jdbc.bean.calendario;

import java.util.ArrayList;

import it.unipv.sfw.jdbc.bean.prenotazione.PrenotazioneDB;

public interface ICalendarioDAO {
	ArrayList<SlotCalendarioDB> selectCalendario();
	boolean updateCalendarioNewPren(PrenotazioneDB p);
	boolean updateCalendarioDelPren(PrenotazioneDB p);
	ArrayList<SlotCalendarioSingoloDB> selectCalendarioOncologica();
	ArrayList<SlotCalendarioSingoloDB> selectCalendarioPsicologica();
	ArrayList<SlotCalendarioSingoloDB> selectCalendarioTac();
	ArrayList<SlotCalendarioSingoloDB> selectCalendarioEsamiSangue();
	ArrayList<SlotCalendarioSingoloDB> selectCalendarioRisonanza();
	ArrayList<SlotCalendarioSingoloDB> selectCalendarioChemio();
	ArrayList<SlotCalendarioSingoloDB> selectCalendarioRadio();
}
