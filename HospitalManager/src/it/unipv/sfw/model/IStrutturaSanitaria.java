package it.unipv.sfw.model;

public interface IStrutturaSanitaria {
	boolean login(int idAcc, String pw);
	int generaIdPren();
	public String generaPwTemp();
	boolean cambioPw(int idAcc, String vecchiaPw, String nuovaPw);
	boolean registrazioneAccount(String cf, String pw, TipoAccount tipo, String nome, String cognome, String sesso,
			String dataNascita, String luogoNascita, String provinciaNascita, String regioneRes, String provinciaRes,
			String cittaRes, String indirizzo, String cap, String eMail, String cellulare,
			TipoPrestazione specializzazione);
}
