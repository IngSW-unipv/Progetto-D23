package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import it.unipv.sfw.model.prenotazione.IPrenotazione;
import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.PopUp;
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
			
			IPrenotazione prenSelezionata = model.getIdPrenotazioni().get(idPren);
			
			
			if(prenSelezionata.getPaziente().getCf() == model.getUtenteCorrente().getCf()) {
			
			String data = prenSelezionata.getData().toString();
			String orario = prenSelezionata.getOrario().toString();
		    
		    view.getCancellaPanelPaziente().setSlot(data+" | "+orario);
			}else {
				PopUp.infoBox("Id prenotazione non valido!","Errore");
			}
			
		} catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}

}

