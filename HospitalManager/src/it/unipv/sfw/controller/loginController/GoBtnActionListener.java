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

	public GoBtnActionListener (StrutturaSanitaria model, ViewController view) {
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
				view.getMedicoPanel().setListaVisite(model.getPrenotazioniDueToMed(Id));
				view.getMedicoPanel().setVisible(true);
				view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				view.getContentPane().setLayout(null);
				view.getMedicoPanel().setNome(model.getNomeById(Id));
				view.getMedicoPanel().setCognome(model.getCognomeById(Id));
				view.getMedicoPanel().setCf(model.getCfById(Id));
			
			case OS:
				view.setVisible(true);
				view.getOperatoreSanitarioPanel().setListaVisite(model.getPrenotazioni());
				view.getOperatoreSanitarioPanel().setVisible(true);
				view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				view.getContentPane().setLayout(null);
				view.getOperatoreSanitarioPanel().setNome(model.getNomeById(Id));
				view.getOperatoreSanitarioPanel().setCognome(model.getCognomeById(Id));
				view.getOperatoreSanitarioPanel().setCf(model.getCfById(Id));


			case OU:
				view.setVisible(true);
				view.getOperatoreUfficioPanel().setListaVisite(model.getPrenotazioni());
				view.getOperatoreUfficioPanel().setVisible(true);
				view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				view.getContentPane().setLayout(null);
				view.getOperatoreUfficioPanel().setNome(model.getNomeById(Id));
				view.getOperatoreUfficioPanel().setCognome(model.getCognomeById(Id));
				view.getOperatoreUfficioPanel().setCf(model.getCfById(Id));
				

			case PA:
				view.setVisible(true);
				view.getPazientePanel().setListaVisite(model.getPrenotazioniDueToPaz(Id));
				view.getPazientePanel().setVisible(true);
				view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				view.getContentPane().setLayout(null);
				view.getPazientePanel().setNome(model.getNomeById(Id));
				view.getPazientePanel().setCognome(model.getCognomeById(Id));
				view.getPazientePanel().setCf(model.getCfById(Id));


			default:

				PopupError err = new PopupError();

				err.infoBox("Errore", "Username o password incorretti");
				pulisciTextField();
			}
		}
		
	}

	private void pulisciTextField() {
		view.getLoginPanel().getIdAccountText().setText(null);
		view.getLoginPanel().getPasswordField().setText(null);
	}

}
