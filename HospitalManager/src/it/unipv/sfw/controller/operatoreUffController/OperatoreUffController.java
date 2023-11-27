package it.unipv.sfw.controller.operatoreUffController;

import it.unipv.sfw.controller.prenotazione.CancellaPrenotazioneOpUffActionListener;
import it.unipv.sfw.controller.prenotazione.ConfermaPrenotazioneOpUffActionListener;
import it.unipv.sfw.model.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class OperatoreUffController {
	private StrutturaSanitaria model;
	private ViewController view;
	
	public OperatoreUffController(StrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
		
		addActionListenerButtons();
	}

	private void addActionListenerButtons() {
		
		ConfermaPrenotazioneOpUffActionListener addPren = new ConfermaPrenotazioneOpUffActionListener(model, view);
		view.getOperatoreUfficioPanel().getPrenotaBtn().addActionListener(addPren);
		
		CancellaPrenotazioneOpUffActionListener cancPren = new CancellaPrenotazioneOpUffActionListener(model, view);
		view.getOperatoreUfficioPanel().getCancellaBtn().addActionListener(cancPren);
		
		AddUtenteActionListener addUtente = new AddUtenteActionListener(model, view);
		view.getOperatoreUfficioPanel().getAggiungiUtenteBtn().addActionListener(addUtente);
		
	}
}
