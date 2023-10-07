package it.unipv.sfw.persona;

import java.sql.Date;

public class OperatoreUfficio extends Persona{

	public OperatoreUfficio(String nome, String cognome, String CF, String sesso, String email, String cellulare,
			String luogoNascita, String indirizzo, String cap, String paese, Date dataNascita) {
		super(nome, cognome, CF, sesso, email, cellulare, luogoNascita, indirizzo, cap, paese, dataNascita);
		
	}
	
}