package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class GoBackOpUffActionListener implements ActionListener{
	private StrutturaSanitaria model;
	private ViewController view;

	public GoBackOpUffActionListener(StrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		view.getCancellaPanelUfficio().setVisible(false);
		view.getPrenotatiPanelUfficio().setVisible(false);
		
		view.getOperatoreUfficioPanel().setVisible(true);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.getContentPane().setLayout(null);

	}

}