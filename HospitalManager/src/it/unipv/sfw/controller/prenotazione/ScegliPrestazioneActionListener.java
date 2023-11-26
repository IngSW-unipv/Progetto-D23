package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JLabel;

import it.unipv.sfw.jdbc.bean.calendario.SlotCalendarioSingoloDB;
import it.unipv.sfw.model.SlotCalendarioSingoli;
import it.unipv.sfw.model.StrutturaSanitaria;
import it.unipv.sfw.model.TipoAccount;
import it.unipv.sfw.model.TipoPrestazione;
import it.unipv.sfw.model.persona.Account;
import it.unipv.sfw.view.ViewController;

public class ScegliPrestazioneActionListener implements ActionListener{
	private StrutturaSanitaria model;
	private ViewController view;
	private TipoPrestazione tipoPrest;

	public ScegliPrestazioneActionListener(StrutturaSanitaria model, ViewController view) {
		super();
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = (String) view.getPrenotatiPanelPaziente().getScegliPrestazione().getSelectedItem();
		
		switch (s) {
		case "Visita Oncologica" : 
			tipoPrest = TipoPrestazione.VISITA_ONCOLOGICA;
			break;
		
		case "Visita Psicologica" :
			tipoPrest = TipoPrestazione.VISITA_PSICOLOGICA;
			break;
			
		case "Esami Sangue":
			tipoPrest = TipoPrestazione.ESAME_SANGUE;
			break;
			
		case "Tac":
			tipoPrest = TipoPrestazione.TAC;
			break;
			
		case "Risonanza Magnetica":
			tipoPrest = TipoPrestazione.RISONANZA_MAGNETICA;
			break;
			
		case "Chemioterapia" :
			tipoPrest = TipoPrestazione.CHEMIOTERAPIA;
			break;
			
		case "Radioterapia" :
			tipoPrest = TipoPrestazione.RADIOTERAPIA;
			break;
				
		default:
			tipoPrest = TipoPrestazione.ESAME_SANGUE;
		}
		
		ArrayList<SlotCalendarioSingoli> slot_liberi = model.getArraySlotLiberiOriginale(tipoPrest);
		model.setArraySlotLiberi(slot_liberi);
		SlotCalendarioSingoli primo_slot = (SlotCalendarioSingoli) slot_liberi.listIterator(0);
		LocalDate data = primo_slot.getData();
		LocalTime orario = primo_slot.getOrario();
		
		DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String dataString = data.format(formatterData);
		
		DateTimeFormatter formatterOrario = DateTimeFormatter.ofPattern("hh:mm");
		String orarioString = orario.format(formatterOrario);
		
		String slot = dataString + orarioString;
		
		XMLDecoder d = new XMLDecoder(new ByteArrayInputStream(slot.getBytes()));
	    JLabel slot_da_inserire = (JLabel) d.readObject();
	    d.close();
	    
	    Account acc = model.getUtenteCorrente();
		TipoAccount tipoAcc = acc.getTipoAcc();
	    
	    if(tipoAcc == TipoAccount.PA) {
	    	view.getPrenotatiPanelPaziente().setSlot(slot_da_inserire);
	    }
	    
	    else {
	    	view.getPrenotatiPanelUfficio().setSlot(slot_da_inserire);
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
