package it.unipv.sfw.controller.loginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.model.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class RegistrazioneController {
	private ViewController view;
	private StrutturaSanitaria model;

	
	public RegistrazioneController(ViewController view, StrutturaSanitaria model) {

		this.view = view;
		this.model = model;

		addActionListenerBottoneRegistraPaziente();
		addActionListenerConfermaRegistrazione();
		addActionListenerRegistraUtente();
	}


	private void addActionListenerRegistraUtente() {
		RegistraUtenteActionListener regUtente = new RegistraUtenteActionListener(model, view);
		view.getRegistratiPanel().getBtnConfermaReg().addActionListener(regUtente);
	}


	private void addActionListenerConfermaRegistrazione() {
		RegistraPazienteActionListener regPaz = new RegistraPazienteActionListener(model, view);
		view.getRegistratiPanelPaziente().getBtnConfermaReg().addActionListener(regPaz);
		
	}


	private void addActionListenerBottoneRegistraPaziente() {
		BtnRegistraPazienteActionListener addPaz = new BtnRegistraPazienteActionListener(view, model);
		view.getLoginPanel().getBtnRegistraPaziente().addActionListener(addPaz);
		
	}

}
