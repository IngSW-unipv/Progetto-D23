package it.unipv.sfw.controller.medicoController;

import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class MedicoController {
	
	private IStrutturaSanitaria model;
	private ViewController view;
	
	public MedicoController(IStrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
	}

}
