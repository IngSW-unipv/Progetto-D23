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

			// tipo di prestazione
			String s = view.getPrenotatiPanelPaziente().getPrestazioneScelta();

			switch (s) {
			case "Visita Oncologica":
				tipoPrest = TipoPrestazione.VISITA_ONCOLOGICA;
				break;

			case "Visita Psicologica":
				tipoPrest = TipoPrestazione.VISITA_PSICOLOGICA;
				break;

			case "Esami Sangue":
				tipoPrest = TipoPrestazione.ESAMI_SANGUE;
				break;

			case "Tac":
				tipoPrest = TipoPrestazione.TAC;
				break;

			case "Risonanza Magnetica":
				tipoPrest = TipoPrestazione.RISONANZA_MAGNETICA;
				break;

			case "Chemioterapia":
				tipoPrest = TipoPrestazione.CHEMIOTERAPIA;
				break;

			case "Radioterapia":
				tipoPrest = TipoPrestazione.RADIOTERAPIA;
				break;

			default:
				tipoPrest = TipoPrestazione.ESAMI_SANGUE;
			}

			// Personale sanitario che effettua la prestazione
			HashMap<TipoPrestazione, Account> mappa = model.getPersonaleSanitario();
			Account personaleSanitario = mappa.get(tipoPrest);

			// data e ora prenotati per la prestazione
			ArrayList<SlotCalendarioSingoli> slotLiberi = model.getArraySlotLiberi();
			int indice = model.getIndexArraySlotLiberi();
			SlotCalendarioSingoli slotCorrente = (SlotCalendarioSingoli) slotLiberi.listIterator(indice);
			LocalDate data = slotCorrente.getData();
			LocalTime orario = slotCorrente.getOrario();

			// paziente
			Paziente paz = (Paziente) model.getUtenteCorrente();

			model.inserisciPrenotazione(tipoPrest, paz, data, orario);
			
			view.getPrenotatiPanelPaziente().setVisible(false);
			view.getPazientePanel().setVisible(true);

		} catch (Exception e1) {
			PopUp err = new PopUp();
			PopUp.infoBox("Ops!", "Qualcosa è andato storto!");
		}

	}

}
