package it.unipv.sfw.controller.passwordController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.model.StrutturaSanitaria;
import it.unipv.sfw.model.persona.Medico;
import it.unipv.sfw.view.ViewController;

public class CambiaPasswordActionListener implements ActionListener{
	
	private ViewController view;
	private static StrutturaSanitaria model;

	public CambiaPasswordActionListener(StrutturaSanitaria model2, ViewController view2) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		view.setVisible(true);
		view.getCambiaPwPanel().setVisible(true);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.getContentPane().setLayout(null);
		
	}

}
