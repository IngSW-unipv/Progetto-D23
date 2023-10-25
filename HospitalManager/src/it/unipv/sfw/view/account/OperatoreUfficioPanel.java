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

public class OperatoreUfficioPanel extends JPanel{
	
	private JLabel nome, cognome, cf, tipoAccount;
	private JList visite;
	private JButton prenota, cancella, logout, aggiungiUtente;
	private DefaultListModel modelloLista;
	
	public OperatoreUfficioPanel() {
		setLayout(new BorderLayout());
		
		JPanel barNord = new JPanel();
		barNord.setLayout(new FlowLayout());
		JPanel barSud = new JPanel();
		barSud.setLayout(new FlowLayout());
		
		nome = new JLabel("Nome");
		cognome = new JLabel("Cognome");
		cf = new JLabel("Cf");
		tipoAccount = new JLabel("Operatore Ufficio");
		prenota = new JButton("PRENOTA");
		cancella = new JButton("CANCELLA");
		logout = new JButton("LOGOUT");
		aggiungiUtente = new JButton("AGGIUNGI UTENTE");
		
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
		barSud.add(aggiungiUtente);
		barSud.add(logout);
		add(barSud, BorderLayout.SOUTH);
		
	}
	
	public void addElementoLista(String s) {
		modelloLista.addElement(s);
	}

	public JLabel getNome() {
		return nome;
	}

	public void setNome(JLabel nome) {
		this.nome = nome;
	}

	public JLabel getCognome() {
		return cognome;
	}

	public void setCognome(JLabel cognome) {
		this.cognome = cognome;
	}

	public JLabel getCf() {
		return cf;
	}

	public void setCf(JLabel cf) {
		this.cf = cf;
	}

	public JLabel getTipoAccount() {
		return tipoAccount;
	}

	public void setTipoAccount(JLabel tipoAccount) {
		this.tipoAccount = tipoAccount;
	}

	public JList getVisite() {
		return visite;
	}

	public void setVisite(JList visite) {
		this.visite = visite;
	}

	public JButton getPrenotaBtn() {
		return prenota;
	}

	public void setPrenota(JButton prenota) {
		this.prenota = prenota;
	}

	public JButton getCancellaBtn() {
		return cancella;
	}

	public void setCancella(JButton cancella) {
		this.cancella = cancella;
	}

	public JButton getLogoutBtn() {
		return logout;
	}

	public void setLogoutBtn(JButton logout) {
		this.logout = logout;
	}

	public JButton getAggiungiUtenteBtn() {
		return aggiungiUtente;
	}

	public void setAggiungiUtente(JButton aggiungiUtente) {
		this.aggiungiUtente = aggiungiUtente;
	}

	public DefaultListModel getModelloLista() {
		return modelloLista;
	}

	public void setModelloLista(DefaultListModel modelloLista) {
		this.modelloLista = modelloLista;
	}
	
	
}

