package it.unipv.sfw.controller.passwordController;

import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class PasswordController {
	private ViewController view;
	private static StrutturaSanitaria model;
	private CambiaPasswordActionListener cambiaPass;
	private ConfermaCambiaPassActionListener confermaCambioPass;
	
	public PasswordController(StrutturaSanitaria model, ViewController view) {

		this.view = view; 
		this.model = model;

		cambiaPass = new CambiaPasswordActionListener(model, view);
		view.getMedicoPanel().getCambiaPw().addActionListener(cambiaPass);
		view.getOperatoreSanitarioPanel().getCambiaPw().addActionListener(cambiaPass);
		view.getPazientePanel().getCambiaPw().addActionListener(cambiaPass);
		
		confermaCambioPass = new ConfermaCambiaPassActionListener(model, view);
		view.getCambiaPwPanel().getConfermaBtn().addActionListener(confermaCambioPass);
	}
}
