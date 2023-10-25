package it.unipv.sfw.controller.loginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.model.StrutturaSanitaria;
import it.unipv.sfw.model.persona.Persona;
import it.unipv.sfw.view.ViewController;

public class RegistraPazienteActionListener implements ActionListener{
	private StrutturaSanitaria model;
	private ViewController view;

	public RegistraPazienteActionListener(StrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String nome = view.getRegistratiPanelPaziente().getNomeField().getText();
		String cognome = view.getRegistratiPanelPaziente().getCognomeField().getText();
		String CF = view.getRegistratiPanelPaziente().getCfField().getText();
		String dataNascita = view.getRegistratiPanelPaziente().getDataNascitaField().getText();
		String luogoNascita = view.getRegistratiPanelPaziente().getLuogoNascitaField().getText();
		String provinciaNascita = view.getRegistratiPanelPaziente().getProvinciaNascita().getText();
		String regResidenza = view.getRegistratiPanelPaziente().getRegioneResidenza().getText();
		String provResidenza = view.getRegistratiPanelPaziente().getProvinciaResidenza().getText();
		String cittaRes = view.getRegistratiPanelPaziente().getCittaResidenza().getText();
		String indirizzo = view.getRegistratiPanelPaziente().getIndirizzo().getText();
		String email = view.getRegistratiPanelPaziente().getEmail().getText();
		String cellulare = view.getRegistratiPanelPaziente().getCellulare().getText();
		String pw = view.getRegistratiPanelPaziente().getPasswordField().toString();
		String cap = view.getRegistratiPanelPaziente().getCapField().getText();
		String sesso = view.getRegistratiPanelPaziente().getSessoScelto();
		
		Persona newPersona = new Persona(CF, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita, regResidenza, provResidenza, cittaRes,
				indirizzo, cap, email, cellulare);
		
		model.aggiungiPaziente(newPersona, pw);
		
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
