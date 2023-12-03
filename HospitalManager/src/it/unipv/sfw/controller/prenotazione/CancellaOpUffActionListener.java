package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.view.ViewController;

public class CancellaOpUffActionListener implements ActionListener{
	private ViewController view;

	public CancellaOpUffActionListener(ViewController view) {
		super();
		this.view = view;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		view.getOperatoreUfficioPanel().setVisible(false);
		view.getCancellaPanelUfficio().setVisible(true);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}

}

