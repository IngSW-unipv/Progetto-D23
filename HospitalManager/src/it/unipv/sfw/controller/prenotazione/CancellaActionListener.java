package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.model.persona.Account;
import it.unipv.sfw.model.persona.TipoAccount;
import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class CancellaActionListener implements ActionListener{
	private StrutturaSanitaria model;
	private ViewController view;

	public CancellaActionListener(StrutturaSanitaria model, ViewController view) {
		super();
		this.model = model;
		this.view = view;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Account user = model.getUtenteCorrente();
		TipoAccount tipoAcc = user.getTipoAcc();
		
		if (tipoAcc == TipoAccount.OU) {
			view.setVisible(true);
			view.getCancellaPanelUfficio().setVisible(true);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.getContentPane().setLayout(null);
		}
		else {
			view.setVisible(true);
			view.getCancellaPanelPaziente().setVisible(true);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.getContentPane().setLayout(null);
		}
		
	}

}
