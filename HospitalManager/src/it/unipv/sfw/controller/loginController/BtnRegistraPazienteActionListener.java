package it.unipv.sfw.controller.loginController;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.view.ViewController;

public class BtnRegistraPazienteActionListener implements ActionListener {
	private ViewController view;
	
	public BtnRegistraPazienteActionListener (ViewController view) {
		super();
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		view.getLoginPanel().setVisible(false);
		view.getOperatoreUfficioPanel().setVisible(false);
		view.getRegistratiPanelPaziente().setVisible(true);
		view.getRegistratiPanelPaziente().getPasswordField().setText(null);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.getContentPane().setLayout(null);	
		
	}

}
