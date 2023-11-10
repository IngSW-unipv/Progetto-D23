package it.unipv.sfw.model.persona;

import it.unipv.sfw.model.TipoAccount;

public class Medico extends Account {


	public Medico(int idAcc, String pw, TipoAccount tipoAcc, String cf, String nome, String cognome, String sesso,
			String dataNascita, String luogoNascita, String provinciaNascita, String regioneRes, String provinciaRes,
			String cittaRes, String indirizzo, String cap, String eMail, String cellulare, String specializzazione) {
		super(idAcc, pw, tipoAcc, cf, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita, regioneRes,
				provinciaRes, cittaRes, indirizzo, cap, eMail, cellulare);
	}
	
	

}
