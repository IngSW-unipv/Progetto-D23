package it.unipv.sfw.controller.passwordController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.view.ViewController;

public class CambiaPasswordActionListener implements ActionListener{
	
	private ViewController view;

	public CambiaPasswordActionListener(ViewController view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		view.getPazientePanel().setVisible(false);
		view.getMedicoPanel().setVisible(false);
		view.getOperatoreSanitarioPanel().setVisible(false);
		view.getOperatoreUfficioPanel().setVisible(false);
		view.getCambiaPwPanel().setVisible(true);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.getContentPane().setLayout(null);
		
	}

}
