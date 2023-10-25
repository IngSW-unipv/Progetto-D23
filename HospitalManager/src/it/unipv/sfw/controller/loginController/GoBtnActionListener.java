package it.unipv.sfw.controller.loginController;

import java.awt.*;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.view.ViewController;
//import it.unipv.sfw.jdbc.bean.DbControllerSingleton;
import it.unipv.sfw.model.StrutturaSanitaria;
import it.unipv.sfw.model.TipoAccount; 


public class GoBtnActionListener implements ActionListener {

	private ViewController view;
	private StrutturaSanitaria model;
	//private DbControllerSingleton dbControl;
	private String CF;

	public GoBtnActionListener (ViewController view, StrutturaSanitaria model) {
		super();
		this.view = view;
		this.model = model;
		//dbControl = DbControllerSingleton.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int Id = Integer.parseInt(view.getLoginPanel().getIdAccountText().getText());
		String pw = view.getLoginPanel().getPasswordField().toString();
		
		boolean isMatching = model.login(Id, pw);  

		if(isMatching) {
			view.getLoginPanel().setVisible(false);
			Toolkit kit = Toolkit.getDefaultToolkit();
			Dimension screenSize = kit.getScreenSize();
			
			int screenHeight= screenSize.height;
			int screenWidth = screenSize.width;
			
			//serve per centrare il frame nello schermo
			view.setSize(screenWidth, screenHeight);
			view.setLocationRelativeTo(null);
			
			TipoAccount tipoAcc = model.getTipoAccount(Id);
			
			switch(tipoAcc) {
			case ME: 
			view.setVisible(true);
			view.getMedicoPanel().setListaVisite(model.selectAllAppuntamentiDueToMed(Id));
			view.getMedicoPanel().setVisible(true);
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.getContentPane().setLayout(null);
			}
		}
		
	}

}
