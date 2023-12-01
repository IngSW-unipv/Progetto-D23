package it.unipv.sfw.controller.loginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.model.persona.Account;
import it.unipv.sfw.model.persona.TipoAccount;
import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class BtnBackRegistrazionePazienteActionListener implements ActionListener{
	
	private StrutturaSanitaria model;
	private ViewController view;

	public BtnBackRegistrazionePazienteActionListener(StrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
			view.getRegistratiPanelPaziente().setVisible(false);
			view.getLoginPanel().setVisible(true);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.getContentPane().setLayout(null);
		
	}

}
