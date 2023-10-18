package it.unipv.sfw.model;

import it.unipv.sfw.model.persona.*;

public class Account {
	private Persona p;
	private int idAcc;
	private String pw;
	private String specializzazione;
	private TipoAccount tipoAcc;
	
	public Account(Persona p, int idAcc, String pw, String specializzazione, TipoAccount tipoAcc) {
		super();
		this.p = p;
		this.idAcc = idAcc;
		this.pw = pw;
		this.specializzazione = specializzazione;
		this.tipoAcc = tipoAcc;
	}

	public Persona getP() {
		return p;
	}

	public int getIdAcc() {
		return idAcc;
	}

	public String getPw() {
		return pw;
	}

	public String getSpecializzazione() {
		return specializzazione;
	}

	public TipoAccount getTipoAcc() {
		return tipoAcc;
	}

	public void setP(Persona p) {
		this.p = p;
	}

	public void setIdAcc(int idAcc) {
		this.idAcc = idAcc;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}

	public void setTipoAcc(TipoAccount tipoAcc) {
		this.tipoAcc = tipoAcc;
	}
	
	
	
	
}
