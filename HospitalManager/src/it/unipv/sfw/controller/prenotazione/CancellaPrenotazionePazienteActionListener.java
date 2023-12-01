package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import it.unipv.sfw.model.prenotazione.Prenotazione;
import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.PopUp;
import it.unipv.sfw.view.ViewController;

public class CancellaPrenotazionePazienteActionListener implements ActionListener{
	private StrutturaSanitaria model;
	private ViewController view;

	public CancellaPrenotazionePazienteActionListener(StrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			
			String s = view.getCancellaPanelPaziente().getIdPrenotazione().getText();
			int idPren = Integer.valueOf(s);
		
			HashMap<Integer, Prenotazione> mappaPrenotazioni = model.getIdPrenotazioni();
			Prenotazione prenSelezionata = mappaPrenotazioni.get(idPren);
			
			boolean check = model.cancellaPrenotazione(prenSelezionata);
			
			if (check == true) {
				PulisciTextField();
				PopUp.infoBox("Prenotazione cancellata con successo", "OK");
			} else {
				PopUp.infoBox("Inserite un Id prenotazione valido", "Errore");
			}
		
		} catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}
	
	private void PulisciTextField() {
		view.getCancellaPanelPaziente().getIdPrenotazione().setText(null);
	}

}
