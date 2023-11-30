package it.unipv.sfw.view.account;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import it.unipv.sfw.model.persona.Account;
import it.unipv.sfw.model.persona.Medico;
import it.unipv.sfw.model.persona.OperatoreSanitario;
import it.unipv.sfw.model.persona.Paziente;
import it.unipv.sfw.model.prenotazione.Prenotazione;

public class OperatoreUfficioPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel nome, cognome, cf, tipoAccount;
	private JLabel pNome, pCognome, pCf, pTipoAccount;
	private JList<String> visite, utenti, calendar;
	private JButton prenota, cancella, logout, aggiungiUtente;
	private DefaultListModel<String> modelloLista, modelloListaDue, modelloListaTre;
	private JLabel appuntamenti, utente, calendario;
	private JScrollPane scrollVisite, scrollUtenti, scrollCalendar;
	
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
		aggiungiUtente = new JButton("AGGIUNGI UTENTE");
		appuntamenti = new JLabel("APPUNTAMENTI");
		utente = new JLabel("UTENTI");
		calendario = new JLabel("CALENDARIO");
		
		visite = new JList<>();
		visite.setPreferredSize(new Dimension(1000, 1000));
		modelloLista = new DefaultListModel<>();
		
		utenti = new JList<>();
		utenti.setPreferredSize(new Dimension(1500, 1000));
		modelloListaDue = new DefaultListModel<>();
		
		calendar = new JList<>();
		calendar.setPreferredSize(new Dimension(1000, 1000));
		modelloListaTre = new DefaultListModel<>();
		
		visite.setModel(modelloLista);
		utenti.setModel(modelloListaDue);
		//calendar.setModel(modelloListaTre);
		
		scrollVisite = new JScrollPane(visite);
		scrollVisite.setPreferredSize(new Dimension(650,150));
		scrollVisite.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollVisite.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        scrollUtenti = new JScrollPane(utenti);
        scrollUtenti.setPreferredSize(new Dimension(650,150));
        scrollUtenti.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollUtenti.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        scrollCalendar = new JScrollPane(calendar);
        scrollCalendar.setPreferredSize(new Dimension(650,150));
        scrollCalendar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollCalendar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		barNordOvest.add(appuntamenti, BorderLayout.PAGE_START);
		barNordOvest.add(scrollVisite, BorderLayout.CENTER);
		add(barNordOvest);
		
		barNordEst.add(cancella);
		barNordEst.add(prenota);
		add(barNordEst);
		
		barCentroSx.add(utente, BorderLayout.PAGE_START);
		barCentroSx.add(scrollUtenti, BorderLayout.CENTER);
		add(barCentroSx);
		
		barCentroDx.add(aggiungiUtente);
		barCentroDx.add(logout);
		add(barCentroDx);
		
		barSudOvest.add(calendario, BorderLayout.PAGE_START);
		barSudOvest.add(scrollCalendar, BorderLayout.CENTER);
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
	
	public void setListaPrenotazioni (ArrayList<Paziente> pazienti) {
		modelloLista.clear();
		for(Paziente a : pazienti) {
			for(Prenotazione p : a.getPrenotazioni()) {
				
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
	
	public void setListaUtenti (ArrayList<Paziente> pazienti, ArrayList<Medico> medici, ArrayList<OperatoreSanitario> operatoriSanitari) {
		ArrayList<Account> u= new ArrayList<>();
		u.addAll(pazienti);
		u.addAll(medici);
		u.addAll(operatoriSanitari);
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

	public JList getVisite() {
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

