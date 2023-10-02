package it.unipv.sfw.strutturasanitaria;

import it.unipv.sfw.persona.Persona;

public class Account {
	private TipoAccount tipoAccount;
	private String pw;
	private Persona user;
	
	public TipoAccount getTipoAcc() {
		return tipoAccount;
	}
	
	public String getPw() {
		return pw;
	}
	
	public Persona getUser() {
		return user;
	}
	
	
	public Account(TipoAccount tipoAccount, String pw, Persona user) {
		this.tipoAccount = tipoAccount;
		this.pw = pw;
		this.user = user;
	}
	
	public void setTipoAccount(TipoAccount tipoAccount) {
		this.tipoAccount = tipoAccount;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public void setPersona(Persona user) {
		this.user = user;
	}
	
}


