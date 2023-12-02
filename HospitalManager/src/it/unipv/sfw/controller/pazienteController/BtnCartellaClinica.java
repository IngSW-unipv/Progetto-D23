package it.unipv.sfw.controller.pazienteController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class BtnCartellaClinica implements ActionListener {
    private IStrutturaSanitaria model;
    private ViewController view;

    public BtnCartellaClinica(IStrutturaSanitaria model, ViewController view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       view.getPazientePanel().setVisible(false);
       view.getAggiornaCartellaClinicaPanel().setVisible(true);
       view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   view.getContentPane().setLayout(null);
    }

}
