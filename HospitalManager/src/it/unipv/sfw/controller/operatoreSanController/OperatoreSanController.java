package it.unipv.sfw.controller.operatoreSanController;

import it.unipv.sfw.controller.loginController.EsciAccountActionListener;
import it.unipv.sfw.model.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class OperatoreSanController {
	private StrutturaSanitaria model;
	private ViewController view;
	
	public OperatoreSanController(StrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
		
		addActionListenerLogout();
	}

	private void addActionListenerLogout() {
		EsciAccountActionListener esci = new EsciAccountActionListener(view, model);
		view.getOperatoreSanitarioPanel().getLogoutBtn().addActionListener(esci);
	}
}
