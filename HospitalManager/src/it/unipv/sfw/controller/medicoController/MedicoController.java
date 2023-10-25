package it.unipv.sfw.controller.medicoController;

import it.unipv.sfw.controller.loginController.EsciAccountActionListener;
import it.unipv.sfw.model.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class MedicoController {
	
	private StrutturaSanitaria model;
	private ViewController view;
	
	public MedicoController(StrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
		
		addActionListenerLogout();
	}

	private void addActionListenerLogout() {
		EsciAccountActionListener esci = new EsciAccountActionListener(view, model);
		view.getMedicoPanel().getLogoutBtn().addActionListener(esci);
	}
}
