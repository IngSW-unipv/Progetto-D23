package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import it.unipv.sfw.model.StrutturaSanitaria;
import it.unipv.sfw.model.persona.Paziente;
import it.unipv.sfw.view.PopUpError;
import it.unipv.sfw.view.ViewController;

public class ConfermaPrenotazionePazienteActionListener implements ActionListener {
	
	private StrutturaSanitaria model;
	private ViewController view;

	public ConfermaPrenotazionePazienteActionListener(StrutturaSanitaria model, ViewController view) {
		super();
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			
			
		}
		catch(exception e) {
			PopUpError err = new PopUpError();
			PopUpError.infoBox("Ops!", "Qualcosa è andato storto!");
		}
		
		
	}

}
