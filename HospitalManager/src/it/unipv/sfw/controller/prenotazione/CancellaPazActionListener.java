package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class CancellaPazActionListener implements ActionListener{
    private IStrutturaSanitaria model;
	private ViewController view;

	public CancellaPazActionListener(IStrutturaSanitaria model, ViewController view) {
		
		this.model = model;
		this.view = view;
		
	}

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        view.getPazientePanel().setVisible(false);
		view.getCancellaPanelPaziente().setVisible(true);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



}
