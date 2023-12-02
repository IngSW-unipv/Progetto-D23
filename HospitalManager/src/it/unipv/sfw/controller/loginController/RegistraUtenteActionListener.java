package it.unipv.sfw.controller.loginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.model.persona.Sesso;
import it.unipv.sfw.model.persona.TipoAccount;
import it.unipv.sfw.model.prenotazione.TipoPrestazione;
import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.PopUp;
import it.unipv.sfw.view.ViewController;

public class RegistraUtenteActionListener implements ActionListener {

	private StrutturaSanitaria model;
	private ViewController view;
	
	public RegistraUtenteActionListener(StrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		
		String nome = view.getRegistratiPanel().getNomeField().getText();
		String cognome = view.getRegistratiPanel().getCognomeField().getText();
		String cf = view.getRegistratiPanel().getCfField().getText();
		String dataNascita = view.getRegistratiPanel().getDataNascitaField().getText();
		String luogoNascita = view.getRegistratiPanel().getLuogoNascitaField().getText();
		String provinciaNascita = view.getRegistratiPanel().getProvinciaNascitaField().getText();
		String regResidenza = view.getRegistratiPanel().getRegioneResidenzaField().getText();
		String provResidenza = view.getRegistratiPanel().getProvinciaResidenzaField().getText();
		String cittaRes = view.getRegistratiPanel().getCittaResidenzaField().getText();
		String indirizzo = view.getRegistratiPanel().getIndirizzoField().getText();
		String email = view.getRegistratiPanel().getEmailField().getText();
		String cellulare = view.getRegistratiPanel().getCellulareField().getText();
		String pw = String.valueOf(view.getRegistratiPanelPaziente().getPasswordField().getPassword());
		String cap = view.getRegistratiPanel().getCapField().getText();
		String sesso = view.getRegistratiPanel().getSessoScelto();
		String tipoAccount = view.getRegistratiPanel().getTipoAccountScelto();
		String specializzazione = view.getRegistratiPanel().getSpecializzazioneScelta();
		
		
		boolean check = model.registrazioneAccount(cf, pw, TipoAccount.valueOf(tipoAccount), nome, cognome,
				Sesso.valueOf(sesso), dataNascita, luogoNascita, provinciaNascita,
				regResidenza, provResidenza, cittaRes, indirizzo, cap, email, cellulare, TipoPrestazione.valueOf(specializzazione), 0, 0, null);
		
		if (check) {
			pulisciTextField();
			PopUp.infoBox("Nuovo account creato", "OK");
			view.getRegistratiPanel().setVisible(false);
			view.getOperatoreUfficioPanel().setVisible(true);
		} else {
			PopUp.infoBox("Registrazione non riuscita", "Errore");
		}
		}
		catch(Exception e1) {

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
		view.getRegistratiPanel().getProvinciaNascitaField().setText(null);
		view.getRegistratiPanel().getRegioneResidenzaField().setText(null);
		view.getRegistratiPanel().getProvinciaResidenzaField().setText(null);
		view.getRegistratiPanel().getCittaResidenzaField().setText(null);
		view.getRegistratiPanel().getIndirizzoField().setText(null);
		view.getRegistratiPanel().getEmailField().setText(null);
		view.getRegistratiPanel().getCellulareField().setText(null);
		view.getRegistratiPanel().getPasswordField().setText(null);
		view.getRegistratiPanel().getCapField().setText(null);
		
	}
	
	
	
}