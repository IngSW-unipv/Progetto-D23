package it.unipv.sfw.controller.loginController;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController; 



public class EsciAccountActionListener implements ActionListener {
	
	private ViewController view;
	private StrutturaSanitaria model;

	
	public EsciAccountActionListener(StrutturaSanitaria model, ViewController view) {
		super();
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		model.setUtenteCorrente(null);
		view.getPazientePanel().setVisible(false);
		view.getMedicoPanel().setVisible(false);
		view.getOperatoreSanitarioPanel().setVisible(false);
		view.getOperatoreUfficioPanel().setVisible(false);
		
		view.getLoginPanel().setVisible(true);
		
	}

}
