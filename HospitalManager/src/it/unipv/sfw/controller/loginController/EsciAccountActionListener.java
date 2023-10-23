package it.unipv.sfw.controller.loginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.view.ViewController;
import it.unipv.sfw.jdbc.bean.DbSingleton;
import it.unipv.sfw.model.StrutturaSanitaria; 



public class EsciAccountActionListener implements ActionListener {
	
	//private DbSingleton db;
	private ViewController view;
	private StrutturaSanitaria model;

	
	public EsciAccountActionListener(ViewController view, StrutturaSanitaria model) {
		super();
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		db.getInstance().closeConnection();
		System.exit(0);
	}

}
