package it.unipv.sfw.controller.loginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class BtnGeneraPassActionListener implements ActionListener{

	private IStrutturaSanitaria model;
	private ViewController view;
	
	public BtnGeneraPassActionListener(IStrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String pw = model.generaPwTemp();
		
		view.getRegistratiPanel().getPasswordField().setText(pw);
		view.getRegistratiPanelPaziente().getPasswordField().setText(pw);
		
		
	}

}
