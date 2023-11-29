package it.unipv.sfw.controller.loginController;

import java.awt.*; 

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.view.PopUpError;
import it.unipv.sfw.view.ViewController;
import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.model.cartellaclinica.GruppiSanguigni;
import it.unipv.sfw.model.persona.*;


public class GoBtnActionListener implements ActionListener {

	private ViewController view;
	private static StrutturaSanitaria model;
	private String Cf;

	public GoBtnActionListener (StrutturaSanitaria model, ViewController view) {
		super();
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String Cf = view.getLoginPanel().getCfText().getText();
		String pw = view.getLoginPanel().getPasswordField().toString();
		
		boolean isMatching = model.login(Cf, pw);  

		if(isMatching) {
			view.getLoginPanel().setVisible(false);
			Toolkit kit = Toolkit.getDefaultToolkit();
			Dimension screenSize = kit.getScreenSize();
			
			int screenHeight= screenSize.height;
			int screenWidth = screenSize.width;
			
			//serve per centrare il frame nello schermo
			view.setSize(screenWidth, screenHeight);
			view.setLocationRelativeTo(null);
			
			Account acc = model.getCfPersone().get(Cf);
			TipoAccount tipoAcc = acc.getTipoAcc();
			model.setUtenteCorrente(Cf);
			
			switch(tipoAcc) {
			case ME: 
				
				Medico med = (Medico) acc;
				view.getMedicoPanel().setListaVisite(med.getCalendario());
				view.getMedicoPanel().setVisible(true);
				view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				view.getContentPane().setLayout(null);
				view.getMedicoPanel().setNome(med.getNome());
				view.getMedicoPanel().setCognome(med.getCognome());
				view.getMedicoPanel().setCf(med.getCf());
			
			case OS:
				
				OperatoreSanitario Op = (OperatoreSanitario)acc;
				view.getOperatoreSanitarioPanel().setListaVisite(model.getPrestazioni());
				view.getOperatoreSanitarioPanel().setVisible(true);
				view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				view.getContentPane().setLayout(null);
				view.getOperatoreSanitarioPanel().setNome(Op.getNome());
				view.getOperatoreSanitarioPanel().setCognome(Op.getCognome());
				view.getOperatoreSanitarioPanel().setCf(Op.getCf());


			case OU:
				
				OperatoreUfficio Ou = (OperatoreUfficio) acc;
				view.getOperatoreUfficioPanel().setListaVisite(model.getPrestazioni());
				view.getOperatoreUfficioPanel().setVisible(true);
				view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				view.getContentPane().setLayout(null);
				view.getOperatoreUfficioPanel().setNome(Ou.getNome());
				view.getOperatoreUfficioPanel().setCognome(Ou.getCognome());
				view.getOperatoreUfficioPanel().setCf(Ou.getCf());
				

			case PA:
				
				Paziente p =(Paziente)acc;		
				view.getPazientePanel().setListaVisite(p.getPrenotazioni());
				view.getPazientePanel().setVisible(true);
				view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				view.getContentPane().setLayout(null);
				view.getPazientePanel().setNome(p.getNome());
				view.getPazientePanel().setCognome(p.getCognome());
				view.getPazientePanel().setCf(p.getCf());
				
				//metto l'altezza nella JLabel
				double altezzaDouble = p.getCartellaPersonale().getAltezza();
				String altezzaString = Double.toString(altezzaDouble);
				view.getPazientePanel().setAltezza(altezzaString);

				//metto il peso nella JLabel
				double pesoDouble = p.getCartellaPersonale().getPeso();
				String pesoString = Double.toString(pesoDouble);
				view.getPazientePanel().setPeso(pesoString);

				//metto il gruppo sanguigno nella JLabel
				GruppiSanguigni sangue = p.getCartellaPersonale().getGruppoSanguigno();
				String stringaGruppo = sangue.name();
				view.getPazientePanel().setGruppoSanguigno(stringaGruppo);


			default:

				PopUpError err = new PopUpError();

				PopUpError.infoBox("Errore", "Username o password incorretti");
				pulisciTextField();
			}
		}
		
	}

	private void pulisciTextField() {
		view.getLoginPanel().getCfText().setText(null);
		view.getLoginPanel().getPasswordField().setText(null);
	}

}
