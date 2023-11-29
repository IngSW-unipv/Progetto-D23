package it.unipv.sfw.view.account;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

import it.unipv.sfw.model.prenotazione.Prenotazione;

public class PazientePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel nome, cognome, cf, tipoAccount;
	private JLabel pNome, pCognome, pCf, pTipoAccount;
	private JList<String> visite, erogate;
	private JButton prenota, cancella, logout, cambiaPw, modificaCartella;
	private DefaultListModel<String> modelloLista;
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
		pCognome = new JLabel();
		cf = new JLabel("CF:");
		pCf = new JLabel();
		tipoAccount = new JLabel("TIPO ACCOUNT:");
		pTipoAccount = new JLabel("Paziente");
		prenota = new JButton("PRENOTA");
		cancella = new JButton("CANCELLA");
		logout = new JButton("LOGOUT");
		modificaCartella = new JButton("MODIFICA CARTELLA CLINICA");
		cambiaPw = new JButton("CAMBIA PASSWORD");
		altezza = new JLabel("ALTEZZA:");
		pAltezza = new JLabel();
		peso = new JLabel("PESO:");
		pPeso = new JLabel();
		gruppoSanguigno = new JLabel("GRUPPO SANGUIGNO:");
		pGruppoSanguigno = new JLabel("");
		prenotazione = new JLabel("PRENOTAZIONI");
		prenotazioniErogate = new JLabel("PRENOTAZIONI EROGATE");
		
		
		visite = new JList<>();
		visite.setPreferredSize(new Dimension(700, 500));
		visite.getAutoscrolls();
		modelloLista = new DefaultListModel<>();
		
		erogate = new JList<>();
		erogate.setPreferredSize(new Dimension(700, 500));
		modelloLista = new DefaultListModel<>();
		
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
		modelloLista.clear();
		for(Prenotazione p : prenotazioni) {
			
			String idPren = String.valueOf(p.getIdPren());
			String pSanitarioNome = p.getPersonaleSanitario().getNome();
			String pSanitarioCognome = p.getPersonaleSanitario().getCognome();
			String prest = p.getPrestazione().getTipo().name();
			String data = p.getData().toString();
			String orario = p.getOrario().toString();
			String s = new String("ID PRENOTAZIONE: "+idPren+", MEDICO/OPERATORE: "+pSanitarioNome
					+" "+pSanitarioCognome+", PRESTAZIONE: "+prest+", DATA: "+data+", ORA: "+orario);
			
			modelloLista.addElement(s);
		}
		visite.setModel(modelloLista);
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
	
	public void setAltezza(String altezza){
		pAltezza.setText(altezza);
	}

	public void setPeso(String peso){
		pPeso.setText(peso);
	}

	public void setGruppoSanguigno(String sangue){
		pGruppoSanguigno.setText(sangue);
	}
	
	public JButton getCambiaPw() {
		return cambiaPw;
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
}

