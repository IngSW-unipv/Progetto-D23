package it.unipv.sfw.prestazionisantarie;

import java.text.DateFormat;

import it.unipv.sfw.persona.Medico;
import it.unipv.sfw.persona.OperatoreSanitario;
import it.unipv.sfw.persona.Paziente;

public class Prenotazione {
	private String id;
	private DateFormat data;
	private Paziente paziente;
	private Medico medico;
	private OperatoreSanitario opSanitario;
	
	
	public Prenotazione(String id, DateFormat data, Paziente paziente, Medico medico, OperatoreSanitario opSanitario) {
		super();
		this.id = id;
		this.data = data;
		this.paziente = paziente;
		this.medico = medico;
		this.opSanitario = opSanitario;
	}
	
	

}
