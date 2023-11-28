package it.unipv.sfw.view.account;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.beans.XMLDecoder;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import javax.swing.*;

import it.unipv.sfw.model.Prenotazione;
import it.unipv.sfw.model.PrestazioneSanitaria;

public class PazientePanel extends JPanel{
	
	private JLabel nome, cognome, cf, tipoAccount;
	private JLabel pNome, pCognome, pCf, pTipoAccount;
	private JList visite, erogate;
	private JButton prenota, cancella, logout, cambiaPw, modificaCartella;
	private DefaultListModel modelloLista;
	private JLabel altezza, peso, gruppoSanguigno;
	private JLabel pAltezza, pPeso, pGruppoSanguigno;
	private JLabel prenotazione, prenotazioniErogate;
	
	public PazientePanel() {
		setLayout(new GridLayout(3,2));
		
		JPanel barNordOvest = new JPanel();
		barNordOvest.setLayout(new BorderLayout());
		JPanel barNordEst = new JPanel();
		barNordEst.setLayout(new GridLayout(2,1));
		JPanel barCentroSx = new JPanel();
		barCentroSx.setLayout(new BorderLayout());
		JPanel barCentroDx = new JPanel();
		barCentroDx.setLayout(new GridLayout(3,1));
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
		modificaCartella = new JButton("MODIFICA CARTELLA CLINICA");
		cambiaPw = new JButton("CAMBIA PASSWORD");
		altezza = new JLabel("ALTEZZA:");
		pAltezza = new JLabel("1.70 m");
		peso = new JLabel("PESO:");
		pPeso = new JLabel("62 kg");
		gruppoSanguigno = new JLabel("GRUPPO SANGUIGNO:");
		pGruppoSanguigno = new JLabel("0 Positivo");
		prenotazione = new JLabel("PRENOTAZIONI");
		prenotazioniErogate = new JLabel("PRENOTAZIONI EROGATE");
		
		
		visite = new JList();
		visite.setPreferredSize(new Dimension(700, 500));
		modelloLista = new DefaultListModel();
		
		erogate = new JList();
		erogate.setPreferredSize(new Dimension(700, 500));
		modelloLista = new DefaultListModel();
		
		visite.setModel(modelloLista);
		erogate.setModel(modelloLista);
		
		
		barNordOvest.add(prenotazione, BorderLayout.PAGE_START);
		barNordOvest.add(new JScrollPane(visite), BorderLayout.CENTER);
		add(barNordOvest);
		
		barNordEst.add(prenota);
		barNordEst.add(cancella);
		add(barNordEst);
		
		barCentroSx.add(prenotazioniErogate, BorderLayout.PAGE_START);
		barCentroSx.add(new JScrollPane(erogate), BorderLayout.CENTER);
		add(barCentroSx);
		
		barCentroDx.add(cambiaPw);
		barCentroDx.add(modificaCartella);
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
	
	public JButton getLogoutBtn() {
		return logout;
	}
	
	public JButton getCancellaBtn() {
		return cancella;
	}
	
	public void setAltezza(String altezza){
		XMLDecoder d = new XMLDecoder(new ByteArrayInputStream(altezza.getBytes()));
	    JLabel label = (JLabel) d.readObject();
	    d.close();
	    this.pAltezza = label;
	}

	public void setPeso(String peso){
		XMLDecoder d = new XMLDecoder(new ByteArrayInputStream(peso.getBytes()));
	    JLabel label = (JLabel) d.readObject();
	    d.close();
	    this.pPeso = label;
	}

	public void setGruppoSanguigno(String sangue){
		XMLDecoder d = new XMLDecoder(new ByteArrayInputStream(sangue.getBytes()));
	    JLabel label = (JLabel) d.readObject();
	    d.close();
	    this.pGruppoSanguigno = label;
	}
	
	public JButton getCambiaPw() {
		return cambiaPw;
	}
}

