package it.unipv.sfw.view.prenotazione;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class PrenotaPanelPaziente extends JPanel{
	
	private JLabel tipoPrestazione;
	private JLabel slot, slotProposto;
	private String[] prestazioneString = {" ", "VISITA_ONCOLOGICA", "VISITA_PSICOLOGICA", "ESAMI_SANGUE", "TAC", "RISONANZA_MAGNETICA", "CHEMIOTERAPIA", "RADIOTERAPIA"};
	private JComboBox <String> scegliPrestazione;
	private JButton conferma, successivo, precedente, indietro;
	
	public PrenotaPanelPaziente() {
		
		setLayout(new BorderLayout(40,40));
		
		JPanel barNord = new JPanel();
		barNord.setLayout(new FlowLayout());
		
		JPanel barCentro = new JPanel();
		barCentro.setLayout(new GridLayout(2,1));
		
		JPanel barSud = new JPanel();
		barSud.setLayout(new GridLayout());
		
		tipoPrestazione = new JLabel("SCEGLI PRESTAZIONE");
		scegliPrestazione = new JComboBox<>(prestazioneString);
		
		slotProposto = new JLabel("Slot Proposto");
		slot = new JLabel();

		conferma = new JButton("CONFERMA APPUNTAMENTO");
		indietro = new JButton("INDIETRO");
		successivo = new JButton("SLOT SUCCESSIVO");
		precedente = new JButton("SLOT PRECEDENTE");
		
		barNord.add(tipoPrestazione);
		barNord.add(scegliPrestazione);
		add(barNord, BorderLayout.PAGE_START);
		
		barCentro.add(slotProposto);
		barCentro.add(slot);
		add(barCentro, BorderLayout.CENTER);
		
		barSud.add(indietro);
		barSud.add(conferma);
		add(barSud, BorderLayout.PAGE_END);
		
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

	public void setSlot(String slot) {
		this.slot.setText(slot);
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

	public JButton getConfermaBtn() {
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

	public String getPrestazioneScelta() {
		return (String) scegliPrestazione.getSelectedItem();
	}
	
	public JButton getBtnBack() {
		return indietro;
	}
}
