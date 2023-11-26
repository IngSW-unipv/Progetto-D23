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
import it.unipv.sfw.model.persona.Account;
import it.unipv.sfw.view.ViewController;

public class SuccessivoActionListener implements ActionListener{
	private StrutturaSanitaria model;
	private ViewController view;

	public SuccessivoActionListener(StrutturaSanitaria model, ViewController view) {
		super();
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<SlotCalendarioSingoli> lista = model.getArraySlotLiberi();
		model.incIndexArraySlotLiberi();
		int index = model.getIndexArraySlotLiberi();
		
		SlotCalendarioSingoli nextSlot = lista.get(index);
		LocalDate data = nextSlot.getData();
		LocalTime orario = nextSlot.getOrario();
		
		DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String dataString = data.format(formatterData);
		
		DateTimeFormatter formatterOrario = DateTimeFormatter.ofPattern("hh:mm");
		String orarioString = orario.format(formatterOrario);
		
		String slot = dataString + orarioString;
		
		XMLDecoder d = new XMLDecoder(new ByteArrayInputStream(slot.getBytes()));
	    JLabel slotSuccessivo = (JLabel) d.readObject();
	    d.close();
		
		
		Account acc = model.getUtenteCorrente();
		TipoAccount tipoAcc = acc.getTipoAcc();
	    
	    if(tipoAcc == TipoAccount.PA) {
	    	view.getPrenotatiPanelPaziente().setSlot(slotSuccessivo);
	    }
	    
	    else {
	    	view.getPrenotatiPanelUfficio().setSlot(slotSuccessivo);
	    }
	}

}
