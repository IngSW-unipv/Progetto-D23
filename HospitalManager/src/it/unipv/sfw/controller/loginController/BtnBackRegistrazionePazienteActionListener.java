package it.unipv.sfw.controller.loginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.model.persona.Account;
import it.unipv.sfw.model.persona.TipoAccount;
import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class BtnBackRegistrazionePazienteActionListener implements ActionListener{
	
	private IStrutturaSanitaria model;
	private ViewController view;

	public BtnBackRegistrazionePazienteActionListener(IStrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Account acc = model.getUtenteCorrente();
		if(acc == null) {
			view.getRegistratiPanelPaziente().setVisible(false);
		pulisciTextFields();
		view.getLoginPanel().setVisible(true);
		}
		else{
			TipoAccount tipoAcc = acc.getTipoAcc();

			if(tipoAcc == TipoAccount.OU) {
				view.getLoginPanel().setVisible(false);
				view.getOperatoreUfficioPanel().setVisible(true);
				view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				view.getContentPane().setLayout(null);
		}
				
		}
		
	}

	private void pulisciTextFields() {
		view.getRegistratiPanelPaziente().getNomeField().setText(null);
		view.getRegistratiPanelPaziente().getCognomeField().setText(null);
		view.getRegistratiPanelPaziente().getCfField().setText(null);
		view.getRegistratiPanelPaziente().getDataNascitaField().setText(null);
		view.getRegistratiPanelPaziente().getLuogoNascitaField().setText(null);
		view.getRegistratiPanelPaziente().getProvinciaNascitaField().setText(null);
		view.getRegistratiPanelPaziente().getRegioneResidenzaField().setText(null);
		view.getRegistratiPanelPaziente().getProvinciaResidenzaField().setText(null);
		view.getRegistratiPanelPaziente().getCittaResidenzaField().setText(null);
		view.getRegistratiPanelPaziente().getIndirizzoField().setText(null);
		view.getRegistratiPanelPaziente().getEmailField().setText(null);
		view.getRegistratiPanelPaziente().getCellulareField().setText(null);
		view.getRegistratiPanelPaziente().getPasswordField().setText(null);
		view.getRegistratiPanelPaziente().getCapField().setText(null);
		view.getRegistratiPanelPaziente().getAltezzaField().setText(null);
		view.getRegistratiPanelPaziente().getPesoField().setText(null);
		view.getRegistratiPanelPaziente().getScegliSesso().setSelectedIndex(0);
		view.getRegistratiPanelPaziente().getScegliGruppo().setSelectedIndex(0);
	}

}
