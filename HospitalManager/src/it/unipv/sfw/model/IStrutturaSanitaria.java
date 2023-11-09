package it.unipv.sfw.model;

public interface IStrutturaSanitaria {
	boolean registrazioneDipendente(TipoAccount tipoAcc, String pw, String specializzazione, 
			String cf, String nome, String cognome, String sesso, String dataNascita, String luogoNascita,
			String provinciaNascita, String regioneRes, String provinciaRes, String cittaRes, String indirizzo,
			String cap, String eMail, String cellulare);
	boolean login(int idAcc, String pw);
	int generaIdAcc();
	int generaIdPren();
	public String generaPwTemp();
	boolean cambioPw(int idAcc, String vecchiaPw, String nuovaPw);
	boolean registrazionePaziente(String cf, String nome, String cognome, String sesso, String dataNascita,
			String luogoNascita, String provinciaNascita, String regioneRes, String provinciaRes, String cittaRes,
			String indirizzo, String cap, String eMail, String cellulare, String pw);
}
