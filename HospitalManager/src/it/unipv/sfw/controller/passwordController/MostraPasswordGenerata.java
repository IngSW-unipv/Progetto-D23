package it.unipv.sfw.controller.passwordController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class MostraPasswordGenerata implements ActionListener{
	private static IStrutturaSanitaria model;
	private ViewController view;
	
	public MostraPasswordGenerata(IStrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	    // Ottenere la password temporaneamente
	    view.getRegistratiPanelPaziente().getPasswordField().setEchoChar((char) 0);
	    view.getRegistratiPanel().getPasswordField().setEchoChar((char)0);

	    Timer timer = new Timer(1000, new ActionListener() {
	    	
	    	public void actionPerformed(ActionEvent evt) {
	    		// Nascondere nuovamente la password dopo un secondo
	    		view.getRegistratiPanel().getPasswordField().setEchoChar('*');
	    		view.getRegistratiPanelPaziente().getPasswordField().setEchoChar('*');
	                }
	            });
	            timer.setRepeats(false); // Eseguire solo una volta
	            timer.start();
	}
}

