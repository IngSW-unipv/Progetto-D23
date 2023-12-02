package it.unipv.sfw.controller.loginController;

import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.ViewController; // MainView

public class LoginController {
	private ViewController view;
	private IStrutturaSanitaria model;
	private GoBtnActionListener go;
	
	public LoginController(IStrutturaSanitaria model, ViewController view) {

		this.view = view; 
		this.model = model;

		go = new GoBtnActionListener(model, view);
		view.getLoginPanel().getBtnLogin().addActionListener(go);

		addEsciActionListener();
	}

	public GoBtnActionListener getGo() {
		return go;
	}

	private void addEsciActionListener() {

		EsciAccountActionListener esci = new EsciAccountActionListener(model, view);
		view.getMedicoPanel().getLogoutBtn().addActionListener(esci);
		view.getPazientePanel().getLogoutBtn().addActionListener(esci);
		view.getOperatoreSanitarioPanel().getLogoutBtn().addActionListener(esci);
		view.getOperatoreUfficioPanel().getLogoutBtn().addActionListener(esci);

	}
}
