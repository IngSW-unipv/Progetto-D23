package it.unipv.sfw.model.persona;

import java.util.ArrayList;

import it.unipv.sfw.model.Prenotazione;

public class Persona {
	private String cf;
	private String nome;
	private String cognome;
	private String sesso;
	private String dataNascita;
	private String luogoNascita;
	private String provinciaNascita;
	private String regioneRes;
	private String provinciaRes;
	private String cittaRes;
	private String indirizzo;
	private String cap;
	private String eMail;
	private String cellulare;
	
	public Persona(String cf, String nome, String cognome, String sesso, String dataNascita, String luogoNascita,
			String provinciaNascita, String regioneRes, String provinciaRes, String cittaRes, String indirizzo,
			String cap, String eMail, String cellulare) {
		super();
		this.cf = cf;
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.dataNascita = dataNascita;
		this.luogoNascita = luogoNascita;
		this.provinciaNascita = provinciaNascita;
		this.regioneRes = regioneRes;
		this.provinciaRes = provinciaRes;
		this.cittaRes = cittaRes;
		this.indirizzo = indirizzo;
		this.cap = cap;
		this.eMail = eMail;
		this.cellulare = cellulare;
	}

	public String getCf() {
		return cf;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getSesso() {
		return sesso;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public String getProvinciaNascita() {
		return provinciaNascita;
	}

	public String getRegioneRes() {
		return regioneRes;
	}

	public String getProvinciaRes() {
		return provinciaRes;
	}

	public String getCittaRes() {
		return cittaRes;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public String getCap() {
		return cap;
	}

	public String geteMail() {
		return eMail;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public void setProvinciaNascita(String provinciaNascita) {
		this.provinciaNascita = provinciaNascita;
	}

	public void setRegioneRes(String regioneRes) {
		this.regioneRes = regioneRes;
	}

	public void setProvinciaRes(String provinciaRes) {
		this.provinciaRes = provinciaRes;
	}

	public void setCittaRes(String cittaRes) {
		this.cittaRes = cittaRes;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}
	
	
		
	
	
}