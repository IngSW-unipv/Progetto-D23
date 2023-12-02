package it.unipv.sfw.controller.pazienteController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unipv.sfw.model.cartellaclinica.GruppiSanguigni;
import it.unipv.sfw.model.persona.Account;
import it.unipv.sfw.model.persona.Paziente;
import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.PopUp;
import it.unipv.sfw.view.ViewController;

public class AggiornaCartellaClinicaActionListener implements ActionListener{
    private IStrutturaSanitaria model;
    private ViewController view;


    public AggiornaCartellaClinicaActionListener(IStrutturaSanitaria model, ViewController view){
        this.model = model;
        this.view= view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            String altezzaString = view.getAggiornaCartellaClinicaPanel().getAltezza().getText();
            String pesoString = view.getAggiornaCartellaClinicaPanel().getPeso().getText();
            String gruppoSanguignoString = view.getAggiornaCartellaClinicaPanel().getGruppoScelto();

            double altezza = Double.parseDouble(altezzaString);
            double peso = Double.parseDouble(pesoString);

            Account acc = model.getUtenteCorrente();
            Paziente paz = (Paziente) acc;

            paz.getCartellaPersonale().setAltezza(altezza);
            paz.getCartellaPersonale().setPeso(peso);
            paz.getCartellaPersonale().setGruppoSanguigno(GruppiSanguigni.valueOf(gruppoSanguignoString));

            PopUp.infoBox("Dati aggiornati", "OK");
            pulisciTextField();
            view.getAggiornaCartellaClinicaPanel().setVisible(false);
            view.getPazientePanel().setVisible(true);

        } catch(Exception e1) {
            PopUp.infoBox("Aggiornamento dati non riuscito", "Errore");
        }
        
        

    }

    private void pulisciTextField() {
        view.getAggiornaCartellaClinicaPanel().getAltezza().setText(null);
        view.getAggiornaCartellaClinicaPanel().getPeso().setText(null);
        //view.getAggiornaCartellaClinicaPanel().getScegliGruppo().set
    }
    
}

