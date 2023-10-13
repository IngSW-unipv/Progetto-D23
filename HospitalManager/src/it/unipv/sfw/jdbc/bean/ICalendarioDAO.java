package it.unipv.sfw.jdbc.bean;

import java.util.ArrayList;

import it.unipv.sfw.prestazionisantarie.Prenotazione;

public interface ICalendarioDAO {
	ArrayList<SlotCalendarioDB> SelectCalendario();
	boolean UpdateCalendario(Prenotazione p);
	ArrayList<SlotCalendarioDB> SelectVoidSlot(String idPrest);
}
