package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import it.unipv.sfw.model.calendario.SlotCalendarioSingoli;
import it.unipv.sfw.model.persona.Account;
import it.unipv.sfw.model.persona.TipoAccount;
import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.PopUp;
import it.unipv.sfw.view.ViewController;

public class PrecedenteActionListener implements ActionListener{
	private StrutturaSanitaria model;
	private ViewController view;

	public PrecedenteActionListener(StrutturaSanitaria model, ViewController view) {
		super();
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(model.getIndexArraySlotLiberi()>0) {
				model.decIndexArraySlotLiberi();
			}
			
			
			SlotCalendarioSingoli slot = model.getArraySlotLiberi().get(model.getIndexArraySlotLiberi());
			String data = slot.getData().toString();
			String orario = slot.getOrario().toString();
			
		    Account acc = model.getUtenteCorrente();
			TipoAccount tipoAcc = acc.getTipoAcc();
		    
		    if(tipoAcc == TipoAccount.PA) {
		    	view.getPrenotatiPanelPaziente().setSlot(data+" | "+orario);
		    }
		    
		    else {
		    	view.getPrenotatiPanelUfficio().setSlot(data+" | "+orario);
		    }
		    
		}catch(Exception e1) {
			e1.printStackTrace();
			PopUp.infoBox("Qualcosa è andato storto!","Ops!");
		}
		
	}

}

