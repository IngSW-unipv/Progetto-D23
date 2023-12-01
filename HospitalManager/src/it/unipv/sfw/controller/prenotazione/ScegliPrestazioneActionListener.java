package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import it.unipv.sfw.model.calendario.SlotCalendarioSingoli;
import it.unipv.sfw.model.persona.Account;
import it.unipv.sfw.model.persona.TipoAccount;
import it.unipv.sfw.model.prenotazione.TipoPrestazione;
import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.PopUp;
import it.unipv.sfw.view.ViewController;

public class ScegliPrestazioneActionListener implements ActionListener{
	private StrutturaSanitaria model;
	private ViewController view;

	public ScegliPrestazioneActionListener(StrutturaSanitaria model, ViewController view) {
		super();
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String s = view.getPrenotatiPanelPaziente().getScegliPrestazione().getSelectedItem().toString();
			TipoPrestazione tipoPrest = TipoPrestazione.valueOf(s);		
			model.impostaSlotLiberiPerPrestazione(tipoPrest);
			//TEST
			System.out.println(model.getArraySlotLiberi().size());
			///////////////
			SlotCalendarioSingoli slot = model.getArraySlotLiberi().get(model.getIndexArraySlotLiberi());
			String data = slot.getData().toString();
			String orario = slot.getOrario().toString();
			
//			DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//			String dataString = data.format(formatterData);
//			
//			DateTimeFormatter formatterOrario = DateTimeFormatter.ofPattern("hh:mm");
//			String orarioString = orario.format(formatterOrario);
			
//			String slot = dataString + orarioString;
			
//			XMLDecoder d = new XMLDecoder(new ByteArrayInputStream(slot.getBytes()));
//		    JLabel slotDaInserire = (JLabel) d.readObject();
//		    d.close();
			
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
