package it.unipv.sfw.persona;

import java.sql.Date;

public class Medico extends Persona{
	private int codiceRegionale;
	private String specializzazione;
	private Date dataAssunzione;
	
	public int getCodiceRegionale() {
		return codiceRegionale;
	}
	
	public String getSpecializzazione() {
		return specializzazione;
	}
	
	
	public void setCodiceRegionale(int n) {
		codiceRegionale =n;
	}
	
	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}

	
	public Date getDataAssunzione() {
		return dataAssunzione;
	}

	public void setDataAssunzione(Date dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}

	public Medico(String nome, String cognome, String CF, String sesso, String email, String cellulare,
			String luogoNascita, String indirizzo, String cap, String paese, Date dataNascita,
			int codiceRegionale, String specializzazione, Date dataAssunzione) {
		
		super(nome, cognome, CF, sesso, email, cellulare, luogoNascita, indirizzo, cap, paese, dataNascita);
		this.codiceRegionale = codiceRegionale;
		this.specializzazione = specializzazione;
		this.dataAssunzione = dataAssunzione;
	}
	
	@Override
	public String toString() {
		return "Medico " + super.toString() + "[codiceRegionale=" + codiceRegionale + ", specializzazione=" + specializzazione + 
				"]";
	
	}
}
