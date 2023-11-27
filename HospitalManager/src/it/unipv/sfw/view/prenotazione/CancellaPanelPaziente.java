package it.unipv.sfw.view.prenotazione;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class CancellaPanelPaziente extends JPanel{
	
	private JLabel idPrenotazione;
	private JLabel slot, cancellaSlot;
	private JTextField idPren;
	private JButton conferma;
	
	public CancellaPanelPaziente() {
		
		setLayout(new BorderLayout(40,40));
		
		JPanel barNord = new JPanel();
		barNord.setLayout(new GridLayout(2,1));
		JPanel barCentro = new JPanel();
		barCentro.setLayout(new FlowLayout());
		
		idPrenotazione = new JLabel("INSERIRE ID PRENOTAZIONE");
		idPren = new JTextField();
		
		cancellaSlot = new JLabel("PRENOTAZIONE DA CANCELLARE:");
		slot = new JLabel("04-12-2023 15:00");

		conferma = new JButton("CANCELLA APPUNTAMENTO");
		
		barNord.add(idPrenotazione);
		barNord.add(idPren);
		add(barNord, BorderLayout.PAGE_START);
		
		barCentro.add(cancellaSlot);
		barCentro.add(slot);
		add(barCentro, BorderLayout.CENTER);
		
		add(conferma, BorderLayout.PAGE_END);
		
	}
	
	public JTextField getIdPrenotazione() {
		return idPren;
	}
	
	public JButton getConferma() {
		return conferma;
	}
}
