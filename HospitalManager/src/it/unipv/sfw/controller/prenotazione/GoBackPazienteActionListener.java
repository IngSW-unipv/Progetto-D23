package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class GoBackPazienteActionListener implements ActionListener{
	private StrutturaSanitaria model;
	private ViewController view;

	public GoBackPazienteActionListener(StrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		view.getPrenotatiPanelPaziente().setVisible(false);
		view.getCancellaPanelPaziente().setVisible(false);
		view.getPazientePanel().setVisible(true);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.getContentPane().setLayout(null);
		
	}

}