package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import it.unipv.sfw.model.Prenotazione;
import it.unipv.sfw.model.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class CancellaPrenotazioneOpUffActionListener implements ActionListener {
	private StrutturaSanitaria model;
	private ViewController view;

	public CancellaPrenotazioneOpUffActionListener(StrutturaSanitaria model, ViewController view) {
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
			
			model.cancellaPrenotazione(prenSelezionata);
		
		} catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}

}