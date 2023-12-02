package it.unipv.sfw.controller.operatoreUffController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class AddUtenteActionListener implements ActionListener {
	private IStrutturaSanitaria model;
	private ViewController view;

	public AddUtenteActionListener(IStrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		view.getOperatoreUfficioPanel().setVisible(false);
		view.getRegistratiPanel().setVisible(true);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.getContentPane().setLayout(null);	
	}

}
