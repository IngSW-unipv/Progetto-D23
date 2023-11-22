package it.unipv.sfw.controller.prenotazione;

import it.unipv.sfw.model.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class PrenotazioneController {
	
	private ViewController view;
	private StrutturaSanitaria model;
	private PrenotaActionListener prenota;
	private ConfermaPrenotazioneActionListener conferma;
	
	public PrenotazioneController (StrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
		
		prenota = new PrenotaActionListener(model, view);
		conferma = new ConfermaPrenotazioneActionListener(model, view);
		
		view.getOperatoreUfficioPanel().getPrenotaBtn().addActionListener(prenota);
		view.getPazientePanel().getPrenotaBtn().addActionListener(prenota);
		view.getPrenotaPanel().getConfermaBtn().addActionListener(conferma);
	}
}


