package it.unipv.sfw.controller.operatoreSanController;

import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class OperatoreSanController {
	private IStrutturaSanitaria model;
	private ViewController view;
	
	public OperatoreSanController(IStrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
	}

}
