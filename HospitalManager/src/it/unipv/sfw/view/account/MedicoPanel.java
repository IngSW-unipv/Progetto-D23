package it.unipv.sfw.view.account;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.beans.XMLDecoder;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import it.unipv.sfw.model.Prenotazione;

public class MedicoPanel extends JPanel{
	
	private JLabel nome, cognome, cf, tipoAccount;
	private JLabel pNome, pCognome, pCf, pTipoAccount;
	private JList visite;
	private JButton logout, cambiaPw;
	private DefaultListModel modelloLista;
	private JLabel calendario;
	
	public MedicoPanel() {
		setLayout(new GridLayout(3,1));
		
		JPanel barNord = new JPanel();
		barNord.setLayout(new BorderLayout());
		JPanel barSud = new JPanel();
		barSud.setLayout(new GridLayout(8,1));
		JPanel barCentro = new JPanel();
		barCentro.setLayout(new GridLayout(2,1));
		
		nome = new JLabel("NOME:");
		pNome = new JLabel("Antonio");
		cognome = new JLabel("COGNOME:");
		pCognome = new JLabel("Cassano");
		cf = new JLabel("CF:");
		pCf = new JLabel("CSSNTN79T09A045S");
		tipoAccount = new JLabel("TIPO ACCOUNT");
		pTipoAccount = new JLabel("Medico");
		logout = new JButton("LOGOUT");
		cambiaPw = new JButton("CAMBIA PASSWORD");
		calendario = new JLabel("CALENDARIO");
		
		visite = new JList();
		visite.setPreferredSize(new Dimension(700, 500));
		modelloLista = new DefaultListModel();
		
		visite.setModel(modelloLista);
		
		
		barNord.add(calendario, BorderLayout.PAGE_START);
		barNord.add(new JScrollPane(visite), BorderLayout.CENTER);
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
	
	public void addElementoLista(String s) {
		modelloLista.addElement(s);
	}
	
	public JButton getLogoutBtn() {
		return logout;
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

	public void setCf(String Cf) {
		XMLDecoder d = new XMLDecoder(new ByteArrayInputStream(Cf.getBytes()));
	    JLabel label = (JLabel) d.readObject();
	    d.close();
	    this.cf = label;
	}
}
