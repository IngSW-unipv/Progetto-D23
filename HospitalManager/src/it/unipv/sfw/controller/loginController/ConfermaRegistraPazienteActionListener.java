package it.unipv.sfw.controller.loginController;

import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.model.cartellaclinica.GruppiSanguigni;
import it.unipv.sfw.model.persona.IAccount;
import it.unipv.sfw.model.persona.Sesso;
import it.unipv.sfw.model.persona.TipoAccount;
import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.PopUp;
import it.unipv.sfw.view.ViewController;

public class ConfermaRegistraPazienteActionListener implements ActionListener{
	private IStrutturaSanitaria model;
	private ViewController view;

	public ConfermaRegistraPazienteActionListener(IStrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			String nome = view.getRegistratiPanelPaziente().getNomeField().getText();
			String cognome = view.getRegistratiPanelPaziente().getCognomeField().getText();
			String cf = view.getRegistratiPanelPaziente().getCfField().getText();
			String dataNascita = view.getRegistratiPanelPaziente().getDataNascitaField().getText();
			String luogoNascita = view.getRegistratiPanelPaziente().getLuogoNascitaField().getText();
			String provinciaNascita = view.getRegistratiPanelPaziente().getProvinciaNascitaField().getText();
			String regResidenza = view.getRegistratiPanelPaziente().getRegioneResidenzaField().getText();
			String provResidenza = view.getRegistratiPanelPaziente().getProvinciaResidenzaField().getText();
			String cittaRes = view.getRegistratiPanelPaziente().getCittaResidenzaField().getText();
			String indirizzo = view.getRegistratiPanelPaziente().getIndirizzoField().getText();
			String email = view.getRegistratiPanelPaziente().getEmailField().getText();
			String cellulare = view.getRegistratiPanelPaziente().getCellulareField().getText();
			String pw = String.valueOf(view.getRegistratiPanelPaziente().getPasswordField().getPassword());
			String cap = view.getRegistratiPanelPaziente().getCapField().getText();
			String sesso = view.getRegistratiPanelPaziente().getSessoScelto();
			String altezza = view.getRegistratiPanelPaziente().getAltezzaField().getText();
			String peso = view.getRegistratiPanelPaziente().getPesoField().getText();
			String gruppoSanguigno = view.getRegistratiPanelPaziente().getGruppoScelto();
						
			Boolean check = model.registrazioneAccount(cf, pw, TipoAccount.PA, nome, cognome, Sesso.valueOf(sesso), dataNascita, luogoNascita, provinciaNascita, regResidenza, provResidenza, cittaRes,
						indirizzo, cap, email, cellulare, Double.parseDouble(altezza), Double.parseDouble(peso), GruppiSanguigni.valueOf(gruppoSanguigno));
			
			
			if (check) {
				
				IAccount acc = model.getUtenteCorrente();
				if(acc == null) {
					pulisciTextField();
					PopUp.infoBox("Nuovo account creato", "OK");
					view.getRegistratiPanelPaziente().setVisible(false);
					view.getLoginPanel().setVisible(true);
					view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
				}else if(acc.getTipoAcc() == TipoAccount.OU){
					
					pulisciTextField();
					PopUp.infoBox("Nuovo account creato", "OK");
					view.getRegistratiPanelPaziente().setVisible(false);
					view.getOperatoreUfficioPanel().setVisible(true);
					view.getOperatoreUfficioPanel().setListaPrenotazioni(model.getPazienti());
					view.getOperatoreUfficioPanel().setListaUtenti(model.getPazienti(), model.getMedici(), model.getOperatoriSanitari());
					view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			} else {
				PopUp.infoBox("C'è stato un errore", "Errore");
			}
			
		}
	
		catch(Exception e1){
			e1.printStackTrace();
			pulisciTextField();
		}
	}

	private void pulisciTextField() {
		view.getRegistratiPanelPaziente().getNomeField().setText(null);
		view.getRegistratiPanelPaziente().getCognomeField().setText(null);
		view.getRegistratiPanelPaziente().getCfField().setText(null);
		view.getRegistratiPanelPaziente().getDataNascitaField().setText(null);
		view.getRegistratiPanelPaziente().getLuogoNascitaField().setText(null);
		view.getRegistratiPanelPaziente().getProvinciaNascitaField().setText(null);
		view.getRegistratiPanelPaziente().getRegioneResidenzaField().setText(null);
		view.getRegistratiPanelPaziente().getProvinciaResidenzaField().setText(null);
		view.getRegistratiPanelPaziente().getCittaResidenzaField().setText(null);
		view.getRegistratiPanelPaziente().getIndirizzoField().setText(null);
		view.getRegistratiPanelPaziente().getEmailField().setText(null);
		view.getRegistratiPanelPaziente().getCellulareField().setText(null);
		view.getRegistratiPanelPaziente().getPasswordField().setText(null);
		view.getRegistratiPanelPaziente().getCapField().setText(null);
		view.getRegistratiPanelPaziente().getAltezzaField().setText(null);
		view.getRegistratiPanelPaziente().getPesoField().setText(null);
		view.getRegistratiPanelPaziente().getScegliSesso().setSelectedIndex(0);
		view.getRegistratiPanelPaziente().getScegliGruppo().setSelectedIndex(0);
	}

}
