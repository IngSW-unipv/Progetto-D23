package it.unipv.sfw.model.persona;

public class OperatoreUfficio extends Account implements IAccount{

	public OperatoreUfficio(String cf, String pw, TipoAccount tipoAcc, String nome, String cognome, Sesso sesso,
			String dataNascita, String luogoNascita, String provinciaNascita, String regioneRes, String provinciaRes,
			String cittaRes, String indirizzo, String cap, String eMail, String cellulare) {
		super(cf, pw, tipoAcc, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita, regioneRes, provinciaRes,
				cittaRes, indirizzo, cap, eMail, cellulare);
		// TODO Auto-generated constructor stub
	}
	

}
