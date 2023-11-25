package it.unipv.sfw.view.prenotazione;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class PrenotaPanelUfficio extends JPanel {
	
	private JLabel tipoPrestazione;
	private JLabel slot, slotProposto;
	private JLabel cfPaziente;
	private JTextField cf;
	private String[] prestazioneString = {"Visita Oncologica", "Visita Psicologica", "Esami Sangue", "Tac", "Risonanza Magnetica", "Chemioterapia", "Radioterapia"};
	private JComboBox <String> scegliPrestazione;
	private JButton conferma, successivo, precedente;
	
	public PrenotaPanelUfficio() {
		
		setLayout(new BorderLayout(40,40));
		
		JPanel barNord = new JPanel();
		barNord.setLayout(new GridLayout(4,1));
		
		JPanel barCentro = new JPanel();
		barCentro.setLayout(new GridLayout(2,1));
		
		
		tipoPrestazione = new JLabel("SCEGLI PRESTAZIONE");
		scegliPrestazione = new JComboBox<>(prestazioneString);
		
		slotProposto = new JLabel("Slot Proposto");
		slot = new JLabel("04-12-2023 15:00");
		
		cfPaziente = new JLabel("INSERIRE CF PAZIENTE");
		cf = new JTextField();
		conferma = new JButton("CONFERMA APPUNTAMENTO");
		
		successivo = new JButton("SLOT SUCCESSIVO");
		precedente = new JButton("SLOT PRECEDENTE");
		
		barNord.add(tipoPrestazione);
		barNord.add(scegliPrestazione);
		barNord.add(cfPaziente);
		barNord.add(cf);
		add(barNord, BorderLayout.PAGE_START);
		
		barCentro.add(slotProposto);
		barCentro.add(slot);
		add(barCentro, BorderLayout.CENTER);
		
		add(conferma, BorderLayout.PAGE_END);
		
		add(precedente, BorderLayout.LINE_START);
		
		add(successivo, BorderLayout.LINE_END);
		
	}

	public JLabel getTipoPrestazione() {
		return tipoPrestazione;
	}

	public void setTipoPrestazione(JLabel tipoPrestazione) {
		this.tipoPrestazione = tipoPrestazione;
	}

	public JLabel getSlot() {
		return slot;
	}

	public void setSlot(JLabel slot) {
		this.slot = slot;
	}

	public JLabel getSlotProposto() {
		return slotProposto;
	}

	public void setSlotProposto(JLabel slotProposto) {
		this.slotProposto = slotProposto;
	}

	public String[] getPrestazioneString() {
		return prestazioneString;
	}

	public void setPrestazioneString(String[] prestazioneString) {
		this.prestazioneString = prestazioneString;
	}

	public JComboBox<String> getScegliPrestazione() {
		return scegliPrestazione;
	}

	public void setScegliPrestazione(JComboBox<String> scegliPrestazione) {
		this.scegliPrestazione = scegliPrestazione;
	}

	public JButton getConferma() {
		return conferma;
	}

	public void setConferma(JButton conferma) {
		this.conferma = conferma;
	}

	public JButton getSuccessivo() {
		return successivo;
	}

	public void setSuccessivo(JButton successivo) {
		this.successivo = successivo;
	}

	public JButton getPrecedente() {
		return precedente;
	}

	public void setPrecedente(JButton precedente) {
		this.precedente = precedente;
	}

}
