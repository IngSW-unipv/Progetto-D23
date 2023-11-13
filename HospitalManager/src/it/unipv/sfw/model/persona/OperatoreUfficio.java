package it.unipv.sfw.model.persona;

import it.unipv.sfw.model.Prenotazione;
import it.unipv.sfw.model.TipoAccount;

public class OperatoreUfficio extends Account implements IPrenotante {

	public OperatoreUfficio(String cf, String pw, TipoAccount tipoAcc, String nome, String cognome, String sesso,
			String dataNascita, String luogoNascita, String provinciaNascita, String regioneRes, String provinciaRes,
			String cittaRes, String indirizzo, String cap, String eMail, String cellulare) {
		super(cf, pw, tipoAcc, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita, regioneRes, provinciaRes,
				cittaRes, indirizzo, cap, eMail, cellulare);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean inserisciPrenotazione(String idPrest) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancellaPrenotazione(Prenotazione p) {
		// TODO Auto-generated method stub
		return false;
	}

}
