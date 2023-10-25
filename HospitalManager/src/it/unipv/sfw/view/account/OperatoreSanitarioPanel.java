package it.unipv.sfw.view.account;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class OperatoreSanitarioPanel extends JPanel{
	private JLabel nome, cognome, cf, tipoAccount;
	private JList visite;
	private JButton logout;
	private DefaultListModel modelloLista;
	
	public OperatoreSanitarioPanel() {
		setLayout(new BorderLayout());
		
		JPanel barNord = new JPanel();
		barNord.setLayout(new FlowLayout());
		JPanel barSud = new JPanel();
		barSud.setLayout(new FlowLayout());
		
		nome = new JLabel("Nome");
		cognome = new JLabel("Cognome");
		cf = new JLabel("Cf");
		tipoAccount = new JLabel("Operatore Sanitario");
		logout = new JButton("LOGOUT");
		
		visite = new JList();
		visite.setPreferredSize(new Dimension(700, 500));
		modelloLista = new DefaultListModel();
		
		visite.setModel(modelloLista);
		
		
		barNord.add(nome);
		barNord.add(cognome);
		barNord.add(cf);
		barNord.add(tipoAccount);
		add(barNord, BorderLayout.NORTH);
		
		add(new JScrollPane(visite), BorderLayout.CENTER);
		
		barSud.add(logout);
		add(barSud, BorderLayout.SOUTH);
		
	}
	
	public void addElementoLista(String s) {
		modelloLista.addElement(s);
	}

	public JButton getLogoutBtn() {
		return logout;
	}
	
	public void setNome(JLabel nome) {
		this.nome = nome;
	}

	public void setCognome(JLabel cognome) {
		this.cognome = cognome;
	}

	public void setCf(JLabel Cf) {
		this.cf = Cf;
	}
}

