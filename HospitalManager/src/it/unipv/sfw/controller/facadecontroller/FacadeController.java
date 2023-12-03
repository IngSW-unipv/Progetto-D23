package it.unipv.sfw.controller.facadecontroller;

import it.unipv.sfw.controller.loginController.LoginController;
import it.unipv.sfw.controller.loginController.RegistrazioneController;
import it.unipv.sfw.controller.operatoreUffController.OperatoreUffController;
import it.unipv.sfw.controller.passwordController.PasswordController;
//import it.unipv.sfw.controller.pazienteController.PazienteController;
import it.unipv.sfw.controller.prenotazione.PrenotazioneController;
import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class FacadeController {
	
	public FacadeController(IStrutturaSanitaria model, ViewController view) {
		
		new LoginController(model, view);
		new RegistrazioneController(model, view);
		new OperatoreUffController(model, view);
		new PasswordController(model, view);
		new PrenotazioneController(model, view);
		//new PazienteController(model, view);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
