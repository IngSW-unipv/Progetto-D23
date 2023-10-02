package it.unipv.sfw.persona;

import java.text.DateFormat;

public class OperatoreSanitario extends Persona{
	private String reparto;
	
	public String getReparto() {
		return reparto;
	}
	
	public void setReparto(String reparto) {
		this.reparto = reparto;
	}
	
	
	public OperatoreSanitario(String nome, String cognome, String CF, String sesso, String email, String cellulare,
			String luogoNascita, String indirizzo, String cap, String paese, DateFormat dataNascita, String reparto) {
		super(nome, cognome, CF, sesso, email, cellulare, luogoNascita, indirizzo, cap, paese, dataNascita);
		this.reparto = reparto;
	}

	@Override
	public String toString() {
		return "OperatoreSanitario " + super.toString() + ", reparto=" + reparto + "]";
	
	}

}