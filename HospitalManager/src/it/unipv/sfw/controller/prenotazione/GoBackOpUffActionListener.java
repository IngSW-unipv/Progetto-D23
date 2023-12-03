package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class GoBackOpUffActionListener implements ActionListener{
	private IStrutturaSanitaria model;
	private ViewController view;

	public GoBackOpUffActionListener(IStrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		view.getCancellaPanelUfficio().setVisible(false);
		view.getPrenotatiPanelUfficio().setVisible(false);
		pulisciTextFields();
		view.getOperatoreUfficioPanel().setVisible(true);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.getContentPane().setLayout(null);

	}
	
	private void pulisciTextFields() {
		//cancella prenotazione del OpUff
		view.getCancellaPanelUfficio().getIdPrenotazione().setText(null);
		view.getCancellaPanelUfficio().getCf().setText(null);
		view.getCancellaPanelUfficio().getSlot().setText(null);
		//prenotazione del OpUff
		view.getPrenotatiPanelUfficio().getSlot().setText(null);
		view.getPrenotatiPanelUfficio().getCfField().setText(null);
		view.getPrenotatiPanelUfficio().getScegliPrestazione().setSelectedIndex(0);

	}

}
