package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import it.unipv.sfw.model.calendario.SlotCalendarioSingoli;
import it.unipv.sfw.model.persona.IAccount;
import it.unipv.sfw.model.persona.TipoAccount;
import it.unipv.sfw.model.prenotazione.TipoPrestazione;
import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.PopUp;
import it.unipv.sfw.view.ViewController;

public class ScegliPrestazioneActionListener implements ActionListener{
	private IStrutturaSanitaria model;
	private ViewController view;

	public ScegliPrestazioneActionListener(IStrutturaSanitaria model, ViewController view) {
		super();
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			
			IAccount acc = model.getUtenteCorrente();
			TipoAccount tipoAcc = acc.getTipoAcc();
			
			if(tipoAcc == TipoAccount.PA) {
				String s = view.getPrenotatiPanelPaziente().getScegliPrestazione().getSelectedItem().toString();
				TipoPrestazione tipoPrest = TipoPrestazione.valueOf(s);		
				model.impostaSlotLiberiPerPrestazione(tipoPrest);
				SlotCalendarioSingoli slot = model.getArraySlotLiberi().get(model.getIndexArraySlotLiberi());
				String data = slot.getData().toString();
				String orario = slot.getOrario().toString();
		    	view.getPrenotatiPanelPaziente().setSlot(data+" | "+orario);
		    }
			
		    if(tipoAcc == TipoAccount.OU) {
		    	String s = view.getPrenotatiPanelUfficio().getScegliPrestazione().getSelectedItem().toString();
				TipoPrestazione tipoPrest = TipoPrestazione.valueOf(s);		
				model.impostaSlotLiberiPerPrestazione(tipoPrest);
				SlotCalendarioSingoli slot = model.getArraySlotLiberi().get(model.getIndexArraySlotLiberi());
				String data = slot.getData().toString();
				String orario = slot.getOrario().toString();
		    	view.getPrenotatiPanelUfficio().setSlot(data+" | "+orario);
		    }
		}catch(Exception e1) {
			e1.printStackTrace();
			PopUp.infoBox("C'è stato un errore imprevisto!","Ops!");
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
