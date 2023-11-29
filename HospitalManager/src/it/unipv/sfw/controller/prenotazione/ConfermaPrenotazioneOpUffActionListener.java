package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import it.unipv.sfw.model.calendario.SlotCalendarioSingoli;
import it.unipv.sfw.model.persona.Account;
import it.unipv.sfw.model.persona.Paziente;
import it.unipv.sfw.model.prenotazione.TipoPrestazione;
import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.PopUp;
import it.unipv.sfw.view.ViewController;

public class ConfermaPrenotazioneOpUffActionListener implements ActionListener {
	private StrutturaSanitaria model;
	private ViewController view;
	private TipoPrestazione tipoPrest;

	public ConfermaPrenotazioneOpUffActionListener(StrutturaSanitaria model, ViewController view) {
		super();
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {

			// tipo di prestazione
			String s = view.getPrenotatiPanelUfficio().getPrestazioneScelta();

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
			
			String CodiceFiscale = view.getPrenotatiPanelUfficio().getCfField().getText();
			
			// data e ora prenotati per la prestazione
			ArrayList<SlotCalendarioSingoli> slotLiberi = model.getArraySlotLiberi();
			int indice = model.getIndexArraySlotLiberi();
			SlotCalendarioSingoli slotCorrente = (SlotCalendarioSingoli) slotLiberi.listIterator(indice);
			LocalDate data = slotCorrente.getData();
			LocalTime orario = slotCorrente.getOrario();
			
			//Paziente
			HashMap<String, Account> listaUtenti = model.getCfPersone();
			Paziente paziente = (Paziente) listaUtenti.get(CodiceFiscale);
			
			model.inserisciPrenotazione(tipoPrest, paziente, data, orario);
			
			view.getPrenotatiPanelUfficio().setVisible(false);
			view.getOperatoreUfficioPanel().setVisible(true);

			
			}catch(Exception e1){
			PopUp err = new PopUp();
			PopUp.infoBox("Ops!", "Qualcosa è andato storto!");
		}
	}
}	
