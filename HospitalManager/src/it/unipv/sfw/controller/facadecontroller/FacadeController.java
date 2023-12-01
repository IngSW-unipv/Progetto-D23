package it.unipv.sfw.controller.facadecontroller;

import it.unipv.sfw.controller.loginController.LoginController;
import it.unipv.sfw.controller.loginController.RegistrazioneController;
import it.unipv.sfw.controller.operatoreUffController.OperatoreUffController;
import it.unipv.sfw.controller.passwordController.PasswordController;
import it.unipv.sfw.controller.pazienteController.PazienteController;
import it.unipv.sfw.controller.prenotazione.PrenotazioneController;
import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class FacadeController {
	
	private LoginController loginController;
	private RegistrazioneController registrazioneController;
	private OperatoreUffController opUffController;
	private PasswordController passController;
	private PrenotazioneController prenController;
	private PazienteController pazController;
	
	public FacadeController(StrutturaSanitaria model, ViewController view) {
		
		loginController = new LoginController(model, view);
		registrazioneController = new RegistrazioneController(model, view);
		opUffController = new OperatoreUffController(model, view);
		passController = new PasswordController(model, view);
		prenController = new PrenotazioneController(model, view);
		pazController = new PazienteController(model, view);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
