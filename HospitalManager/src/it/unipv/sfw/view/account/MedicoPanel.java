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

import it.unipv.sfw.model.prenotazione.IPrenotazione;

public class MedicoPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel nome, cognome, cf, tipoAccount;
	private JLabel pNome, pCognome, pCf, pTipoAccount;
	private JList<String> visite;
	private JButton logout, cambiaPw;
	private DefaultListModel<String> modelloLista;
	private JLabel appuntamenti;
	private JScrollPane scrollVisite;
	
	public MedicoPanel() {
		setLayout(new GridLayout(3,1));
		
		JPanel barNord = new JPanel();
		barNord.setLayout(new BorderLayout());
		JPanel barSud = new JPanel();
		barSud.setLayout(new GridLayout(8,1));
		JPanel barCentro = new JPanel();
		barCentro.setLayout(new GridLayout(2,1));
		
		nome = new JLabel("NOME:");
		pNome = new JLabel();
		cognome = new JLabel("COGNOME:");
		pCognome = new JLabel();
		cf = new JLabel("CF:");
		pCf = new JLabel();
		tipoAccount = new JLabel("TIPO ACCOUNT");
		pTipoAccount = new JLabel("Medico");
		logout = new JButton("LOGOUT");
		cambiaPw = new JButton("CAMBIA PASSWORD");
		appuntamenti = new JLabel("APPUNTAMENTI");
		
		visite = new JList<>();
		visite.setPreferredSize(new Dimension(1000, 1000));
		modelloLista = new DefaultListModel<>();
		
		visite.setModel(modelloLista);
		
		scrollVisite = new JScrollPane(visite);
		scrollVisite.setPreferredSize(new Dimension(650,150));
		scrollVisite.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollVisite.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);		
		
		barNord.add(appuntamenti, BorderLayout.PAGE_START);
		barNord.add(scrollVisite, BorderLayout.CENTER);
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
	
	public void setListaPrenotazioni (ArrayList<IPrenotazione> arrayList) {
		modelloLista.clear();
		for(IPrenotazione p : arrayList) {
			
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
		visite.setModel(modelloLista);
	}
	
	public JButton getLogoutBtn() {
		return logout;
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
	
	public JButton getCambiaPw() {
		return cambiaPw;
	}
}
