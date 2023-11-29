package it.unipv.sfw.controller.loginController;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class BtnRegistraPazienteActionListener implements ActionListener {
	private ViewController view;
	private StrutturaSanitaria model;
	
	public BtnRegistraPazienteActionListener (StrutturaSanitaria model, ViewController view) {
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
