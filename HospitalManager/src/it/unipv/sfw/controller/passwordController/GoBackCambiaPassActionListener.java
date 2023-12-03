package it.unipv.sfw.controller.passwordController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.model.persona.IAccount;
import it.unipv.sfw.model.persona.TipoAccount;
import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class GoBackCambiaPassActionListener implements ActionListener{
	private IStrutturaSanitaria model;
	private ViewController view;

	public GoBackCambiaPassActionListener(IStrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		IAccount acc = model.getUtenteCorrente();
		TipoAccount tipoAcc = acc.getTipoAcc();
		view.getCambiaPwPanel().setNewPass(null);
		view.getCambiaPwPanel().setOldPass(null);
		view.getCambiaPwPanel().setVisible(false);
		
		switch(tipoAcc) {
		
		case PA:
			view.getPazientePanel().setVisible(true);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			break;
			
		case ME:
			view.getMedicoPanel().setVisible(true);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			break;
			
		case OU:
			view.getOperatoreUfficioPanel().setVisible(true);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			break;
			
		case OS:
			view.getOperatoreSanitarioPanel().setVisible(true);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			break;
		}
	}

}
