package it.unipv.sfw.controller.passwordController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.model.persona.Account;
import it.unipv.sfw.model.persona.TipoAccount;
import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class GoBackCambiaPassActionListener implements ActionListener{
	private StrutturaSanitaria model;
	private ViewController view;

	public GoBackCambiaPassActionListener(StrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Account acc = model.getUtenteCorrente();
		TipoAccount tipoAcc = acc.getTipoAcc();
		view.getCambiaPwPanel().setVisible(false);
		
		switch(tipoAcc) {
		
		case PA:
			view.getPazientePanel().setVisible(true);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.getContentPane().setLayout(null);
			break;
			
		case ME:
			view.getMedicoPanel().setVisible(true);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.getContentPane().setLayout(null);
			break;
			
		case OU:
			view.getOperatoreUfficioPanel().setVisible(true);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.getContentPane().setLayout(null);
			break;
			
		case OS:
			view.getOperatoreSanitarioPanel().setVisible(true);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.getContentPane().setLayout(null);
			break;
		}
	}

}
