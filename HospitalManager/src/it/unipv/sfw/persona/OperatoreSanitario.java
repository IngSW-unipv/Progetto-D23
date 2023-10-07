package it.unipv.sfw.persona;

import java.sql.Date;

public class OperatoreSanitario extends Persona{
	
	public OperatoreSanitario(String nome, String cognome, String CF, String sesso, String email, String cellulare,
			String luogoNascita, String indirizzo, String cap, String paese, Date dataNascita, String reparto) {
		super(nome, cognome, CF, sesso, email, cellulare, luogoNascita, indirizzo, cap, paese, dataNascita);
		
	}

	@Override
	public String toString() {
		return "OperatoreSanitario " + super.toString() + "]";
	
	}

}