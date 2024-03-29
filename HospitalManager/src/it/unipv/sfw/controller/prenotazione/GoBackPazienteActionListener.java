package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.view.ViewController;

public class GoBackPazienteActionListener implements ActionListener{
	private ViewController view;

	public GoBackPazienteActionListener(ViewController view) {
		this.view = view;	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		view.getPrenotatiPanelPaziente().setVisible(false);
		view.getCancellaPanelPaziente().setVisible(false);
		pulisciTextFields();
		view.getPazientePanel().setVisible(true);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.getContentPane().setLayout(null);
		
	}

	private void pulisciTextFields() {

		//cancella prenotazione del paziente
		view.getCancellaPanelPaziente().getIdPrenotazione().setText(null);
		view.getCancellaPanelPaziente().getSlot().setText(null);

		//prenotazione del paziente
		view.getPrenotatiPanelPaziente().getSlot().setText(null);
	}

}
