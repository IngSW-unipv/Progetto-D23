package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.model.persona.Account;
import it.unipv.sfw.model.persona.TipoAccount;
import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class PrenotaActionListener implements ActionListener {
	
	private StrutturaSanitaria model;
	private ViewController view;

	public PrenotaActionListener(StrutturaSanitaria model, ViewController view) {
		super();
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Account user = model.getUtenteCorrente();
		TipoAccount tipoAcc = user.getTipoAcc();
		
		if (tipoAcc == TipoAccount.OU) {
			view.getOperatoreUfficioPanel().setVisible(false);
			view.getPrenotatiPanelUfficio().setVisible(true);
			view.getPrenotatiPanelUfficio().getScegliPrestazione().setSelectedIndex(0);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.getContentPane().setLayout(null);
		}
		else {
			view.getPazientePanel().setVisible(false);
			view.getPrenotatiPanelPaziente().setVisible(true);
			view.getPrenotatiPanelPaziente().getScegliPrestazione().setSelectedIndex(0);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.getContentPane().setLayout(null);
		}
	}

}
