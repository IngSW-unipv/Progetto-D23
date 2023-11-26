package it.unipv.sfw.controller.prenotazione;

import it.unipv.sfw.model.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class PrenotazioneController {
	
	private ViewController view;
	private StrutturaSanitaria model;
	private PrenotaActionListener prenota;
	private ConfermaPrenotazionePazienteActionListener confermaPaziente;
	private ConfermaPrenotazioneUfficioActionListener confermaUfficio;
	private ScegliPrestazioneActionListener scegliPrest;
	private SuccessivoActionListener successivo;
	private PrecedenteActionListener precedente;
	
	public PrenotazioneController (StrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
		
		prenota = new PrenotaActionListener(model, view);
		confermaPaziente = new ConfermaPrenotazionePazienteActionListener(model, view);
		confermaUfficio = new ConfermaPrenotazioneUfficioActionListener(model, view);
		scegliPrest = new ScegliPrestazioneActionListener(model, view);
		successivo = new SuccessivoActionListener(model, view);
		precedente = new PrecedenteActionListener(model, view);
		
		view.getOperatoreUfficioPanel().getPrenotaBtn().addActionListener(prenota);
		view.getPazientePanel().getPrenotaBtn().addActionListener(prenota);
		
		view.getPrenotatiPanelPaziente().getConfermaBtn().addActionListener(confermaPaziente);
		view.getPrenotatiPanelUfficio().getConfermaBtn().addActionListener(confermaUfficio);
		
		view.getPrenotatiPanelPaziente().getScegliPrestazione().addActionListener(scegliPrest);
		view.getPrenotatiPanelUfficio().getScegliPrestazione().addActionListener(scegliPrest);
	
		view.getPrenotatiPanelPaziente().getSuccessivo().addActionListener(successivo);
		view.getPrenotatiPanelUfficio().getSuccessivo().addActionListener(successivo);
	
		view.getPrenotatiPanelPaziente().getPrecedente().addActionListener(precedente);
		view.getPrenotatiPanelUfficio().getPrecedente().addActionListener(precedente);
	}
}


