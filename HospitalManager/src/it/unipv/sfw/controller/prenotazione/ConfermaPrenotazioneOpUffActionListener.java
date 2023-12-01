package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
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
			String s = view.getPrenotatiPanelPaziente().getScegliPrestazione().getSelectedItem().toString();
			tipoPrest = TipoPrestazione.valueOf(s);
			
			String cf = view.getPrenotatiPanelUfficio().getCfField().getText();
			
			// data e ora prenotati per la prestazione
			SlotCalendarioSingoli slotCorrente = model.getArraySlotLiberi().get(model.getIndexArraySlotLiberi());
			LocalDate data = slotCorrente.getData();
			LocalTime orario = slotCorrente.getOrario();
			
			//Paziente
			HashMap<String, Account> listaUtenti = model.getCfPersone();
			Paziente paziente = (Paziente) listaUtenti.get(cf);
			
			boolean check = model.inserisciPrenotazione(tipoPrest, paziente, data, orario);
			
			if (check == true) {
				PopUp.infoBox("Prenotazione cancellata con successo", "OK");
				view.getPrenotatiPanelUfficio().setVisible(false);
				view.getOperatoreUfficioPanel().setVisible(true);
			} else {
				PopUp.infoBox("Qualcosa è andato storto!","Errore");
			}
			

			
			}catch(Exception e1){
			e1.printStackTrace();
		}
	}
}	
