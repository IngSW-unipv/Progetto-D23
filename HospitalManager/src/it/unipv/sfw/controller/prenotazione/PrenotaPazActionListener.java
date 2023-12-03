package it.unipv.sfw.controller.prenotazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.view.ViewController;

public class PrenotaPazActionListener implements ActionListener{
    private ViewController view;

    public PrenotaPazActionListener(ViewController view){
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
		view.getPazientePanel().setVisible(false);
		view.getPrenotatiPanelPaziente().setVisible(true);
		view.getPrenotatiPanelPaziente().getScegliPrestazione().setSelectedIndex(0);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
    }
    
}
