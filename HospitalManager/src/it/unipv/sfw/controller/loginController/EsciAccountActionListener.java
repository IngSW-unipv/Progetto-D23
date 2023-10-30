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

	
	public EsciAccountActionListener(StrutturaSanitaria model, ViewController view) {
		super();
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {s
		db.getInstance().closeConnection();
		System.exit(0);
	}

}
