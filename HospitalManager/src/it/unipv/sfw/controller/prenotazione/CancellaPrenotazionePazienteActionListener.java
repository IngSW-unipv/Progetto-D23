package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import it.unipv.sfw.model.prenotazione.Prenotazione;
import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.PopUp;
import it.unipv.sfw.view.ViewController;

public class CancellaPrenotazionePazienteActionListener implements ActionListener{
	private IStrutturaSanitaria model;
	private ViewController view;

	public CancellaPrenotazionePazienteActionListener(IStrutturaSanitaria model, ViewController view) {
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
			
			boolean check = prenSelezionata.getPaziente().getCf() == model.getUtenteCorrente().getCf();
			
			if(check) {
			
				check = model.cancellaPrenotazione(prenSelezionata);
			}
			
			if (check) {
				PulisciTextField();
				PopUp.infoBox("Prenotazione cancellata con successo", "OK");
			} else {
				PopUp.infoBox("Inserire un Id prenotazione valido", "Errore");
			}
		
		} catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}
	
	private void PulisciTextField() {
		view.getCancellaPanelPaziente().getIdPrenotazione().setText(null);
	}

}
