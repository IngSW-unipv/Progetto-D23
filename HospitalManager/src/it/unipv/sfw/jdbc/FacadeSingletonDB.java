package it.unipv.sfw.jdbc;

import java.util.ArrayList;

import it.unipv.sfw.jdbc.bean.account.*;
import it.unipv.sfw.jdbc.bean.anagrafica.*;
import it.unipv.sfw.jdbc.bean.calendario.*;
import it.unipv.sfw.jdbc.bean.cartellaclinica.*;
import it.unipv.sfw.jdbc.bean.esiti.*;
import it.unipv.sfw.jdbc.bean.prenotazione.*;
import it.unipv.sfw.jdbc.bean.prestazionesanitaria.*;
import it.unipv.sfw.model.StrutturaSanitaria;
import it.unipv.sfw.model.persona.Persona;

public class FacadeSingletonDB {
	
	private static FacadeSingletonDB controllerDB;
	private static StrutturaSanitaria struttura1;
	
	private IAccountDAO account;
	private IAnagraficaDAO anagrafica;
	private ICalendarioDAO calendario;
	private ICartellaClinicaDAO cartellaClinica;
	private IEsitiDAO esiti;
	private IPrenotazioneDAO prenotazione;
	private IPrestazioneSanitariaDAO prestazione;

	//costruttore
	//...
	
	public void popolaAnagrafica() {
		ArrayList<AnagraficaDB> tmp = new ArrayList<>();
		
		tmp = anagrafica.selectAllAnagrafica();
		
		for (AnagraficaDB a: tmp) {
			
			struttura1.getAnagrafica().add(new Persona(a.getCf(), a.getNome(), a.getCognome(), a.getSesso(), 
					a.getDataNascita(), a.getLuogoNascita(), a.getProvinciaNascita(), a.getRegioneRes(), a.getProvinciaRes(), 
					a.getCittaRes(), a.getIndirizzo(), a.getCap(), a.geteMail(), a.getCellulare()));
		}
	}
	
	
	
}
