package it.unipv.sfw.view.account;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.beans.XMLDecoder;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import it.unipv.sfw.model.Prenotazione;
import it.unipv.sfw.model.PrestazioneSanitaria;

public class OperatoreUfficioPanel extends JPanel{
	
	private JLabel nome, cognome, cf, tipoAccount;
	private JLabel pNome, pCognome, pCf, pTipoAccount;
	private JList visite, utenti, calendar;
	private JButton prenota, cancella, logout, aggiungiUtente;
	private DefaultListModel modelloLista;
	private JLabel appuntamenti, utente, calendario;
	
	public OperatoreUfficioPanel() {
		setLayout(new GridLayout(3,2));
		
		JPanel barNordOvest = new JPanel();
		barNordOvest.setLayout(new BorderLayout());
		JPanel barNordEst = new JPanel();
		barNordEst.setLayout(new GridLayout(2,1));
		JPanel barCentroSx = new JPanel();
		barCentroSx.setLayout(new BorderLayout());
		JPanel barCentroDx = new JPanel();
		barCentroDx.setLayout(new GridLayout(2,1));
		JPanel barSudOvest = new JPanel();
		barSudOvest.setLayout(new BorderLayout());
		JPanel barSudEst = new JPanel();
		barSudEst.setLayout(new GridLayout(4,2));
		
		nome = new JLabel("NOME:");
		pNome = new JLabel("Luigi");
		cognome = new JLabel("COGNOME:");
		pCognome = new JLabel("Di Maio");
		cf = new JLabel("CF:");
		pCf = new JLabel("DMILGU74R03A083S");
		tipoAccount = new JLabel("TIPO ACCOUNT:");
		pTipoAccount = new JLabel("Operatore Ufficio");
		prenota = new JButton("PRENOTA");
		cancella = new JButton("CANCELLA");
		logout = new JButton("LOGOUT");
		aggiungiUtente = new JButton("AGGIUNGI UTENTE");
		appuntamenti = new JLabel("APPUNTAMENTI");
		utente = new JLabel("UTENTI");
		calendario = new JLabel("CALENDARIO");
		
		visite = new JList();
		visite.setPreferredSize(new Dimension(700, 500));
		modelloLista = new DefaultListModel();
		
		utenti = new JList();
		utenti.setPreferredSize(new Dimension(700, 500));
		modelloLista = new DefaultListModel();
		
		calendar = new JList();
		calendar.setPreferredSize(new Dimension(700, 500));
		modelloLista = new DefaultListModel();
		
		visite.setModel(modelloLista);
		utenti.setModel(modelloLista);
		calendar.setModel(modelloLista);
		
		barNordOvest.add(appuntamenti, BorderLayout.PAGE_START);
		barNordOvest.add(new JScrollPane(visite), BorderLayout.CENTER);
		add(barNordOvest);
		
		barNordEst.add(cancella);
		barNordEst.add(prenota);
		add(barNordEst);
		
		barCentroSx.add(utente, BorderLayout.PAGE_START);
		barCentroSx.add(new JScrollPane(utenti), BorderLayout.CENTER);
		add(barCentroSx);
		
		barCentroDx.add(aggiungiUtente);
		barCentroDx.add(logout);
		add(barCentroDx);
		
		barSudOvest.add(calendario, BorderLayout.PAGE_START);
		barSudOvest.add(new JScrollPane(calendar), BorderLayout.CENTER);
		add(barSudOvest);
		
		barSudEst.add(nome);
		barSudEst.add(pNome);
		barSudEst.add(cognome);
		barSudEst.add(pCognome);
		barSudEst.add(cf);
		barSudEst.add(pCf);
		barSudEst.add(tipoAccount);
		barSudEst.add(pTipoAccount);
		add(barSudEst);
		
	}
	
	public void addElementoLista(String s) {
		modelloLista.addElement(s);
	}

	public JLabel getNome() {
		return nome;
	}

	public void setNome(String nome) {
		XMLDecoder d = new XMLDecoder(new ByteArrayInputStream(nome.getBytes()));
	    JLabel label = (JLabel) d.readObject();
	    d.close();
	    this.nome = label;
	}

	public JLabel getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		XMLDecoder d = new XMLDecoder(new ByteArrayInputStream(cognome.getBytes()));
	    JLabel label = (JLabel) d.readObject();
	    d.close();
	    this.cognome = label;
	}

	public JLabel getCf() {
		return cf;
	}

	public void setCf(String cf) {
		XMLDecoder d = new XMLDecoder(new ByteArrayInputStream(cf.getBytes()));
	    JLabel label = (JLabel) d.readObject();
	    d.close();
	    this.cf = label;
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

	public void setListaVisite(ArrayList<PrestazioneSanitaria> prenotazioni) {
		JList list = new JList<>(prenotazioni.toArray(new String[prenotazioni.size()]));
		this.visite = list;
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

