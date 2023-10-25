package it.unipv.sfw.controller.loginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.model.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class RegistraPazienteActionListener implements ActionListener {
	private ViewController view;
	private StrutturaSanitaria model;
	
	public RegistraPazienteActionListener (ViewController view, StrutturaSanitaria model) {
		super();
		this.view = view;
		this.model = model;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		view.setVisible(true);
		view.getRegistratiPanelPaziente().setVisible(true);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.getContentPane().setLayout(null);	
		
	}

}
