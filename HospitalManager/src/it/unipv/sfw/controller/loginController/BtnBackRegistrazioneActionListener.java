package it.unipv.sfw.controller.loginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class BtnBackRegistrazioneActionListener implements ActionListener{
	private IStrutturaSanitaria model;
	private ViewController view;
	
	public BtnBackRegistrazioneActionListener(IStrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		view.getRegistratiPanel().setVisible(false);
		pulisciTextFields();
		view.getOperatoreUfficioPanel().setVisible(true);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.getContentPane().setLayout(null);
		
	}

	private void pulisciTextFields() {
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
		view.getRegistratiPanel().getScegliSesso().setSelectedIndex(0);
		view.getRegistratiPanel().getScegliSpecializzazione().setSelectedIndex(0);
		view.getRegistratiPanel().getScegliSpecializzazione().setSelectedIndex(0);
	}

}
