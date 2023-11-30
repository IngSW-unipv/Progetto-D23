package it.unipv.sfw.view.account;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class OperatoreSanitarioPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel nome, cognome, cf, tipoAccount;
	private JLabel pNome, pCognome, pCf, pTipoAccount;
	private JList visite;
	private JButton logout, cambiaPw;
	private DefaultListModel modelloLista;
	private JLabel appuntamenti;
	
	public OperatoreSanitarioPanel() {
		setLayout(new GridLayout(3,1));
		
		JPanel barNord = new JPanel();
		barNord.setLayout(new BorderLayout());
		JPanel barSud = new JPanel();
		barSud.setLayout(new GridLayout(8,1));
		JPanel barCentro = new JPanel();
		barCentro.setLayout(new GridLayout(2,1));
		
		nome = new JLabel("NOME:");
		pNome = new JLabel("Lele");
		cognome = new JLabel("COGNOME:");
		pCognome = new JLabel("Adani");
		cf = new JLabel("CF:");
		pCf = new JLabel("DNALLE79T09A045S");
		tipoAccount = new JLabel("TIPO ACCOUNT");
		pTipoAccount = new JLabel("Operatore Sanitario");
		logout = new JButton("LOGOUT");
		cambiaPw = new JButton("CAMBIA PASSWORD");
		appuntamenti = new JLabel("APPUNTAMENTI");
		
		visite = new JList();
		visite.setPreferredSize(new Dimension(700, 500));
		modelloLista = new DefaultListModel();
		
		visite.setModel(modelloLista);
		
		
		barNord.add(appuntamenti, BorderLayout.PAGE_START);
		barNord.add(new JScrollPane(visite), BorderLayout.CENTER);
		add(barNord);
		
		barCentro.add(cambiaPw);
		barCentro.add(logout);
		add(barCentro);
		
		barSud.add(nome);
		barSud.add(pNome);
		barSud.add(cognome);
		barSud.add(pCognome);
		barSud.add(cf);
		barSud.add(pCf);
		barSud.add(tipoAccount);
		barSud.add(pTipoAccount);
		add(barSud);
		
	}
	
	
	public void setNome(String nome) {
	    pNome.setText(nome);
	}

	public void setCognome(String cognome) {
		pCognome.setText(cognome);
	}

	public void setCf(String cf) {
		pCf.setText(cf);
	}

	public JButton getLogoutBtn() {
		return logout;
	}
	
	public JButton getCambiaPw() {
		return cambiaPw;
	}
}

