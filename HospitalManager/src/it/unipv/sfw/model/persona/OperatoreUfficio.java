package it.unipv.sfw.model.persona;

import it.unipv.sfw.model.Prenotazione;

public class OperatoreUfficio extends Persona implements IPrenotante {

	public OperatoreUfficio(String cf, String nome, String cognome, String sesso, String dataNascita,
			String luogoNascita, String provinciaNascita, String regioneRes, String provinciaRes, String cittaRes,
			String indirizzo, String cap, String eMail, String cellulare) {
		super(cf, nome, cognome, sesso, dataNascita, luogoNascita, provinciaNascita, regioneRes, provinciaRes, cittaRes,
				indirizzo, cap, eMail, cellulare);
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
