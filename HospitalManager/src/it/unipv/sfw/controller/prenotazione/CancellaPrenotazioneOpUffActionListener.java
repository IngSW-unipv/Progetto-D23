package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import it.unipv.sfw.model.prenotazione.Prenotazione;
import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.PopUp;
import it.unipv.sfw.view.ViewController;

public class CancellaPrenotazioneOpUffActionListener implements ActionListener {
	private IStrutturaSanitaria model;
	private ViewController view;

	public CancellaPrenotazioneOpUffActionListener(IStrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String cfPaziente = view.getCancellaPanelUfficio().getCf().getText();
			
			String s = view.getCancellaPanelUfficio().getIdPrenotazione().getText();
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
		view.getCancellaPanelUfficio().getCf().setText(null);
		view.getCancellaPanelUfficio().getIdPrenotazione().setText(null);
	}

}
