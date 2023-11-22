package it.unipv.sfw.view.account;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.beans.XMLDecoder;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import javax.swing.*;

import it.unipv.sfw.model.Prenotazione;

public class PazientePanel extends JPanel{
	
	private JLabel nome, cognome, cf, tipoAccount;
	private JLabel pNome, pCognome, pCf, pTipoAccount;
	private JList visite, esiti;
	private JButton prenota, cancella, logout, cambiaPw;
	private DefaultListModel modelloLista;
	private JLabel altezza, peso, gruppoSanguigno;
	private JLabel pAltezza, pPeso, pGruppoSanguigno;
	private JLabel prenotazione, esito;
	
	public PazientePanel() {
		setLayout(new GridLayout(3,2));
		
		JPanel barNordOvest = new JPanel();
		barNordOvest.setLayout(new BorderLayout());
		JPanel barNordEst = new JPanel();
		barNordEst.setLayout(new GridLayout(2,1));
		JPanel barCentroSx = new JPanel();
		barCentroSx.setLayout(new BorderLayout());
		JPanel barCentroDx = new JPanel();
		barCentroDx.setLayout(new GridLayout(2,1));
		JPanel barSudEst = new JPanel();
		barSudEst.setLayout(new GridLayout(6,1));
		JPanel barSudOvest = new JPanel();
		barSudOvest.setLayout(new GridLayout(8,1));
		
		
		nome = new JLabel("NOME:");
		pNome = new JLabel();
		cognome = new JLabel("COGNOME:");
		pCognome = new JLabel("Franco");
		cf = new JLabel("CF:");
		pCf = new JLabel("FRNPPP55R01A089S");
		tipoAccount = new JLabel("TIPO ACCOUNT:");
		pTipoAccount = new JLabel("Paziente");
		prenota = new JButton("PRENOTA");
		cancella = new JButton("CANCELLA");
		logout = new JButton("LOGOUT");
		cambiaPw = new JButton("CAMBIA PASSWORD");
		altezza = new JLabel("ALTEZZA:");
		pAltezza = new JLabel("1.70 m");
		peso = new JLabel("PESO:");
		pPeso = new JLabel("62 kg");
		gruppoSanguigno = new JLabel("GRUPPO SANGUIGNO:");
		pGruppoSanguigno = new JLabel("0 Positivo");
		prenotazione = new JLabel("PRENOTAZIONI");
		esito = new JLabel("ESITI");
		
		
		visite = new JList();
		visite.setPreferredSize(new Dimension(700, 500));
		modelloLista = new DefaultListModel();
		
		esiti = new JList();
		esiti.setPreferredSize(new Dimension(700, 500));
		modelloLista = new DefaultListModel();
		
		visite.setModel(modelloLista);
		esiti.setModel(modelloLista);
		
		
		barNordOvest.add(prenotazione, BorderLayout.PAGE_START);
		barNordOvest.add(new JScrollPane(visite), BorderLayout.CENTER);
		add(barNordOvest);
		
		barNordEst.add(prenota);
		barNordEst.add(cancella);
		add(barNordEst);
		
		barCentroSx.add(esito, BorderLayout.PAGE_START);
		barCentroSx.add(new JScrollPane(esiti), BorderLayout.CENTER);
		add(barCentroSx);
		
		barCentroDx.add(cambiaPw);
		barCentroDx.add(logout);
		add(barCentroDx);
		
		barSudOvest.add(nome);
		barSudOvest.add(pNome);
		barSudOvest.add(cognome); 
		barSudOvest.add(pCognome);
		barSudOvest.add(cf);
		barSudOvest.add(pCf);
		barSudOvest.add(tipoAccount);
		barSudOvest.add(pTipoAccount);
		add(barSudOvest);
		
		barSudEst.add(altezza);
		barSudEst.add(pAltezza);
		barSudEst.add(peso);
		barSudEst.add(pPeso);
		barSudEst.add(gruppoSanguigno);
		barSudEst.add(pGruppoSanguigno);
		add(barSudEst);
		
	}
	
	public void addElementoLista(String s) {
		modelloLista.addElement(s);
	}
	
	
	public void setListaVisite (ArrayList<Prenotazione> prenotazioni) {
		JList list = new JList<>(prenotazioni.toArray(new String[prenotazioni.size()]));
		this.visite = list;
	}

	public void setNome(String nome) {
	    XMLDecoder d = new XMLDecoder(new ByteArrayInputStream(nome.getBytes()));
	    JLabel label = (JLabel) d.readObject();
	    d.close();
	    this.nome = label;
	}

	public void setCognome(String cognome) {
		XMLDecoder d = new XMLDecoder(new ByteArrayInputStream(cognome.getBytes()));
	    JLabel label = (JLabel) d.readObject();
	    d.close();
	    this.cognome = label;
	}

	public void setCf(String cf) {
		XMLDecoder d = new XMLDecoder(new ByteArrayInputStream(cf.getBytes()));
	    JLabel label = (JLabel) d.readObject();
	    d.close();
	    this.cf = label;
	}

	public JButton getPrenotaBtn() {
		return prenota;
	}
	
}

