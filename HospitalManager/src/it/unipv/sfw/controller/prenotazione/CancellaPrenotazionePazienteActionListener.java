package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import it.unipv.sfw.model.persona.IPaziente;
import it.unipv.sfw.model.prenotazione.IPrenotazione;
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
		
			HashMap<Integer, IPrenotazione> mappaPrenotazioni = model.getIdPrenotazioni();
			IPrenotazione prenSelezionata = mappaPrenotazioni.get(idPren);
			
			IPaziente paz = prenSelezionata.getPaziente();
			
			boolean check = prenSelezionata.getPaziente().getCf() == model.getUtenteCorrente().getCf();
			if(check) {
			
				check = model.cancellaPrenotazione(prenSelezionata);
			}
			
			if(check) {
				PulisciTextField();
				PopUp.infoBox("Prenotazione cancellata con successo", "OK");
				view.getCancellaPanelPaziente().setVisible(false);
				view.getPazientePanel().setVisible(true);
				view.getPazientePanel().setListaPrenotazioni(paz.getPrenotazioni());
				view.getPazientePanel().setListaPrenotazioniErogate(paz.getCartellaPersonale().getPrenotazioni());
			}else {
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
