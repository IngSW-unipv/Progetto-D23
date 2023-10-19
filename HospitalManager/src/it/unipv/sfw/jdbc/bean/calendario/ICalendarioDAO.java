package it.unipv.sfw.jdbc.bean.calendario;

import java.util.ArrayList;

import it.unipv.sfw.model.Prenotazione;

public interface ICalendarioDAO {
	ArrayList<SlotCalendarioDB> SelectCalendario();
	boolean UpdateCalendario(Prenotazione p);
	ArrayList<SlotCalendarioDB> SelectVoidSlot(String idPrest);
}