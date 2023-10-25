package it.unipv.sfw.controller.loginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.model.StrutturaSanitaria;
import it.unipv.sfw.model.persona.Persona;
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
		
		Persona newPersona = new Persona(CF, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita, regResidenza, provResidenza, cittaRes,
				indirizzo, cap, email, cellulare);
		
		model.aggiungiUtente(newPersona, pw);
		
		pulisciTextField();
		//PopUpOk ok = new PopUpOk();
		//ok.infoBox("Nuovo account creato", "OK");
		view.getRegistratiPanelPaziente().setVisible(false);
		
		//catch {
		//	PopupError err = new PopupError();
			//err.infoBox("le due password non coincidono", "Errore");
		//	pulisciTextField();
		//}
	}

	private void pulisciTextField() {
		view.getRegistratiPanelPaziente().getNomeField().setText(null);
		view.getRegistratiPanelPaziente().getCognomeField().setText(null);
		view.getRegistratiPanelPaziente().getCfField().setText(null);
		view.getRegistratiPanelPaziente().getDataNascitaField().setText(null);
		view.getRegistratiPanelPaziente().getLuogoNascitaField().setText(null);
		view.getRegistratiPanelPaziente().getProvinciaNascita().setText(null);
		view.getRegistratiPanelPaziente().getRegioneResidenza().setText(null);
		view.getRegistratiPanelPaziente().getProvinciaResidenza().setText(null);
		view.getRegistratiPanelPaziente().getCittaResidenza().setText(null);
		view.getRegistratiPanelPaziente().getIndirizzo().setText(null);
		view.getRegistratiPanelPaziente().getEmail().setText(null);
		view.getRegistratiPanelPaziente().getCellulare().setText(null);
		view.getRegistratiPanelPaziente().getPasswordField().setText(null);
		view.getRegistratiPanelPaziente().getCapField().setText(null);
		
	}
		
	}

}
