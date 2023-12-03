package it.unipv.sfw.controller.loginController;

import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class RegistrazioneController {
	private ViewController view;
	private IStrutturaSanitaria model;

	
	public RegistrazioneController(IStrutturaSanitaria model, ViewController view) {

		this.view = view;
		this.model = model;

		addActionListenerBottoneRegistraPaziente();
		addActionListenerConfermaRegistrazione();
		addActionListenerGeneraPassword();
		addActionListenerGoBack();
	}

	private void addActionListenerGeneraPassword() {
		BtnGeneraPassActionListener generaPass = new BtnGeneraPassActionListener (model, view);
		view.getRegistratiPanelPaziente().getBtnGeneraPass().addActionListener(generaPass);
	}


	private void addActionListenerConfermaRegistrazione() {
		ConfermaRegistraPazienteActionListener regPaz = new ConfermaRegistraPazienteActionListener(model, view);
		view.getRegistratiPanelPaziente().getBtnConfermaReg().addActionListener(regPaz);
		
	}


	private void addActionListenerBottoneRegistraPaziente() {
		BtnRegistraPazienteActionListener addPaz = new BtnRegistraPazienteActionListener(model, view);
		view.getLoginPanel().getBtnRegistraPaziente().addActionListener(addPaz);
		view.getOperatoreUfficioPanel().getBtnAggPaz().addActionListener(addPaz);
		
	}
	
	private void addActionListenerGoBack() {
		BtnBackRegistrazionePazienteActionListener goBack = new BtnBackRegistrazionePazienteActionListener(model, view);
		view.getRegistratiPanelPaziente().getBtnBack().addActionListener(goBack);
	}

}
