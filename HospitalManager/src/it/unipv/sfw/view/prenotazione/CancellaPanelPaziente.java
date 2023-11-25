package it.unipv.sfw.view.prenotazione;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class CancellaPanelPaziente extends JPanel{
	
	private JLabel tipoPrestazione;
	private JLabel slot, cancellaSlot;
	private String[] prestazioneString = {"Visita Oncologica", "Visita Psicologica", "Esami Sangue", "Tac", "Risonanza Magnetica", "Chemioterapia", "Radioterapia"};
	private JComboBox <String> scegliPrestazione;
	private JButton conferma, successivo, precedente;
	
	public CancellaPanelPaziente() {
		
		setLayout(new BorderLayout(40,40));
		
		JPanel barNord = new JPanel();
		barNord.setLayout(new FlowLayout());
		
		JPanel barCentro = new JPanel();
		barCentro.setLayout(new GridLayout(2,1));
		
		tipoPrestazione = new JLabel("SCEGLI PRESTAZIONE");
		scegliPrestazione = new JComboBox<>(prestazioneString);
		
		cancellaSlot = new JLabel("Prenotazione da Cancellare");
		slot = new JLabel("04-12-2023 15:00");

		conferma = new JButton("CANCELLA APPUNTAMENTO");
		successivo = new JButton("APPUNTAMENTO SUCCESSIVO");
		precedente = new JButton("APPUNTAMENTO PRECEDENTE");
		
		barNord.add(tipoPrestazione);
		barNord.add(scegliPrestazione);
		add(barNord, BorderLayout.PAGE_START);
		
		barCentro.add(cancellaSlot);
		barCentro.add(slot);
		add(barCentro, BorderLayout.CENTER);
		
		add(conferma, BorderLayout.PAGE_END);
		
		add(precedente, BorderLayout.LINE_START);
		
		add(successivo, BorderLayout.LINE_END);
		
	}

}
