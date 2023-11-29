package it.unipv.sfw.controller.loginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.model.persona.Persona;
import it.unipv.sfw.model.persona.TipoAccount;
import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.PopUp;
import it.unipv.sfw.view.ViewController;

public class RegistraUtenteActionListener implements ActionListener {

	private StrutturaSanitaria model;
	private ViewController view;
	private TipoAccount tipoAcc;
	
	public RegistraUtenteActionListener(StrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		
		String nome = view.getRegistratiPanel().getNomeField().getText();
		String cognome = view.getRegistratiPanel().getCognomeField().getText();
		String CF = view.getRegistratiPanel().getCfField().getText();
		String dataNascita = view.getRegistratiPanel().getDataNascitaField().getText();
		String luogoNascita = view.getRegistratiPanel().getLuogoNascitaField().getText();
		String provinciaNascita = view.getRegistratiPanel().getProvinciaNascitaField().getText();
		String regResidenza = view.getRegistratiPanel().getRegioneResidenzaField().getText();
		String provResidenza = view.getRegistratiPanel().getProvinciaResidenzaField().getText();
		String cittaRes = view.getRegistratiPanel().getCittaResidenzaField().getText();
		String indirizzo = view.getRegistratiPanel().getIndirizzoField().getText();
		String email = view.getRegistratiPanel().getEmailField().getText();
		String cellulare = view.getRegistratiPanel().getCellulareField().getText();
		String pw = view.getRegistratiPanel().getPasswordField().toString();
		String cap = view.getRegistratiPanel().getCapField().getText();
		String sesso = view.getRegistratiPanel().getSessoScelto();
		String tipoAccount = view.getRegistratiPanel().getTipoAccountScelto();
		String specializzazione = view.getRegistratiPanel().getSpecializzazioneScelta();
		
		if (tipoAccount == "paziente") {
			TipoAccount tipoAcc = TipoAccount.PA;
		}
		else if(tipoAccount == "medico"){
			TipoAccount tipoAcc = TipoAccount.ME;
		}
		else if(tipoAccount == "OperatoreUfficio"){
			TipoAccount tipoAcc = TipoAccount.OU;
		}
		else {
			TipoAccount tipoAcc = TipoAccount.OS;
		}
		
		model.registrazioneAccount(CF, pw, tipoAcc, CF, nome, cognome,
				sesso, dataNascita, luogoNascita, provinciaNascita,
				regResidenza, provResidenza, cittaRes, indirizzo, cap, email, cellulare, specializzazione);
		
		pulisciTextField();
		PopUp ok = new PopUp();
		PopUp.infoBox("Nuovo account creato", "OK");
		view.getRegistratiPanel().setVisible(false);
		view.getOperatoreUfficioPanel().setVisible(true);
		}
		catch(Exception e1) {
			PopUp err = new PopUp();
			PopUp.infoBox("Registrazione non riuscita", "Errore");
			pulisciTextField();
		}
	}

	private void pulisciTextField() {
		view.getRegistratiPanel().getNomeField().setText(null);
		view.getRegistratiPanel().getCognomeField().setText(null);
		view.getRegistratiPanel().getCfField().setText(null);
		view.getRegistratiPanel().getDataNascitaField().setText(null);
		view.getRegistratiPanel().getLuogoNascitaField().setText(null);
		view.getRegistratiPanel().getProvinciaNascita().setText(null);
		view.getRegistratiPanel().getRegioneResidenza().setText(null);
		view.getRegistratiPanel().getProvinciaResidenza().setText(null);
		view.getRegistratiPanel().getCittaResidenza().setText(null);
		view.getRegistratiPanel().getIndirizzo().setText(null);
		view.getRegistratiPanel().getEmail().setText(null);
		view.getRegistratiPanel().getCellulare().setText(null);
		view.getRegistratiPanel().getPasswordField().setText(null);
		view.getRegistratiPanel().getCapField().setText(null);
		
	}
	
	
	
	
	
	
	
	
	
	
}