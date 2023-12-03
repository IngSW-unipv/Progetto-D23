package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class PrenotaOpUffActionListener implements ActionListener {
	
	private IStrutturaSanitaria model;
	private ViewController view;

	public PrenotaOpUffActionListener(IStrutturaSanitaria model, ViewController view) {
		super();
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		view.getOperatoreUfficioPanel().setVisible(false);
		view.getPrenotatiPanelUfficio().setVisible(true);
		view.getPrenotatiPanelUfficio().getScegliPrestazione().setSelectedIndex(0);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
	}

}
