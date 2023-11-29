package it.unipv.sfw.controller.prenotazione;

import it.unipv.sfw.model.strutturasanitaria.StrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class PrenotazioneController {
	
	private ViewController view;
	private StrutturaSanitaria model;
	private PrenotaActionListener prenota;
	
	private CercaPrenDaCancellarePaziente cercaPrenPaz;
	private CercaPrenDaCancellareUff cercaPrenUff;
	
	private ConfermaPrenotazionePazienteActionListener confermaPaziente;
	private ConfermaPrenotazioneOpUffActionListener confermaUfficio;
	
	private CancellaPrenotazionePazienteActionListener confermaCancellaPaz;
	private CancellaPrenotazioneOpUffActionListener confermaCancellaOpUff;
	
	private CancellaActionListener cancella;
	private ScegliPrestazioneActionListener scegliPrest;
	private SuccessivoActionListener successivo;
	private PrecedenteActionListener precedente;
	
	public PrenotazioneController (StrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
		
		prenota = new PrenotaActionListener(model, view);
		cancella = new CancellaActionListener(model, view);
		
		cercaPrenPaz = new CercaPrenDaCancellarePaziente(model, view);
		cercaPrenUff = new CercaPrenDaCancellareUff(model, view);
		
		confermaPaziente = new ConfermaPrenotazionePazienteActionListener(model, view);
		confermaUfficio = new ConfermaPrenotazioneOpUffActionListener(model, view);	
		
		confermaCancellaPaz = new CancellaPrenotazionePazienteActionListener(model, view);
		confermaCancellaOpUff = new CancellaPrenotazioneOpUffActionListener(model, view);
		
		scegliPrest = new ScegliPrestazioneActionListener(model, view);
		
		successivo = new SuccessivoActionListener(model, view);
		
		precedente = new PrecedenteActionListener(model, view);
		
		
		view.getOperatoreUfficioPanel().getPrenotaBtn().addActionListener(prenota);
		view.getPazientePanel().getPrenotaBtn().addActionListener(prenota);
		
		view.getPazientePanel().getCancellaBtn().addActionListener(cancella);
		view.getOperatoreUfficioPanel().getCancellaBtn().addActionListener(cancella);
		
		view.getPrenotatiPanelPaziente().getConfermaBtn().addActionListener(confermaPaziente);
		view.getPrenotatiPanelUfficio().getConfermaBtn().addActionListener(confermaUfficio);
		
		view.getCancellaPanelPaziente().getConferma().addActionListener(confermaCancellaPaz);
		view.getCancellaPanelUfficio().getConferma().addActionListener(confermaCancellaOpUff);
		
		view.getCancellaPanelPaziente().getCerca().addActionListener(cercaPrenPaz);
		view.getCancellaPanelUfficio().getCerca().addActionListener(cercaPrenUff);
		
		view.getPrenotatiPanelPaziente().getScegliPrestazione().addActionListener(scegliPrest);
		view.getPrenotatiPanelUfficio().getScegliPrestazione().addActionListener(scegliPrest);
	
		view.getPrenotatiPanelPaziente().getSuccessivo().addActionListener(successivo);
		view.getPrenotatiPanelUfficio().getSuccessivo().addActionListener(successivo);
	
		view.getPrenotatiPanelPaziente().getPrecedente().addActionListener(precedente);
		view.getPrenotatiPanelUfficio().getPrecedente().addActionListener(precedente);
		
	}
}


