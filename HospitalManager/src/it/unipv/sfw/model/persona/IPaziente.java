package it.unipv.sfw.model.persona;

import java.util.ArrayList;

import it.unipv.sfw.model.cartellaclinica.CartellaClinica;
import it.unipv.sfw.model.prenotazione.IPrenotazione;

public interface IPaziente {
	boolean spostaPrenotazioniErogate();	
	CartellaClinica getCartellaPersonale();
	ArrayList<IPrenotazione> getPrenotazioni();
	void setPrenotazioni(ArrayList<IPrenotazione> prenotazioni);
	void setCartellaPersonale(CartellaClinica cartellaPersonale);
	String getCf();
	String getNome();
	String getCognome();
	TipoAccount getTipoAcc();
	String getPw();
	Sesso getSesso();
	String getDataNascita();
	String getLuogoNascita();
	String getProvinciaNascita();
	String getRegioneRes();
	String getProvinciaRes();
	String getCittaRes();
	String getIndirizzo();
	String getCap();
	String geteMail();
	String getCellulare();
}
