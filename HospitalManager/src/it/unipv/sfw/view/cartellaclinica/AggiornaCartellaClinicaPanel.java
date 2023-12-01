package it.unipv.sfw.view.cartellaclinica;

import java.awt.GridLayout;

import javax.swing.*;

public class AggiornaCartellaClinicaPanel extends JPanel{
	
	private JLabel altezza, peso, gruppoSanguigno;
	private JTextField altezzaText, pesoText;
	private String[] gruppo = {"A_POSITIVO", "A_NEGATIVO", "B_POSITIVO", "B_NEGATIVO", "AB_POSITIVO", "AB_NEGATIVO", "ZERO_POSITIVO", "ZERO_NEGATIVO"};
	private JComboBox<String> scegliGruppo;
	private JButton aggiorna, indietro;
	
	public AggiornaCartellaClinicaPanel() {
		setLayout(new GridLayout(4,4));
		
		altezza = new JLabel("ALTEZZA");
		peso = new JLabel("PESO");
		gruppoSanguigno = new JLabel("GRUPPO SANGUIGNO");
		
		altezzaText = new JTextField();
		pesoText = new JTextField();
		
		aggiorna = new JButton("AGGIORNA DATI");
		indietro = new JButton("INDIETRO");
		
		scegliGruppo = new JComboBox<>(gruppo);
		
		add(altezza);
		add(altezzaText);
		add(peso);
		add(pesoText);
		add(gruppoSanguigno);
		add(scegliGruppo);
		add(indietro);
		add(aggiorna);
		
	}

	public JButton getBtnBack() {
		return indietro;
	}
	
	public JButton getBtnAggiorna() {
		return aggiorna;
	}

	public JTextField getAltezza(){
		return altezzaText;
	}

	public JTextField getPeso(){
		return pesoText;
	}

	public String getGruppoScelto() {
		return (String) scegliGruppo.getSelectedItem();
	}

	public JComboBox<String> getScegliGruppo(){
		return scegliGruppo;
	}
	
	

}
