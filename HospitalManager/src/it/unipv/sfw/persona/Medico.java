package it.unipv.sfw.persona;

import java.text.DateFormat;

public class Medico extends Persona{
	private int codiceRegionale;
	private String specializzazione, reparto;
	
	public int getCodiceRegionale() {
		return codiceRegionale;
	}
	
	public String getSpecializzazione() {
		return specializzazione;
	}
	
	public String getReparto() {
		return reparto;
	}
	
	
	
	public void setCodiceRegionale(int n) {
		codiceRegionale =n;
	}
	
	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}
	
	public void setReparto(String reparto) {
		this.reparto = reparto;
	}
	
	public Medico(String nome, String cognome, String CF, String sesso, String email, String cellulare,
			String luogoNascita, String indirizzo, String cap, String paese, DateFormat dataNascita,
			int codiceRegionale, String specializzazione, String reparto) {
		
		super(nome, cognome, CF, sesso, email, cellulare, luogoNascita, indirizzo, cap, paese, dataNascita);
		this.codiceRegionale = codiceRegionale;
		this.specializzazione = specializzazione;
		this.reparto = reparto;
	}
	
	@Override
	public String toString() {
		return "Medico " + super.toString() + "[codiceRegionale=" + codiceRegionale + ", specializzazione=" + specializzazione + 
				", reparto=" + reparto + "]";
	
	}
}
