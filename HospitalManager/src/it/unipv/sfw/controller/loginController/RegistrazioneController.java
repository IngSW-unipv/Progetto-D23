package it.unipv.sfw.controller.loginController;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class RegistrazioneController {
	private ViewController view;
	private StrutturaSanitaria model;

	
	public RegistrazioneController(StrutturaSanitaria model, ViewController view) {

		this.view = view;
		this.model = model;

		addActionListenerBottoneRegistraPaziente();
		addActionListenerConfermaRegistrazione();
		addActionListenerGeneraPassword();
		addActionListenerRegistraUtente();
		addActionListenerGoBack();
	}


	private void addActionListenerGeneraPassword() {
		BtnGeneraPassActionListener generaPass = new BtnGeneraPassActionListener (model, view);
		view.getRegistratiPanelPaziente().getBtnGeneraPass().addActionListener(generaPass);
	}


	private void addActionListenerRegistraUtente() {
		RegistraUtenteActionListener regUtente = new RegistraUtenteActionListener(model, view);
		view.getRegistratiPanel().getBtnConfermaReg().addActionListener(regUtente);
	}


	private void addActionListenerConfermaRegistrazione() {
		ConfermaRegistraPazienteActionListener regPaz = new ConfermaRegistraPazienteActionListener(model, view);
		view.getRegistratiPanelPaziente().getBtnConfermaReg().addActionListener(regPaz);
		
	}


	private void addActionListenerBottoneRegistraPaziente() {
		BtnRegistraPazienteActionListener addPaz = new BtnRegistraPazienteActionListener(model, view);
		view.getLoginPanel().getBtnRegistraPaziente().addActionListener(addPaz);
		
	}
	
	private void addActionListenerGoBack() {
		BtnBackRegistrazionePazienteActionListener goBack = new BtnBackRegistrazionePazienteActionListener(model, view);
		view.getRegistratiPanelPaziente().getBtnBack().addActionListener(goBack);
		BtnBackRegistrazioneActionListener goBackOpUff = new BtnBackRegistrazioneActionListener(model, view);
		view.getRegistratiPanel().getBtnBack().addActionListener(goBackOpUff);
	}

}
