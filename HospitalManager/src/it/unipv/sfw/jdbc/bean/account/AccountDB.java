package it.unipv.sfw.jdbc.bean.account;

import it.unipv.sfw.account.TipoAccount;

public class AccountDB {
	private int idAcc;
	private TipoAccount tipoAcc;
	private String cf;
	private String pw;
	private String specializzazione;
	
	public AccountDB(int idAcc, String tipoAcc, String cf, String pw, String specializzazione) {
		super();
		this.idAcc = idAcc;
		this.tipoAcc = TipoAccount.valueOf(tipoAcc);	//string to enum
		this.cf = cf;
		this.pw = pw;
		this.specializzazione = specializzazione;
	}

	public int getIdAcc() {
		return idAcc;
	}

	public TipoAccount getTipoAcc() {
		return tipoAcc;
	}

	public String getCf() {
		return cf;
	}

	public String getPw() {
		return pw;
	}
	
	public String getSpecializzazione() {
		return specializzazione;
	}
	
}
