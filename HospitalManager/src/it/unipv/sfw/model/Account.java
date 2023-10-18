package it.unipv.sfw.model;

public class Account {
	private int idAcc;
	private TipoAccount tipoAcc;
	private String cf;
	private String pw;
	private String specializzazione;
	
	public Account(int idAcc, String tipoAcc, String cf, String pw, String specializzazione) {
		super();
		this.idAcc = idAcc;
		this.tipoAcc = TipoAccount.valueOf(tipoAcc);
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

	public void setIdAcc(int idAcc) {
		this.idAcc = idAcc;
	}

	public void setTipoAcc(TipoAccount tipoAcc) {
		this.tipoAcc = tipoAcc;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}
	
	
	
}
