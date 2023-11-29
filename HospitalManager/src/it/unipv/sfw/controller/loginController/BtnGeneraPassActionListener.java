package it.unipv.sfw.controller.loginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class BtnGeneraPassActionListener implements ActionListener{

	private StrutturaSanitaria model;
	private ViewController view;
	
	public BtnGeneraPassActionListener(StrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String pw = model.generaPwTemp();
		view.getRegistratiPanelPaziente().getPasswordField().setText(pw);
		
	}

}
