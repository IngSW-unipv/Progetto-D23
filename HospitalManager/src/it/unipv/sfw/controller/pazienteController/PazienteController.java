package it.unipv.sfw.controller.pazienteController;

import it.unipv.sfw.controller.operatoreUffController.AddPrenotazioneActionListener;
import it.unipv.sfw.controller.operatoreUffController.CancellaPrenotazioneActionListener;
import it.unipv.sfw.model.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class PazienteController {
	private StrutturaSanitaria model;
	private ViewController view;
	
	public PazienteController(StrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
		
		addActionListenerButtons();
	}
	
	private void addActionListenerButtons() {
		
		AddPrenotazioneActionListener addPren = new AddPrenotazioneActionListener(model, view);
		view.getPazientePanel().getPrenotaBtn().addActionListener(addPren);
		
		CancellaPrenotazioneActionListener cancPren = new CancellaPrenotazioneActionListener(model, view);
		view.getPazientePanel().getCancellaBtn().addActionListener(cancPren);
	}

	
		
}
