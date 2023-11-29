package it.unipv.sfw.controller.operatoreSanController;

import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class OperatoreSanController {
	private StrutturaSanitaria model;
	private ViewController view;
	
	public OperatoreSanController(StrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
	}

}
