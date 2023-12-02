package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;

import it.unipv.sfw.model.calendario.SlotCalendarioSingoli;
import it.unipv.sfw.model.persona.Account;
import it.unipv.sfw.model.persona.Paziente;
import it.unipv.sfw.model.prenotazione.Prenotazione;
import it.unipv.sfw.model.prenotazione.PrestazioneSanitaria;
import it.unipv.sfw.model.prenotazione.TipoPrestazione;
import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.PopUp;
import it.unipv.sfw.view.ViewController;

public class ConfermaPrenotazionePazienteActionListener implements ActionListener {

	private StrutturaSanitaria model;
	private ViewController view;
	private TipoPrestazione tipoPrest;

	public ConfermaPrenotazionePazienteActionListener(StrutturaSanitaria model, ViewController view) {
		super();
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			String s = view.getPrenotatiPanelPaziente().getScegliPrestazione().getSelectedItem().toString();
			tipoPrest = TipoPrestazione.valueOf(s);
			// Personale sanitario che effettua la prestazione
			HashMap<TipoPrestazione, Account> mappa = model.getPersonaleSanitario();
			Account personaleSanitario = mappa.get(tipoPrest);

			// data e ora prenotati per la prestazione
			SlotCalendarioSingoli slotCorrente = model.getArraySlotLiberi().get(model.getIndexArraySlotLiberi());
			LocalDate data = slotCorrente.getData();
			LocalTime orario = slotCorrente.getOrario();

			// paziente
			Paziente paz = (Paziente) model.getUtenteCorrente();

			boolean check = model.inserisciPrenotazione(tipoPrest, paz, data, orario);
			
			if (check == true) {
				PopUp.infoBox("Prenotazione cancellata con successo", "OK");
				pulisciTextFields();
				view.getPrenotatiPanelPaziente().setVisible(false);
				view.getPazientePanel().setVisible(true);
			} else {
				PopUp.infoBox("Qualcosa è andato storto!","Errore");
			}
			
			

		} catch (Exception e1) {
			e1.printStackTrace();
			PopUp.infoBox("Conferma Prenotazione!","Errore");
		}

	}

	private void pulisciTextFields() {
		view.getPrenotatiPanelPaziente().getSlot().setText(null);
	}

}
