package it.unipv.sfw.controller.loginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.model.persona.Account;
import it.unipv.sfw.model.persona.TipoAccount;
import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class BtnBackRegistrazioneActionListener implements ActionListener{
	
	private StrutturaSanitaria model;
	private ViewController view;

	public BtnBackRegistrazioneActionListener(StrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Account acc = model.getUtenteCorrente();
		TipoAccount tipoAcc = acc.getTipoAcc();
		
		if(tipoAcc == TipoAccount.OU) {
			view.getRegistratiPanel().setVisible(false);
			view.getOperatoreUfficioPanel().setVisible(true);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.getContentPane().setLayout(null);
		} 
		else {
			view.getRegistratiPanelPaziente().setVisible(false);
			view.getLoginPanel().setVisible(true);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.getContentPane().setLayout(null);
		}
	}

}
