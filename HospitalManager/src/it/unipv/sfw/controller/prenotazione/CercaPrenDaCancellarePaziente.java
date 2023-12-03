package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.util.HashMap;

import it.unipv.sfw.model.prenotazione.Prenotazione;
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
			//TEST
			System.out.println(s + "\n" + idPren);
			//
			Prenotazione prenSelezionata = model.getIdPrenotazioni().get(idPren);
			
			//TEST
			System.out.println(prenSelezionata);
			//
			
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

