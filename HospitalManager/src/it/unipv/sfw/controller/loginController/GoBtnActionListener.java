package it.unipv.sfw.controller.loginController;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.view.PopUp;
import it.unipv.sfw.view.ViewController;
import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.model.cartellaclinica.GruppiSanguigni;
import it.unipv.sfw.model.persona.*;


public class GoBtnActionListener implements ActionListener {

	private ViewController view;
	private IStrutturaSanitaria model;

	public GoBtnActionListener (IStrutturaSanitaria model, ViewController view) {
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
			IAccount acc = model.getCfPersone().get(cf);
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
				view.getOperatoreSanitarioPanel().setListaVisite(op.getCalendario());
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
				view.getOperatoreUfficioPanel().setListaPrenotazioni(model.getPazienti());
				view.getOperatoreUfficioPanel().setListaUtenti(model.getPazienti(), model.getMedici(), model.getOperatoriSanitari());
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
