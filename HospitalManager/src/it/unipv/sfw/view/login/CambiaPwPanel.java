package it.unipv.sfw.view.login;

import java.awt.GridLayout;

import javax.swing.*;

public class CambiaPwPanel extends JPanel{
	
	private JLabel vecchiaPw, nuovaPw;
	private JPasswordField oldPw, newPw;
	private JButton conferma, indietro;

	public CambiaPwPanel() {
		
		setLayout(new GridLayout(3,3));
		
		oldPw = new JPasswordField();
		newPw = new JPasswordField();
		conferma = new JButton("CONFERMA PASSWORD");
		vecchiaPw = new JLabel("DIGITA VECCHIA PASSWORD");
		nuovaPw = new JLabel("DIGITA NUOVA PASSWORD");
		indietro = new JButton("INDIETRO");
		
		add(vecchiaPw);
		add(oldPw);
		add(nuovaPw);
		add(newPw);
		add(indietro);
		add(conferma);
		
	}

	public JButton getConfermaBtn() {
		return conferma;
	}
}
