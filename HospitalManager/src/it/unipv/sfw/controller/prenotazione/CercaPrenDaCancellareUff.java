package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.util.HashMap;

import it.unipv.sfw.model.prenotazione.IPrenotazione;
import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.PopUp;
import it.unipv.sfw.view.ViewController;

public class CercaPrenDaCancellareUff implements ActionListener{
	private IStrutturaSanitaria model;
	private ViewController view;
	
	public CercaPrenDaCancellareUff (IStrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			String cfPaziente = view.getCancellaPanelUfficio().getCf().getText();
			String s = view.getCancellaPanelUfficio().getIdPrenotazione().getText();
			int idPren = Integer.valueOf(s);
		
//			HashMap<Integer, IPrenotazione> mappaPrenotazioni = model.getIdPrenotazioni();
//			IPrenotazione prenSelezionata = mappaPrenotazioni.get(idPren);
			//TEST
			System.out.println(s + "\n" + idPren);
			//
			IPrenotazione prenSelezionata = model.getIdPrenotazioni().get(idPren);
			
			//TEST
			System.out.println(prenSelezionata);
			
			boolean check = prenSelezionata.getPaziente().getCf().equals(cfPaziente);
			
			String data = prenSelezionata.getData().toString();
			String orario = prenSelezionata.getOrario().toString();
		    
			if(check) {
				view.getCancellaPanelUfficio().setSlot(data+" | "+orario);
			} else {
				PopUp.infoBox("Controlla dati inseriti", "Errore");
			}
		    
			
		} catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}

}
