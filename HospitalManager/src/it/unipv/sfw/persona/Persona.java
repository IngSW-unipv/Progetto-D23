package it.unipv.sfw.persona;

import java.text.DateFormat;

public abstract class Persona {
	private String nome, cognome, cf, sesso, eMail, cellulare, luogoNascita, indirizzo, cap, paese;
	DateFormat dataNascita;	



	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}
	
	public String getCf() {
		return cf;
	}

	public String getSesso() {
		return sesso;
	}
	
	public String getEmail() {
		return eMail;
	}
	
	public String getCellulare() {
		return cellulare;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getCap() {
		return cap;
	}

	public String getPaese() {
		return paese;
	}
	
	public DateFormat getDataNascita() {
		return dataNascita;
	}
	
	
	public Persona(String nome, String cognome, String CF, String sesso, String email, String cellulare, String luogoNascita, String indirizzo, String cap, String paese,
			DateFormat dataNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.cf = CF;
		this.sesso = sesso;
		this.eMail = email;
		this.cellulare = cellulare;
		this.luogoNascita = luogoNascita;
		this.indirizzo = indirizzo;
		this.cap = cap;
		this.paese = paese;
		this.dataNascita = dataNascita;
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", CF=" + cf + ", sesso=" + sesso + ", email=" + eMail + ", cellulare="
				+ cellulare + ", luogo di nascita=" + luogoNascita + ", indirizzo=" + indirizzo + ", cap=" + cap +", paese=" + paese +"]";
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public void setCf(String cf) {
		this.cf = cf;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	
	public void setEmail(String email) {
		this.eMail = email;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}
	public void setPaese(String paese) {
		this.paese = paese;
	}
	public void setDataNascita(DateFormat dataNascita) {
		this.dataNascita = dataNascita;
	}
}