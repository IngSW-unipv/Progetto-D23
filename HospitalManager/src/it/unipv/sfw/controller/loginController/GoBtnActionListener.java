package it.unipv.sfw.controller.loginController;

import java.awt.*; 

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.view.PopUp;
import it.unipv.sfw.view.ViewController;
import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.model.cartellaclinica.GruppiSanguigni;
import it.unipv.sfw.model.persona.*;


public class GoBtnActionListener implements ActionListener {

	private ViewController view;
	private StrutturaSanitaria model;

	public GoBtnActionListener (StrutturaSanitaria model, ViewController view) {
		super();
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cf = view.getLoginPanel().getCfText().getText();
		String pw = String.valueOf(view.getLoginPanel().getPasswordField().getPassword());	
		boolean isMatching = model.login(cf, pw);  

		if(isMatching) {
			view.getLoginPanel().setVisible(false);
//			Toolkit kit = Toolkit.getDefaultToolkit();
//			Dimension screenSize = kit.getScreenSize();
//			
//			int screenHeight= screenSize.height;
//			int screenWidth = screenSize.width;
//			
//			//serve per centrare il frame nello schermo
//			view.setSize(screenWidth, screenHeight);
//			view.setLocationRelativeTo(null);
			
			Account acc = model.getCfPersone().get(cf);
			TipoAccount tipoAcc = acc.getTipoAcc();
			model.aggiornaPrenotazioni();
			model.setUtenteCorrente(cf);
			
			switch(tipoAcc) {
			case ME: 
				view.getLoginPanel().setVisible(false);
				view.getMedicoPanel().setVisible(true);
				Medico m = (Medico) acc;
				view.getMedicoPanel().setListaPrenotazioni(m.getCalendario());
				view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				view.getContentPane().setLayout(null);
				view.getMedicoPanel().setNome(m.getNome());
				view.getMedicoPanel().setCognome(m.getCognome());
				view.getMedicoPanel().setCf(m.getCf());
				break;
			
			case OS:
				view.getLoginPanel().setVisible(false);
				view.getOperatoreSanitarioPanel().setVisible(true);
				OperatoreSanitario op = (OperatoreSanitario)acc;
				//togliere commento dopo aver aggiornato OperatoreSanotarioPanel
				//view.getOperatoreSanitarioPanel().setListaVisite(op.getCalendario());
				view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				view.getContentPane().setLayout(null);
				view.getOperatoreSanitarioPanel().setNome(op.getNome());
				view.getOperatoreSanitarioPanel().setCognome(op.getCognome());
				view.getOperatoreSanitarioPanel().setCf(op.getCf());
				break;

			case OU:
				view.getLoginPanel().setVisible(false);
				view.getOperatoreUfficioPanel().setVisible(true);
				OperatoreUfficio ou = (OperatoreUfficio) acc;
				//sistemare dopo aver aggiornato OpertoreUfficioPanel
				//view.getOperatoreUfficioPanel().setListaVisite();
				view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				view.getContentPane().setLayout(null);
				view.getOperatoreUfficioPanel().setNome(ou.getNome());
				view.getOperatoreUfficioPanel().setCognome(ou.getCognome());
				view.getOperatoreUfficioPanel().setCf(ou.getCf());
				break;

			case PA:
				view.getLoginPanel().setVisible(false);
				view.getPazientePanel().setVisible(true);
				Paziente p =(Paziente)acc;		
				view.getPazientePanel().setListaPrenotazioni(p.getPrenotazioni());
				view.getPazientePanel().setListaPrenotazioniErogate(p.getCartellaPersonale().getPrenotazioni());
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
				break;

			default:
				break;				
			}
		}else {
			PopUp.infoBox("Username o password incorretti", "Errore");
			pulisciTextField();
		}
		
	}

	private void pulisciTextField() {
		view.getLoginPanel().getCfText().setText(null);
		view.getLoginPanel().getPasswordField().setText(null);
	}

}
