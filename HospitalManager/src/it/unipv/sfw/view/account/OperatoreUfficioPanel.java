package it.unipv.sfw.view.account;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import it.unipv.sfw.model.persona.Account;
import it.unipv.sfw.model.persona.IPaziente;
import it.unipv.sfw.model.persona.IPersonaleSanitario;
import it.unipv.sfw.model.persona.Medico;
import it.unipv.sfw.model.persona.OperatoreSanitario;
import it.unipv.sfw.model.persona.Paziente;
import it.unipv.sfw.model.prenotazione.IPrenotazione;

public class OperatoreUfficioPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel nome, cognome, cf, tipoAccount;
	private JLabel pNome, pCognome, pCf, pTipoAccount;
	private JList<String> visite, utenti;
	private JButton prenota, cancella, logout, aggiungiPaziente, cambiaPw;
	private DefaultListModel<String> modelloLista, modelloListaDue;
	private JLabel appuntamenti, utente;
	private JScrollPane scrollVisite, scrollUtenti;
	
	public OperatoreUfficioPanel() {
		setLayout(new GridLayout(3,2));
		
		JPanel barNordOvest = new JPanel();
		barNordOvest.setLayout(new BorderLayout());
		JPanel barNordEst = new JPanel();
		barNordEst.setLayout(new GridLayout(2,1));
		JPanel barCentroSx = new JPanel();
		barCentroSx.setLayout(new BorderLayout());
		JPanel barCentroDx = new JPanel();
		barCentroDx.setLayout(new BorderLayout());
		JPanel barSudOvest = new JPanel();
		barSudOvest.setLayout(new GridLayout(4,2));
		JPanel barSudEst = new JPanel();
		barSudEst.setLayout(new GridLayout(2,1));
		
		nome = new JLabel("NOME:");
		pNome = new JLabel();
		cognome = new JLabel("COGNOME:");
		pCognome = new JLabel();
		cf = new JLabel("CF:");
		pCf = new JLabel();
		tipoAccount = new JLabel("TIPO ACCOUNT:");
		pTipoAccount = new JLabel("Operatore Ufficio");
		prenota = new JButton("PRENOTA");
		cancella = new JButton("CANCELLA");
		logout = new JButton("LOGOUT");
		aggiungiPaziente = new JButton("AGGIUNGI PAZIENTE");
		appuntamenti = new JLabel("APPUNTAMENTI");
		utente = new JLabel("UTENTI");
		cambiaPw = new JButton("CAMBIA PASSWORD");
		
		visite = new JList<>();
		visite.setPreferredSize(new Dimension(1000, 1000));
		modelloLista = new DefaultListModel<>();
		
		utenti = new JList<>();
		utenti.setPreferredSize(new Dimension(1500, 1000));
		modelloListaDue = new DefaultListModel<>();
		
		visite.setModel(modelloLista);
		utenti.setModel(modelloListaDue);
		
		scrollVisite = new JScrollPane(visite);
		scrollVisite.setPreferredSize(new Dimension(650,150));
		scrollVisite.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollVisite.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        scrollUtenti = new JScrollPane(utenti);
        scrollUtenti.setPreferredSize(new Dimension(650,150));
        scrollUtenti.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollUtenti.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
		
		barNordOvest.add(appuntamenti, BorderLayout.PAGE_START);
		barNordOvest.add(scrollVisite, BorderLayout.CENTER);
		add(barNordOvest);
		
		barNordEst.add(cancella);
		barNordEst.add(prenota);
		add(barNordEst);
		
		barCentroSx.add(utente, BorderLayout.PAGE_START);
		barCentroSx.add(scrollUtenti, BorderLayout.CENTER);
		add(barCentroSx);
		
		
		barCentroDx.add(aggiungiPaziente, BorderLayout.CENTER);
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
		
		barSudEst.add(cambiaPw);
		barSudEst.add(logout);
		add(barSudEst);
		
	}
	
	public void setListaPrenotazioni (ArrayList<IPaziente> pazienti) {
		modelloLista.clear();
		for(IPaziente a : pazienti) {
			for(IPrenotazione p : a.getPrenotazioni()) {
				
				String idPren = String.valueOf(p.getIdPren());
				String cf = p.getPaziente().getCf();
				String pazienteNome = p.getPaziente().getNome();
				String pazienteCognome = p.getPaziente().getCognome();
				String prest = p.getPrestazione().getTipo().name();
				String data = p.getData().toString();
				String orario = p.getOrario().toString();
				String s = new String("Data: "+data+" | Ora: "+orario+" | ID: "+idPren+" | Paziente: "+cf+", "+pazienteNome
						+" "+pazienteCognome+" | Prestazione: "+prest);
				
				modelloLista.addElement(s);
			}
		}
		
		visite.setModel(modelloLista);
	}
	
	public void setListaUtenti (ArrayList<IPaziente> pazienti, ArrayList<IPersonaleSanitario> medici, ArrayList<IPersonaleSanitario> operatoriSanitari) {
		ArrayList<Account> u= new ArrayList<>();
		Iterator<IPaziente> p = pazienti.iterator();
		 while (p.hasNext()) {
	        		u.add((Paziente) p.next());
	        	}
		 Iterator<IPersonaleSanitario> m = medici.iterator();
		 while (m.hasNext()) {
	        		u.add((Medico)m.next());
	        	}
		 Iterator<IPersonaleSanitario> os = operatoriSanitari.iterator();
		 while (os.hasNext()) {
	        		u.add((OperatoreSanitario)os.next());
	        	}
		
		modelloListaDue.clear();
		for(Account a : u) {
			String tipo = a.getTipoAcc().name();
			String cf = a.getCf();
			String nome = a.getNome();
			String cognome = a.getCognome();
			String sesso = a.getSesso().toString();
			String data = a.getDataNascita();
			String luogo = a.getLuogoNascita()+" ("+a.getProvinciaNascita()+")";
			String residenza = a.getCittaRes()+" ("+a.getProvinciaRes()+"), "+a.getCap()+", "+a.getIndirizzo();
			String mail = a.geteMail();
			String cell = a.getCellulare();
			
			String s = new String("Tipo: "+tipo+" | Utente: "+cf+", "+nome+" "+cognome+" | Sesso: "+sesso
					+" | Data Nascita: "+ data+" | Luogo Nascita: "+luogo+" | Residenza: "+residenza
					+" | EMail: "+mail+" | Cellulare: "+cell);
			
			modelloListaDue.addElement(s);
		}
		utenti.setModel(modelloListaDue);
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
	
	public JLabel getNome() {
		return nome;
	}

	public JLabel getCognome() {
		return cognome;
	}

	public JLabel getCf() {
		return cf;
	}

	public JLabel getTipoAccount() {
		return tipoAccount;
	}

	public void setTipoAccount(JLabel tipoAccount) {
		this.tipoAccount = tipoAccount;
	}

	public JList<String> getVisite() {
		return visite;
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

	public DefaultListModel<String> getModelloLista() {
		return modelloLista;
	}

	public void setModelloLista(DefaultListModel<String> modelloLista) {
		this.modelloLista = modelloLista;
	}
	
	public JButton getBtnAggPaz() {
		return aggiungiPaziente;
	}
}

