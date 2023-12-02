package it.unipv.sfw.controller.pazienteController;

import it.unipv.sfw.controller.prenotazione.GoBackPazienteActionListener;
import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class PazienteController {
	private IStrutturaSanitaria model;
	private ViewController view;
	
	public PazienteController(IStrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
		

		AggiornaCartellaClinicaActionListener aggCartClin = new AggiornaCartellaClinicaActionListener(model, view);
		view.getAggiornaCartellaClinicaPanel().getBtnAggiorna().addActionListener(aggCartClin);
	
		GoBackPazienteActionListener goBack = new GoBackPazienteActionListener(model, view);
		view.getAggiornaCartellaClinicaPanel().getBtnBack().addActionListener(goBack);
	}
			
}
