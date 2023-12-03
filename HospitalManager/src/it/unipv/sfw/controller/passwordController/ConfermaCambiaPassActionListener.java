package it.unipv.sfw.controller.passwordController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.model.persona.IAccount;
import it.unipv.sfw.model.persona.TipoAccount;
import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.PopUp;
import it.unipv.sfw.view.ViewController;

public class ConfermaCambiaPassActionListener implements ActionListener{
	private IStrutturaSanitaria model;
	private ViewController view;

	public ConfermaCambiaPassActionListener(IStrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {

			String oldPass = new String(view.getCambiaPwPanel().getOldPw().getPassword());
			String newPass = new String(view.getCambiaPwPanel().getNewPw().getPassword());
			IAccount acc = model.getUtenteCorrente();
			String cf = acc.getCf();
			TipoAccount tipoAcc = acc.getTipoAcc();

			Boolean check = model.cambioPw(cf, oldPass, newPass);

			if(check){
				view.getCambiaPwPanel().setNewPass(null);
				view.getCambiaPwPanel().setOldPass(null);
				
				
				PopUp.infoBox("Password cambiata con successo", "OK");

				switch(tipoAcc){

					case PA:
					view.getCambiaPwPanel().setVisible(false);
					view.getPazientePanel().setVisible(true);
					view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					break;

					case ME:
					view.getCambiaPwPanel().setVisible(false);
					view.getMedicoPanel().setVisible(true);
					view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					break;

					case OS:
					view.getCambiaPwPanel().setVisible(false);
					view.getOperatoreSanitarioPanel().setVisible(true);
					view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					break;
				}
			} else {
				PopUp.infoBox("C'è stato un errore nel cambio password", "Errore");
			}

		} catch (Exception e1){
			PopUp.infoBox("Errore: password sbagliata", "Errore");
		}

	}

}
