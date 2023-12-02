package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.util.HashMap;

import it.unipv.sfw.model.prenotazione.Prenotazione;
import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class CercaPrenDaCancellarePaziente implements ActionListener{
	private IStrutturaSanitaria model;
	private ViewController view;
	
	public CercaPrenDaCancellarePaziente (IStrutturaSanitaria model, ViewController view) {
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
			
			String data = prenSelezionata.getData().toString();
			String orario = prenSelezionata.getOrario().toString();
			
//			DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//			String dataString = data.format(formatterData);
//			
//			DateTimeFormatter formatterOrario = DateTimeFormatter.ofPattern("hh:mm");
//			String orarioString = orario.format(formatterOrario);
//			
//			String slot = dataString + orarioString;
//			
//			XMLDecoder d = new XMLDecoder(new ByteArrayInputStream(slot.getBytes()));
//		    JLabel slotDaCancellare = (JLabel) d.readObject();
//		    d.close();
		    
		    view.getCancellaPanelPaziente().setSlot(data+" | "+orario);
			
		} catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}

}

