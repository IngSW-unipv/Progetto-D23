package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import it.unipv.sfw.model.prenotazione.IPrenotazione;
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
		
			HashMap<Integer, IPrenotazione> mappaPrenotazioni = model.getIdPrenotazioni();
			IPrenotazione prenSelezionata = mappaPrenotazioni.get(idPren);
			
			boolean check = prenSelezionata.getPaziente().getCf().equals(cfPaziente);		
			
			if(check) {
			
				check = model.cancellaPrenotazione(prenSelezionata);
			}
			
			if (check) {
				PulisciTextField();
				PopUp.infoBox("Prenotazione cancellata con successo", "OK");
				view.getCancellaPanelUfficio().setVisible(false);
				view.getOperatoreUfficioPanel().setVisible(true);
				view.getOperatoreUfficioPanel().setListaPrenotazioni(model.getPazienti());
				view.getOperatoreUfficioPanel().setListaUtenti(model.getPazienti(), model.getMedici(), model.getOperatoriSanitari());
			} else {
				PopUp.infoBox("Dati inseriti non validi", "Errore");
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
