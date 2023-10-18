package it.unipv.sfw.controller.loginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;
import it.unipv.sfw.jdbc.bean.DbControllerSingleton; 


public class GoBtnActionListener implements ActionListener {

	private ViewController view;
	private StrutturaSanitaria model;
	private DbControllerSingleton dbControl;
	private String CF;

	public GoBtnActionListener (ViewController view, StrutturaSanitaria model) {
		super();
		this.view = view;
		this.model = model;
		dbControl = DbControllerSingleton.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO da completare
		
	}

}
