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
	private JButton cerca, conferma;
	
	public CancellaPanelUfficio() {
		
		setLayout(new BorderLayout(40,40));
		
		JPanel barNord = new JPanel();
		barNord.setLayout(new GridLayout(5,1));
		JPanel barCentro = new JPanel();
		barCentro.setLayout(new FlowLayout());
		
		idPrenotazione = new JLabel("INSERIRE ID PRENOTAZIONE");
		cfPaziente = new JLabel("INSERIRE CF PAZIENTE");
		cf = new JTextField();
		idPren = new JTextField();
		
		cancellaSlot = new JLabel("PRENOTAZIONE DA CANCELLARE:");
		slot = new JLabel("04-12-2023 15:00");

		cerca = new JButton("CERCA APPUNTAMENTO");
		conferma = new JButton("CANCELLA APPUNTAMENTO");
		
		barNord.add(cfPaziente);
		barNord.add(cf);
		barNord.add(idPrenotazione);
		barNord.add(idPren);
		barNord.add(cerca);
		add(barNord, BorderLayout.PAGE_START);
		
		barCentro.add(cancellaSlot);
		barCentro.add(slot);
		add(barCentro, BorderLayout.CENTER);
		
		add(conferma, BorderLayout.PAGE_END);
		
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
	
	public void setSlot(JLabel slot) {
		this.slot = slot;
	}
	
	public JButton getCerca() {
		return cerca;
	}
	
	
	
}
