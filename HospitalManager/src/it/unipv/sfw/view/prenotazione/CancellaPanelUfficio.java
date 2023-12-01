package it.unipv.sfw.view.prenotazione;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class CancellaPanelUfficio extends JPanel{
	
	private JLabel idPrenotazione;
	private JLabel slot, cancellaSlot;
	private JLabel cfPaziente;
	private JTextField cf, idPren;
	private JButton cerca, conferma, indietro;
	
	public CancellaPanelUfficio() {
		
		setLayout(new BorderLayout(40,40));
		
		JPanel barNord = new JPanel();
		barNord.setLayout(new GridLayout(5,1));
		
		JPanel barCentro = new JPanel();
		barCentro.setLayout(new FlowLayout());
		
		JPanel barSud = new JPanel();
		barSud.setLayout(new GridLayout());
		
		idPrenotazione = new JLabel("INSERIRE ID PRENOTAZIONE");
		cfPaziente = new JLabel("INSERIRE CF PAZIENTE");
		cf = new JTextField();
		idPren = new JTextField();
		
		cancellaSlot = new JLabel("PRENOTAZIONE DA CANCELLARE:");
		slot = new JLabel();

		cerca = new JButton("CERCA APPUNTAMENTO");
		conferma = new JButton("CANCELLA APPUNTAMENTO");
		indietro = new JButton("INDIETRO");
		
		barNord.add(cfPaziente);
		barNord.add(cf);
		barNord.add(idPrenotazione);
		barNord.add(idPren);
		barNord.add(cerca);
		add(barNord, BorderLayout.PAGE_START);
		
		barCentro.add(cancellaSlot);
		barCentro.add(slot);
		add(barCentro, BorderLayout.CENTER);
		
		barSud.add(indietro);
		barSud.add(conferma);
		add(barSud, BorderLayout.PAGE_END);
		
	}

	public JButton getConferma() {
		return conferma;
	}
	
	public JTextField getIdPrenotazione() {
		return idPren;
	}
	
	public JTextField getCf() {
		return cf;
	}
	
	public void setSlot(String slot) {
		this.slot.setText(slot);
	}
	
	public JButton getCerca() {
		return cerca;
	}
	
	public JButton getBtnBack() {
		return indietro;
	}
	
}
