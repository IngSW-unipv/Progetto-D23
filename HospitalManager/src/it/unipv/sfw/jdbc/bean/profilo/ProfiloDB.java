package it.unipv.sfw.jdbc.bean.profilo;

import it.unipv.sfw.model.persona.Sesso;
import it.unipv.sfw.model.persona.TipoAccount;

public class ProfiloDB {
	private String cf;
	private TipoAccount tipoAcc;
	private String pw;
	private String specializzazione;
	private String nome;
	private String cognome;
	private Sesso sesso;
	private String dataNascita;
	private String luogoNascita;
	private String provinciaNascita;
	private String regioneRes;
	private String provinciaRes;
	private String cittaRes;
	private String indirizzo;
	private String cap;
	private String eMail;
	private String cellulare;
	
	public ProfiloDB(String cf, String tipoAcc, String pw, String specializzazione, String nome,
			String cognome, String sesso, String dataNascita, String luogoNascita, String provinciaNascita,
			String regioneRes, String provinciaRes, String cittaRes, String indirizzo, String cap, String eMail,
			String cellulare) {
		super();
		this.cf = cf;
		this.tipoAcc = TipoAccount.valueOf(tipoAcc);
		this.pw = pw;
		this.specializzazione = specializzazione;
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = Sesso.valueOf(sesso);
		this.dataNascita = dataNascita;
		this.luogoNascita = luogoNascita;
		this.provinciaNascita = provinciaNascita;
		this.regioneRes = regioneRes;
		this.provinciaRes = provinciaRes;
		this.cittaRes = cittaRes;
		this.indirizzo = indirizzo;
		this.cap = cap;
		this.eMail = eMail;
		this.cellulare = cellulare;
	}


	public TipoAccount getTipoAcc() {
		return tipoAcc;
	}

	public void setTipoAcc(TipoAccount tipoAcc) {
		this.tipoAcc = tipoAcc;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getSpecializzazione() {
		return specializzazione;
	}

	public void setSpecializzazione(String specializzazione) {
		this.specializzazione = specializzazione;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Sesso getSesso() {
		return sesso;
	}

	public void setSesso(Sesso sesso) {
		this.sesso = sesso;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public String getProvinciaNascita() {
		return provinciaNascita;
	}

	public void setProvinciaNascita(String provinciaNascita) {
		this.provinciaNascita = provinciaNascita;
	}

	public String getRegioneRes() {
		return regioneRes;
	}

	public void setRegioneRes(String regioneRes) {
		this.regioneRes = regioneRes;
	}

	public String getProvinciaRes() {
		return provinciaRes;
	}

	public void setProvinciaRes(String provinciaRes) {
		this.provinciaRes = provinciaRes;
	}

	public String getCittaRes() {
		return cittaRes;
	}

	public void setCittaRes(String cittaRes) {
		this.cittaRes = cittaRes;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}
	
	
	

}
