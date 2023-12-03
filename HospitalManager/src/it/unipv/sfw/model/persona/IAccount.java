package it.unipv.sfw.model.persona;

import javax.security.auth.login.LoginException;

import it.unipv.sfw.model.prenotazione.TipoPrestazione;

public interface IAccount {
	public TipoPrestazione getSpecializzazione();
	public boolean setPw(String vecchiaPw, String nuovaPw) throws LoginException;
	public boolean controllaPw(String pw) throws LoginException;
	public String getPw();
	public void setPw(String pw);
	public TipoAccount getTipoAcc();
	public void setTipoAcc(TipoAccount tipoAcc);
	public String getCf();
	public void setCf(String cf);
	public String getNome();
	public void setNome(String nome);
	public String getCognome();
	public void setCognome(String cognome);
	public Sesso getSesso();
	public void setSesso(Sesso sesso);
	public String getDataNascita();
	public void setDataNascita(String dataNascita);
	public String getLuogoNascita();
	public void setLuogoNascita(String luogoNascita);
	public String getProvinciaNascita();
	public void setProvinciaNascita(String provinciaNascita);
	public String getRegioneRes();
	public void setRegioneRes(String regioneRes);
	public String getProvinciaRes();
	public void setProvinciaRes(String provinciaRes);
	public String getCittaRes();
	public void setCittaRes(String cittaRes);
	public String getIndirizzo();
	public void setIndirizzo(String indirizzo);
	public String getCap();
	public void setCap(String cap);
	public String geteMail();
	public void seteMail(String eMail);
	public String getCellulare();
	public void setCellulare(String cellulare);
	
	
		

}
