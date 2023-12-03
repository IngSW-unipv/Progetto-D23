package it.unipv.sfw.controller.passwordController;

import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class PasswordController {

	private CambiaPasswordActionListener cambiaPass;
	private ConfermaCambiaPassActionListener confermaCambioPass;
	private GoBackCambiaPassActionListener goBackPass;
	private MostraPasswordGenerata showPass;
	
	public PasswordController(IStrutturaSanitaria model, ViewController view) {

		cambiaPass = new CambiaPasswordActionListener(view);
		view.getMedicoPanel().getCambiaPw().addActionListener(cambiaPass);
		view.getOperatoreSanitarioPanel().getCambiaPw().addActionListener(cambiaPass);
		view.getPazientePanel().getCambiaPw().addActionListener(cambiaPass);
		view.getOperatoreUfficioPanel().getBtnCambiaPw().addActionListener(cambiaPass);
		
		confermaCambioPass = new ConfermaCambiaPassActionListener(model, view);
		view.getCambiaPwPanel().getConfermaBtn().addActionListener(confermaCambioPass);
		
		goBackPass = new GoBackCambiaPassActionListener(model, view);
		view.getCambiaPwPanel().getBtnBack().addActionListener(goBackPass);
		
		showPass = new MostraPasswordGenerata(view);
		view.getRegistratiPanelPaziente().getBtnMostra().addActionListener(showPass);
		}
}
