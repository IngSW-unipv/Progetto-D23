package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import javax.swing.JLabel;

import it.unipv.sfw.model.prenotazione.Prenotazione;
import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class CercaPrenDaCancellarePaziente implements ActionListener{
	private StrutturaSanitaria model;
	private ViewController view;
	
	public CercaPrenDaCancellarePaziente (StrutturaSanitaria model, ViewController view) {
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
			
			LocalDate data = prenSelezionata.getData();
			LocalTime orario = prenSelezionata.getOrario();
			
			DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			String dataString = data.format(formatterData);
			
			DateTimeFormatter formatterOrario = DateTimeFormatter.ofPattern("hh:mm");
			String orarioString = orario.format(formatterOrario);
			
			String slot = dataString + orarioString;
			
			XMLDecoder d = new XMLDecoder(new ByteArrayInputStream(slot.getBytes()));
		    JLabel slotDaCancellare = (JLabel) d.readObject();
		    d.close();
		    
		    view.getCancellaPanelPaziente().setSlot(slotDaCancellare);
			
		} catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}

}

