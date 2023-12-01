package it.unipv.sfw.controller.pazienteController;

import it.unipv.sfw.controller.prenotazione.GoBackPazienteActionListener;
import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class PazienteController {
	private StrutturaSanitaria model;
	private ViewController view;
	
	public PazienteController(StrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
		
		BtnCartellaClinica btnCartClin = new BtnCartellaClinica(model, view);
		view.getPazientePanel().getAggiornaCartellaBtn().addActionListener(btnCartClin);

		AggiornaCartellaClinicaActionListener aggCartClin = new AggiornaCartellaClinicaActionListener(model, view);
		view.getAggiornaCartellaClinicaPanel().getBtnAggiorna().addActionListener(aggCartClin);
	
		GoBackPazienteActionListener goBack = new GoBackPazienteActionListener(model, view);
		view.getAggiornaCartellaClinicaPanel().getBtnBack().addActionListener(goBack);
	}
			
}
