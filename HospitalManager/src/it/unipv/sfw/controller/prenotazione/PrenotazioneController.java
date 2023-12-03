package it.unipv.sfw.controller.prenotazione;

import it.unipv.sfw.model.strutturasanitaria.IStrutturaSanitaria;
import it.unipv.sfw.view.ViewController;

public class PrenotazioneController {
	
	private ViewController view;
	private IStrutturaSanitaria model;
	
	private PrenotaOpUffActionListener prenotaOpUff;
	private PrenotaPazActionListener prenotaPaz;
	
	private CercaPrenDaCancellarePaziente cercaPrenPaz;
	private CercaPrenDaCancellareUff cercaPrenUff;
	
	private ConfermaPrenotazionePazienteActionListener confermaPaziente;
	private ConfermaPrenotazioneOpUffActionListener confermaUfficio;
	
	private CancellaPrenotazionePazienteActionListener confermaCancellaPaz;
	private CancellaPrenotazioneOpUffActionListener confermaCancellaOpUff;
	
	private CancellaOpUffActionListener cancellaOpUff;
	private CancellaPazActionListener cancellaPaz;
	
	private ScegliPrestazioneActionListener scegliPrest;
	private SuccessivoActionListener successivo;
	private PrecedenteActionListener precedente;
	
	private GoBackPazienteActionListener goBackPaz;
	private GoBackOpUffActionListener goBackOpUff;
	
	public PrenotazioneController (IStrutturaSanitaria model, ViewController view) {
		this.model = model;
		this.view = view;
		
		prenotaOpUff = new PrenotaOpUffActionListener(model, view);
		prenotaPaz = new PrenotaPazActionListener(model, view);
		
		cancellaOpUff = new CancellaOpUffActionListener(model, view);
		cancellaPaz = new CancellaPazActionListener(model, view);
		
		goBackPaz = new GoBackPazienteActionListener(model, view);
		goBackOpUff = new GoBackOpUffActionListener(model, view);
		
		cercaPrenPaz = new CercaPrenDaCancellarePaziente(model, view);
		cercaPrenUff = new CercaPrenDaCancellareUff(model, view);
		
		confermaPaziente = new ConfermaPrenotazionePazienteActionListener(model, view);
		confermaUfficio = new ConfermaPrenotazioneOpUffActionListener(model, view);	
		
		confermaCancellaPaz = new CancellaPrenotazionePazienteActionListener(model, view);
		confermaCancellaOpUff = new CancellaPrenotazioneOpUffActionListener(model, view);
		
		scegliPrest = new ScegliPrestazioneActionListener(model, view);
		
		successivo = new SuccessivoActionListener(model, view);
		
		precedente = new PrecedenteActionListener(model, view);
		
		
		view.getCancellaPanelPaziente().getBtnBack().addActionListener(goBackPaz);
		view.getPrenotatiPanelPaziente().getBtnBack().addActionListener(goBackPaz);
		view.getCancellaPanelUfficio().getBtnBack().addActionListener(goBackOpUff);
		view.getPrenotatiPanelUfficio().getBtnBack().addActionListener(goBackOpUff);
		
		
		view.getOperatoreUfficioPanel().getPrenotaBtn().addActionListener(prenotaOpUff);
		view.getPazientePanel().getPrenotaBtn().addActionListener(prenotaPaz);
		
		view.getPazientePanel().getCancellaBtn().addActionListener(cancellaOpUff);
		view.getOperatoreUfficioPanel().getCancellaBtn().addActionListener(cancellaPaz);
		
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


