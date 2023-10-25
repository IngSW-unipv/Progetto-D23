package it.unipv.sfw.view.account;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.*;

import it.unipv.sfw.model.Prenotazione;

public class PazientePanel extends JPanel{
	
	private JLabel nome, cognome, cf, tipoAccount;
	private JList visite;
	private JButton prenota, cancella, logout;
	private DefaultListModel modelloLista;
	
	public PazientePanel() {
		setLayout(new BorderLayout());
		
		JPanel barNord = new JPanel();
		barNord.setLayout(new FlowLayout());
		JPanel barSud = new JPanel();
		barSud.setLayout(new FlowLayout());
		
		nome = new JLabel("Nome");
		cognome = new JLabel("Cognome");
		cf = new JLabel("Cf");
		tipoAccount = new JLabel("Paziente");
		prenota = new JButton("PRENOTA");
		cancella = new JButton("CANCELLA");
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
		
		barSud.add(cancella);
		barSud.add(prenota);
		barSud.add(logout);
		add(barSud, BorderLayout.SOUTH);
		
	}
	
	public void addElementoLista(String s) {
		modelloLista.addElement(s);
	}
	
	public void setListaVisite (ArrayList<Prenotazione> prenotazioni) {
		JList list = new JList<>(prenotazioni.toArray(new String[prenotazioni.size()]));
		this.visite = list;
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

	public JButton getPrenotaBtn() {
		return prenota;
	}
	
	public JButton getCancellaBtn() {
		return cancella;
	}
}

